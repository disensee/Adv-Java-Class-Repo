import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {5,2,9,4,7};
		
		arr = mergeSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] mergeSort(int[] arr) {
		//base case
		if (arr.length == 1) {
			return arr;
		}
		
		
		int[] lArr = split(arr, true);
		int[] rArr = split(arr, false);
		
		lArr = mergeSort(lArr);
		rArr = mergeSort(rArr);
		
		int[] cArr = combine(lArr, rArr);
		return cArr;
		
	}
	
	public static int[] split(int[] arr, boolean isLeft) {
		int m = arr.length /2;
		//5/2 = 2 (integer division)
		
		if(isLeft) {
			//returns the left chunk
			int[] lArr = new int[m];
			for(int i = 0; i < m; i++) {
				lArr[i] = arr[i];
			}
			
			return lArr;
			
		}
		else {
			//returns right chunk
			
			int[] rArr = new int[m + arr.length % 2];
			for(int i = m;i < arr.length; i++) {
				rArr[i - m] = arr[i];
			}
			
			return rArr;
			
		}
	}
	
	public static int[] combine(int[] lArr, int[] rArr) {
		int[] arr = new int[lArr.length + rArr.length];
		
		int lLoc = 0;
		int rLoc = 0;
		int loc = 0;
		while(lLoc < lArr.length && rLoc < rArr.length) {
			if(lArr[lLoc] < rArr[rLoc]) {
				arr[loc] = lArr[lLoc];
				loc++;
				lLoc++;
			}else {
				arr[loc++] = rArr[rLoc++];
			}
		}
		
		//add anything remaining in either array
		while(lLoc < lArr.length) {
			arr[loc++] = lArr[lLoc++];
		}
		while(rLoc < rArr.length) {
			arr[loc++] = rArr[rLoc++];
		}
		
		
		return arr;
	}

}

//PERFORMANCE
//n*log(n)
