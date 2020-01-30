
public class PersonDemo {

	public static void main(String[] args) {
		Person s = new Student("Fred Flinstone", 12345); //Polymorphism(person variable, student constructed)
		
		((Student) s).reset("Barney Rubble", 432134);
		
		s.writeOutput();

	}

}
