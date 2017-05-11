package numbers;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CombineTest
{
	Combine combiner;

	@Before
	public void setUp() throws Exception
	{
		combiner = new Combine();
	}

	@Test
	public void testCombine()
	{
		assertNotNull(combiner);
	}

	@Test
	public void testValidate()
	{
		List<String> numbers = new LinkedList<String>();
		numbers.add("50"); numbers.add("-2"); numbers.add("1");
		assertFalse(combiner.validate(numbers));
		numbers.clear();
		numbers.add("50"); numbers.add("9.8"); numbers.add("1");
		assertFalse(combiner.validate(numbers));
		numbers.clear();
		numbers.add("50"); numbers.add("poop"); numbers.add("1");
		assertFalse(combiner.validate(numbers));
		numbers.clear();
		numbers.add("50"); numbers.add("4"); numbers.add("1");
		assertTrue(combiner.validate(numbers));
	}

	@Test
	public void testGetMax()
	{
		assertEquals(95021, combiner.getMax("[50, 2, 1, 9]"));
		assertEquals(56550, combiner.getMax("5, 50, 56"));
		assertEquals(565655, combiner.getMax("5, 565, 56"));
		assertEquals(567565, combiner.getMax("5, 567, 56"));
		assertEquals(565645, combiner.getMax("5, 564, 56"));
		assertEquals(554544, combiner.getMax("5, 544, 54"));
		assertEquals(42423420, combiner.getMax("420, 42, 423"));
		assertEquals(42442420, combiner.getMax("420, 42, 424"));
	}
}
