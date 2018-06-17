package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame;

/*	Uninitialized_variable_info说明存储单元包含验证类型uninitialized(offset)。
 * 	offset项给出了一个偏移量，表示在包含此StackMapTable属性的Code属性中，new指令创建的对象所存储的位置。
 * 
 * 	Uninitialized_variable_info {
	    u1 tag = ITEM_Uninitialized =8
	    u2 offset;
	}
 */
public class UninitializedVariableInfo extends VerificationTypeInfo{
	private byte b1;//high byte of offset
	private byte b2;//low byte of offset
	private int offset;

}
