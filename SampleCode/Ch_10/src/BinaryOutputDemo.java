import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryOutputDemo {

	public static void main(String[] args) {
		String fileName = "/Users/dylan/tmp/numbers.dat";
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			
			int num1 = 100;
			out.writeInt(num1);
			int num2 = 200;
			out.writeInt(num2);
			int num3 = 300;
			out.writeInt(num3);
			
			System.out.println("File output done");
			out.close();
		}
		catch(FileNotFoundException fnf) {
			System.out.println("Problem opening file");
		}
		catch(IOException ioe) {
			System.out.println("Problem outputting file");
		}
		catch(Exception e) {
			System.out.println("Unknown");
			e.printStackTrace();
		}

	}

}
