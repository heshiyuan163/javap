package classAnalyser.classFile.fields;

import classAnalyser.classFile.common.attribute.AttributeInfo;

/*
 * 每个字段（Field）都由field_info结构所定义，在同一个Class文件中，不会有两个字段同时具有相同的字段名和描述符（§4.3.2）。
	field_info结构格式如下： 
			field_info { u2 access_flags; 
						 u2 name_index; 
						 u2 descriptor_index; 
						 u2 attributes_count; 
						 attribute_info attributes[attributes_count]; 
					}
 */
public class FieldInfo {
	
	private byte b1;//high byte of access_flags;
	private byte b2;//low byte of access_flags
	
	/*
	 * access_flags项的值是用于定义字段被访问权限和基础属性的掩码标志。access_flags的取值范围和相应含义见下表:
	 * 		标记名			值 			说明 
	 * 		ACC_PUBLIC 		0x0001 		public，表示字段可以从任何包访问。
	 * 		ACC_PRIVATE 	0x0002 		private，表示字段仅能该类自身调用。
	 * 		ACC_PROTECTED 	0x0004 		protected，表示字段可以被子类调用。
	 * 		ACC_STATIC 		0x0008 		static，表示静态字段。
	 * 		ACC_FINAL 		0x0010 		final，表示字段定义后值无法修改（JLS §17.5）
	 * 		ACC_VOLATILE 	0x0040 		volatile，表示字段是易变的。
	 * 		ACC_TRANSIENT 	0x0080 		transient，表示字段不会被序列化。
	 * 		ACC_SYNTHETIC 	0x1000 		表示字段由编译器自动产生。
	 * 		ACC_ENUM 		0x4000 		enum，表示字段为枚举类型。
	 * 1.字段如果带有ACC_SYNTHETIC标志，则说明这个字段不是由源码产生的，而是由编译器自动产生的。
	 * 2.字段如果被标有ACC_ENUM标志，这说明这个字段是一个枚举类型成员。
	 * 3.Class文件中的字段可以被设置多个上表中的标记。不过有些标记是互斥的，一个字段最多只能设置ACC_PRIVATE， ACC_PROTECTED，
	 * 	和ACC_PUBLIC（JLS §8.3.1）三个标志中的一个，也不能同时设置标志ACC_FINAL和ACC_VOLATILE（JLS §8.3.1.4）。
	 * 4.接口中的所有字段都具有ACC_PUBLIC，ACC_STATIC和ACC_FINAL标记，也可能被设置ACC_SYNTHETIC标记，但是不能含有
	 * 	上表中的其它符号标记了（JLS §9.3）。
	 * 5.在上表中没有出现的access_flags项的值为扩充而预留，在生成的Class文件中应被设置成0，Java虚拟机实现也应该忽略它们。
	 */
	private int access_flags;
	
	private byte b3;//high byte of name_index
	private byte b4;//low byte of name_index
	
	/*
	 * name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示一个有效的字段的非全限定名（§4.2.2）。
	 */
	private int name_index;
	
	private byte b5;//high byte of descriptor_index
	private byte b6;//low byte of descriptor_index
	
	/*
	 * descriptor_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示一个有效的字段的描述符（§4.3.2）。
	 */
	private int descriptor_index;
	
	private byte b7;//high byte of attributes_count
	private byte b8;//low byte of attributes_count
	
	//attributes_count的项的值表示当前字段的附加属性（§4.7）的数量
	private int attributes_count;
	
	/*
	 * attributes表的每一个成员的值必须是attribute（§4.7）结构，一个字段可以有任意个关联属性。 
	 * 本规范所定义的field_info结构中，attributes表可出现的成员有：
	 * 		ConstantValue（§4.7.2）, ==>ConstantValueAttribute
	 * 		Synthetic（§4.7.8）, 		==>SyntheticAttribute
	 * 		Signature（§4.7.9）, 		==>SignatureAttribute
	 * 		Deprecated（§4.7.15）, 	==>DeprecatedAttribute
	 * 		RuntimeVisibleAnnotations（§4.7.16）==>RuntimeVisibleAnnotationsAttribute 和
	 * 		RuntimeInvisibleAnnotations（§4.7.17）。 
	 * Java虚拟机实现必须正确的识别和读取field_info结构的attributes表中的ConstantValue（§4.7.2）属性。
	 * 如果Java虚拟机实现支持版本号为49.0或更高的Class文件，那么它必须正确的识别和读取这些Class文件中的Signature（§4.7.9）, 
	 * RuntimeVisibleAnnotations（§4.7.16） 和RuntimeInvisibleAnnotations（§4.7.17）结构。 
	 * 所有Java虚拟机实现都必须默认忽略field_info结构中attributes表所不可识别的成员。
	 * 本规范中没有定义的属性不可影响Class文件的语义，它们只能提供附加描述信息（§4.7.1）。
	 */
	private AttributeInfo[] attributes;

}
