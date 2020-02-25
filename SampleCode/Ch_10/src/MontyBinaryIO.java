import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MontyBinaryIO {

	public static void main(String[] args) {
		String fileName = "/Users/dylan/tmp/words.dat";
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			
			out.writeUTF("What's your favorite color?");
			out.writeInt(500);
			out.writeUTF("Blue");
			
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
