import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BinaryInputDemo {

	public static void main(String[] args) {
		String fileName = "/Users/dylan/tmp/numbers.dat";
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			
			int num1 = in.readInt();
			System.out.println("First num: " + num1);
			
			int num2 = in.readInt();
			System.out.println("Second num: " + num2);
			
			int num3 = in.readInt();
			System.out.println("Third num: " + num3);
			
			System.out.println("Reading file done");
			in.close();
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