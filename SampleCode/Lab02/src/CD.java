import java.text.SimpleDateFormat;
import java.util.Date;

public class CD {
	//Instance Variables
	private String cdName;
	private long amountInCents;
	private Date purchaseDate;
	private int months;
	private double annualRate;
	private int compoundingType;
	private Portfolio portfolio;
	
	//Constants
	public static final int CD_COMPOUND_ANNUALLY = 1;
	public static final int CD_COMPOUND_MONTHLY = 12;
	public static final int CD_COMPOUND_DAILY = 365;
	
	//Constructors
	public CD(String cdName, long amountInCents, Date purchaseDate, int months, 
			  double annualRate, int compoundingType, Portfolio portfolio) {
		setCdName(cdName);
		setAmountInCents(amountInCents);
		setPurchaseDate(purchaseDate);
		setMonths(months);
		setAnnualRate(annualRate);
		setCompoundingType(compoundingType);
		setPortfolio(portfolio);
		portfolio.addCdToPortfolio(this);
	}
	
	//Methods ***THESE NEED TO BE DEFINED***
	public Date calcMaturityDate() {
		Date maturityDate = new Date(this.purchaseDate.getYear(), this.purchaseDate.getDate(), this.purchaseDate.getMonth());
		
		//maturityDate.setMonth(maturityDate.getMonth() + months);
		
		
		return maturityDate;
	}
	
	public long calcValueAtMaturity() {
		return 1;
	}
	
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date purchaseDate = this.purchaseDate;
		Date maturityDate = this.calcMaturityDate();
		String formattedPurchaseDate = formatter.format(purchaseDate);
		String formattedMaturityDate = formatter.format(maturityDate);
		
		
		return "Name: " + cdName + "\n" + 
				"Amount Invested: " + amountInCents/100 + "\n"  + 
				"Purchase Date: " + formattedPurchaseDate + "\n"  + 
				"Term (Months): " + months + "\n"  + 
				"Annual Rate: " + annualRate + "\n"  + 
				"Compounding Type: " + compoundingType + "\n"  +
				"Maturity Date: " + formattedMaturityDate + "\n"  +
				"Value at Maturity: " + this.calcValueAtMaturity();
	}

	//Accessors
	public String getCdName() {
		return cdName;
	}

	public void setCdName(String cdName) {
		this.cdName = cdName;
	}

	public long getAmountInCents() {
		return amountInCents;
	}

	public void setAmountInCents(long amountInCents) {
		this.amountInCents = amountInCents;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public double getAnnualRate() {
		return annualRate;
	}

	public void setAnnualRate(double annualRate) {
		this.annualRate = annualRate;
	}

	public int getCompoundingType() {
		return compoundingType;
	}

	public void setCompoundingType(int compoundingType) {
		this.compoundingType = compoundingType;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	
}
