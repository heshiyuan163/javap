package classAnalyser.classFile.methods.methodInfo.attribute.exceptionsAttribute;

import classAnalyser.struct.U2Struct;

public class ExceptionIndexTableItem extends U2Struct{
	
	/*
	 * 该值必须是对常量池的有效索引。
	 * 常量池在该索引处的成员必须都是CONSTANT_Class_info（§4.4.1）结构，表示这个方法声明要抛出的异常的类的类型。
	 */
	private int CONSTANT_Class_index;

}
