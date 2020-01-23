package tests;

import com.samples.dylanisensee.CustomString;

public class CustomStringExamples {

	public static void main(String[] args) {
		char[] values = new char[] {'a', 'b', 'c'};
		CustomString cs = new CustomString(values);
		char[] compValues = new char[] {'b', 'c'};
		CustomString compCs = new CustomString(compValues);
		char[] compValues2 = new char[] {'d', 'e', 'f'};
		CustomString compCs2 = new CustomString(compValues2);
		CustomString emptyCS = new CustomString();
		
		char testCharAt = cs.charAt(2);
		System.out.println(testCharAt);
		
		char testEmptyCharAt = emptyCS.charAt(3);
		System.out.println(testEmptyCharAt);
		
		int size = cs.getSize();
		System.out.println(size);
		System.out.println(cs.length());
		
		System.out.println(cs.indexOf('a'));
		System.out.println(cs.indexOf(98));
		
		System.out.println(cs.toString());
		
		System.out.println(cs.equals(compCs2));
		
		
//		CustomString ucCS = cs.toUpperCase();
//		System.out.println(ucCS.toString());
		
		cs.resize(6);
		System.out.println(cs.length());
		
		compCs.append(compValues2);
		System.out.println(compCs);
		
		
		
		char[] anotherTest = new char[] {'a', 'b'};
		CustomString anotherTestCs = new CustomString(anotherTest);
		System.out.println(cs.startsWith(anotherTestCs));
		
		System.out.println(cs.substring(0, 3));
		
		System.out.println(cs.indexOf(compCs));
	}

}
