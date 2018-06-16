package classAnalyser.classFile.common.attribute;

import classAnalyser.classFile.common.attribute.annotation.ElementValuePairs;

/*
 * annotation结构的格式如下： 
 * 			annotation { 
 * 							u2 type_index; 
 * 						 	u2 num_element_value_pairs;
 * 			 				{ 
 * 								u2 element_name_index; 
 * 						  		element_value value; 
 * 							}element_value_pairs[num_element_value_pairs] 
 * 						}
 */
public class Annotation {
	private byte b1;//high byte of type_index
	private byte b2;//low byte of type_index
	
	/*
	 *type_index项的值必须是对常量池的一个有效索引。
	 *常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 *表示一个字段描述符，
	 *这个字段描述符表示一个注解类型，和当前annotation结构表示的注解一致。 
	 */
	private int type_index;
	
	private byte b3;//high byte of num_element_value_pairs
	private byte b4;//low byte of num_element_value_pairs
	
	/*
	 * num_element_value_pairs项的值给出了当前annotation结构表示的注解的
	 * 键值对（键值对的格式为：元素-值）的数量，即element_value_pairs[]数组成员数量。
	 * 需要注意的是，在单独一个注解中可能含有数量最多为65535个键值对。
	 */
	private int num_element_value_pairs;
	
	//element_value_pairs[]数组的每一个成员的值对应当前annotation结构表示的注解中的一个唯一的键值对。
	private ElementValuePairs[] element_value_pairs;//length=num_element_value_pairs
}
