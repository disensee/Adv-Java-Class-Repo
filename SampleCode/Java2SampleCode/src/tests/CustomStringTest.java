package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.samples.dylanisensee.CustomString;

public class CustomStringTest {
	
	char[] values = new char[] {'a','b','c'};
	public CustomString cs = new CustomString(values);

	@Test
	public void testLength() {
		int length = cs.length();
		assertEquals(3, length);
	}
	
	char[] values1 = new char[] {};
	public CustomString csEmptyTest = new CustomString(values1);
	
	@Test 
	public void testIsEmpty() {
		boolean isEmpty = csEmptyTest.isEmpty();
		assertEquals(true, isEmpty);
	}
	
	@Test
	public void testCharAt() {
		char testValue = cs.charAt(3);
		assertEquals('0', testValue);
	}
	

}
