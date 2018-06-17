package classAnalyser.classFile.fields.attributeInfo.attribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;

/*
 * ConstantValue属性是定长(2 bytes,也即是constantvalue_index占用的2个字节)属性，
 * 位于field_info（§4.5）结构的属性表中。
 * ConstantValue属性表示一个常量字段的值。在一个field_info结构的属性表中最多只能有一个ConstantValue属性。
 * 如果该字段为静态类型（即field_info结构的access_flags项设置了ACC_STATIC标志），
 * 则说明这个field_info结构表示的常量字段值将被分配为它的ConstantValue属性表示的值，
 * 这个过程也是类或接口申明的常量字段（Constant Field（§5.5））初始化的一部分。
 * 这个过程发生在引用类或接口的类初始化方法（§2.9）执行之前。
如果field_info结构表示的非静态字段包含了ConstantValue属性，那么这个属性必须被虚拟机所忽略。
所有Java虚拟机实现必须能够识别ConstantValue属性。

ConstantValue属性的格式如下： ConstantValue_attribute { u2 attribute_name_index; 
												  u4 attribute_length; //固定为2 bytes
												  u2 constantvalue_index;
												}
 */
public class ConstantValueAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值，必须是一个对常量池的有效索引。
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“ConstantValue”。
	 */
	
	private byte b7;//high byte of constantvalue_index
	private byte b8;//low byte of constantvalue_index
	
	/*
	 * constantvalue_index项的值，必须是一个对常量池的有效索引。
	 * 常量池在该索引处的项给出该属性表示的常量值。常量池的项的类型表示的字段类型下表所示:
	 * 		字段类型							项类型
	 * 		long 							CONSTANT_Long
	 * 		float 							CONSTANT_Float 
	 * 		double 							CONSTANT_Double 
	 * 		int,short,char,byte,boolean 	CONSTANT_Integer 
	 * 		String 							CONSTANT_String
	 */
	private int constantvalue_index;

}
