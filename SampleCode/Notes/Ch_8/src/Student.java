
public class Student extends Person {
	//Instance variables
	private int studentNumber;
	
	//Constructors
	public Student(String name, int studentNumber) {
		super(name);
		setStudentNumber(studentNumber);
	}
	
	public Student() {
		this("Unknown", 0);
	}
	
	//Methods
	public boolean equals(Object o) {
		if(!(o instanceof Student)) {
			System.out.println("I need a student");
			System.exit(0);
		}
		return this.equals((Student) o);
	}
	
	public boolean equals(Student otherStudent) {
		return this.hasSameName(otherStudent) && this.getStudentNumber() == otherStudent.getStudentNumber();
	}
	
	@Override
	public void writeOutput() {
		//System.out.println("Name: " + getName());
		super.writeOutput();
		System.out.println("Student Number: " + getStudentNumber());
	}
	
	public void reset(String name, int studentNumber) {
		setName(name);
		setStudentNumber(studentNumber);
	}
	
	//Getters and setters
	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
}
