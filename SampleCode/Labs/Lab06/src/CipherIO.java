import java.io.FileNotFoundException;
import java.io.IOException;

public interface CipherIO {
	
	public void writeToBinaryFile() throws FileNotFoundException, IOException;
	
	public int readFromBinaryFile() throws FileNotFoundException, IOException, ClassNotFoundException;
	
}
