package classAnalyser.classFile.constantPool;

/**
在Class文件的常量池中，所有的8字节的常量都占两个表成员（项）的空间。如果一个CONSTANT_Long_info或CONSTANT_Double_info
结构的项在常量池中的索引为n，则常量池中下一个有效的项的索引为n+2，此时常量池中索引为n+1的项有效但必须被认为不可用①。
 */
public class ConstantDoubleInfo extends ConstantPoolInfo{
	/**
	 * CONSTANT_Double_info { u1 tag; 
	 * 							u4 high_bytes; 
	 * 							u4 low_bytes; 
	 * 				}
	 */
	
	private byte b1_h;
	private byte b2_h;
	private byte b3_h;
	private byte b4_h;
	
	
	private byte b1_l;
	private byte b2_l;
	private byte b3_l;
	private byte b4_l;
	
	/**
	 * CONSTANT_Double_info结构中的high_bytes和low_bytes共同按照IEEE 754双精度浮点格式（§2.3.2）表示double常量的值。
	 * high_bytes和low_bytes都按照Big-Endian顺序存储。
	 * CONSTANT_Double_info结构表示的值将按照下列方式来表示，high_bytes和low_bytes首先被转换成一个long常量的bits：
			 如果bits值为0x7ff0000000000000L，表示double值为正无穷。
 			如果bits值为0xfff0000000000000L，表示double值为负无穷。
 			如果bits值在范围0x7ff0000000000001L到 0x7fffffffffffffffL或者0xfff0000000000001L到 0xffffffffffffffffL内，表示double值为NaN。
		 在其它情况下，设s、e、m，它们的值根据bits和如下公式计算： 
			int s =((bits >> 63) == 0) ? 1 : -1; 
			int e =(int)((bits >> 52) & 0x7ffL); 
			long m =(e == 0) ? (bits & 0xfffffffffffffL) << 1 : (bits & 0xfffffffffffffL) | 0x10000000000000L;
		则double的浮点值为数学表达式s·m·2e – 1075的计算结果。
	 */
	
}
