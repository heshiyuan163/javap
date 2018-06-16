package classAnalyser.classFile.common.attribute.annotation;


/*
 * element_value结构是一个可辨识联合体（Discriminated Union）①，用于表示“元素-值”的键值对中的值。
 * 它被用来描述所有注解（包括RuntimeVisibleAnnotations、RuntimeInvisibleAnnotations、
 * RuntimeVisibleParameterAnnotations和untimeInvisibleParameterAnnotations）中涉及到的元素值。
 * 
	element_value的结构格式如下：
	element_value { 
					u1 tag;
					union { 
							u2 const_value_index;| 
							{ 
								u2 type_name_index; 
								u2 const_name_index; 
							} enum_const_value;| 
							u2 class_info_index;| 
							annotation annotation_value;| 
							{ 
								u2 num_values; 
								element_value values[num_values]; 
							} array_value; 
					} value; //联合体表示value是union{}中的众多选项中的某一个(根据tag的不同而不同)
	}
① 译者注：“Discriminated Union”是一种数据结构，用于表示若干种具有独立特征的同类项集合。
 */
public class ElementValue {
	
	/*
	 * tag项表明了当前注解的元素-值对的类型。tag值为字母'B'、'C'、'D'、'F'、'I'、'J'、'S'和'Z'时表示的含义和章节4.3.2中
	 * 表4.2所定义的一样。其余tag的预定义值和对应解释如下表所示:
	 * 
	 * tag值			元素类型 
	 * s 			String 
	 * e 			enum constant 
	 * c 			class 
	 * @ 			annotation type 
	 * [ 			array
	 * 
	 */
	private byte tag;
	
	/*value:value项的表示当前注解元素的值。此项是一个联合体结构，当前项的tag项决定了这个联合体结构的哪一项会被使用：
	 * 1.enum_const_value:当tag项为'e'时，enum_const_value才被使用。此时：
	 * 					type_name_index项的值必须是对常量池的一个有效索引。
	 * 						常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 						表示一个有效的字段描述符（§4.3.2），
	 * 						这个字段描述符表示当前element_value结构所表示的枚举常量类型的内部形式的二进制名称（§ 4.2.1）。
	 * 					const_name_index项的值必须是对常量池的一个有效索引。
	 * 						常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 						表示一个有效的字段描述符（§4.3.2），
	 * 						这个字段描述符表示当前element_value结构所表示的枚举常量类型的简单名称。
	 * 
	 * 2.class_info_index: 当tag项为'c'时，class_info_index项才会被使用。
	 * 					class_info_index项的值必须是对常量池的一个有效索引。
	 * 					常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 					表示返回描述符（§4.3.3）的类型，这个类型由当前element_value结构所表示的类型决定（譬如：
	 * 					'V'表示Void，'Ljava/lang/Object;'表示类java.lang.Object等）。
	 * 
	 * 3.annotation_value: 当tag项为'@'时，annotation_value项才会被使用。
	 * 					这时element_value结构表示一个内部的注解（Nested Annotation）。
	 * 
	 * 4.array_value: 当tag项为'['时，array_value项才会被使用。array_value项包含如下两项：
	 * 				num_values: num_values项的值给定了当前element_value结构表示的数组类型的成员的数量。
	 * 							注意，允许数组类型元素中最多有65535个元素。
	 * 				values: values的每个成员的值都给指明了当前element_value 结构所表示的数组类型的一个元素值。
	 *
	 * 5.const_value_index:The const_value_index item is used if the tag item is one of B, C, D, F,
	 * 				 I, J, S, Z, or s. The value of the const_value_index item must be a valid index
	 * 				 into the constant_pool table. The constant_pool entry at that index must be of 
	 * 				 the correct entry type for the field type designated by the tag item, as specified 
	 * 				 in Table 4.9.

	 * */

}
