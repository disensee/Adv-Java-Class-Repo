
public class Staff extends Employee {
	//Instance variable(s)
	private int payGrade;
	
	//Constructors
	public Staff() {
		super();
		setPayGrade(1);
	}
	
	public Staff(String name, int employeeId, String department, int payGrade) {
		super(name, employeeId, department);
		setPayGrade(payGrade);
	}
	
	//Methods
	@Override
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Pay Grade: " + getPayGrade());;
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof Staff)) {
			System.out.println("Please compare a staff member");
			System.exit(0);
		}
		return this.equals((Staff) o);
	}
	
	public boolean equals(Staff otherStaff) {
		return super.isSameEmployee(otherStaff);
	}
	
	//Accessors
	public int getPayGrade() {
		return payGrade;
	}

	public void setPayGrade(int payGrade) {
		if(payGrade < 1 || payGrade > 20) {
			System.out.println(this.getName() + "'s " + "pay grade must be a value between 1 and 20");
			System.exit(0);
		}
		this.payGrade = payGrade;
	}
	
}
