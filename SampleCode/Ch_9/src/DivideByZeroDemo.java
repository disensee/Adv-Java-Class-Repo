import java.util.Scanner;

public class DivideByZeroDemo {

	public static void main(String[] args) {
		DivideByZeroDemo demo = new DivideByZeroDemo();
		//demo.doIt();
		try {
			demo.divideIt();
		}
		catch(DivideByZeroException dbz) {
			System.out.println(dbz.getMessage());
			System.out.println("Try again");
			main(null);
		}
		System.out.println("END");
	}
	
	public void divideIt() throws DivideByZeroException{
		Scanner s = new Scanner(System.in);
		
			System.out.println("Enter a numerator");
			int num = s.nextInt();
			System.out.println("Enter a denominator");
			int denom = s.nextInt();
			
			if(denom == 0) {
				throw new DivideByZeroException();
			}
			
			double quotient = num/(double)denom;
			System.out.println(quotient);
		
	}
	
	public void doIt() {
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter a numerator");
			int num = s.nextInt();
			System.out.println("Enter a denominator");
			int denom = s.nextInt();
			
			if(denom == 0) {
				throw new DivideByZeroException();
			}
			
			double quotient = num/(double)denom;
			System.out.println(quotient);
		}
		catch(DivideByZeroException dbz){
			System.out.println(dbz.getMessage());
			System.out.println("Try again");
			doIt();
		}
	}
}
