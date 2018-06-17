package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame.VerificationTypeInfo;

/*帧类型same_locals_1_stack_item_frame_extended由值为247的类型标记表示，
 *它表明当前帧拥有和前一个栈映射帧完全相同的locals[]数组，同时对应的stack[]数组的成员个数为1。
 *当前帧的offset_delta的值需要由offset_delta项明确指定。
 *有1个stack[]数组的成员跟随在offset_delta项之后。
 *
 * same_locals_1_stack_item_frame_extended {
	    u1 frame_type = SAME_LOCALS_1_STACK_ITEM_EXTENDED;  247 
	    u2 offset_delta;
	    verification_type_info stack[1];
	}
 */
public class SameLocals1StackItemFrameExtended extends StackMapFrame{
	
	private VerificationTypeInfo[] stack;//length=1

}
