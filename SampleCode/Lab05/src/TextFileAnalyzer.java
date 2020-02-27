import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class TextFileAnalyzer {
	//Instance variable(s)
	private File inputFile;
	private File statsXMLFile;
	private ArrayList<Word> words;
	private Scanner input;
	
	//Methods
	public TextFileAnalyzer(File inputFile, ArrayList<Word> words) {//, File statsXMLFile) {
		setInputFile(inputFile);
		//setStatsXMLFile(statsXMLFile);
		setWords(words);
	}
	
	public void processInput() throws FileNotFoundException {
		input = new Scanner(inputFile);
		if(input == null) {
			throw new FileNotFoundException();
		}
		while(input.hasNextLine()) {
			String line = input.nextLine();
			line = line.replaceAll("\\p{Punct}", "");
			String[] lineData = line.split(" ");
			for(String s : lineData) {
				Word word = new Word(s);
				words.add(word);
			}
		}
		input.close();
	}

	
	//Accessors
	public File getInputFile() {
		return inputFile;
	}


	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}


	public File getStatsXMLFile() {
		return statsXMLFile;
	}


	public void setStatsXMLFile(File statsXMLFile) {
		this.statsXMLFile = statsXMLFile;
	}


	public ArrayList<Word> getWords() {
		return words;
	}


	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}
}
