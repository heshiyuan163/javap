package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

/*
 * stack_map_frame结构的第一个字节作为类型标记（Tag），第一个字节后会跟随0或多个字节用于说明更多信息，这些信息因类型标记的不同而变化。
 * 
 * All frame types, even full_frame, rely on the previous frame for some of their semantics. 
 * This raises the question of what is the very first frame? The initial frame is implicit, 
 * and computed from the method descriptor. (See the Prolog predicate methodInitialStackFrame (§4.10.1.6).) 
 * 
 * 译文:所有的帧类型，包括full_frame，它们的部分语义会依赖于前置帧，这点使得确定基准帧（Very First Frame）变得尤为重要，
 * 方法的初始帧是隐式的，它通过方法描述符计算得出，详细信息请参考methodInitialStackFrame (§4.10.1.6).) 
 */

public class StackMapFrame {
	
	private byte b1;//high byte of frame_type
	private byte b2;//low byte of frame_type
	private int frame_type;
	
	private byte b3;//high byte of offset_delta
	private byte b4;//low byte of offset_delta
	private int offset_delta;
}
