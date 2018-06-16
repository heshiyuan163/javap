package classAnalyser.classFile;

import classAnalyser.classFile.methods.MethodInfo;
import classAnalyser.struct.U2Struct;

/*
 * methods{
 * 	 u2             methods_count;
     method_info    methods[methods_count];
 * }
 */
public class Methods extends U2Struct{
	
	/*
	 * 方法计数器，methods_count的值表示当前Class文件methods[]数组的成员个数。
	 * Methods[]数组中每一项都是一个method_info结构（§4.5）的数据项。
	 */
	private int methods_count;
	
	
	/*
	 * 方法表，methods[]数组中的每个成员都必须是一个method_info结构（§4.6）的数据项，用于表示当前类或接口中某个方法的完整描述。
	 * 如果某个method_info结构的access_flags项既没有设置ACC_NATIVE标志也没有设置ACC_ABSTRACT标志，那么它所对应的方法体
	 * 就应当可以被Java虚拟机直接从当前类加载，而不需要引用其它类。
	 * method_info结构可以表示类和接口中定义的所有方法，包括实例方法、类方法、实例初始化方法方法（§2.9）和类或接口初始化方法方法（§2.9）。
	 * methods[]数组只描述当前类或接口中声明的方法，不包括从父类或父接口继承的方法。
	 */
	private MethodInfo[] methods; //length=methods_count
	

}
