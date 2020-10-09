import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		InsertionSort iSort = new InsertionSort();
		int[] arr = new int[] {6,5,4,3};
		
		iSort.insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	private void insertionSort(int[] arr) {
		
		//Worst case: (O)n^2
		//Best case: (O)n
		//Average: (O)n^2
		
		
		//outer pass
		for(int i = 1; i < arr.length; i++) {
			//pull out target and make the hole
			int target = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > target) {
				//shift right
				arr[j+1] = arr[j];
				j--;
			}
			//Put it home
			arr[j + 1] = target;
		}
	}

}
