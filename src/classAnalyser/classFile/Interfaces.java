package classAnalyser.classFile;

import classAnalyser.classFile.interfaces.InterfaceInfo;
import classAnalyser.struct.U2Struct;

public class Interfaces extends U2Struct{
	/**
	 *  {
	 *  	u2 interfaces_count; 
	 *   	u2 interfaces[interfaces_count];
	 *  }
	 */
	//接口计数器，interfaces_count的值表示当前类或接口的直接父接口数量。
	private int interfaces_count;
	
	/*
	 * 接口表，interfaces[]数组中的每个成员的值必须是一个对constant_pool表中项目的一个有效索引值，它的长度为interfaces_count。
	 * 每个成员interfaces[i] 必须为CONSTANT_Class_info类型常量（§4.4.1），其中0 ≤ i < interfaces_count。
	 * 在interfaces[]数组中，成员所表示的接口顺序和对应的源代码中给定的接口顺序（从左至右）一样，即interfaces[0]对应的是
	 * 源代码中最左边的接口。
	 */
	private InterfaceInfo[] interfaces;

}
