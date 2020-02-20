import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] arr = new int[] {6,8,1,4,2};
		
		selectionSort.selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			int smallestIndex = i;
			for(int j =  i + 1; j < arr.length; j++) {
				//searching for the smallest after i
				if(arr[j] < arr[smallestIndex]) {
					//we should update the smallest index
					smallestIndex = j;
				}
				//perform the swap
				int holdI = arr[i];
				arr[i] = arr[smallestIndex];
				arr[smallestIndex] = holdI;
			}
		}
	}

}
