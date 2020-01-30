import java.util.ArrayList;

public class Portfolio {
	private ArrayList<Owner> ownerList = new ArrayList();
	private ArrayList<CD> cdList = new ArrayList();
	
	//Constructors
	public Portfolio(Owner o) {
		ownerList = new ArrayList();
		addOwnerToPortfolio(o);
	}
	
	public Portfolio(ArrayList<Owner> owners ) {
		for(Owner o : owners) {
			addOwnerToPortfolio(o);
		}
			
	}
	//Methods
	public void addOwnerToPortfolio(Owner o) {
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
		
	}
	
	public CD findCDWithMaxMaturityValue() {
		return null;
	}
	
	public CD findCDMaturingSoonest() {
		return null;
	}
	
	public String toString() {
		return "Owners: " + ownerList.toString() + 
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
