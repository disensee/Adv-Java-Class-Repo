
public class Word implements Comparable<Word>{
	
	private String word;
	private int usageCnt;
	
	//Constructor
	public Word(String word) {
		setWord(word);
		setUsageCnt(1);
	}
	
	//Methods
	public void incrementUsageCnt() {
		this.usageCnt++;
	}
	
	@Override
	public int compareTo(Word word) {
		Word otherWord = (Word)word;
		return this.getUsageCnt() - otherWord.getUsageCnt();
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
