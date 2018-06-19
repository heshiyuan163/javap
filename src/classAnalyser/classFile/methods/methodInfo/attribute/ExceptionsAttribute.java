package classAnalyser.classFile.methods.methodInfo.attribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;
import classAnalyser.classFile.methods.methodInfo.attribute.exceptionsAttribute.ExceptionIndexTableItem;

/*
 * Exceptions属性是一个变长属性，它位于method_info（§4.6）结构的属性表中。
 * Exceptions属性指出了一个方法需要检查的可能抛出的异常。
 * 一个method_info结构中最多只能有一个Exceptions属性。
 * 
 * 一个方法如果要抛出异常，必须至少满足下列三个条件中的一个：
 		要抛出的是RuntimeException或其子类的实例。
 		要抛出的是Error或其子类的实例。
 		要抛出的是在exception_index_table[]数组中申明的异常类或其子类的实例。
      这些要求没有在Java虚拟机中进行强制检查，它们只在编译时进行强制检查。
 * 
 * The Exceptions attribute has the following format:

		Exceptions_attribute {
		    u2 attribute_name_index;
		    u4 attribute_length;
		    u2 number_of_exceptions;
		    u2 exception_index_table[number_of_exceptions];
		}
 */
public class ExceptionsAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的一个有效索引。
	 * 常量池在该索引处的成员必须是CONSTANT_Utf8_info（§4.4.7）结构，表示字符串"Exceptions"。
	 */
	
	//attribute_length项的值给出了当前属性的长度，不包括开始的attribute_name_index+attribute_length的6个字节。
	
	private byte b7;//high byte of number_of_exceptions
	private byte b8;//low byte of number_of_exceptions
	
	//number_of_exceptions项的值给出了exception_index_table[]数组中成员的数量。
	private int number_of_exceptions;
	
	/*
	 * exception_index_table[]数组的每个成员的值都必须是对常量池的有效索引。
	 * 常量池在这些索引处的成员必须都是CONSTANT_Class_info（§4.4.1）结构，表示这个方法声明要抛出的异常的类的类型。
	 */
	private ExceptionIndexTableItem[] exception_index_table;//length=number_of_exceptions
}