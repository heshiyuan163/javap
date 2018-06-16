package classAnalyser.classFile.constantPool;

public class ConstantStringInfo extends ConstantPoolInfo{
	/**
	 * CONSTANT_String_info { u1 tag; 
	 * 							u2 string_index;
	 * 					 }
	 */
	
	private byte b1;//high byte of string_index
	private byte b2;//low byte of string_index
	
	/**
	 * string_index项的值必须是对常量池的有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 表示一组Unicode码点序列，这组Unicode码点序列最终会被初始化为一个String对象。
	 */
	private int string_index;
	
}
