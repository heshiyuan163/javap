package classAnalyser.classFile.common.attribute;


/*
 * Deprecated属性是可选定长(0 byte)属性，位于	ClassFile（§4.1）, 
 * 										field_info（§4.5） 或 
 * 										method_info（§4.6）结构的属性表中。
 * 类、接口、方法或字段都可以带有为Deprecated属性，如果类、接口、方法或字段标记了此属性，则说明它将会在后续某个版本中被取代。
 * 在运行时解释器或工具（譬如编译器）读取Class文件格式时，可以用Deprecated属性来告诉使用者避免使用这些类、接口、方法或字段，选择其他更好的方式。
 * Deprecated属性的出现不会修改类或接口的语义。
   Deprecated属性是在JDK 1.1为了支持注释中的关键词@deprecated而引入的。
	
   The Deprecated attribute has the following format:

		Deprecated_attribute {
		    u2 attribute_name_index;
		    u4 attribute_length;//==0
		}
 */
public class DeprecatedAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“Deprecated”。
	 */
}
