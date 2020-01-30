import java.util.Date;

public class Broker {

	public static void main(String[] args) {
		Owner bob = new Owner("Bob", "Smith");
		Portfolio bobsPortfolio = new Portfolio(bob);
		CD cd1 = new CD("CD_01", 1000*100, new Date(115, 0, 1), 12 , 1.5, CD.CD_COMPOUND_ANNUALLY, bobsPortfolio);
		CD cd2 = new CD("CD_02", 1000*100, new Date(115, 2, 15), 60, 2.35, CD.CD_COMPOUND_ANNUALLY, bobsPortfolio);
		CD cd3 = new CD("CD_03", 1000*100, new Date(115, 5, 1), 60, 2.35, CD.CD_COMPOUND_MONTHLY, bobsPortfolio);
	
		System.out.println(bobsPortfolio.getCdByName("CD_01"));
		bobsPortfolio.generatePortfolioSummaryReport();

	}

}
