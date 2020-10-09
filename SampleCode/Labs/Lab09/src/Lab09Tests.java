//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class Lab09Tests {
	CustomLinkedList<String> list = new CustomLinkedList<String>();
	
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
	void testContainsTrue() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		boolean contains = list.contains("Rick");
		assertEquals(true, contains);
	}
	
	@Test
	void testContainsFalse() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		boolean contains = list.contains("Birdperson");
		assertEquals(false, contains);
	}
	
	@Test 
	void testToArray() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		Object[] oArr = new Object[list.size()];
		oArr[0] = "Rick";
		oArr[1] = "Morty";
		oArr[2] = "Jerry";
		
		Object[] tArr = list.toArray();
		
		assertEquals(oArr, tArr);
	}
	
	@Test
	void testToArrayEmpty(){
		try {
			Object[] arr = list.toArray();
		}catch(NullPointerException npe) {
			System.out.println("TO ARRAY NULL TEST: " + npe.getMessage());
		}
	}
	
	@Test
	void testAdd() {
		boolean addSuccess = list.add("Rick");
		assertEquals(true, addSuccess);
		
		boolean addFail = list.add(null);
		assertEquals(false, addFail);
	}
	
	@Test
	void testRemoveObjectTrue() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		boolean removed = list.remove("Morty");
		int size = list.size();
		assertEquals(true, removed);
		assertEquals(2, size);
	}
	
	@Test
	void testRemoveObjectFalse() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		boolean removed = list.remove("Summer");
		assertEquals(false, removed);
	}
	
	@Test
	void testRemoveObjectNull() {
		try {
			boolean removed = list.remove("o");
		}catch(NullPointerException npe) {
			System.out.println("NULL REMOVE TEST: " + npe.getMessage());
		}
	}
	
	@Test
	void testClear() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		list.clear();
		boolean isEmpty = list.isEmpty();
		
		assertEquals(true, isEmpty);
	}
	
	@Test
	void testGet() {
//		list.add("Rick");
//		list.add("Morty");
//		list.add("Jerry");
		
		try {
			String test = list.get(2);
			//String outOfBounds = list.get(3);
			assertEquals("Jerry", test);
		}catch(NullPointerException npe) {
			System.out.println("GET TEST ERROR: " + npe.getMessage());
		}
	}
	
	@Test
	void testSet() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		String test = list.set(1, "Birdperson");
		String test2 = list.get(1);
		
		assertEquals("Morty", test);
		assertEquals("Birdperson", test2);
	}
	
	@Test
	void testSetHead() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		String test = list.set(0, "Birdperson");
		String test2 = list.get(0);
		
		assertEquals("Rick", test);
		assertEquals("Birdperson", test2);
	}
	
	@Test
	void testSetEmpty() {		
		try{
			String test = list.set(0, "Birdperson");
			assertEquals(null , test);
		}catch(UnsupportedOperationException uoe) {
			System.out.println("SET TEST EMPTY: " + uoe.getMessage());
		}
	}
	
	@Test
	void testSetOutOfBounds() {		
		try{
			list.add("Tammy");
			
			String test = list.set(1, "Birdperson");
			assertEquals(null , test);
		}catch(IndexOutOfBoundsException npe) {
			System.out.println("SET TEST OUT OF BOUNDS: " + npe.getMessage());
		}
	}
	
	@Test
	void testAddIndex() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		
		try {
			list.add(0, "Birdperson");
			list.add(2, "Summer");
		
			int size = list.size();
		
			//list.add(7, "Beth");
			
			assertEquals("Birdperson", list.get(0));
			assertEquals("Rick", list.get(1));
			assertEquals("Summer", list.get(2));
			assertEquals("Morty", list.get(3));
			assertEquals("Jerry", list.get(4));
			assertEquals(5, size);
		}catch(NullPointerException npe) {
			System.out.println("TEST ADD INDEX NULL: " + npe.getMessage());
		}catch(IndexOutOfBoundsException iob) {
			System.out.println("TEST ADD INDEX OUT OF BOUNDS: " + iob.getMessage());
		}
	}
	
	@Test
	void testRemoveIndex() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		try {
			String removed = list.remove(2);
			//list.remove(5);
			int size = list.size();
			
			assertEquals("Jerry", removed);
			assertEquals(2, size);
		}catch(NullPointerException npe) {
			System.out.println("TEST REMOVE INDEX NULL: " + npe.getMessage());
		}catch(IndexOutOfBoundsException iob) {
			System.out.println("TEST REMOVE INDEX OUT OF BOUNDS: " + iob.getMessage());
		}

	}
	
	@Test
	void testIndexOf() {
		list.add("Rick");
		list.add("Morty");
		list.add("Jerry");
		
		try {
			int index = list.indexOf("Jerry");
			int noIndex = list.indexOf("Squanchy");
			
			assertEquals(2, index);
			assertEquals(-1, noIndex);
		}catch(NullPointerException npe) {
			System.out.println("TEST INDEX OF: " + npe.getMessage());
		}
	}
	
	@Test
	void testLastIndexOf() {
//		list.add("Rick");
//		list.add("Morty");
//		list.add("Jerry");
//		list.add("Rick");
//		list.add("Morty");
//		list.add("Jerry");
		
		try {
			int lastIndexOfRick = list.lastIndexOf("Rick");
			int lastIndexOfMorty = list.lastIndexOf("Morty");
			int lastIndexOfJerry = list.lastIndexOf("Jerry");
			int lastIndexOfNotFound = list.lastIndexOf("Gazorpian");
			
			assertEquals(3, lastIndexOfRick);
			assertEquals(4, lastIndexOfMorty);
			assertEquals(5, lastIndexOfJerry);
			assertEquals(-1, lastIndexOfNotFound);
		}catch(NullPointerException npe) {
			System.out.println("TEST LAST INDEX OF NULL: " + npe.getMessage());
		}
	}
}
