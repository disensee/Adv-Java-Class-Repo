
public class Owner {
	//Instance variables
	private String firstName;
	private String lastName;
	private Portfolio portfolio;
	
	//Constructor
	public Owner(String firstName, String lastName, Portfolio portfolio) {
		setFirstName(firstName);
		setLastName(lastName);
		assignPortfolioToOwner(portfolio);
	}
	
	//Methods
	public void assignPortfolioToOwner(Portfolio p) {
		this.portfolio = p;
	}
	
	public String toString() {
		return "First Name: " + firstName + 
				"Last Name: " + lastName;
	}
	
	
	//Getters/setters
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

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	
	
}
