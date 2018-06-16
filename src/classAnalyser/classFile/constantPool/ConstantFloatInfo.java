package classAnalyser.classFile.constantPool;

public class ConstantFloatInfo extends ConstantPoolInfo{

	/**
	 * CONSTANT_Float_info { u1 tag; u4 bytes; }
	 */
	private byte b1;
	private byte b2;
	private byte b3;
	private byte b4;
	
	/**
	 * CONSTANT_Float_info结构的bytes项按照IEEE 754单精度浮点格式（§2.3.2）.表示float常量的值，
	 * 按照Big-Endian的顺序存储。 
	 * CONSTANT_Float_info结构表示的值将按照下列方式来表示，bytes项的值首先被转换成一个int常量的bits：
 				如果bits值为0x7f800000，表示float值为正无穷。
 				如果bits值为0xff800000，表示float值为负无穷。
 				如果bits值在范围0x7f800001到0x7fffffff或者0xff800001到0xffffffff内，表示float值为NaN。
 		在其它情况下，设s、e、m，它们值根据bits和如下公式计算：
 			int s =((bits >> 31) == 0) ? 1 : -1; 
 			int e =((bits >> 23) & 0xff);
 			int m =(e == 0） ? bits & 0x7fffff) << 1 : (bits & 0x7fffff) | 0x800000;
		则float的浮点值为数值表达式s·m·2e–150的计算结果。
	 */
	private int bytes;
}
