import java.util.ArrayList;

public class PersonDemo {

	public static void main(String[] args) {
		/*
		Person s = new Student("Fred Flinstone", 12345); //Polymorphism(person variable, student constructed)
		
		((Student) s).reset("Barney Rubble", 432134);
		
		s.writeOutput();
		
		Undergraduate greg = new Undergraduate("Greg", 12345678, 4);
		
		Undergraduate fred = new Undergraduate("Fred", 87654321, 1);
		
		fred.reset("Fred Jr.", 12345679);
		fred.writeOutput();
		
		if(greg.equals(fred)) {
			System.out.println("ERROR");
		}
		
		Student bob = new Student("Bob", 12345);
		Undergraduate mike = new Undergraduate("Mike", 54321, 1);
		
		
		SomeClass.compareNumbers(bob, mike);
		*/
		//---***LAB03 PROGRAM***---
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
		//Staff invalidPayGrade0 = new Staff("Linda", 6205, "Food Services", 0);
		Staff invalidPayGrade21 = new Staff("Gene", 6206, "Food Services", 21);

	}

}
