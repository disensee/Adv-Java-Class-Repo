import java.util.Scanner;

public class DoDivision {
	private int numerator;
	private int denominator;
	private double quotient;

	public static void main(String[] args) {
		DoDivision doIt = new DoDivision();
		try {
			doIt.doNormalCase();
		}
		catch(NumberFormatException nfe) {
			System.out.println("Please enter a number greater than zero.");
			try {
				doIt.giveSecondChance();
				}
			catch(NumberFormatException nfe2){
				System.out.println("Invalid input.");
			};
		}
		catch(DivideByZeroException dbz) {
			System.out.println(dbz.getMessage());
			try {
				doIt.giveSecondChance();
				}
			catch(NumberFormatException nfe2){
				System.out.println("Invalid input.");
			};
		}
		
		System.out.println("End of program.");
	}
	
	public void doNormalCase() throws DivideByZeroException{
		System.out.println("Enter numerator: ");
		Scanner keyboard = new Scanner(System.in);
		numerator = Integer.parseInt(keyboard.nextLine());
		System.out.println("Enter denominator: ");
		denominator = Integer.parseInt(keyboard.nextLine());
		if(denominator == 0) {
			throw new DivideByZeroException();
			}
		quotient = numerator/denominator;
		keyboard.close();
		System.out.println(numerator + "/" + denominator + "=" + quotient);
	}

	
	public void giveSecondChance() throws NumberFormatException{
		Scanner s = new Scanner(System.in);
		System.out.println("Try again:");
		System.out.println("Enter a numerator:");
		int numerator = Integer.parseInt(s.nextLine());
		System.out.println("Enter a denominator:");
		int denominator = Integer.parseInt(s.nextLine());
		
		
		if(denominator == 0) {
			System.out.println("I cannot do division by zero.");
			System.out.println("Since I cannot do what you want,");
			System.out.println("the program will now end.");
			System.exit(0);
		}
		
		s.close();
		double quotient = numerator/(double)denominator;
		System.out.println(numerator + "/" + denominator + "=" + quotient);
	}
}
