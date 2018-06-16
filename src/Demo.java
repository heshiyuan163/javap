public class Demo{
	
	public  void hello( ) {
		/*隐式的第一个基本块的stack frame map是从方法签名计算出来的。这个例子hello是个实例方法，
		 * 没有显示声明的参数，所以参数个数是1，也就是隐藏参数this。
		 * 那么在字节码偏移量0的位置上，操作数栈为空，局部变量区：[ class Demo ] */
		//***********basic blocl 1  begin
		int age_int=100;
		int num1=121;
		int num2=122;
		int num3=123;
		if(age_int==124){
			int num1_1=125;
			int num1_2=126;
			//***********basic blocl 1  end
		}
		
		
		/*frame_type = 255  full_frame 
	          	offset_delta = 27 27
	          	locals = [ class Demo, int, int, int, int ]
	          	stack = []*/
		//***********basic blocl 2  begin
		if(age_int==127){
			int num2_1=128;
			int num2_2=129;
			//***********basic blocl 2  end
		}
		
		/*frame_type = 15  same  27+15+1=43*/
		//***********basic blocl 3  begin
		if(age_int==130){
			int num3_1=131;
			int num3_2=132;
			//***********basic blocl 3  end
		}
		
		/*frame_type = 16  same  43+16+1=60*/
		//***********basic blocl 4  begin
		if(age_int==133){
			int num4_1=134;
			int num4_2=135;
			//***********basic blocl 4  end
		}
		
		/*frame_type = 16  same  60+16+1=77*/
		//***********basic blocl 5  begin
		int num4=136;
		int num5=137;
		//***********basic blocl 5  end
	}
}