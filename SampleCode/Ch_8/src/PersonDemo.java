import java.util.ArrayList;

public class PersonDemo {

	public static void main(String[] args) {
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
		
		ArrayList<Person> people = new ArrayList();
		people.add(new Undergraduate("Spongebob", 12345, 1));
		people.add(new Student("Squidward", 123450));
		people.add(new Person("Patrick"));
		people.add(new Person("Gary"));
		
		for(Person p : people) {
			p.writeOutput();
			System.out.println();
		}
		
		
		
		System.out.println("Done");
	}

}
