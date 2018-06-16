package classAnalyser.classFile.constantPool;

//CONSTANT_Long_info结构表示8字节（long）的数值常量：
/**
在Class文件的常量池中，所有的8字节的常量都占两个表成员（项）的空间。
如果一个CONSTANT_Long_info或CONSTANT_Double_info结构的项在常量池中的索引为n，
则常量池中下一个有效的项的索引为n+2，此时常量池中索引为n+1的项有效但必须被认为不可用①。
由于历史原因（译者注：是指JVM开发时是处于32位机为主流的时代），让8字节常量占用2个表元素的空间是一个无奈的选择。
*/
public class ConstantLongInfo extends ConstantPoolInfo{

	/**
	 * CONSTANT_Long_info { u1 tag; 
	 * 						u4 high_bytes; 
	 * 						u4 low_bytes; 
	 * 		}
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
	 * CONSTANT_Long_info结构中的无符号的high_bytes和low_bytes项用于共同表示long型常量，
	 * 构造形式为((long) high_bytes << 32) + low_bytes，
	 * high_bytes和low_bytes都按照Big-Endian顺序存储。
	 */
	
}
