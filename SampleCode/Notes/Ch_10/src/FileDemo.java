import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) {
//		File file = new File("/Users/dylan/tmp/out.txt");
//		
//		
//		if(!file.exists()) {
//			System.out.println("No such file");
//		}else if(!file.canRead()) {
//			System.out.println("File not readable");
//		}else if(!file.canWrite()) {
//			System.out.println("File not writeable");
//		}else {
//			System.out.println("File exists and is R/W");
//		}
//		
//		System.out.println("The file is " + file.length() + " bytes in size");
		Scanner input = null;
		double runningTotal = 0;
		try {
			input = new Scanner(new File("/Users/dylan/tmp/transactions.csv"));
		}catch(FileNotFoundException fnf) {
			fnf.getMessage();
		}
		int lineCnt = 0;
		while(input.hasNextLine()) {
			lineCnt++;
			String line = input.nextLine();
			if(lineCnt == 1) {continue;}
			String[] strArr = line.split(",");
			String msg = "Sold %d of %s (SKU: %s) at $%.2f\n";
			int qty = Integer.parseInt(strArr[1]);
			double salePrice = Double.parseDouble(strArr[2]);
			System.out.printf(msg, qty, strArr[3], strArr[0], salePrice);
			runningTotal += qty * salePrice;
		}
		System.out.printf("Total sales: $%.2f", runningTotal);
		input.close();
	}

}
