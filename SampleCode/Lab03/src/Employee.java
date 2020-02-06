
public abstract class Employee extends Person{
	//Instance variable(s)
	private int employeeId;
	private String department;
	
	//Constructors
	public Employee() {
		this("Unknown", 0, "Unknown");
	}
	
	public Employee(String name, int employeeId, String department) {
		super(name);
		setEmployeeId(employeeId);
		setDepartment(department);
	}
	
	//Methods
	@Override
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Employee ID: " + getEmployeeId());
		System.out.println("Department: " + getDepartment());
	}
	
	public boolean isSameEmployee(Employee otherEmployee) {
		return this.getEmployeeId() == otherEmployee.getEmployeeId();
	}
	
	//Accessors
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		if(employeeId <= 0) {
			System.out.println("Employee ID must be a positive number");
			System.exit(0);
		}
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
