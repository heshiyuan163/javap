package classAnalyser.classFile.common.attribute;

/*
 * Signature属性是可选的定长(2 bytes)属性，位于ClassFile（§4.1），field_info（§4.5）或method_info（§4.6）结构的
 * 属性表中。在Java语言中，任何类、接口、初始化方法或成员的泛型签名如果包含了类型变量（Type Variables）或参数化类型
 * （Parameterized Types），则Signature属性会为它记录泛型签名信息。
 * 
 * Signature属性格式如下： Signature_attribute { u2 attribute_name_index; 
 * 											u4 attribute_length; //=2
 * 											u2 signature_index; 
 * 										}
 */
public class SignatureAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是一个对常量池的有效索引。
	 * 常量池在索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“Signature”。
	 */
	
	/*
	 * ignature_index项的值必须是一个对常量池的有效索引。
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示类签名或方法类型签名或
	 * 字段类型签名：如果当前的Signature属性是ClassFile结构的属性，则这个结构表示类签名，
	 * 			 如果当前的Signature属性是method_info结构的属性，则这个结构表示方法类型签名，
	 * 			如果当前Signature属性是field_info结构的属性，则这个结构表示字段类型签名。
	 */
	private int signature_index;

}
