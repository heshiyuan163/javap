package classAnalyser.classFile.constantPool;

//方法
public class ConstantMethodrefInfo extends ConstantPoolInfo{
	
	/**
	 * CONSTANT_Methodref_info { u1 tag; 
	 * 							 u2 class_index; 
	 * 							 u2 name_and_type_index; 
	 * 						}
	 */

	
	private byte b1;//high byte of class_index
	private byte b2;//low byte of class_index
	
	/**
	 * class_index项的值必须是对常量池的有效索引，常量池在该索引处的项必须是CONSTANT_Class_info（§4.4.1）结构，
	 * 表示一个类(不能是接口)，当前方法是这个类的成员。
	 */
	private int class_index;
	
	private byte b3;//high byte of name_and_type_index
	private byte b4;//low byte of name_and_type_index
	
	/**
	 * name_and_type_index项的值必须是对常量池的有效索引，常量池在该索引处的项必
		须是CONSTANT_NameAndType_info（§4.4.6）结构，它表示当前方法的名字和描述符。
		
		如果一个CONSTANT_Methodref_info结构的方法名以“<”（'\u003c'）开头，则说明这个
		方法名是特殊的<init>，即这个方法是实例初始化方法（§2.9），它的返回类型必须为空。
	 */
	private int name_and_type_index;
}
