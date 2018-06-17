package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;
import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.localVariableTableAttribute.LocalVariableTableItem;

/*
 * 	LocalVariableTable是可选变长属性，位于Code（§4.7.3）属性的属性表中。
	它被调试器用于确定方法在执行过程中局部变量的信息。
	在Code属性的属性表中，LocalVariableTable属性可以按照任意顺序出现。
	Code属性中的每个局部变量最多只能有一个LocalVariableTable属性。
	
	The LocalVariableTable attribute has the following format:

	LocalVariableTable_attribute {
	    u2 attribute_name_index;
	    u4 attribute_length;
	    u2 local_variable_table_length;
	    {   u2 start_pc;
	        u2 length;
	        u2 name_index;
	        u2 descriptor_index;
	        u2 index;
	    } local_variable_table[local_variable_table_length];
	}
 */
public class LocalVariableTableAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“LocalVariableTable”。
	 */
	
	//attribute_length项的值给出当前属性的长度，不包括开始的attribute_name_index+attribute_length的6个字节。
	
	
	private byte b7;//high byte of local_variable_table_length
	private byte b8;//low byte of local_variable_table_length
	
	/*
	 * local_variable_table_length项的值给出了local_variable_table[]数组的成员的数量。
	 */
	private int local_variable_table_length;
	
	/*
	 * local_variable_table[]数组的每一个成员表示一个局部变量的值在code[]数组中的偏移量范围。
	 * 它同时也是用于从当前帧的局部变量表找出所需的局部变量的索引。
	 */
	private LocalVariableTableItem[] local_variable_table;
}
