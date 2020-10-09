import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TextFileAnalyzer {
	//Instance variable(s)
	private File inputFile;
	private File statsXMLFile;
	private ArrayList<Word> words;
	private Scanner input;
	private HashMap<String, Word> wordMap = new HashMap<>();
	
	//Constructor
	public TextFileAnalyzer(File inputFile, File statsXMLFile) {
		setInputFile(inputFile);
		setStatsXMLFile(statsXMLFile);
	}
	
	//Methods
	public void processInput() throws FileNotFoundException {
		words = new ArrayList<Word>();
		input = new Scanner(inputFile);
		
		if(input == null) {
			throw new FileNotFoundException();
		}
		while(input.hasNext()) {
			String line = input.next().toLowerCase();
			line = line.replaceAll("\\p{Punct}", "");
			String[] lineData = line.split(" ");
			for(String s : lineData) {
				if(!wordMap.containsKey(s)) {
				Word word = new Word(s);
				wordMap.put(s, word);
				words.add(word);
				}else{
					wordMap.get(s).incrementUsageCnt();
				}
			}
		}
		input.close();
		
		Collections.sort(words, Collections.reverseOrder());
		
		System.out.println("The file has been read and sorted");
		
	}
	
	public void generateStatsFile() throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root element
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("TEXT_ANALYZER"); 
		doc.appendChild(rootElement);
		for(Word w : words) {
			//word element
			Element word = doc.createElement("WORD");
			rootElement.appendChild(word);
			
			//word_text element
			Element wordText = doc.createElement("WORD_TEXT");
			wordText.appendChild(doc.createTextNode(w.getWord()));
			word.appendChild(wordText);
			
			//usage_cnt element
			Element usageCnt = doc.createElement("USAGE_CNT");
			usageCnt.appendChild(doc.createTextNode(Integer.toString(w.getUsageCnt())));
			word.appendChild(usageCnt);
		}

		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance(); 
		Transformer transformer = transformerFactory.newTransformer();
		
		//format
		transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

        transformer.setOutputProperty(
                "{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		
		
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(statsXMLFile);

		transformer.transform(source, result);
		System.out.println("XML file saved!");
		
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
