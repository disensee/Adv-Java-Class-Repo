import java.util.Scanner;

public class GotMilk01 {
	public static void main(String[] args) {
		System.out.println("Enter the number of donuts: ");
		Scanner s = new Scanner(System.in);
		
		int donutCnt = s.nextInt();
		
		System.out.println("Enter the number of glasses of milk: ");
		int milkCnt = s.nextInt();
		
		double donutsPerGlass = donutCnt/milkCnt;
		
		String msg = String.format("%d donuts.\n%d glasses of milk.\nYou have %.2f donuts for each glass of milk.", donutCnt, milkCnt, donutsPerGlass);
		System.out.println(msg);
		
	}
}
