
public class CountNumZeros {

	public static void main(String[] args) {
		System.out.println(countNumZeros(2030));
	}
	
	public static int countNumZeros(int num) {
		//base case
		if(num < 10) {
			if(num == 0) {
				return 1;
			}else{
				return 0;
			}
		}
		//normal case
		int lsd = num % 10;
		if(lsd == 0) {
			return countNumZeros(num / 10) + 1;
		}
		else {
			return countNumZeros(num / 10);
		}
		
	}
}
