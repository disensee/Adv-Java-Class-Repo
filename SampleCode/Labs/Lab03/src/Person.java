
public abstract class Person {
	//Instance variables
	private String name;
	
	//Constructors
	public Person(String name) {
		setName(name);
	}
	
	private Person() {
		this("Unknown");
	}
	//Methods
	public void writeOutput() {
		System.out.println("Name: " + name);
	}
	
	public boolean hasSameName(Person otherPerson) {
		return this.getName().equalsIgnoreCase(otherPerson.name);	
	}
	//Accessors
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
