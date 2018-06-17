package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame;

/*	Long_variable_info类型说明存储单元包含验证类型long，
 * 	Long_variable_info {
		    u1 tag = ITEM_Long; =4
	}
	
 * 	This structure gives the contents of two locations in the operand stack or in the local variable array.
	If the location is a local variable, then:
    	It must not be the local variable with the highest index.
    	The next higher numbered local variable contains the verification type top.
	If the location is an operand stack entry, then:
    	The current location must not be the topmost location of the operand stack.
    	The next location closer to the top of the operand stack contains the verification type top.

 * 译文：	如果存储单元是局部变量，则要求：
 			不能是最大索引值的局部变量。
 			按顺序计数的下一个局部变量包含验证类型ᴛ
		如果单元存储是操作数栈成员，则要求：
 			当前的存储单元不能在栈顶。
 			靠近栈顶方向的下一个存储单元包含验证类型ᴛ。
 */
public class LongVariableInfo extends VerificationTypeInfo{

}
