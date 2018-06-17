package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;
import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.lineNumberTableAttribute.LineNumberTableItem;

/*
 * LineNumberTable属性是可选变长属性，位于Code（§4.7.3）结构的属性表。
 * 它被调试器用于确定源文件中行号表示的内容在Java虚拟机的code[]数组中对应的部分。
 * 在Code属性的属性表中，LineNumberTable属性可以按照任意顺序出现，
 * 此外，多个LineNumberTable属性可以共同表示一个行号在源文件中表示的内容，即LineNumberTable属性不需要与源文件的行一一对应(因为可能一行源码由多个字节码指令组成)。
 * 
 * The LineNumberTable attribute has the following format:

	LineNumberTable_attribute {
	    u2 attribute_name_index;
	    u4 attribute_length;
	    u2 line_number_table_length;
	    {   u2 start_pc;
	        u2 line_number;	
	    } line_number_table[line_number_table_length];
	}
 */
public class LineNumberTableAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“LineNumberTable”。
	 */
	
	/*
	 * attribute_length给出了当前属性的长度，不包括开始的attribute_name_index+attribute_length的6个字节。
	 */
	
	
	private byte b7;//high byte of line_number_table_length
	private byte b8;//low byte of line_number_table_length
	
	/*
	 * line_number_table_length项的值给出了line_number_table[]数组的成员个数。
	 */
	private int line_number_table_length;
	
	/*
	 * line_number_table[]数组的每个成员都表明源文件中行号的变化在code[]数组中都会有对应的标记点。
	 */
	private LineNumberTableItem[] line_number_table;//length=line_number_table_length
	
	

}
