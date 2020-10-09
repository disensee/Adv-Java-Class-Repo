import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MontyBinaryIn {

	public static void main(String[] args) {
		String fileName = "/Users/dylan/tmp/words.dat";
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			
			String str1 = in.readUTF();
			System.out.println("String 1: " + str1);
			
			int num1 = in.readInt();
			System.out.println("Num 1: " + num1);
			
			String str2 = in.readUTF();
			System.out.println("String 2: " + str2);
			
			System.out.println("File input done");
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
