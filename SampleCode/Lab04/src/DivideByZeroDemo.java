import java.util.Scanner;

public class DivideByZeroDemo {

	public static void main(String[] args) {
		DivideByZeroDemo demo = new DivideByZeroDemo();
		try {
			demo.doIt();
		}
		catch(DivideByZeroException dbz) {
			System.out.println(dbz.getMessage());
			main(null);
		}
		catch(NumberFormatException nfe) {
			System.out.println("Please enter a number");
			main(null);
		}
	}
	
	public void doIt() throws DivideByZeroException {
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter a numerator:");
			int num = Integer.parseInt(s.nextLine());
			System.out.println("Enter a denominator:");
			int denom = Integer.parseInt(s.nextLine());
			
			if(denom == 0) {
				throw new DivideByZeroException("Oops. Should not have used zero.");
			}
			
			double quotient = num/(double)denom;
			System.out.println(quotient);
		}
		catch(DivideByZeroException dbz){
			System.out.println(dbz.getMessage());
			giveSecondChance();
		}
		catch(NumberFormatException nfe){
			System.out.println("Please enter a number.");
			giveSecondChance();
		}
		System.out.println("End of program.");
	}
	
	public void giveSecondChance() throws DivideByZeroException{
		Scanner s = new Scanner(System.in);
			System.out.println("Try again:");
			System.out.println("Enter a numerator:");
			int num = Integer.parseInt(s.nextLine());
			System.out.println("Enter a denominator:");
			int denom = Integer.parseInt(s.nextLine());
			
			if(denom == 0) {
				System.out.println("I cannot do division by zero.");
				System.out.println("Since I cannot do what you want,");
				System.out.println("the program will now end.");
				System.exit(0);
			}
			
			double quotient = num/(double)denom;
			System.out.println(quotient);
	}
}
