package classAnalyser.classFile.methods.methodInfo.attribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;


/*
 * AnnotationDefault属性是一个变长属性，位于某些特殊的method_info（§4.6）结构的属性表中，这些结构表示注解类型的元素。
 * AnnotationDefault属性用于保存method_info结构表示的元素的默认值。
 * 每个method_info结构表示的一个元素的注解最多只能有一个AnnotationDefault属性。
 * Java虚拟机必须保证这些默认值可见，可供反射API使用。
 * 
 * The AnnotationDefault attribute has the following format:

	AnnotationDefault_attribute {
	    u2            attribute_name_index;
	    u4            attribute_length;
	    element_value default_value;
	}
 */
public class AnnotationDefaultAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“AnnotationDefault”。
	 */
	
	/*
	 * attribute_length项的值给出了当前属性的长度，不包括开始的attribute_name_index+attribute_length的6个字节。
	 * attribute_length项的值由默认值决定。
	 */
	
	//default_value项表示AnnotationDefault属性所对应注解类型元素的默认值。
	//长度可以确定，但是该怎么解析呢？？？？没说清楚
	
}