
public class Recursion {
	
	//MERGE SORT METHODS
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
	
	private static int[] split(int[] arr, boolean isLeft) {
		int m = arr.length /2;
		
		if(isLeft) {
			//returns the left part of the array
			int[] lArr = new int[m];
			for(int i = 0; i < m; i++) {
				lArr[i] = arr[i];
			}
			
			return lArr;
			
		}
		else {
			//returns the right part of the array
			
			int[] rArr = new int[m + arr.length % 2];
			for(int i = m;i < arr.length; i++) {
				rArr[i - m] = arr[i];
			}
			
			return rArr;
			
		}
	}
	
	private static int[] combine(int[] lArr, int[] rArr) {
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
		
		while(lLoc < lArr.length) {
			arr[loc++] = lArr[lLoc++];
		}
		while(rLoc < rArr.length) {
			arr[loc++] = rArr[rLoc++];
		}
		
		
		return arr;
	}
	//END OF MERGE SORT METHODS
	
	
	//BINARY SEARCH METHOD(S)
	public static int binarySearch(int[] arr, int l, int r, int target) {
			
			//base case
			if(l > r) {
				return -1;
			}
			
			int m = (l + r) / 2;
			if(arr[m] == target) {
				return m;
			}
			else if(target < arr[m]) {
				//search left
				return binarySearch(arr, l, m-1, target);
			}
			else {
				//search right
				return binarySearch(arr, m+1 ,r , target);
			}
	}
	//END OF BINARY SEARCH METHOD(S)
	
}
