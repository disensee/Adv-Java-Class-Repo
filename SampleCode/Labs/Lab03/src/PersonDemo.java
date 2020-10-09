import java.util.ArrayList;
import java.util.Arrays;

public class PersonDemo {

	public static void main(String[] args) {
		System.out.println("LAB03 PROGRAM OUTPUT:\n");
		ArrayList<Person> people = new ArrayList();
		people.add(new Undergraduate("Spongebob", 12345, 1));
		people.add(new Student("Squidward", 10));
		people.add(new Faculty("Patrick", 2345, "Information Technology", "Application Developer"));
		people.add(new Staff("Gary", 4321, "Maintenance", 5));
		
		for(Person p : people) {
			p.writeOutput();
			System.out.println();
		}
		
		Faculty f1 = new Faculty("Patrick", 2345, "Information Technology", "Database Administrator");
		Faculty f2 = new Faculty("Pat", 2345, "Information Technology", "Application Developer");
		Faculty f3 = new Faculty("Dylan", 5678, "Information Technology", "Application Developer");
		
		System.out.println("Faculty.equals() known true case: " + f1.equals(f2));
		System.out.println("Faculty.equals() known false case: " + f2.equals(f3));
		System.out.println();
		
		Staff s1 = new Staff("Bob", 34567, "Food Services", 4);
		System.out.println("Pay grade precondition test - known true case: " + s1.getName() + "'s " + "pay grade is " + s1.getPayGrade());
		System.out.println("Uncomment line 54 or 55 to test known false cases on the Staff pay grade precondition");
		//Staff invalidPayGrade0 = new Staff("Linda", 6205, "Food Services", 0);
		//Staff invalidPayGrade21 = new Staff("Gene", 6206, "Food Services", 21);
		System.out.println();
		
		Student[] stuArr = new Student[5];
		stuArr[0] = new Student("Jack", 12345);
		stuArr[1] = new Student("Paul", 12349);
		stuArr[2] = new Student("Sally", 12348);
		stuArr[3] = new Student("Emma", 12347);
		stuArr[4] = new Student("Pete", 12346);
		
		Arrays.sort(stuArr);
		System.out.println("\nTesting compareTo...\n");
		for(Student s : stuArr) {
			s.writeOutput();;
		}
		System.out.println("\nTesting bubble sort...\n");
		Student.bubbleSortStudentArr(stuArr);
		
		for(Student s : stuArr) {
			s.writeOutput();;
		}
	}
}
