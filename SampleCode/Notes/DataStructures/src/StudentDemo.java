import java.util.HashMap;

public class StudentDemo {
	
	public static void main(String[] args) {
		
		HashMap<Integer, Student> studentMap = new HashMap(); 
		
		Student bob = new Student(1234, "Squarepants", "Spongebob", 16);
		studentMap.put(bob.getStudentIdInt(), bob);
		
		studentMap.put(new Integer(2345), new Student(2345, "Star", "Patrick", 16));
		
		//Pull out a single value
		Student patrick = studentMap.get(new Integer(2345));
		System.out.println(patrick.toString());
		
		//loop through map
		int sCnt = 0;
		for(Integer studentId : studentMap.keySet()) {
			Student nextStudent = studentMap.get(studentId);
			System.out.println("Student " + sCnt + " " + nextStudent.toString());
			sCnt++;
		}
	}
	
	
}
