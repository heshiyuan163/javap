package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

import classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame.VerificationTypeInfo;

/*
 * full_frame {
	    u1 frame_type = FULL_FRAME;  255 
	    u2 offset_delta;
	    u2 number_of_locals;
	    verification_type_info locals[number_of_locals];
	    u2 number_of_stack_items;
	    verification_type_info stack[number_of_stack_items];
	}
	
	
	The 0th entry in locals represents the type of local variable 0. 
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
	
	The 0th entry in stack represents the type of the bottom of the stack, 
	and subsequent entries represent types of stack elements closer to the top of the operand stack. 
	We shall refer to the bottom element of the stack as stack element 0, 
	and to subsequent elements as stack element 1, 2 etc. 
	If stack[M] represents stack element N, 
	then stack[M+1] represents stack element N+1 if stack[M] is one of:
				    Top_variable_info
				    Integer_variable_info
				    Float_variable_info
				    Null_variable_info
				    UninitializedThis_variable_info
				    Object_variable_info
				    Uninitialized_variable_info
	Otherwise, stack[M+1] represents stack element N+2.
	It is an error if, 
	for any index i, 
	stack[i] represents a stack entry whose index is greater than the maximum operand stack size for the method. 
 */
public class FullFrame extends StackMapFrame{
	
	private byte b5;//high byte of number_of_locals
	private byte b6;//low byte of number_of_locals
	
	private int number_of_locals;
	private VerificationTypeInfo[] locals;//length=number_of_locals
	
	private byte b7;//high byte of number_of_stack_items
	private byte b8;//low byte of number_of_stack_items
	
	private int number_of_stack_items;
	private VerificationTypeInfo[] stack;//length=number_of_stack_items

}
