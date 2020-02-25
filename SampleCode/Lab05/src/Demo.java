import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "/Users/dylan/tmp/SampleOutput/green_eggs_and_ham.txt";
		File geah = new File(filePath);
		ArrayList<Word> words = new ArrayList<Word>();
		TextFileAnalyzer tfa = new TextFileAnalyzer(geah, words);
		
		tfa.processInput();
		
		for(Word w : words) {
			System.out.println(w.toString());
		}
	}

}
