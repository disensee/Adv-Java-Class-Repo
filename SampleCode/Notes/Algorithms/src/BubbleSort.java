import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] {6, 3, 2, 7, 4};
		
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static int[] bubbleSort(int[] arr) {
		boolean itemSwapped = true;
		while(itemSwapped) {
			itemSwapped = false;
			for(int j = 0; j < (arr.length -1); j++) {
				if(arr[j] > arr[j + 1]) {
					//swap
					int holdJ = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = holdJ;
					itemSwapped = true;
				}
			}
		}
		return arr;
	}

}
