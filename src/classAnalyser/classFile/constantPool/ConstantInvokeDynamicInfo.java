package classAnalyser.classFile.constantPool;

/*
 * CONSTANT_InvokeDynamic_info用于表示invokedynamic指令所使用到的
 * 引导方法（Bootstrap Method）、引导方法使用到动态调用名称（Dynamic Invocation Name）、
 * 参数和请求返回类型、以及可以选择性的附加被称为静态参数（Static Arguments）的常量序列。
 */
public class ConstantInvokeDynamicInfo extends ConstantPoolInfo{
	/*
	 * CONSTANT_InvokeDynamic_info { u1 tag; 
	 * 								 u2 bootstrap_method_attr_index; 
	 * 								 u2 name_and_type_index;
	 * 							 }
	 */
	
	private byte b1;//high byte of bootstrap_method_attr_index
	private byte b2;//low byte of bootstrap_method_attr_index
	
	/*
	 * bootstrap_method_attr_index项的值必须是对当前Class文件中
	 * 引导方法表（§4.7.21）的bootstrap_methods[]数组的有效索引。
	 */
	private int bootstrap_method_attr_index;
	
	private byte b3;//high byte of name_and_type_index
	private byte b4;//low byte of name_and_type_index
	
	/*
	 * name_and_type_index项的值必须是对当前常量池的有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_NameAndType_info（§4.4.6）结构，
	 * 表示方法名和方法描述符（§4.3.3）。
	 */
	private int name_and_type_index;
}
