import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	public Tests test = new Tests();
	
	@Test
	public void testAdd() {
		int result = test.add(1,2);
		assertEquals(3, result);
	}

}
