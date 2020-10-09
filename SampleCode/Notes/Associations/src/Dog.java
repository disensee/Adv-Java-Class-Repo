import java.util.ArrayList;
import java.util.Date;

public class Dog {
	private String name;
	private Date dateOfBirth;
	private int weight;
	private Breed breed;
	private ArrayList ownerList;
	
	//Constructor
	public Dog(String name, Owner owner, Breed breed) {
		setName(name);
		ownerList = new ArrayList();
		
		breed.addDog(this);
		addOwner(owner); 
	}
	
	public void addOwner(Owner owner) {
		if(!ownerList.contains(owner)) {
			ownerList.add(owner);
		}
		
		ArrayList ownerDogList = owner.getDogList();
		if(!ownerDogList.contains(this)) {
			ownerDogList.add(this);
		}
	}
	
	
	//Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public ArrayList getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(ArrayList ownerList) {
		this.ownerList = ownerList;
	}
	
	
}
