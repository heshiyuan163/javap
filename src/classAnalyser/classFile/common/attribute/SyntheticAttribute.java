package classAnalyser.classFile.common.attribute;

/*
 * Synthetic属性是定长属性(固定0 byte)，位于ClassFile（§4.1）、FieldInfo（§4.5）等中的属性表。
 * 如果一个类成员没有在源文件中出现，则必须标记带有Synthetic属性，或者设置ACC_SYNTHETIC标志。
 * 唯一的例外是某些与人工实现无关的、由编译器自动产生的方法，也就是说，Java编程语言的默认的实例初始化方法（无参数的实例初始化方法）、
 * 类初始化方法，以及Enum.values()和Enum.valueOf()等方法是不用使用Synthetic属性或ACC_SYNTHETIC标记的。
Synthetic属性是在JDK 1.1中为了支持内部类或接口而引入的。

Synthetic属性的格式如下： Synthetic_attribute { u2 attribute_name_index; 
										  u4 attribute_length; //=0
										}
 */
public class SyntheticAttribute extends AttributeInfo{

	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引，
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“Synthetic”。
	 */
}
