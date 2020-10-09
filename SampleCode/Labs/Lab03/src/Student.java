
public class Student extends Person implements Comparable<Student>{
	//Instance variables
	private int studentNumber;
	
	//Constructors
	public Student(String name, int studentNumber) {
		super(name);
		setStudentNumber(studentNumber);
	}
	
	public Student() {
		this("Unknown", 1);
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
		super.writeOutput();
		System.out.println("Student Number: " + getStudentNumber());
	}
	
	public void reset(String name, int studentNumber) {
		setName(name);
		setStudentNumber(studentNumber);
	}
	
//	Order based on student ID number
	@Override
	public int compareTo(Student s) {
		Student otherStudent = (Student)s;
		return this.studentNumber - otherStudent.studentNumber;
	}
	
//	Order lexicographically
//	@Override 
//	public int compareTo(Student s) {
//		Student otherStudent = (Student)s;
//		return (this.getName().compareTo(otherStudent.getName()));
//	}
	
//	Bubble Sort for student objects
	public static Student[] bubbleSortStudentArr(Student[] stuArr) {
		boolean studentSwapped = true;
		while(studentSwapped) {
			studentSwapped = false;
			for(int i = 0; i < stuArr.length - 1; i++) {
				if(stuArr[i].getStudentNumber() > stuArr[i + 1].getStudentNumber()) {
					Student holdStudent = stuArr[i];
					stuArr[i] = stuArr[i +  1];
					stuArr[i + 1] = holdStudent;
					studentSwapped = true;
				}
			}
		}
		return stuArr;
	}
	
	
	//Getters and setters
	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		if(studentNumber <= 0) {
			System.out.println("Student number must be positive");
			System.exit(0);
		}
		this.studentNumber = studentNumber;
	}
}
