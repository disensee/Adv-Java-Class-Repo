
public class BinarySearch {
	public static void main(String[] args) {
		int[] toSearch = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] toSearchR = new int[] {1,2,3,4,5};
		
		int l = 0;
		int h = toSearch.length - 1;
		int target1 = 9;
		int target2 = 2;
		int target3 = 12;	
		
		
		System.out.println(bSearch(toSearch, 0, target1));
		System.out.println(bSearch(toSearch, 0, target2));
		System.out.println(bSearch(toSearch, 0, target3));
		
		int targetR = 1;
		int loc = bsRecurse(toSearch, 0, toSearch.length - 1, targetR);
		if(loc != 0) {
			System.out.println("ERROR 1");
		}else {
			System.out.println("No news is good news!");
		}
		
		targetR = 100;
		loc = bsRecurse(toSearch, 0, toSearch.length - 1, targetR);
		if(loc != -1) {
			System.out.println("ERROR 2");
		}else {
			System.out.println("No news is good news!");
		}
		
		
	}
	
	public static int bSearch(int[] arr, int l, int target) {
		l = 0;
		int h = arr.length - 1;
		while(l <= h) {
			int m = (l + h) / 2;
			if(arr[m] == target) {
				return m;
			}
			else if(arr[m] < target) {
				l = m + 1;
			}
			else if(arr[m] > target){
				h = m - 1;
			}
		}
		return - 1;
	}
	
	
	//bs returns the index of target in array if it exists, otherwise -1 is returned
	public static int bsRecurse(int[] arr, int l, int r, int target) {
		
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
			return bsRecurse(arr, l, m-1, target);
		}
		else {
			//search right
			return bsRecurse(arr, m+1 ,r , target);
		}
	}
}
