import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Demo {

	public static void main(String[] args){
		String geahFilePath = "InputFiles/green_eggs_and_ham.txt";
		String geahOutputPath = "LabOutput/green_eggs_and_ham.xml";
		
		String tiFilePath = "InputFiles/treasure_island.txt";
		String tiOutputPath = "LabOutput/treasure_island.xml";
		
		String shkFilePath = "InputFiles/shakespeare.txt";
		String shkOutputPath = "LabOutput/shakespeare.xml";
		
		
		File geah = new File(geahFilePath);
		File geahStatsXMLFile = new File(geahOutputPath);
		
		File treasureIsland = new File(tiFilePath);
		File tiStatsXMLFile = new File(tiOutputPath);
		
		File shk = new File(shkFilePath);
		File shkStatsXMLFile = new File(shkOutputPath);
		
		
		TextFileAnalyzer geahTfa = new TextFileAnalyzer(geah, geahStatsXMLFile);
		TextFileAnalyzer tiTfa = new TextFileAnalyzer(treasureIsland, tiStatsXMLFile);
		TextFileAnalyzer shkTfa = new TextFileAnalyzer(shk, shkStatsXMLFile);
		
		
		
		try {
			geahTfa.processInput();
			geahTfa.generateStatsFile();
			
			tiTfa.processInput();
			tiTfa.generateStatsFile();
			
			shkTfa.processInput();
			shkTfa.generateStatsFile();
		}
		catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		catch (ParserConfigurationException pce) {
			System.out.println(pce.getMessage());
		}
		catch (TransformerException te) {
			System.out.println(te.getMessage());
		}
		
	}

}
