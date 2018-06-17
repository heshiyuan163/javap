package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.lineNumberTableAttribute;

import classAnalyser.struct.U2Struct;

/*
  {    u2 start_pc;
	   u2 line_number;	
   } 
 */
public class LineNumberTableItem extends U2Struct{
	
	/*
	 * start_pc项的值必须是code[]数组的一个索引，code[]数组在该索引处的字符表示源文件中新的行的起点。
	   start_pc项的值必须小于当前LineNumberTable属性所在的Code属性的code_length项的值。
	 */
	private int start_pc;
	
	private byte b3;//high byte of line_number
	private byte b4;//low byte of line_number
	
	//ine_number项的值必须与源文件的行数相匹配。
	private int line_number;
	
	

}
