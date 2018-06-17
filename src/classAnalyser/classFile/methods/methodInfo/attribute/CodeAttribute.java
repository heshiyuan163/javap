package classAnalyser.classFile.methods.methodInfo.attribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;

/*
 * Code属性是一个变长属性，位于method_info（§4.6）结构的属性表。
 * 一个Code属性只为唯一一个方法、实例类初始化方法或类初始化方法（§2.9）保存Java虚拟机指令及相关辅助信息。 
 * 所有Java虚拟机实现都必须能够识别Code属性。
 * 如果方法被声明为native或者abstract类型，那么对应的method_info结构不能有明确的Code属性，
 * 其它情况下，method_info必须有明确的Code属性。
 * 
 * The Code attribute has the following format:

	Code_attribute {
	    u2 attribute_name_index;
	    u4 attribute_length;
	    u2 max_stack;
	    u2 max_locals;
	    u4 code_length;
	    u1 code[code_length];
	    u2 exception_table_length;
	    {   u2 start_pc;
	        u2 end_pc;
	        u2 handler_pc;
	        u2 catch_type;
	    } exception_table[exception_table_length];
	    u2 attributes_count;
	    attribute_info attributes[attributes_count];
	}
 */
public class CodeAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串“Code”。
	 */
	
	/*
	 * attribute_length项的值表示当前属性的长度，不包括attribute_name_index+attribute_length的6个字节。
	 */
	
	private byte b7;//high byte of max_stack
	private byte b8;//low byte of max_stack
	
	/*max_stack项的值给出了当前方法的操作数栈在运行执行的任何时间点的最大深度（§2.6.2）。
	 *在任意时刻，操作数栈都会有一个确定的栈深度，一个long或者double类型的数据会占用2个单位的栈深度，其他数据类型则会占用1个单位深度。
	 */
	private int max_stack;
	
	private byte b9;//high byte of max_locals
	private byte b10;//low byte of max_locals
	
	/*
	 * max_locals项的值给出了分配在当前方法引用的局部变量表中的局部变量个数，包括调用此方法时用于传递参数的局部变量。
	 * long和double型的局部变量的最大索引是max_locals-2，其它类型的局部变量的最大索引是max_locals-1.
	 */
	private int max_locals;
	
	/* u4 code_length;
	    u1 code[code_length];*/
	private byte b11;
	private byte b12;
	private byte b13;
	private byte b14;
	
	/*
	 * code_length项给出了当前方法的code[]数组的字节数①，code_length的值必须大于0，即code[]数组不能为空。
	 * ① 译者注：请注意，由于部分指令在code[]数组中存有直接操作数，换句话说，有一些字节码指令的实际长度是超过一个字节的，
	 * 		因此此处字节数长度code_length并不等同于code[]数组的成员个数。
	 */
	private int code_length;
	
	/*
	 * code[]数组给出了实现当前方法的Java虚拟机字节码。 
	 * code[]数组以按字节寻址的方式读入机器内存，如果code[]数组的第一个字节是按以4字节边界对齐的话，
	 * 那么tableswitch和lookupswitch指令中所有涉及到的32位偏移量也都是按4字节长度对齐的（关于code[]数组边界对齐
	 * 对字节码的影响，请参考相关的指令描述）。 本规范对关于code[]数组内容的详细约束有很多，将在后面单独章节（§4.9）中列出。
	 */
	private byte[] code;
	
	private byte b15;//high byte of exception_table_length
	private byte b16;//low byte of exception_table_length
	
	//exception_table_length项的值给出了exception_table[]数组的成员个数量。
	private int exception_table_length;
	
	/*
	 * exception_table[]数组的每个成员表示code[]数组中的一个异常处理器（Exception Handler）。
	 * exception_table[]数组中，异常处理器顺序是有意义的（不能随意更改），详细内容见2.10节。
	 */
	private ExceptionTableItem[] exception_table;//length=exception_table_length
	
	/*
	 *  u2 attributes_count;
	    attribute_info attributes[attributes_count];
	 */
	
	private byte b17;//high byte of attributes_count
	private byte b18;//low byte of attributes_count
	
	//attributes_count项的值给出了Code属性中attributes表的成员个数。
	private int attributes_count;
	
	/*
	 * 属性表的每个成员的值必须是attribute结构（§4.7）。
	 * 一个Code属性可以有任意数量的可选属性与之关联。
	 * 本规范中定义的、可以出现在Code属性的属性表中的成员只能是	LineNumberTable（§4.7.12），==>LineNumberTableAttribute
	 * 											LocalVariableTable（§4.7.13），==>LocalVariableTableAttribute
	 * 											LocalVariableTypeTable（§4.7.14）和//TODO TODO
	 * 											StackMapTable（§4.7.4）属性。 
	 * 如果一个Java虚拟机实现支持的Class文件版本号为50.0或更高，那么它必须正确的识别和读取Code属性的属性表出现的StackMapTable（§4.7.4）属性。 
	 * Java虚拟机实现必须自动忽略Code属性的属性表数组中出现的所有它不能识别属性。
	 * 本规范中没有定义的属性不可影响Class文件的语义，只能提供附加描述信息（§4.7.1）。
	 */
	private AttributeInfo[] attributes;//length=attributes_count

}
