package classAnalyser.classFile.common.attribute;

/*运行时非可见注解：
The RuntimeInvisibleAnnotations attribute is similar to the RuntimeVisibleAnnotations attribute, except that 
the annotations represented by a RuntimeInvisibleAnnotations attribute must not be made available for return 
by reflective APIs, unless the Java Virtual Machine has been instructed to retain these annotations via some 
implementation-specific mechanism such as a command line flag. In the absence of such instructions, the Java 
Virtual Machine ignores this attribute.

The RuntimeInvisibleAnnotations attribute is a variable-length attribute in the attributes table of a ClassFile, field_info, 
or method_info structure (§4.1, §4.5, §4.6). The RuntimeInvisibleAnnotations attribute records run-time-invisible Java programming language annotations 
on the corresponding class, method, or field.

Each ClassFile, field_info, and method_info structure may contain at most one RuntimeInvisibleAnnotations attribute, which 
records all the run-time-invisible Java programming language annotations on the corresponding program element. 
    The RuntimeInvisibleAnnotations attribute has the following format:

	RuntimeInvisibleAnnotations_attribute {
	    u2         attribute_name_index;
	    u4         attribute_length;
	    u2         num_annotations;
	    annotation annotations[num_annotations];
	}
 */
public class RuntimeInvisibleAnnotationsAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“RuntimeInvisibleAnnotations”。
	 */
	
	/*
	 * attribute_length项的值给出了当前属性的长度，不包括开始的6个字节。
	 * attribute_length项的值由当前结构的运行时非可见注解的数量和值决定。
	 */
	
	private byte b7;//high byte of num_annotations
	private byte b8;//low byte of num_annotations
	
	/*
	 * num_annotations项的值给出了当前结构表示的运行时非可见注解的数量。
	 * 每个程序元素最多可能会被附加65535个运行时非可见的java语言注解。
	 */
	private int num_annotations;
	
	/*
	 *annotations[]数组的每个成员的值表示一个程序元素的唯一的运行时非可见注解。 
	 */
	private Annotation[] annotations;//length=num_annotations

}
