
public class MinMaxAvg {

	public static void main(String[] args) {
		int arr[] = new int[]{77, 65, 50, 45, 95};
		int min = findMin(arr);
		
		if(min != 45) {
			System.out.println("Failed");
		}else {
			System.out.println("Pass");
		}
		
		int max = findMax(arr);
		if(max != 95) {
			System.out.println("Failed");
		}else {
			System.out.println("Pass");
		}
		
		double average = findAvg(arr);
		if(average != 66.4) {
			System.out.println("Failed");
		}else {
			System.out.println("Pass");
		}
		
		int maxIndex = findMaxIndex(arr);
		if(maxIndex != 4) {
			System.out.println("Failed");
		}else {
			System.out.println("Pass");
		}
	}
	
	public static int findMin(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	public static int findMax(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static double findAvg(int[] arr) {
		double sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = sum/arr.length;
		return avg;
	}
	
	public static int findMaxIndex(int[] arr) {
		int index = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[index]) {
				index = i;
			}
		}
		return index;
	}

}
