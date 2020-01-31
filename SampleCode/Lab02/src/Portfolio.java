import java.util.ArrayList;
import java.util.Date;

public class Portfolio {
	private ArrayList<Owner> ownerList;
	private ArrayList<CD> cdList;
	
	//Constructors
	public Portfolio(Owner o) {
		addOwnerToPortfolio(o);
	}
	
	public Portfolio(ArrayList<Owner> owners) {
		for(Owner o : owners) {
			addOwnerToPortfolio(o);
		}
			
	}
	//Methods
	public void addOwnerToPortfolio(Owner o) {
		ownerList = new ArrayList();
		cdList = new ArrayList();
		if(!ownerList.contains(o)) {
			ownerList.add(o);
		}
		
		o.assignPortfolioToOwner(this);
	}
	
	public void addCdToPortfolio(CD cd) {
		if(!cdList.contains(cd)) {
			cdList.add(cd);
		}
	}
	
	public CD getCdByName(String cdName) {
		CD returnCd = null;;
		for(CD cd : cdList) {
			if (cdName == cd.getCdName()){
				returnCd = cd;
			}
		}
		return returnCd;
	}
	
	public void generatePortfolioSummaryReport() {
		System.out.println("***Portfolio Summary Report***\n");
		System.out.println("***Owners***");
		for(Owner o : ownerList) {
			System.out.println("Owner " + ownerList.indexOf(o) + 1 + ": " + o.toString());
		}
		
		System.out.println("\n***CDs***");
		for(CD cd : cdList) {
			System.out.println(cd.toString() + "\n");
		}
		
		System.out.println("***CD with Max Value At Maturity***");
		System.out.println(findCDWithMaxMaturityValue() + "\n");
		
		System.out.println("***CD that is Maturing the Soonest***");
		System.out.println(findCDMaturingSoonest());
	}
	
	public CD findCDWithMaxMaturityValue() {
		CD returnCD = cdList.get(0);
		long valueAtMaturity = cdList.get(0).calcValueAtMaturity();
		for(int i = 1; i < cdList.size(); i++) {
			if(cdList.get(i).calcValueAtMaturity() > returnCD.calcValueAtMaturity()){
				returnCD = cdList.get(i);
			}
		}
		return returnCD;
	}
	
	public CD findCDMaturingSoonest() {
		CD returnCD = cdList.get(0);
		Date maturityDate = cdList.get(0).calcMaturityDate();
		for(int i = 1; i < cdList.size(); i++) {
			if(cdList.get(i).calcMaturityDate().before(returnCD.calcMaturityDate())) {
				returnCD = cdList.get(i);
			}
		}
		return returnCD;
	}
	
	public String toString() {
		return "Owner(s): " + ownerList.toString() + "\n" + 
				"CDs: " + cdList.toString();
	}
	
	//Accessors
	public ArrayList<Owner> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(ArrayList<Owner> ownerList) {
		this.ownerList = ownerList;
	}

	public ArrayList<CD> getCdList() {
		return cdList;
	}

	public void setCdList(ArrayList<CD> cdList) {
		this.cdList = cdList;
	}
	
	
}
