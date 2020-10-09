
public class GCD {

	public static void main(String[] args) {
		int num1 = 252;
		int num2 = 105;
		
		int gcd = gcd(num1, num2);
		if(gcd != 21) {
			System.out.println("ERROR!");
		}
		
		System.out.println("All done");

	}
	
	public static int gcd(int num1, int num2) {
		//base case
		if(num1 == num2) {
			return num1;
		}
		
		int delta = Math.abs(num1 - num2);
		if(num1 > num2) {
			return gcd(delta, num2);
		}
		else {
			return gcd(num1, delta);
		}
		
	}

}
