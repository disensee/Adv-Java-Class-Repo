
public class DigitsToWords {

	public static void main(String[] args) {
		digitsToWords(15);
	}
	
	public static void digitsToWords(int num) {
		
		if(num < 10) {
			System.out.print(numToWord(num) + " ");
			return;
		}
		//normal case
		int lsd = num%10;
		int red = num/10;
		
		digitsToWords(red);
		System.out.print(numToWord(lsd) + " ");
	}
	
	
	public static String numToWord(int num) {
		switch(num) {
		case 0:
			return "Zero";
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3: 
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		default:
			return "ERROR";
		}
	}

}
