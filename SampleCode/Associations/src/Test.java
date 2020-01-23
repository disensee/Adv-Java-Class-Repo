
public class Test {

	public static void main(String[] args) {
		Breed carolinaDog = new Breed("Carolina Dog");
		Breed pekingese = new Breed("Pekingese");
		Breed catahoula = new Breed("Catahoula Leopard");
		
		Owner dylan = new Owner("Dylan", "Isensee");
		Owner emma = new Owner("Emma", "Maybanks");
		Owner tressa = new Owner("Tressa", "Isensee");
		
		Dog ren = new Dog("Ren", dylan, carolinaDog);
		String msg = "Ren's breed is " + ren.getBreed().getName();
		System.out.println(msg);
		
		//Test the dog -> association
		ren.addOwner(emma);
		System.out.println("Ren is owned by:");
		for(int i = 0; i < ren.getOwnerList().size(); i++) {
			Owner nextOwner = (Owner) ren.getOwnerList().get(i);
			System.out.println("\t" + nextOwner.getFirstName());
		}
		
		//Test the owner -> dog association
		Dog indie = new Dog("Indie", tressa, catahoula);
		System.out.println("Tressa owns...");
		for(int i = 0; i < tressa.getDogList().size(); i++) {
			Dog nDog = (Dog)tressa.getDogList().get(i);
			System.out.println("\t" + nDog.getName());
		}
		
		//Test the breed to dog association
		Dog willis = new Dog("Willis", dylan, carolinaDog);
		System.out.println("The following dogs are a " + carolinaDog.getName());
		for(Object o : carolinaDog.getDogList()) {
			Dog d = (Dog)o;
			System.out.println("\t" + d.getName());
		}
		
	}

}
