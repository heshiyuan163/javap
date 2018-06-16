package classAnalyser.classFile.constantPool;

//CONSTANT_Utf8_info结构用于表示字符串常量的值：
public class ConstantUtf8Info extends ConstantPoolInfo{
	/**
	 * CONSTANT_Utf8_info { u1 tag; 
	 * 						u2 length; 
	 * 						u1 bytes[length];
	 * 					 }
	 */
	
	private byte b1;//high byte of length
	private byte b2;//low byte of length
	
	/**
	 * length项的值指明了bytes[]数组的长度（注意，不能等同于当前结构所表示的String对象的长度），
	 * CONSTANT_Utf8_info结构中的内容是以length属性确定长度而不是以null作为字符串的终结符。
	 */
	private int length;
	
	
	/**
	 * bytes[]是表示字符串值的byte数组，
	 * bytes[]数组中每个成员的byte值都不会是0，
	 * 也不在0xf0至0xff范围内。
		字符串常量采用改进过的UTF-8编码表示。
		这种以改进过的UTF-8编码中，用于表示的字符串的码点字符序列可以包含ASCII中的所有非空（Non-Null）字符和所有Unicode编码的字符，
		一个字符占一个byte。
	 */
}
