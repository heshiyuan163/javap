package classAnalyser.classFile.methods;

import classAnalyser.classFile.common.attribute.AttributeInfo;

/*
方法:
所有方法（Method），包括实例初始化方法和类初始化方法（§2.9）在内，都由method_info结构所定义。
在一个Class文件中，不会有两个方法同时具有相同的方法名和描述符（§ 4.3.3）。
	method_info结构格式如下:
	
	method_info {
	    u2             access_flags;
	    u2             name_index;
	    u2             descriptor_index;
	    u2             attributes_count;
	    attribute_info attributes[attributes_count];
	}
 */
public class MethodInfo {
	
	private byte b1;//high byte of access_flags
	private byte b2;//low byte of access_flags
	
	/*
	 * access_flags项的值是用于定义当前方法的访问权限和基本属性的掩码标志，access_flags的取值范围和相应含义见表4.5所示。
	 * 表4.5 方法 access_flags标记列表:
	 * 标记名				值 			说明
	 * ACC_PUBLIC 		0x0001 		public，方法可以从包外访问
	 * ACC_PRIVATE 		0x0002 		private，方法只能本类中访问
	 * ACC_PROTECTED 	0x0004 		protected，方法在自身和子类可以访问
	 * ACC_STATIC 		0x0008 		static，静态方法
	 * ACC_FINAL 		0x0010 		final，方法不能被重写（覆盖） 
	 * ACC_SYNCHRONIZED 0x0020 		synchronized，方法由管程同步
	 * ACC_BRIDGE 		0x0040 		bridge，方法由编译器产生
	 * ACC_VARARGS 		0x0080 		表示方法带有变长参数
	 * ACC_NATIVE 		0x0100 		native，方法引用非java语言的本地方法
	 * ACC_ABSTRACT 	0x0400 		abstract，方法没有具体实现
	 * ACC_STRICT 		0x0800 		strictfp，方法使用FP-strict浮点格式
	 * ACC_SYNTHETIC 	0x1000 		方法在源文件中不出现，由编译器产生
	 * 
	ACC_VARARGS标志是用于说明方法在源码层的参数列表是否变长的。如果是变长的，则在编译时，方法的ACC_VARARGS标志设置1，其余的方法ACC_VARARGS标志设置为0。
	ACC_BRIDGE标志用于说明这个方法是由编译生成的桥接方法①。
	如果方法设置了ACC_SYNTHETIC标志，则说明这个方法是由编译器生成的并且不会在源代码中出现，少量的例外情况将在4.7.8节“Synthetic属性”中提到。
	Class文件中的方法可以设置多个表4.5中的标志，但是有些标志是互斥的：
		1.一个方法只能设置ACC_PRIVATE，ACC_PROTECTED和ACC_PUBLI三个标志中的一个标志；
		2.如果一个方法被设置ACC_ABSTRACT标志，则这个方法不能被设置ACC_FINAL，ACC_NATIVE, ACC_PRIVATE, ACC_STATIC, ACC_STRICT和
			ACC_SYNCHRONIZED标志（JLS §8.4.3.1, JLS §8.4.3.3, JLS §8.4.3.4）。 
	所有的接口方法必须被设置ACC_ABSTRACT和ACC_PUBLIC标志；还可以选择设置ACC_VARARGS，ACC_BRIDGE和ACC_SYNTHETIC标志，但是不能再设置表4.5中
	其它的标志了（JLS §9.4）。
	实例初始化方法（§2.9）只能被ACC_PRIVATE，ACC_PROTECTED和ACC_PUBLIC中的一个标志；还可以设置ACC_STRICT， ACC_VARARGS和ACC_SYNTHETIC标志，
	但是不能再设置表4.5中的其它标志了。
	类初始化方法（§2.9）由Java虚拟机隐式自动调用，它的access_flags项的值除了ACC_STRICT标志，其它的标志都将被忽略。
	在表4.5中没有出现的access_flags项值为未来扩充而预留，在生成的Class文件中应被设置成0，Java虚拟机实现应该忽略它们。

	① 译者注：桥接方法是JDK 1.5引入泛型后，为了使Java的范型方法生成的字节码和1.5版本前的字节码相兼容，由编译器自动生成的方法。
	 */
	private int access_flags;
	
	private byte b3;//high byte of name_index
	private byte b4;//low byte of name_index
	
	/*
	 * name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，它要么表示初始化方法的名字（<init>或<clinit>），要么表示一个方法的有效的非全限定名（§4.2.2）
	 */
	private int name_index;
	
	private byte b5;//high byte of descriptor_index
	private byte b6;//low byte of descriptor_index
	
	/*
	 * descriptor_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的项必须是CONSTANT_Utf8_info（§4.4.7）结构，表示一个有效的方法的描述符（§4.3.3） (注意：本规范在未来的某个版本中可能会要求当access_flags项的
	 * ACC_VARARGS标志被设置时，方法描述符中的最后一个参数必须是数组类型)
	 */
	private int descriptor_index;
	
	private byte b7;//high byte of attributes_count
	private byte b8;//low byte of attributes_count
	
	/*
	 * attributes_count的项的值表示这个方法的附加属性（§4.7）的数量。
	 */
	private int attributes_count;
	
	/*
	 * attributes表的每一个成员的值必须是attribute（§4.7）结构，一个方法可以有任意个与之相关的属性。
	 * 本规范所定义的method_info结构中，属性表可出现的成员有：
	 * 				Code（§4.7.3），==>CodeAttribute
	 * 				Exceptions（§4.7.5），==>ExceptionsAttribute
	 * 				Synthetic（§4.7.8），==>SyntheticAttribute
	 * 				Signature（§4.7.9），==>SignatureAttribute
	 * 				Deprecated（§4.7.15），==>DeprecatedAttribute
	 * 				RuntimeVisibleAnnotations（§4.7.16），==>RuntimeVisibleAnnotationsAttribute
	 * 				RuntimeInvisibleAnnotations（§4.7.17），==>RuntimeInvisibleAnnotationsAttribute
	 * 				RuntimeVisibleParameterAnnotations（§4.7.18），==>RuntimeVisibleParameterAnnotationsAttribute
	 * 				RuntimeInvisibleParameterAnnotations（§4.7.19），==>RuntimeInvisibleParameterAnnotationsAttribute
	 * 				AnnotationDefault（§4.7.20）==>AnnotationDefaultAttribute
	 * 	结构。
	 * 
	 * Java虚拟机实现必须正确识别和读取method_info结构中的属性表的Code（§4.7.3）和Exceptions（§4.7.5）属性。
	 * 如果Java虚拟机实现支持版本为49.0或更高的Class文件，那么它必须正确识别和读取这些Class文件的Signature（§4.7.9），
	 * 		RuntimeVisibleAnnotations（§4.7.16）， RuntimeInvisibleAnnotations（§4.7.17）， 
	 * 		RuntimeVisibleParameterAnnotations（§4.7.18），RuntimeInvisibleParameterAnnotations（§4.7.19）和 
	 * 		AnnotationDefault（§4.7.20）属性。
	 * 所有Java虚拟机实现必须默认忽略method_info结构中attributes表所不可识别的成员。
	 * 本规范中没有定义的属性不可影响Class文件的语义，它们只能提供附加描述信息（§4.7.1）。
	 */
	private AttributeInfo[] attributes;

}
