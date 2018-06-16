package classAnalyser.classFile;

import classAnalyser.classFile.constantPool.ConstantPoolInfo;
import classAnalyser.struct.U2Struct;

public class ConstantPool extends U2Struct{
	
	/*
	 *  ConstantPool{ u2 constant_pool_count; 
	 *   			  cp_info constant_pool[constant_pool_count-1]; 
	 *   			}
	 */
	
	/*
	 * 常量池计数器，constant_pool_count的值等于constant_pool表中的成员数加1。
	 * constant_pool表的索引值只有在大于0且小于constant_pool_count时才会被认为是有效的②，
	 * 对于long和double类型有例外情况，可参见§4.4.5。
	 * 
	 * ② 译者注：虽然值为0的constant_pool索引是无效的，但其他用到常量池的数据结构可以使用索引0来表示“不引用任何一个常量池项”的意思。
	 */
	private int constant_pool_count;
	
	/**
	 * 常量类型							值 
	 * CONSTANT_Class 					7  	done
	 * CONSTANT_Fieldref 				9 	done
	 * CONSTANT_Methodref 				10  done
	 * CONSTANT_InterfaceMethodref 		11 	done
	 * CONSTANT_String 					8 	done
	 * CONSTANT_Integer 				3 	done
	 * CONSTANT_Float 					4 	done
	 * CONSTANT_Long 					5 	done
	 * CONSTANT_Double 					6 	done
	 * CONSTANT_NameAndType 			12 	done
	 * CONSTANT_Utf8 					1 	done
	 * CONSTANT_MethodHandle 			15 	done
	 * CONSTANT_MethodType 				16 	done
	 * CONSTANT_InvokeDynamic 			18	done
	 */
	
	/*
	 * 常量池，constant_pool是一种表结构（§4.4），
	 * 它包含Class文件结构及其子结构中引用的所有字符串常量、类或接口名、字段名和其它常量。
	 * 常量池中的每一项都具备相同的格式特征——第一个字节作为类型标记用于识别该项是哪种类型的常量，
	 * 称为“tag byte”。
	 * 常量池的索引范围是1至constant_pool_count−1。
	 */
	private ConstantPoolInfo[] constant_pool;
	
	
	public int getConstant_pool_count() {
		return constant_pool_count;
	}
	public void setConstant_pool_count(int constant_pool_count) {
		this.constant_pool_count = constant_pool_count;
	}
	public ConstantPoolInfo[] getConstant_pool() {
		return constant_pool;
	}
	public void setConstant_pool(ConstantPoolInfo[] constant_pool) {
		this.constant_pool = constant_pool;
	}
	
	
	
	

}
