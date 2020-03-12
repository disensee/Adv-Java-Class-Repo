import java.io.Serializable;

public class SecretAgent implements Serializable {
	//Instance Variables
	private String firstName;
	private String lastName;
	private String id;
	
	//Constructor
	public SecretAgent(String lastName, String firstName, String id) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Secret Agent:" + "\n" + "\t" + "ID: " + this.getId() + "\n" + 
				"\t" + "Name: " + this.getFirstName() + " " + this.getLastName();
	}
	
	//Accessors
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}
	
	
}
