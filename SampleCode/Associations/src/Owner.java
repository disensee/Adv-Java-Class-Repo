import java.util.ArrayList;

public class Owner {
	//Instance variables
	private String firstName;
	private String lastName;
	private ArrayList dogList;
	
	//Constructors
	public Owner(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		dogList = new ArrayList();
	}
	
	//Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList getDogList() {
		return dogList;
	}
	public void setDogList(ArrayList dogList) {
		this.dogList = dogList;
	}
	
}
