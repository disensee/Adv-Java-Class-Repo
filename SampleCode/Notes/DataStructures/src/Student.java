
public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private int age;
	
	public Student(int studentId, String lastName, String firstName, int age) {
		setStudentId(studentId);
		setLastName(lastName);
		setFirstName(firstName);
		setAge(age);
	}
	
	public String toString() {
		return String.format("Student ID: %d%nLast Name: %s%nFirst Name: %s%n", studentId, lastName, firstName);
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public Integer getStudentIdInt() {
		return new Integer(studentId);
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
