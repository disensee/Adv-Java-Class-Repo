import java.io.*;
import java.util.Scanner;

public class TextFileInputDemo {

	public static void main(String[] args) {
		String fileName = "/Users/dylan/tmp/out.txt";
		//String path = "../output.txt";
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException nfe) {
			System.out.println("Error opening the file..." + fileName);
			System.exit(0);
		}
		int lineCnt = 0;
		while(input.hasNextLine()) {
			
			String line = input.nextLine();
			System.out.println(line);
			lineCnt++;
		}
		
		System.out.println(lineCnt);
		input.close();
	}

}
