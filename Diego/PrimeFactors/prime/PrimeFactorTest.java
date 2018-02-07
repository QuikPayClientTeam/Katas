package prime;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static prime.PrimeFactor.generate;

public class PrimeFactorTest {
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	private List<Integer> list(int... numbers) {
		List<Integer> list = new LinkedList<Integer>();
		for (int number : numbers) {
			list.add(number);
		}

		return list;
	}

	@Test
	public void test1() {
		assertEquals(list(), generate(1));
	}

	@Test
	public void test2() {
		assertEquals(list(2), generate(2));
	}

	@Test
	public void test3() {
		assertEquals(list(3), generate(3));
	}

	@Test
	public void test4() {
		assertEquals(list(2, 2), generate(4));
	}

	@Test
	public void test5() {
		assertEquals(list(5), generate(5));
	}

	@Test
	public void test6() {
		assertEquals(list(2, 3), generate(6));
	}

	@Test
	public void test7() {
		assertEquals(list(7), generate(7));
	}

	@Test
	public void test8() {
		assertEquals(list(2, 2, 2), generate(8));
	}

	@Test
	public void test9() {
		assertEquals(list(3, 3), generate(9));
	}

	@Test
	public void test10() {
		assertEquals(list(2, 5), generate(10));
	}

	@Test
	public void test12() {
		assertEquals(list(2, 2, 3), generate(12));
	}

	@Test
	public void test13() {
		assertEquals(list(13), generate(13));
	}
}
