package warmup1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WarmupTest
{
	Warmup main;
	
	@Before
	public void setUp() throws Exception
	{
		main = new Warmup();
	}

	@After
	public void tearDown() throws Exception
	{
		main = null;
	}

	@Test
	public void testSleepIn()
	{
		assertEquals(true, main.sleepIn(false, false));
		assertEquals(false, main.sleepIn(true, false));
		assertEquals(true, main.sleepIn(false, true));
		assertEquals(true, main.sleepIn(true, true));
	}
	
	@Test
	public void testMonkeyTrouble()
	{
		assertEquals(true, main.monkeyTrouble(true, true));
		assertEquals(true, main.monkeyTrouble(false, false));
		assertEquals(false, main.monkeyTrouble(true, false));
		assertEquals(false, main.monkeyTrouble(false, true));
	}

	@Test
	public void testSumDouble()
	{
		assertEquals(3, main.sumDouble(1, 2));
		assertEquals(5, main.sumDouble(3, 2));
		assertEquals(8, main.sumDouble(2, 2));
		assertEquals(-1, main.sumDouble(-1, 0));
		assertEquals(12, main.sumDouble(3, 3));
		assertEquals(0, main.sumDouble(0, 0));
		assertEquals(1, main.sumDouble(0, 1));
		assertEquals(7, main.sumDouble(3, 4));
	}
	
	@Test
	public void testDiff21()
	{
		assertEquals(2, main.diff21(19));
		assertEquals(11, main.diff21(10));
		assertEquals(0, main.diff21(21));
		assertEquals(2, main.diff21(22));
		assertEquals(8, main.diff21(25));
		assertEquals(18, main.diff21(30));
		assertEquals(21, main.diff21(0));
		assertEquals(20, main.diff21(1));
		assertEquals(19, main.diff21(2));
		assertEquals(22, main.diff21(-1));
		assertEquals(23, main.diff21(-2));
		assertEquals(58, main.diff21(50));
	}
	
	@Test
	public void testParrotTrouble()
	{
		assertEquals(true, main.parrotTrouble(true, 6));
		assertEquals(false, main.parrotTrouble(true, 7));
		assertEquals(false, main.parrotTrouble(false, 6));
		assertEquals(true, main.parrotTrouble(true, 21));
		assertEquals(false, main.parrotTrouble(false, 21));
		assertEquals(false, main.parrotTrouble(false, 20));
		assertEquals(true, main.parrotTrouble(true, 23));
		assertEquals(false, main.parrotTrouble(false, 23));
		assertEquals(false, main.parrotTrouble(true, 20));
		assertEquals(false, main.parrotTrouble(false, 12));
	}
	
	@Test
	public void testMakes10()
	{
		assertEquals(true, main.makes10(9, 10));
		assertEquals(false, main.makes10(9, 9));
		assertEquals(true, main.makes10(1, 9));
		assertEquals(true, main.makes10(10, 1));
		assertEquals(true, main.makes10(10, 10));
		assertEquals(true, main.makes10(8, 2));
		assertEquals(false, main.makes10(8, 3));
		assertEquals(true, main.makes10(10, 42));
		assertEquals(true, main.makes10(12, -2));
	}
	
	@Test
	public void testNearHundred()
	{
		assertEquals(true, main.nearHundred(93));
		assertEquals(true, main.nearHundred(90));
		assertEquals(false, main.nearHundred(89));
		assertEquals(false, main.nearHundred(121));
		assertEquals(false, main.nearHundred(-101));
		assertEquals(false, main.nearHundred(-209));
		assertEquals(true, main.nearHundred(209));
	}
	
	@Test
	public void testPosNeg()
	{
		assertEquals(true, main.posNeg(1, -1, false));
		assertEquals(true, main.posNeg(-1, 1, false));
		assertEquals(true, main.posNeg(-5, -5, true));
		assertEquals(false, main.posNeg(-4, -5, false));
		assertEquals(false, main.posNeg(-5, -6, false));
		assertEquals(false, main.posNeg(1, 1, false));
		assertEquals(false, main.posNeg(1, 1, true));
	}
	
	@Test
	public void testNotString()
	{
		assertEquals(true, main.notString("candy").equals("not candy"));
		assertEquals(true, main.notString("x").equals("not x"));
		assertEquals(true, main.notString("bad").equals("not bad"));
		assertEquals(true, main.notString("not bad").equals("not bad"));
		assertEquals(true, main.notString("no").equals("not no"));
		assertEquals(true, main.notString("not").equals("not"));
		assertEquals(true, main.notString("is not").equals("not is not"));
	}
	
	@Test
	public void testMissingChar()
	{
		assertEquals(true, main.missingChar("kitten", 0).equals("itten"));
		assertEquals(true, main.missingChar("kitten", 1).equals("ktten"));
		assertEquals(true, main.missingChar("kitten", 4).equals("kittn"));
	}
	
	@Test
	public void testFrontBack()
	{
		assertEquals(true, main.frontBack("code").equals("eodc"));
		assertEquals(true, main.frontBack("a").equals("a"));
		assertEquals(true, main.frontBack("ab").equals("ba"));
		assertEquals(true, main.frontBack("").equals(""));
	}
	
	@Test
	public void testFront3()
	{
		assertEquals(true, main.front3("Java").equals("JavJavJav"));
		assertEquals(true, main.front3("Chocolate").equals("ChoChoCho"));
		assertEquals(true, main.front3("abc").equals("abcabcabc"));
		assertEquals(true, main.front3("").equals(""));
		assertEquals(true, main.front3("a").equals("aaa"));
	}
	
	@Test
	public void testBackAround()
	{
		assertEquals(true, main.backAround("cat").equals("tcatt"));
		assertEquals(true, main.backAround("Hello").equals("oHelloo"));
		assertEquals(true, main.backAround("a").equals("aaa"));
	}
	
	@Test
	public void testOr35()
	{
		assertEquals(true, main.or35(3));
		assertEquals(true, main.or35(10));
		assertEquals(false, main.or35(8));
	}
	
	@Test
	public void testFront22()
	{
		assertEquals(true, main.front22("kitten").equals("kikittenki"));
		assertEquals(true, main.front22("Ha").equals("HaHaHa"));
		assertEquals(true, main.front22("abc").equals("ababcab"));
	}
	
	@Test
	public void testStartHi()
	{
		assertEquals(true, main.startHi("hi there"));
		assertEquals(true, main.startHi("hi"));
		assertEquals(false, main.startHi("Hello hi"));
		assertEquals(false, main.startHi("h"));
		assertEquals(false, main.startHi(""));
	}
	
	@Test
	public void testIcyHot()
	{
		assertEquals(true, main.icyHot(120, -1));
		assertEquals(true, main.icyHot(-1, 120));
		assertEquals(false, main.icyHot(2, 120));
		assertEquals(false, main.icyHot(-2, -2));
		assertEquals(false, main.icyHot(120, 120));
	}
}
