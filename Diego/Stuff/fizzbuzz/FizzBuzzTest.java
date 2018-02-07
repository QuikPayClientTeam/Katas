package fizzbuzz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
	private FizzBuzz fb;
	
	@Before
	public void setUp() throws Exception {
		fb = new FizzBuzz();
	}

	@Test
	public void testFizz() {
		assertEquals("Print Fizz", "Fizz", fb.determine(3));
		assertEquals("Print Fizz", "Fizz", fb.determine(12));
	}

	@Test
	public void testBuzz() {
		assertEquals("Print Buzz", "Buzz", fb.determine(5));
		assertEquals("Print Buzz", "Buzz", fb.determine(10));
	}

	@Test
	public void testFizzBuzz() {
		assertEquals("Print FizzBuzz", "FizzBuzz", fb.determine(15));
		assertEquals("Print FizzBuzz", "FizzBuzz", fb.determine(30));
	}

	@Test
	public void testNone() {
		assertEquals("Print 4", "4", fb.determine(4));
	}
}
