
public class Validator {

	public static void main(String[] args) {
		int arr[] = new int[] {3,1,7,8,9,3,7,2,9,9,7};
		
		int total = 0;
		
		for(int i = 0; i<arr.length; i++) {
			//even
			if(i%2 == 0) {
				total += arr[i];
			//odd
			}else {
				int doubleOddIndex = arr[i] * 2;
				if(doubleOddIndex > 9) {
					//split and total
					int lsd = doubleOddIndex%10;
					int msd = (doubleOddIndex/10)%10;
					total+= lsd + msd;
					
				}else {
					total += doubleOddIndex;
				}
			}
		}
		if (total%10 == 0) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
		
	}
}
