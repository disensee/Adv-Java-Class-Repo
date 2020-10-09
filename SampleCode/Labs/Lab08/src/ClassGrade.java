
public class ClassGrade {
	//Instance Variables
	private String classId;
	private int credits;
	private double grade;
	
	public ClassGrade(String classId, int credits, double grade) {
		setClassId(classId);
		setCredits(credits);
		setGrade(grade);
	}
	
	
	//Accessors
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public double getGradePoints() {
		return (double)this.getCredits() * this.getGrade();
	}
	
	public String toString() {
		return String.format("Class: %s Credits: %d Grade: %.2f Grade Points: %.2f", classId, credits, grade, this.getGradePoints());
	}
	
}
