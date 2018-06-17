package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

/*帧类型chop_frame的类型标记的取值范围是248至250。
 *如果类型标记所确定的帧类型是为chop_frame，则说明对应的操作数栈为空，并且拥有和前一个栈映射帧相同的locals[]数组，不过其中的第k个之后的locals项是不存在的。
 *k的值由251-frame_type确定。
 *
 * chop_frame {
	    u1 frame_type = CHOP;  248-250 
	    u2 offset_delta;
	}
 */
public class ChopFrame extends StackMapFrame{

}
