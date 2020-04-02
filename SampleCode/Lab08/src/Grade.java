
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
		return Math.round((this.earnedPoints/this.availablePoints) * 100.0) / 100.0;
	}
	
	
	public int getEarnedPoints() {
		return earnedPoints;
	}

	public int getAvailablePoints() {
		return availablePoints;
	}
	
	public String toString() {
		return null;	
	}
	
}
