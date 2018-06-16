package classAnalyser.classFile.common.attribute;

/*
 * 属性（Attributes）在Class文件格式中的ClassFile（§4.1）结构、field_info （§4.5）结构、method_info（§4.6）结构和
 * Code_attribute（§4.7.3）结构都有使用，
 * 所有属性的通用格式如下： attribute_info { u2 attribute_name_index; 
 * 									 u4 attribute_length; 
 * 									 u1 info[attribute_length];
 * 								 }
 */
public abstract class AttributeInfo {

		private byte b1;//high byte of attribute_name_index
		private byte b2;//low byte of attribute_name_index
		
		/*
		 * attribute_name_index必须是对当前Class文件的常量池的有效16位无符号索引。
		 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示当前属性的名字。
		 */
		private int attribute_name_index;
		
		private byte b3;
		private byte b4;
		private byte b5;
		private byte b6;
		
		/*
		 * attribute_length项的值给出了跟随其后的字节的长度(即字节数)，这个长度不包括attribute_name_index和
		 * attribute_length项的6个字节。
		 */
		private int attribute_length;
		
		
		//后面的info所代表的的内容(格式以及解析方式)根据attribute_name_index指向的内容不同而不同
		private  byte[] info;//length=attribute_length
}
