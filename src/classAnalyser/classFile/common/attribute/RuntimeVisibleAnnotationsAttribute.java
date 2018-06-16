package classAnalyser.classFile.common.attribute;

/*
 * RuntimeVisibleAnnotations属性是可变长属性，位于	ClassFile（§4.1）， 
 * 											field_info（§4.5）或
 * 											method_info（§4.6）结构的属性表中。
 * RuntimeVisibleAnnotations用于保存Java语言中的类、字段或方法的运行时的可见注解（Annotations）。
 * 每个ClassFile，field_info和method_info结构最多只能含有一个RuntimeVisibleAnnotations属性为当前的程序元素保存所有的运行时可见的Java语言注解。
 * Java虚拟机必须支持这些注解可被反射的API使用它们。
 * 
	The RuntimeVisibleAnnotations attribute has the following format:

		RuntimeVisibleAnnotations_attribute {
		    u2         attribute_name_index;
		    u4         attribute_length;
		    u2         num_annotations;
		    annotation annotations[num_annotations];
		}
 */
public class RuntimeVisibleAnnotationsAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“RuntimeVisibleAnnotations”。
	 */
	
	/*
	 * attribute_length项的值给出了当前属性的长度，不包括开始的6个字节。
	 * attribute_length项的值由当前结构的运行时可见注解的数量和值决定。
	 */
	
	private byte b7;//high byte of num_annotations
	private byte b8;//low byte of num_annotations
	
	/*
	 * num_annotations项的值给出了当前结构表示的运行时可见注解的数量。
	 * 每个程序元素最多可能会被附加65535个运行时可见的java语言注解。
	 */
	private int num_annotations;
	
	//annotations[]数组的每个成员的值表示一个程序元素的唯一的运行时可见注解。
	private Annotation[] annotations;//length=num_annotations
}
