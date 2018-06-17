package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame.VerificationTypeInfo;

/*
 * 帧类型same_locals_1_stack_item_frame的类型标记的取值范围是64至127。
 * 如果类型标记所确定的帧类型是same_locals_1_stack_item_frame类型，则说明当前帧拥有和前一个栈映射帧完全相同的locals[]数组，同时对应的stack[]数组的成员个数为1。
 * 当前帧的offset_delta值为frame_type-64。
 * 并且有1个verification_type_info项跟随在此帧类型之后，用于表示那一个stack项的成员。
 * 
 * same_locals_1_stack_item_frame {
	    u1 frame_type = SAME_LOCALS_1_STACK_ITEM;  64-127 
	    verification_type_info stack[1];
	}
 */
public class SameLocals1StackItemFrame extends StackMapFrame{
	
	private VerificationTypeInfo[] stack;//length=1

}
