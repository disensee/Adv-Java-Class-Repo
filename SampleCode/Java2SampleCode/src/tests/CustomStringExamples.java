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

	}

}
