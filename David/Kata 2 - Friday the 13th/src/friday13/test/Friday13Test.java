package friday13.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import friday13.main.Friday13;

public class Friday13Test {

	@Test
	public void testFriday13() {
		assertEquals("FRIDAY is NOT the most common 13th day of the month", "FRIDAY", Friday13.mostCommonDay());
	}

}
