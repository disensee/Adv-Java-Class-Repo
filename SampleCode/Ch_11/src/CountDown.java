
public class CountDown {

	public static void main(String[] args) {
		countDown(10);
	}
	
	public static void countDown(int num) {
		//base condition(base case)
		if(num <= 0) {
			System.out.println(num);
			return;
		}
		
		System.out.println(num);
		countDown(num-1);
	}
	
	

}
