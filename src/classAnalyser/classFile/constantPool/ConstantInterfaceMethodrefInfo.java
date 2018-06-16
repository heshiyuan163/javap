package classAnalyser.classFile.constantPool;

//接口方法
public class ConstantInterfaceMethodrefInfo extends ConstantPoolInfo{
	
	/**
	 * CONSTANT_InterfaceMethodref_info { u1 tag; 
	 * 										u2 class_index; 
	 * 										u2 name_and_type_index;
	 * 								 }
	 */
	
	private byte b1;//high byte of class_index
	private byte b2;//low byte of class_index
	
	/**
	 * class_index项的值必须是对常量池的有效索引，常量池在该索引处的项必须是CONSTANT_Class_info（§4.4.1）结构，
	 * 表示一个接口(不能是类)，当前方法是这个接口的成员。
	 */
	private int class_index;
	
	private byte b3;//high byte of name_and_type_index
	private byte b4;//low byte of name_and_type_index
	
	/**
	 * name_and_type_index项的值必须是对常量池的有效索引，常量池在该索引处的项必
		须是CONSTANT_NameAndType_info（§4.4.6）结构，它表示当前方法的名字和描述符。
	 */
	private int name_and_type_index;
}
