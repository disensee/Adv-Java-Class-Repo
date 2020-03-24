
public class TimerDemo {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000; i++) {
			System.out.println(i);
		}
		
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
	}
}
