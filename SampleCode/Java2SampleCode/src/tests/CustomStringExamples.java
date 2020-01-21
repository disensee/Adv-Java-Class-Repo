package tests;

import com.samples.dylanisensee.CustomString;

public class CustomStringExamples {

	public static void main(String[] args) {
		char[] values = new char[] {'a', 'b', 'c'};
		CustomString cs = new CustomString(values);
		CustomString emptyCS = new CustomString();
		
		char testCharAt = cs.charAt(2);
		System.out.println(testCharAt);
		
		char testEmptyCharAt = emptyCS.charAt(3);
		System.out.println(testEmptyCharAt);
		
		int size = cs.getSize();
		System.out.println(size);
		System.out.println(cs.length());
		
		System.out.println(cs.indexOf('d'));
		System.out.println(cs.indexOf(100));
		
		System.out.println(cs.toString());
		
	}

}
