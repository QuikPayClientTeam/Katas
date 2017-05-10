package kata11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CombinedNumbersTest {

	@Test
	public void getMax() {

		List<Integer> combinations = new ArrayList<Integer>();
		combinations.add(1);
		combinations.add(4);
		combinations.add(7);
		combinations.add(1);

		assertEquals(7, CombinedNumbers.getMax(combinations));
		assertNotSame(1, CombinedNumbers.getMax(combinations));

	}

	@Test
	public void arrayToSum() {
		int[] test = new int[] { 50, 2, 1, 9 }; // 95021
		assertEquals(50219, CombinedNumbers.arrayToSum(test));
		assertNotSame("50219", CombinedNumbers.arrayToSum(test));
		assertNotSame(95021, CombinedNumbers.arrayToSum(test));
	}

	@Test
	public void getAllPermutations() {
		List<Integer> list = new ArrayList<Integer>();
		int[] test = new int[] { 1, 2 };

		// list to test against
		/*
		 * Debug run of {1,2} : getAllPermutations: 12 getAllPermutations: 12
		 * getAllPermutations: 12 getAllPermutations: 12 getAllPermutations: 21
		 * getAllPermutations: 21
		 */
		List<Integer> compare = new ArrayList<Integer>();
		compare.add(12);
		compare.add(12);
		compare.add(12);
		compare.add(12);
		compare.add(21);
		compare.add(21);

		assertEquals(compare, CombinedNumbers.getAllPermutations(test, 0, list));
	}

}
