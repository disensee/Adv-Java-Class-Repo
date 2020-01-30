import java.util.Date;

public class Broker {

	public static void main(String[] args) {
		Owner bob = new Owner("Bob", "Smith");
		Portfolio bobsPortfolio = new Portfolio(bob);
		CD cd1 = new CD("CD_01", 1000*100, new Date(115, 2, 15), 60 , 1.5, CD.CD_COMPOUND_ANNUALLY, bobsPortfolio);
		
		System.out.println(cd1.toString());

	}

}
