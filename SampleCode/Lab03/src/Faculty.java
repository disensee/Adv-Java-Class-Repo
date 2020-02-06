
public class Faculty extends Employee {
	//Instance variable(s)
	private String title;
	
	//Constructors
	public Faculty() {
		super();
		setTitle("Unknown");
	}
	
	public Faculty(String name, int employeeId, String department, String title) {
		super(name, employeeId, department);
		setTitle(title);
	}
	
	//Methods
	@Override
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Title: " + getTitle());;
	}
	
	//Accessors
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
