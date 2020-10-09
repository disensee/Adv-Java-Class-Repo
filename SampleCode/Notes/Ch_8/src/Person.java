
public class Person {
	//Instance variables
	private String name;
	
	//Constructors
	public Person(String name) {
		setName(name);
	}
	
	public Person() {
		this("Unknown");
	}
	
	public void writeOutput() {
		System.out.println("Name: " + name);
	}
	
	public boolean hasSameName(Person otherPerson) {
		return this.getName().equals(otherPerson.name);	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
