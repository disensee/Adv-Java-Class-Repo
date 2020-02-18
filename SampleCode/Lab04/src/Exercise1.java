import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		System.out.println("Enter the number of donuts: ");
		Scanner s = new Scanner(System.in);
		
		try {
			int donutCnt = Integer.parseInt(s.nextLine());
			
			
			if(donutCnt < 1) {
				System.out.println("You need to have at least one donut");
				throw new NumberFormatException("Exception: No Donuts!");
			}
			
			
			
			System.out.println("Enter the number of glasses of milk: ");
			int milkCnt = Integer.parseInt(s.nextLine());
			
			if(milkCnt < 1) {
				System.out.println("You must have at least one glass of milk");
				throw new ArithmeticException("Exception: No Milk!");
				}

			
			double donutsPerGlass = donutCnt/milkCnt;
			
			String msg = String.format("%d donuts.\n%d glasses of milk.\nYou have %.2f donuts for each glass of milk.", donutCnt, milkCnt, donutsPerGlass);
			System.out.println(msg);
			
		}
		catch(ArithmeticException ae){//Order exceptions from most specific to most general
			System.out.println("You can't have donuts without milk!");
			main(null);
		}
		catch(NumberFormatException nfe){
			System.out.println("Please enter a whole number greater than or than equal to one.");
			main(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Go get donuts and milk");
		}
	}
}


