
public class CountDown {

	public static void main(String[] args) {
		countUp(10);
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
	
	public static void countUp(int num) {
		//base case
		if(num == 0) {
			System.out.println(num);
			return;
		}
		
		countUp(num-1);
		System.out.println(num);	
	}
	
	

}
