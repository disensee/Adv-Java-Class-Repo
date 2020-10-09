package tests;

import com.samples.dylanisensee.CustomString;

public class CustomStringExamples {

	public static void main(String[] args) {
		char[] values = new char[] {'a', 'b', 'b', 'b','c'};
		CustomString cs = new CustomString(values);
		char[] compValues = new char[] {'c'};
		CustomString compCs = new CustomString(compValues);
		char[] compValues2 = new char[] {'d', 'e', 'f'};
		CustomString compCs2 = new CustomString(compValues2);
		CustomString emptyCS = new CustomString();
		char[] sizeTest = new char[10];
		
		sizeTest[0] = 'a';
		CustomString sizeTestCustStr = new CustomString(sizeTest);
		
		System.out.println("getSize: " + sizeTestCustStr.getSize());
		
		char testCharAt = cs.charAt(2);
		System.out.println("charAt: " + testCharAt);
		
		char testEmptyCharAt = emptyCS.charAt(3);
		System.out.println("charAt(empty): " + testEmptyCharAt);

		System.out.println("length: " + cs.length());
		
		System.out.println("indexOf(char): " + cs.indexOf('a'));
		System.out.println("indexOf(int): " + cs.indexOf(98));
		System.out.println("indexOf(customString): " + cs.indexOf(compCs));
		System.out.println("toString: " + cs.toString());
		
		System.out.println("equals: " + cs.equals(compCs2));
		
		
		CustomString ucCS = cs.toUpperCase();
		System.out.println("toUpperCase: " + ucCS.toString());
		
		cs.resize(6);
		System.out.println("resize: " + cs.length());
		
		
		cs.append(compValues2);
		System.out.println("append: " + cs);
		
		
		char[] anotherTest = new char[] {'A', 'B'};
		CustomString anotherTestCs = new CustomString(anotherTest);
		System.out.println("startsWith: " + cs.startsWith(anotherTestCs));
		
		System.out.println("substring: " + cs.substring(0, 4));
		
		
		System.out.print("toCharArray: ");
		for(int i = 0; i < compCs2.toCharArray().length; i++) {
			System.out.print(compCs2.toCharArray()[i]);
		}
		
		char[] suffixValues = new char[] {'e', 'f'};
		CustomString suffix = new CustomString(suffixValues);
		System.out.println("\nendsWith: " + compCs2.endsWith(suffix));
		
		char[] values2 = new char[] {'a', 'b', 'c'};
		CustomString csUnchanged = new CustomString(values2);
		CustomString compCsUnchanged = new CustomString(compValues);
		System.out.println("equalsIgnoreCase: " + csUnchanged.equalsIgnoreCase(compCsUnchanged));
		
		char[] bc = new char[] {'b','c'};
		CustomString containsTest = new CustomString(bc);
		System.out.println("contains: " + csUnchanged.contains(containsTest));
		
		char[] compareToValues = new char[] {'A', 'B', 'C'};
		char[] compareToValues2 = new char[] {'A', 'B', 'C'};
		char[] compareToValues3 = new char[] {'A', 'B', 'C', 'D'};
		char[] compareToValues4 = new char[] {'X', 'Y', 'Z'};
		CustomString compareToCs = new CustomString(compareToValues);
		CustomString compareToCs1 = new CustomString(compareToValues);
		CustomString compareToCs2 = new CustomString(compareToValues2);
		CustomString compareToCs3 = new CustomString(compareToValues3);
		CustomString compareToCs4 = new CustomString(compareToValues4);
		
		System.out.println("compareTo: " + compareToCs3.compareTo(compareToCs));
		
		
		char[] replaceTestValues = new char[] {'d','y','l','a','n'};
		char[] replaceTestValuesTarget = new char[] {'a', 'n'};
		char[] replaceTestValueReplacement = new char[] {'o', 'm'};
		CustomString replaceTest = new CustomString(replaceTestValues);
		CustomString replaceTestTarget = new CustomString(replaceTestValuesTarget);
		CustomString replaceTestReplacement = new CustomString(replaceTestValueReplacement);
		System.out.println("replace: " + replaceTest.replace(replaceTestTarget, replaceTestReplacement));
		//Replace is maybe kind of working
		
		
	}

}
