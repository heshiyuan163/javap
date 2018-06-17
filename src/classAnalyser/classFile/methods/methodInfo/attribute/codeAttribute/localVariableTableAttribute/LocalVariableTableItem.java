package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.localVariableTableAttribute;

/*
 *		 {  u2 start_pc;
	        u2 length;
	        u2 name_index;
	        u2 descriptor_index;
	        u2 index;
	     }
 */
public class LocalVariableTableItem {
	
	private byte b1;//high byte of start_pc
	private byte b2;//low byte of start_pc
	
	/*
	 * 所有给定的局部变量的索引都在范围[start_pc, start_pc+length)中，即从start_pc（包括自身值）至start_pc+length（不包括自身值）。
	 * start_pc的值必须是一个对当前Code属性的code[]数组的有效索引，code[]数组在这个索引处必须是一条指令操作码。
	 * start_pc+length要么是当前Code属性的code[]数组的有效索引，code[]数组在该索引处必须是一条指令的操作码，要么是刚超过code[]数组长度的最小索引值。
	 */
	private int start_pc;
	
	private byte b3;//high byte of length
	private byte b4;//low byte of length
	
	private int length;
	
	private byte b5;//high byte of name_index
	private byte b6;//low byte of name_index
	
	/*
	 * name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示一个局部变量的有效的非全限定名（§4.2.2）。
	 */
	private int name_index;
	
	private byte b7;//high byte of descriptor_index
	private byte b8;//low byte of descriptor_index
	
	/*
	 * descriptor_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示源程序中局部变量类型的字段描述符（§4.3.2）。
	 */
	private int descriptor_index;
	
	private byte b9;//high byte of index
	private byte b10;//low byte of index
	
	/*
	 * index为此局部变量在当前栈帧的局部变量表中的索引。
	 * 如果在index索引处的局部变量是long或double型，则占用index和index+1两个索引。
	 */
	private int index;

}
