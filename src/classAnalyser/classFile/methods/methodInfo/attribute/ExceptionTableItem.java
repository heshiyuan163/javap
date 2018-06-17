package classAnalyser.classFile.methods.methodInfo.attribute;
/*
 * {    u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
    }
 */
public class ExceptionTableItem {
	
	private byte b1;//high byte of start_pc
	private byte b2;//low byte of start_pc
	
	/*
	 * start_pc和end_pc两项的值表明了异常处理器在code[]数组中的有效范围。
	 * start_pc必须是对当前code[]数组中某一指令的操作码的有效索引，
	 * start_pc的值必须比end_pc小。
	 * end_pc要么是对当前code[]数组中某一指令的操作码的有效索引，要么等于code_length的值，即当前code[]数组的长度。
	 * 当程序计数器在范围[start_pc, end_pc)内时，异常处理器就将生效。
	 * 即设x为异常句柄的有效范围内的值，x满足：start_pc ≤ x < end_pc。
	 * 实际上，end_pc值本身不属于异常处理器的有效范围(这点属于Java虚拟机历史上的一个设计缺陷：如果Java虚拟机中的一个方法的
	 * code属性的长度刚好是65535个字节，并且以一个1个字节长度的指令结束，那么这条指令将不能被异常处理器所处理。不过编译器可以
	 * 通过限制任何方法、实例初始化方法或类初始化方法的code[]数组最大长度为65534，这样可以间接弥补这个BUG)。
	 */
	private int start_pc;
	
	private byte b3;//high byte of end_pc
	private byte b4;//low byte of end_pc
	private int end_pc;
	
	private byte b5;//high byte of handler_pc
	private byte b6;//low byte of handler_pc
	
	/*
	 * handler_pc项表示一个异常处理器的起点，它的值必须同时是一个对当前code[]数组中某一指令的操作码的有效索引。
	 */
	private int handler_pc;
	
	private byte b7;//high byte of catch_type
	private byte b8;//low byte of catch_type
	
	/*
	 * 如果catch_type项的值不为0，那么它必须是对常量池的一个有效索引，
	 * 常量池在该索引处的项必须是CONSTANT_Class_info（§4.4.1）结构，表示当前异常处理器指定需要捕捉的异常类型。
	 * 只有当抛出的异常是指定的类或其子类的实例时，异常处理器才会被调用。
	 * 如果catch_type项的值如果为0，那么这个异常处理器将会在所有异常抛出时都被调用。
	 * 这可以用于实现finally语句（§3.13，“编译finally”）。
	 */
	private int catch_type;

}
