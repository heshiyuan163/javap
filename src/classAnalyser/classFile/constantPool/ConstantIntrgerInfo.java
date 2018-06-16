package classAnalyser.classFile.constantPool;

public class ConstantIntrgerInfo extends ConstantPoolInfo{

	/**
	 * CONSTANT_Integer_info { u1 tag; u4 bytes; }
	 */
	
	private byte b1;
	private byte b2;
	private byte b3;
	private byte b4;
	
	/**
	 * CONSTANT_Integer_info结构的bytes项表示int常量的值，按照Big-Endian(高位优先)的顺序存储。
	 */
	private int bytes;
}
