package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute.stackMapFrame;

/*	Object_variable_info类型说明存储单元包含某个Class的实例。
 * 	由常量池在cpool_index给出的索引处的CONSTANT_CLASS_Info（§4.4.1）结构表示。
 * 
 * Object_variable_info {
	    u1 tag = ITEM_Object; =7
	    u2 cpool_index;
	}
 */
public class ObjectVariableInfo extends VerificationTypeInfo{
	
	private byte b1;//high byte of cpool_index
	private byte b2;//low byte of cpool_index
	private int cpool_index;

}
