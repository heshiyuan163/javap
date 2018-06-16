package classAnalyser.classFile;

import classAnalyser.struct.U2Struct;
/*
访问标志，access_flags是一种掩码标志，用于表示某个类或者接口的访问权限及基础属性。
access_flags的取值范围和相应含义下表： 
	标记名 			值 			含义 
	ACC_PUBLIC 		0x0001 		可以被包的类外访问。 
	ACC_FINAL 		0x0010 		不允许有子类。 
	ACC_SUPER 		0x0020 		当用到invokespecial指令时，需要特殊处理③的父类方法。
	ACC_INTERFACE 	0x0200 		标识定义的是接口而不是类。
	ACC_ABSTRACT 	0x0400 		不能被实例化。 
	ACC_SYNTHETIC 	0x1000 		标识并非Java源码生成的代码。
	ACC_ANNOTATION 	0x2000 		标识注解类型 
	ACC_ENUM 		0x4000 		标识枚举类型
③ 译者注：此处“特殊处理”是相对于JDK 1.0.2之前的Class文件而言，invokespecial的语义和处理方式
	在JDK 1.0.2时发生了变化，为避免二义性，在JDK 1.0.2之后编译出的Class文件，都带有ACC_SUPER标志用以区分。

1.带有ACC_SYNTHETIC标志的类，意味着它是由编译器自己产生的而不是由程序员编写的源代码生成的。
2.带有ACC_ENUM标志的类，意味着它或它的父类被声明为枚举类型。
3.带有ACC_INTERFACE标志的类，意味着它是接口而不是类，反之是类而不是接口。
     如果一个Class文件被设置了ACC_INTERFACE标志，那么同时也得设置ACC_ABSTRACT标志（JLS §9.1.1.1）。
     同时它不能再设置ACC_FINAL、ACC_SUPER 和 ACC_ENUM标志。
4.注解类型必定带有ACC_ANNOTATION标记，如果设置了ANNOTATION标记，ACC_INTERFACE也必须被同时设置。
     如果没有同时设置ACC_INTERFACE标记，那么这个Class文件可以具有上表中的除ACC_ANNOTATION外的所有其它标记。
     当然ACC_FINAL和ACC_ABSTRACT这类互斥的标记除外（JLS §8.1.1.2）
5.ACC_SUPER标志用于确定该Class文件里面的invokespecial指令使用的是哪一种执行语义。
     目前Java虚拟机的编译器都应当设置这个标志。ACC_SUPER标记是为了向后兼容旧编译器编译的
  Class文件而存在的，在JDK1.0.2版本以前的编译器产生的Class文件中，access_flag里面没有ACC_SUPER标志。
    同时，JDK1.0.2前的Java虚拟机遇到ACC_SUPER标记会自动忽略它。
6.在上表中没有使用的access_flags标志位是为未来扩充而预留的，这些预留的标志为在编译器中会被设置为0， Java虚拟机实现也会自动忽略它们。
 */
public class AccessFlags extends U2Struct{

	
}
