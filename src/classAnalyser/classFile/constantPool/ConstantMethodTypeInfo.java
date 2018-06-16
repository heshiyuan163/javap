package classAnalyser.classFile.constantPool;

public class ConstantMethodTypeInfo extends ConstantPoolInfo{
	
	/**
	 * CONSTANT_MethodType_info结构用于表示方法类型：
	 *  CONSTANT_MethodType_info { u1 tag; 
	 *  						   u2 descriptor_index; 
	 *  						}
	 */
	
	
	private byte b1;//high byte of descriptor_index
	private byte b2;//low byte of descriptor_index
	
	/**
	 * descriptor_index项的值必须是对常量池的有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示方法的描述符（§4.3.3）。
	 */
	private int descriptor_index;
}
