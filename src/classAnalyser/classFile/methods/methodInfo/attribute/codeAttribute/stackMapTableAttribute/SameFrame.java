package classAnalyser.classFile.methods.methodInfo.attribute.codeAttribute.stackMapTableAttribute;

/*
 * 帧类型same_frame的类型标记（frame_type）的取值范围是0至63，
 * 如果类型标记所确定的帧类型是same_frame类型，则明当前帧拥有和前一个栈映射帧完全相同的locals[]数组，并且对应的stack项的成员个数为0。
 * 当前帧的offset_delta值就使用frame_type项的值来表示①。
 * 
 * ① 译者注：此处描述的“stack”、“locals”是StackMapTable属性中的项，它们与 运行时栈帧 中的 操作数栈、局部变量表 有映射关系，但并非同一样东西。
 * 		       原文中的对它们的描述为“stack”和“operand stack”、“locals”和“local variables”，译文中，指代属性项时使用locals[]数组、
 * 		   stack表来表示，而提到运行时栈帧时，则会明确翻译为操作数栈、局部变量表，也请读者注意根据上下文注意区分。
 * 
 * same_frame {
    	u1 frame_type = SAME;  0-63 
	}
 */
public class SameFrame extends StackMapFrame{

}
