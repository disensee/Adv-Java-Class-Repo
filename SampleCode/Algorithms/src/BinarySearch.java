
public class BinarySearch {
	public static void main(String[] args) {
		int[] toSearch = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		int l = 0;
		int h = toSearch.length - 1;
		int target1 = 9;
		int target2 = 2;
		int target3 = 12;	
		
		
		System.out.println(bSearch(toSearch, 0, target1));
		System.out.println(bSearch(toSearch, 0, target2));
		System.out.println(bSearch(toSearch, 0, target3));
		
	}
	
	public static int bSearch(int[] arr, int l, int target) {
		l = 0;
		int h = arr.length - 1;
		while(l <= h) {
			int m = (l + h) / 2;
			if(arr[m] == target) {
				return m;
			}else if(arr[m] < target) {
				l = m + 1;
			}else if(arr[m] > target){
				h = m - 1;
			}
		}
		return - 1;
	}
}
