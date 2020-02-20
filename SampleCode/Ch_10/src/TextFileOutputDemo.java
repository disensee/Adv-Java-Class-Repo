import java.io.*;

public class TextFileOutputDemo {

	public static void main(String[] args) {
		String fileName = "/Users/dylan/tmp/out.txt";
		
		//Create writer object
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(fileName);
			
			output.println("This is line 1");
			output.println("This is line 2");
		}catch(FileNotFoundException nfe) {
			System.out.println("Error opening the file..." + fileName);
			System.exit(0);
		}
		
		output.close();
	}
}
