package classAnalyser.classFile;

import classAnalyser.struct.U2Struct;

/*
 * 类索引，this_class的值必须是对constant_pool表中项目的一个有效索引值。
 * constant_pool表在这个索引处的项必须为CONSTANT_Class_info类型常量（§4.4.1），
 * 表示这个Class文件所定义的类或接口。
 */
public class ThisClass extends U2Struct{

}
