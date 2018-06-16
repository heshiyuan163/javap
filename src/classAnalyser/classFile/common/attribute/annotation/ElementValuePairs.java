package classAnalyser.classFile.common.attribute.annotation;

/*
 * { 
  		u2 element_name_index; 
 		element_value value; 
 }
 */
public class ElementValuePairs {
	
	private byte b1;//high byte of element_name_index
	private byte b2;//low byte of element_name_index
	
	/**
	 * element_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 表示一个有效的字段描述符（§4.3.2），这个字段描述符用于定义当前element_value_pairs的成员表示的注解的注解名。
	 */
	private int element_name_index;
	
	//value的项的值给出了element_value_pairs中的成员的键值对中的
	private ElementValue value;

}
