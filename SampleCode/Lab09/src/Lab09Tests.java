//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Lab09Tests {
	SinglyLinkedList<String> list = new SinglyLinkedList<String>();
	
	@Test
	void testSize() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		int size = list.size();
		assertEquals(3, size);
	}
	
	@Test
	void testIsEmptyTrue() {
		boolean isEmpty = list.isEmpty();
		assertEquals(true, isEmpty);
	}
	
	@Test
	void testIsEmptyFalse() {
		list.add("Birdperson");
		boolean isEmpty = list.isEmpty();
		assertEquals(false, isEmpty);
	}
	
	@Test
	void testAdd() {
		boolean addSuccess = list.add("Rick");
		assertEquals(true, addSuccess);
	}
	
	@Test
	void testRemoveObjectTrue() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		boolean removed = list.remove("Morty");
		assertEquals(true, removed);
	}
	
	@Test
	void testRemoveObjectFalse() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		boolean removed = list.remove("Summer");
		assertEquals(false, removed);
	}
	
}
