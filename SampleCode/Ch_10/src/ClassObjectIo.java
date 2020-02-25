import java.io.*;
public class ClassObjectIo {

	public static void main(String[] args) {
		ObjectOutputStream out = null;
		String fileName = "/Users/dylan/tmp/species.dat";
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(IOException ioe){
			System.out.println("Error opening file");
		}
	
		
		Species ant = new Species();
		ant.name = "Ant";
		ant.population = 1000;
		ant.growthRate = .10;
		
		Species scorpion = new Species();
		scorpion.name = "Scorpion";
		scorpion.population = 50;
		scorpion.growthRate = 1.1;
		
		
		try {
			out.writeObject(ant);
			out.writeObject(scorpion);
			out.close();
			System.out.println("Done writing species");
		}
		catch(IOException io) {
			System.out.println("ERR: cannot open file!");
			io.printStackTrace();
		}
		
		//read it back in
		System.out.println("Reading it back in...");
		ObjectInputStream in = null;
		
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
		}
		catch(IOException io) {
			System.out.println("ERR: cannot open file!");
			io.printStackTrace();
		}
		
		Species s1 = null; 
		Species s2 = null;
		try {
			s1 = (Species)in.readObject();
			s2 = (Species)in.readObject();
			in.close();
		}
		catch(Exception e) {
			System.out.println("Error reading species!");
			System.exit(0);
		}
		
		System.out.println("Species 1: " + s1.name);
		System.out.println("Species 2: " + s2.name);
	}
}
