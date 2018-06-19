package classAnalyser.classFile.methods.methodInfo.attribute;

/*
 * RuntimeInvisibleParameterAnnotations属性和RuntimeVisibleParameterAnnotations属性类似，
 * 区别是RuntimeInvisibleParameterAnnotations属性表示的注解不能被反射的API访问，
 * 除非Java虚拟机通过特殊的实现相关的方式（譬如特定的命令行参数）收到才会（为反射的API）使用这些注解。
 * 否则，Java虚拟机将忽略RuntimeInvisibleParameterAnnotations属性。
 * 
	RuntimeInvisibleParameterAnnotations属性是一个变长属性，位于method_info（§4.6）结构的属性表中。
	用于保存对应方法的参数的所有运行时非可见的Java语言注解。
	每个method_info结构最多只能含有一个RuntimeInvisibleParameterAnnotations属性用于保存当前Java语言中的程序元素的所有运行时非可见注解。

	The RuntimeInvisibleParameterAnnotations attribute has the following format:
	
		RuntimeInvisibleParameterAnnotations_attribute {
		    u2 attribute_name_index;
		    u4 attribute_length;
		    u1 num_parameters;
		    {   u2         num_annotations;
		        annotation annotations[num_annotations];
		    } parameter_annotations[num_parameters];
		}
 */
//一下所有的注释说明只要把"RuntimeVisibleParameterAnnotationsAttribute"中的"可见"换成"非可见"即可
public class RuntimeInvisibleParameterAnnotationsAttribute extends RuntimeVisibleParameterAnnotationsAttribute{
	
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“RuntimeInvisibleParameterAnnotations”。
	 */

}
