
public class FibRecursion {

	public static void main(String[] args) {
		int fibResult = fib(5);
		if(fibResult != 5) {
			System.out.println("ERROR fib(5)");
		}else {
			System.out.println("Good fib(5)!");
		}
		
		fibResult = fib(30);
		if(fibResult != 832040) {
			System.out.println("ERROR fib(30)");
		}else {
			System.out.println("Good fib(30)!");
		}
	}
	
	public static int fib(int n) {
		//base case
		if(n == 0) {
			return 0;
		}
		
		if(n == 1) {
			return 1;
		}
		
		//recurse
		return fib(n-1) + fib(n-2);
	}
}
