
public class Word implements Comparable{
	
	private String word;
	private int usageCnt;
	
	//Constructor
	public Word(String word) {
		setWord(word);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString(){
		return this.word;
	}
	//Accessors
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getUsageCnt() {
		return usageCnt;
	}

	public void setUsageCnt(int usageCnt) {
		this.usageCnt = usageCnt;
	}	

}
