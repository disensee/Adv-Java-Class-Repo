import java.util.Scanner;

public class NumberFormatDemo {

	public static void main(String[] args) {
		System.out.println("Enter a double...");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		try {
			double number = Double.parseDouble(input);
			System.out.println(number);
		}
		catch(NumberFormatException nfe) {
			nfe.getMessage();
			System.out.println("Invalid number entered...");
			System.out.println("Try again...");
			main(null);
		}
		
	}

}
