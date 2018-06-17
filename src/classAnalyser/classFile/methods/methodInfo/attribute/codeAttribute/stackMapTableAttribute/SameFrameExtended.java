package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

/*帧类型same_frame_extended由值为251的类型标记表示。
 *如果类型标记所确定的帧类型是same_frame_extended类型，则说明 当前帧 有拥有和前一个 栈映射帧 的完全相同的locals[]数组，同时对应的stack[]数组的成员数量为0。
 * same_frame_extended {
	    u1 frame_type = SAME_FRAME_EXTENDED;  251 
	    u2 offset_delta;
	}
 */
public class SameFrameExtended extends StackMapFrame{

}
