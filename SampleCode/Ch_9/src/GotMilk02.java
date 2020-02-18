import java.util.Scanner;

public class GotMilk02 {
	public static void main(String[] args) {
		System.out.println("Enter the number of donuts: ");
		Scanner s = new Scanner(System.in);
		
		try {
			int donutCnt = s.nextInt();
			
			System.out.println("Enter the number of glasses of milk: ");
			int milkCnt = s.nextInt();
			
//			if(milkCnt < 1) {
//				System.out.println("No milk");
//				System.exit(0);
//				throw new Exception("Exception: No Milk!");
//				}
			
			double donutsPerGlass = donutCnt/milkCnt;
			
			String msg = String.format("%d donuts.\n%d glasses of milk.\nYou have %.2f donuts for each glass of milk.", donutCnt, milkCnt, donutsPerGlass);
			System.out.println(msg);
			
		}
		catch(ArithmeticException ae){//Order exceptions from most specific to most general
			System.out.println("You can't have donuts without milk");
			main(null);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("Go get milk");
		}
	}
}
