package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame.VerificationTypeInfo;

/*帧类型append_frame的类型标记的取值范围是252至254。
 *如果类型标记所确定的帧类型为append_frame，则说明对应操作数栈为空，并且包含和前一个栈映射帧相同的locals[]数组，不过还额外附加k个的locals项。
 *k值为frame_type-251。
 *
 * append_frame {
	    u1 frame_type = APPEND;  252-254 
	    u2 offset_delta;
	    verification_type_info locals[frame_type - 251];
	}
	
	The 0th entry in locals represents the type of the first additional local variable. 
	If locals[M] represents local variable N, 
	then locals[M+1] represents local variable N+1 if locals[M] is one of:
    				Top_variable_info
				    Integer_variable_info
				    Float_variable_info
				    Null_variable_info
				    UninitializedThis_variable_info
				    Object_variable_info
				    Uninitialized_variable_info
	Otherwise locals[M+1] represents local variable N+2.

	It is an error if, 
	for any index i, 
	locals[i] represents a local variable whose index is greater than the maximum number of local variables for the method. 
	
	
	译文：在locals[]数组中，索引为0的（第一个）成员表示第一个添加的局部变量。
		如果要从条件“locals[M]表示第N个局部变量”中推导出结论“locals[M+1]就表示第N+1个局部变量”的话，那就意味着locals[M]一定是下列结构之一：
 				Top_variable_info
 				Integer_variable_info
				Float_variable_info
			 	Null_variable_info
			 	UninitializedThis_variable_info
			 	Object_variable_info
				Uninitialized_variable_info
		否则，locals[M+1]就将表示第N+2个局部变量。
		对于任意的索引i，locals[i]所表示的局部变量的索引都不能大于此方法的局部变量表的最大索引值。
 */
public class AppendFrame extends StackMapFrame{
	
	private VerificationTypeInfo[] locals;

}
