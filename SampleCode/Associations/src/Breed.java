import java.util.ArrayList;

public class Breed {
	//Instance variables
	private String Name;
	private ArrayList dogList;
	
	//Constructors
	public Breed(String name){
		setName(name);
		dogList = new ArrayList();
	}
	
	
	//Methods
	public void addDog(Dog dog){
		dog.setBreed(this);
		
		if(!dogList.contains(dog)) {
			dogList.add(dog);
		}
	}
	
	//Setters and getters
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList getDogList() {
		return dogList;
	}
	
	
}
