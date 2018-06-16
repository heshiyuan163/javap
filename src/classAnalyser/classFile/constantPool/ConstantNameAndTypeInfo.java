package classAnalyser.classFile.constantPool;

/*
 * CONSTANT_NameAndType_info结构用于表示字段或方法，
 * 但是和4.4.2章节中介绍的3个结构不同，
 * CONSTANT_NameAndType_info结构没有标识出它所属的类或接口，
 */
public class ConstantNameAndTypeInfo extends ConstantPoolInfo{
	
	/**
	 * CONSTANT_NameAndType_info { u1 tag; 
	 * 								u2 name_index; 
	 * 								u2 descriptor_index;
	 * 							 }
	 */
	
	private byte b1;//high byte of name_index
	private byte b2;//low byte of name_index
	
	/**
	 * name_index项的值必须是对常量池的有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 这个结构要么表示特殊的方法名<init>（§2.9），
	 * 要么表示一个有效的字段或方法的非限定名（Unqualified Name）。
	 */
	private int name_index;
	
	private byte b3;//high byte of descriptor_index
	private byte b4;//low byte of descriptor_index
	
	/**
	 * descriptor_index项的值必须是对常量池的有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，
	 * 这个结构表示一个有效的字段描述符（§4.3.2）或方法描述符（§4.3.3）。
	 */
	private int descriptor_index;
}
	