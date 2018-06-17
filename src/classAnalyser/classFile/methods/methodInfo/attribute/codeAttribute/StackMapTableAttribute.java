package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute;

import classAnalyser.classFile.common.attribute.AttributeInfo;
import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.StackMapFrame;


/*	StackMapTable属性是一个变长属性，位于Code（§4.7.3）属性的属性表中。
 * 	这个属性会在虚拟机类加载的类型阶段（§4.10.1）被使用。
	StackMapTable属性包含0至多个栈映射帧（Stack Map Frames），
	每个 栈映射帧 都显式或隐式地指定了一个字节码偏移量，
	用于表示 局部变量表 和 操作数栈 的验证类型（Verification Types §4.10.1）。
	
	类型检测器（Type Checker）会检查和处理目标方法的 局部变量 和 操作数栈 所需要的类型。
	本章节中，一个存储单元（Location）的含义是唯一的 局部变量 或 操作数栈项。
	
	我们还将用到术语“栈映射帧”（Stack Map Frame）和“类型状态”（Type State）来描述如何从方法的 局部变量 和 操作数栈 的存储单元映射到验证类型（Verification Types）。
	当描述Class文件侧的映射时，我们通常使用的术语是“栈映射帧”，而当描述类型检查器侧的映射关系时，我们通常使用的术语是“类型状态”。
	
	在版本号大于或等于50.0的Class文件中，如果方法的Code属性中没有附带StackMapTable属性，那就意味着它带有一个隐式的StackMap属性。
	这个StackMap属性的作用等同于number_of_entries值为0的StackMapTable属性。
	一个方法的Code属性最多只能有一个StackMapTable属性，否则将抛出ClassFormatError异常。
	
 	The StackMapTable attribute has the following format:

		StackMapTable_attribute {
		    u2              attribute_name_index;
		    u4              attribute_length;
		    u2              number_of_entries;
		    stack_map_frame entries[number_of_entries];
		}
 */
public class StackMapTableAttribute extends AttributeInfo{
	
	/*
	 * attribute_name_index项的值必须是对常量池的有效索引，常量池在该索引的项处必须是CONSTANT_Utf8_info（§4.4.7）结构，表示“StackMapTable”字符串。
	 */
	
	//attribute_length项的值表示当前属性的长度，不包括开始的attribute_name_index+attribute_length的6个字节。
	
	private byte b7;//high byte of number_of_entries
	private byte b8;//low byte of number_of_entries
	
	/*
	 * number_of_entries项的值给出了entries表中的成员数量。
	 * Entries表的每个成员是都是一个stack_map_frame结构的项。
	 */
	private int number_of_entries;
	
	/*
	 * entries表给出了当前方法所需的stack_map_frame结构。
	 * 
	 * 每个stack_map_frame结构都使用一个特定的字节偏移量来表示类型状态。
	 * 每个帧类型（Frame Type）都显式或隐式地标明一个offset_delta（增量偏移量）值，用于计算每个帧在运行时的实际字节码偏移量。
	 * 使用时帧的字节偏移量计算方法为：前一帧的字节码偏移量（Bytecode Offset）加上offset_delta的值再加1，
	 * 如果前一个帧是方法的初始帧（Initial Frame），那这时候字节码偏移量就是offset_delta。
	 * 
	 * 只要保证栈映射帧有正确的存储顺序，在类型检查时我们就可以使用 增量偏移量 而不是实际的 字节码偏移量。
	 * 此外，由于对每一个帧都使用了offset_delta+1的计算方式，我们可以确保 偏移量 不会重复。
	 * 
	 * 在Code属性的code[]数组项中，如果偏移量i的位置是某条指令的起点，同时这个Code属性包含有StackMapTable属性，
	 * 它的entries项中也有一个适用于地址偏移量i的stack_map_frame结构，那我们就说这条指令拥有一个与之相对应的栈映射帧。
	 * 
	 * 一个栈映射帧可以包含若干种帧类型（Frame Types）：
				   	union stack_map_frame {
							    same_frame;									==>SameFrame
							    same_locals_1_stack_item_frame;				==>SameLocals1StackItemFrame
							    same_locals_1_stack_item_frame_extended;	==>SameLocals1StackItemFrameExtended
							    chop_frame;									==>ChopFrame
							    same_frame_extended;						==>SameFrameExtended
							    append_frame;								==>AppendFrame
							    full_frame;									==>FullFrame
						}
	 */
	private StackMapFrame[] entries;//length=number_of_entries
}
