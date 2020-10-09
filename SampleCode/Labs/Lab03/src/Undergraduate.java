
public class Undergraduate extends Student {
	//Instance variable(s)
	private int level; //1 for freshman - 4 for senior
	
	//Constructors
	public Undergraduate() {
		super();
		level = 1;
	}
	
	public Undergraduate(String name, int studentNumber, int level) {
		super(name, studentNumber);
		setLevel(level);
	}
	
	//Methods
	public void reset(String newName, int newStudentNumber, int newLevel) {
		reset(newName, newStudentNumber); //Student reset
		setLevel(newLevel);
	}
	@Override
	public void writeOutput(){
		super.writeOutput();
		System.out.println("Student Level: " + this.getLevel());
	}
	
	public boolean equals(Undergraduate other) {
		return super.equals(other) && this.level == other.level;
	}
	
	//Accessors
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		if(level < 1 || level > 4) {
			System.out.println("Level must be between 1 and 4");
			System.exit(0);
		}
		this.level = level;
	}
	
}
