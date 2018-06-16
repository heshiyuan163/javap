package classAnalyser.classFile;

import classAnalyser.classFile.fields.FieldInfo;
import classAnalyser.struct.U2Struct;

public class Fields extends U2Struct{
	/*
	 *   {
	 *   	u2 fields_count; 
	 *   	field_info fields[fields_count];
	 *   }
	 */
	/*
	 * 字段计数器，fields_count的值表示当前Class文件fields[]数组的成员个数。
	 * fields[]数组中每一项都是一个field_info结构（§4.5）的数据项，
	 * 它用于表示该类或接口声明的类字段或者实例字段①。
	 * ① 译者注：类字段即被声明为static的字段，也称为类变量或者类属性，同样，实例字段是指未被声明为static的字段。
	 * 由于《Java虚拟机规范》中，“Variable”和“Attribute”出现频率很高且在大多数场景中具备其他含义，
	 * 所以译文中统一把“Field”翻译为“字段”，即“类字段”、“实例字段”。
	 */
	private int fields_count;
	
	/*
	 * 字段表，fields[]数组中的每个成员都必须是一个fields_info结构（§4.5）的数据项，
	 * 用于表示当前类或接口中某个字段的完整描述。
	 * fields[]数组描述当前类或接口声明的所有字段，但不包括从父类或父接口继承的部分。
	 */
	private FieldInfo[] fields;

}
