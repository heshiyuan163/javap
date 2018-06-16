package classAnalyser.classFile;

import classAnalyser.struct.U2Struct;

/*
 * 父类索引，对于类来说，super_class的值必须为0或者是对constant_pool表中项目的一个有效索引值。
 * 如果它的值不为0，那constant_pool表在这个索引处的项必须为CONSTANT_Class_info类型常量（§4.4.1），
 * 表示这个Class文件所定义的类的直接父类。
 * 当前类的直接父类，以及它所有间接父类的access_flag中都不能带有ACC_FINAL标记。
 * 对于接口来说，它的Class文件的super_class项的值必须是对constant_pool表中项目的一个有效索引值。
 * constant_pool表在这个索引处的项必须为代表java.lang.Object的CONSTANT_Class_info类型常量（§4.4.1）。
 * 如果Class文件的super_class的值为0，那这个Class文件只可能是定义的是java.lang.Object类，只有它是唯一没有父类的类。
 */
public class SuperClass extends U2Struct{

}
