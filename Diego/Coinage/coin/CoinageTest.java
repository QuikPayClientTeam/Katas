package coin;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoinageTest {
	private static final int[] standard = {1, 5, 10, 25};
	private static final int[] other = {1, 5, 10, 25, 50};
	
	private Coinage c1;
	private Coinage c2;

	@Before
	public void setUp() throws Exception {
		c1 = new Coinage();
		c2 = new Coinage(other);
	}

	@Test
	public void testCoinage() {
		assertNotNull(c1);
		assertNotNull(c2);
	}

	@Test
	public void testDenominations() {
		assertTrue("c1 is using the denominations 1, 5, 10, and 25", Arrays.equals(standard, c1.getDenominations()));
		assertTrue("c2 is using the denominations 1, 5, 10, 25, and 50", Arrays.equals(other, c2.getDenominations()));
	}

	@Test
	public void testCombinations() {
		List<List<Integer>> combinations;

		combinations = c1.getCombinations(1);
		assertEquals("Number of combinations for 1 is 1", 1, combinations.size());
		combinations = c1.getCombinations(5);
		assertEquals("Number of combinations for 5 is 2", 2, combinations.size());
		combinations = c1.getCombinations(6);
		assertEquals("Number of combinations for 6 is 2", 2, combinations.size());
		combinations = c1.getCombinations(10);
		assertEquals("Number of combinations for 10 is 4", 4, combinations.size());
		combinations = c1.getCombinations(15);
		assertEquals("Number of combinations for 15 is 6", 6, combinations.size());
		combinations = c1.getCombinations(16);
		assertEquals("Number of combinations for 16 is 6", 6, combinations.size());
		combinations = c1.getCombinations(21);
		assertEquals("Number of combinations for 21 is 9", 9, combinations.size());
		combinations = c1.getCombinations(30);
		assertEquals("Number of combinations for 30 is 18", 18, combinations.size());
		combinations = c1.getCombinations(100);
		assertEquals("Number of combinations for 100 is 242", 242, combinations.size());
		printCombinations(combinations);
	}

	private void printCombinations(List<List<Integer>> combinations) {
		System.out.println(combinations.size());
		for (int i = 0; i < combinations.size(); i++) {
			List<Integer> combination = combinations.get(i);
			System.out.print("  [");
			for (int j = 0; j < combination.size(); j++) {
				System.out.print(combination.get(j));
				if (j < combination.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
	}
}
