import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args){
		String filePath = "/Users/dylan/tmp/SampleOutput/green_eggs_and_ham.txt";
		File geah = new File(filePath);
		ArrayList<Word> words = new ArrayList<Word>();
		TextFileAnalyzer tfa = new TextFileAnalyzer(geah, words);
		
		
		try {
			tfa.processInput();
		}
		catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		for(Word w : words) {
			System.out.println(w.toString());
		}
	}

}
