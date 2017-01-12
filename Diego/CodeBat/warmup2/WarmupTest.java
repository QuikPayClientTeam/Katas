package warmup2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class WarmupTest
{
	private Warmup warmup;

	@Before
	public void setUp() throws Exception
	{
		warmup = new Warmup();
	}

	@Test
	public void testStringTimes()
	{
		assertEquals("HiHi", warmup.stringTimes("Hi", 2));
		assertEquals("HiHiHi", warmup.stringTimes("Hi", 3));
		assertEquals("Hi", warmup.stringTimes("Hi", 1));
	}

	@Test
	public void testFrontTimes()
	{
		assertEquals("ChoCho", warmup.frontTimes("Chocolate", 2));
		assertEquals("ChoChoCho", warmup.frontTimes("Chocolate", 3));
		assertEquals("AbcAbcAbc", warmup.frontTimes("Abc", 3));
	}

	@Test
	public void testCountXX()
	{
		assertEquals(1, warmup.countXX("abcxx"));
		assertEquals(2, warmup.countXX("xxx"));
		assertEquals(3, warmup.countXX("xxxx"));
	}

	@Test
	public void testDoubleX()
	{
		assertEquals(true, warmup.doubleX("axxbb"));
		assertEquals(false, warmup.doubleX("axaxax"));
		assertEquals(true, warmup.doubleX("xxxxx"));
	}

	@Test
	public void testStringBits()
	{
		assertEquals("Hlo", warmup.stringBits("Hello"));
		assertEquals("H", warmup.stringBits("Hi"));
		assertEquals("Hello", warmup.stringBits("Heeololeo"));
	}

	@Test
	public void testStringSplosion()
	{
		assertEquals("CCoCodCode", warmup.stringSplosion("Code"));
		assertEquals("aababc", warmup.stringSplosion("abc"));
		assertEquals("aab", warmup.stringSplosion("ab"));
	}

	@Test
	public void testLast2()
	{
		assertEquals(1, warmup.last2("hixxhi"));
		assertEquals(1, warmup.last2("xaxxaxaxx"));
		assertEquals(2, warmup.last2("axxxaaxx"));
	}

	@Test
	public void testArrayCount9()
	{
		assertEquals(1, warmup.arrayCount9(new int[]{1, 2, 9}));
		assertEquals(2, warmup.arrayCount9(new int[]{1, 9, 9}));
		assertEquals(3, warmup.arrayCount9(new int[]{1, 9, 9, 3, 9}));
	}

	@Test
	public void testArrayFront9()
	{
		assertEquals(true, warmup.arrayFront9(new int[]{1, 2, 9, 3, 4}));
		assertEquals(false, warmup.arrayFront9(new int[]{1, 2, 3, 4, 9}));
		assertEquals(false, warmup.arrayFront9(new int[]{1, 2, 3, 4, 5}));
	}

	@Test
	public void testArray123()
	{
		assertEquals(true, warmup.array123(new int[]{1, 1, 2, 3, 1}));
		assertEquals(false, warmup.array123(new int[]{1, 1, 2, 4, 1}));
		assertEquals(true, warmup.array123(new int[]{1, 1, 2, 1, 2, 3}));
	}

	@Test
	public void testStringMatch()
	{
		assertEquals(3, warmup.stringMatch("xxcaazz", "xxbaaz"));
		assertEquals(2, warmup.stringMatch("abc", "abc"));
		assertEquals(0, warmup.stringMatch("abc", "axc"));
	}

	@Test
	public void testStringX()
	{
		assertEquals("xHix", warmup.stringX("xxHxix"));
		assertEquals("abcd", warmup.stringX("abxxxcd"));
		assertEquals("xabcdx", warmup.stringX("xabxxxcdx"));
	}

	@Test
	public void testAltPairs()
	{
		assertEquals("kien", warmup.altPairs("kitten"));
		assertEquals("Chole", warmup.altPairs("Chocolate"));
		assertEquals("Congrr", warmup.altPairs("CodingHorror"));
	}

	@Test
	public void testStringYak()
	{
		assertEquals("pak", warmup.stringYak("yakpak"));
		assertEquals("pak", warmup.stringYak("pakyak"));
		assertEquals("123ya", warmup.stringYak("yik123ya"));
	}

	@Test
	public void testArray667()
	{
		assertEquals(1, warmup.array667(new int[]{6, 6, 2}));
		assertEquals(1, warmup.array667(new int[]{6, 6, 2, 6}));
		assertEquals(1, warmup.array667(new int[]{6, 7, 2, 6}));
	}

	@Test
	public void testNoTriples()
	{
		assertEquals(true, warmup.noTriples(new int[]{1, 1, 2, 2, 1}));
		assertEquals(false, warmup.noTriples(new int[]{1, 1, 2, 2, 2, 1}));
		assertEquals(false, warmup.noTriples(new int[]{1, 1, 1, 2, 2, 2, 1}));
	}

	@Test
	public void testHas271()
	{
		assertEquals(true, warmup.has271(new int[]{1, 2, 7, 1}));
		assertEquals(false, warmup.has271(new int[]{1, 2, 8, 1}));
		assertEquals(true, warmup.has271(new int[]{2, 7, 1}));
	}
}
