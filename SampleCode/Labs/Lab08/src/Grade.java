
public class Grade {
	
	//Instance Variables
	
	private int earnedPoints;
	private int availablePoints;
	
	//Constructor
	
	public Grade(int earnedPoints, int availablePoints){
		this.earnedPoints = earnedPoints;
		this.availablePoints = availablePoints;
	}
	
	public void setGrade(int earnedPoints, int availablePoints) {
		this.earnedPoints = earnedPoints;
		this.availablePoints = availablePoints;
	}
	
	public double getPercentage() {
		return ((double)earnedPoints/(double)availablePoints) * 100.00;
	}
	
	
	public int getEarnedPoints() {
		return earnedPoints;
	}

	public int getAvailablePoints() {
		return availablePoints;
	}
	
	public String toString() {
		return String.format("%d : %d -- %.2f%%", earnedPoints, availablePoints, getPercentage());
	}
	
}
