package classAnalyser.classFile.constantPool;

public class ConstantClassInfo extends ConstantPoolInfo{
	
	/**
	 * CONSTANT_Class_info { u1 tag; 
	 * 						 u2 name_index; 
	 * 					}
	 */
	private byte b1;//high byte of name_index
	private byte b2;//low byte of name_index
	/**
	 * name_index项的值，必须是对常量池的一个有效索引。常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 代表一个有效的类或接口二进制名称的内部形式。
	 */
	private int name_index;
	

}
