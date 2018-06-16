package classAnalyser.classFile.constantPool;

public class ConstantMethodHandleInfo extends ConstantPoolInfo{
	/**
	 * CONSTANT_MethodHandle_info结构用于表示方法句柄，
	 * 结构如下： CONSTANT_MethodHandle_info { u1 tag; 
	 * 										u1 reference_kind; 
	 * 										u2 reference_index;
	 *									 }
	 */
	
	/**
	 * reference_kind项的值必须在1至9之间（包括1和9），
	 * 它决定了方法句柄的类型。
	 * 方法句柄类型的值表示方法句柄的字节码行为（Bytecode Behavior §5.4.3.5）。
	 */
	private byte reference_kind;
	
	private byte b1;//high byte of reference_index
	private byte b2;//low byte of reference_index
	
	/**
	 * reference_index项的值必须是对常量池的有效索引：
	 * 如果reference_kind项的值为1（REF_getField）、2（REF_getStatic）、3（REF_putField）
	 * 或4（REF_putStatic），那么常量池在reference_index索引处的项必须是CONSTANT_Fieldref_info（§4.4.2）结构，
	 * 表示由一个字段创建的方法句柄。
 	如果reference_kind项的值是5（REF_invokeVirtual）、6（REF_invokeStatic）、7（REF_invokeSpecial）
	或8（REF_newInvokeSpecial），那么常量池在reference_index索引处的项必须是CONSTANT_Methodref_info（§4.4.2）结构，
	表示由类的方法或构造函数创建的方法句柄。
	 如果reference_kind项的值是9（REF_invokeInterface），那么常量池在reference_index索引处的项必须是
	CONSTANT_InterfaceMethodref_info（§4.4.2）结构，表示由接口方法创建的方法句柄。
 	如果reference_kind项的值是5（REF_invokeVirtual）、6（REF_invokeStatic）、7（REF_invokeSpecial）
	或9（REF_invokeInterface），那么方法句柄对应的方法不能为实例初始化（<init>）方法或类初始化方法（<clinit>）。
 	如果reference_kind项的值是8（REF_newInvokeSpecial），那么方法句柄对应的方法必须为实例初始化（<init>）方法。
	 */
	private int reference_index;
	
}
