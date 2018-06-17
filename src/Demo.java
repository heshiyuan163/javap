
public class Demo{
	
	public int  div(int a,int b){
		try {
			int result=a/b;
			return result;
		}catch (NullPointerException e) {
			e.printStackTrace();
			return 0;
		}catch (ArithmeticException e) {
			e.printStackTrace();
			return 0;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			System.out.println("xxxxxxxxxxx");
		}
	}
}