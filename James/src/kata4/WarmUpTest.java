package kata4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WarmUpTest {
	
	/*
	 * Column One
	 */


	@Test
	public void SleepIn(){
		//Saturday
		assertTrue(AllThemWarmUps.SleepIn(false, false));
		//Monday
		assertFalse(AllThemWarmUps.SleepIn(true, false));
		//Monday:Vacation
		assertTrue(AllThemWarmUps.SleepIn(true, true));
		//Saturday: Vacation
		assertTrue(AllThemWarmUps.SleepIn(false, true));
		
	}

	@Test
	public void diff21(){
		assertEquals(11, AllThemWarmUps.diff21(10));
		assertEquals(0, AllThemWarmUps.diff21(21));
		assertEquals(80, AllThemWarmUps.diff21(61));
		assertEquals(23, AllThemWarmUps.diff21(-2));
	}
	
	
	@Test
	public void nearHundred(){
		assertTrue(AllThemWarmUps.nearHundred(98));
		assertTrue(AllThemWarmUps.nearHundred(197));
		assertFalse(AllThemWarmUps.nearHundred(34));
		assertFalse(AllThemWarmUps.nearHundred(-225));
	}

	
	@Test
	public void missingChar(){
		assertEquals("ktten",  AllThemWarmUps.missingChar("kitten", 1));
		assertEquals("eritas",  AllThemWarmUps.missingChar("Veritas", 0));
		assertEquals("Tail Win",  AllThemWarmUps.missingChar("Tail Wind", "Tail Win".length()));
	}
	
	@Test
	public void backAround(){
		assertEquals("tcatt", AllThemWarmUps.backAround("cat"));
		assertEquals("xxx", AllThemWarmUps.backAround("x"));
		assertEquals("nWhat the Hell Mann", AllThemWarmUps.backAround("What the Hell Man"));
		assertNotSame("uffu",AllThemWarmUps.backAround("xsf"));
		assertNull(AllThemWarmUps.backAround(null));
	}
	
	@Test
	public void startHi(){
		assertTrue(AllThemWarmUps.startHi("hi"));
		assertTrue(AllThemWarmUps.startHi("HI"));
		assertTrue(AllThemWarmUps.startHi("Hi from the other side"));
		assertFalse(AllThemWarmUps.startHi("Hello from the other side"));
		assertFalse(AllThemWarmUps.startHi("Ho Hi Hi"));
		assertFalse(AllThemWarmUps.startHi("H"));
	}
	
	@Test
	public void hasTeen(){
		assertTrue(AllThemWarmUps.hasTeen(new int[] {0,4,14,9}));
		assertTrue(AllThemWarmUps.hasTeen(new int[] {0,4,14,9,14,90,100,-12}));
		assertFalse(AllThemWarmUps.hasTeen(new int[] {0,4,8}));
		assertFalse(AllThemWarmUps.hasTeen(new int[] {}));
	}
	
	@Test
	public void mixStart(){
		assertTrue(AllThemWarmUps.mixStart("mix"));
		assertTrue(AllThemWarmUps.mixStart("9ixy"));
		assertTrue(AllThemWarmUps.mixStart("mixalot"));
		assertFalse(AllThemWarmUps.mixStart("myxalot"));
		assertFalse(AllThemWarmUps.mixStart("m"));
	}
	
	@Test
	public void close10(){
		assertEquals(0,AllThemWarmUps.close10(8,8));
		assertEquals(9,AllThemWarmUps.close10(9,25));
		assertEquals(9,AllThemWarmUps.close10(25,9));
		assertEquals(-25,AllThemWarmUps.close10(-25,-53));
		assertEquals(10,AllThemWarmUps.close10(10,235));
	}
	
	@Test
	public void stringE(){
		assertTrue(AllThemWarmUps.stringE("Heelo"));
		assertTrue(AllThemWarmUps.stringE("Hello"));
		assertFalse(AllThemWarmUps.stringE("Heeeeeello"));
		assertFalse(AllThemWarmUps.stringE("asfkas"));
	}
	
	@Test
	public void everyNth(){
		assertEquals("Mrce",AllThemWarmUps.everyNth("Miracle", 2));
		assertEquals("Miracle",AllThemWarmUps.everyNth("Miracle", 1));
		assertEquals("WRONG! *sniff*",AllThemWarmUps.everyNth("Miracle", 0));
		assertNotSame("Forge", AllThemWarmUps.everyNth("Forglelelel", 4));
		assertNotSame("Forge", AllThemWarmUps.everyNth("Tiny Hands", -4));
	}
	
	/*
	 * Column Two
	 */
	@Test
	public void monkeyTrouble(){
		assertTrue(AllThemWarmUps.monkeyTrouble(true, true));
		assertTrue(AllThemWarmUps.monkeyTrouble(false, false));
		assertFalse(AllThemWarmUps.monkeyTrouble(false, true));
		assertFalse(AllThemWarmUps.monkeyTrouble(true, false));
		
	}
	
	@Test
	public void parrotTrouble(){
		assertTrue(AllThemWarmUps.parrotTrouble(true, 6));
		assertFalse(AllThemWarmUps.parrotTrouble(true, 7));
		assertTrue(AllThemWarmUps.parrotTrouble(true, 21));
		assertFalse(AllThemWarmUps.parrotTrouble(true, 20));
		assertFalse(AllThemWarmUps.parrotTrouble(false, 21));
		assertFalse(AllThemWarmUps.parrotTrouble(false, 8));
	}
	
	@Test
	public void posNeg(){
		assertTrue(AllThemWarmUps.posNeg(-1, 1, false));
		assertTrue(AllThemWarmUps.posNeg(4, -55, false));
		assertFalse(AllThemWarmUps.posNeg(4, -55, true));
		assertFalse(AllThemWarmUps.posNeg(4, 44, true));
		assertTrue(AllThemWarmUps.posNeg(-85, -75, true));
	}
	
	@Test
	public void frontBack(){
		assertEquals("oellh", AllThemWarmUps.frontBack("hello"));
		assertEquals("", AllThemWarmUps.frontBack(""));
		assertEquals("lupernaturas", AllThemWarmUps.frontBack("supernatural"));
	}
	
	@Test
	public void or35(){
		assertTrue(AllThemWarmUps.or35(35));
		assertTrue(AllThemWarmUps.or35(120));
		assertTrue(AllThemWarmUps.or35(3));
		assertTrue(AllThemWarmUps.or35(5));
		assertFalse(AllThemWarmUps.or35(8));
		assertFalse(AllThemWarmUps.or35(-2));
		assertTrue(AllThemWarmUps.or35(-5));
	}
	
	@Test
	public void icyHot(){
		assertTrue(AllThemWarmUps.icyHot(-2, 104));
		assertTrue(AllThemWarmUps.icyHot(122, -144));
		assertFalse(AllThemWarmUps.icyHot(-122, -144));
		assertFalse(AllThemWarmUps.icyHot(122, 144));
		assertFalse(AllThemWarmUps.icyHot(-7, 35));
		assertFalse(AllThemWarmUps.icyHot(2, 144));
	}
	
	@Test
	public void loneTeen(){
		assertTrue(AllThemWarmUps.loneTeen(13, 4));
		assertTrue(AllThemWarmUps.loneTeen(-4, 18));
		assertTrue(AllThemWarmUps.loneTeen(4, 19));
		assertTrue(AllThemWarmUps.loneTeen(13, 5));
		assertFalse(AllThemWarmUps.loneTeen(15, 19));
		assertFalse(AllThemWarmUps.loneTeen(1, 4));
	}
	
	@Test
	public void startOz(){
		assertEquals("o",AllThemWarmUps.startOz("o"));
		assertEquals("oz",AllThemWarmUps.startOz("ozmysadfsdg"));
		assertEquals("",AllThemWarmUps.startOz("zomysadfsdg"));
		assertEquals("z",AllThemWarmUps.startOz("zzz"));
		assertEquals("",AllThemWarmUps.startOz(""));
	}
	
	@Test 
	public void in3050(){
		assertTrue(AllThemWarmUps.in3050(35, 30));
		assertTrue(AllThemWarmUps.in3050(45, 50));
		assertFalse(AllThemWarmUps.in3050(-45, -50));
		assertFalse(AllThemWarmUps.in3050(45, 35));
	}
	
	@Test 
	public void lastDigit(){
		assertTrue(AllThemWarmUps.lastDigit(113, 3));
		assertTrue(AllThemWarmUps.lastDigit(10, 0));
		assertTrue(AllThemWarmUps.lastDigit(7, 37));
		assertFalse(AllThemWarmUps.lastDigit(7, -37));
		assertFalse(AllThemWarmUps.lastDigit(6, 37));
	}

	/*
	 * Column Three
	 */
	
	@Test
	public void sumDouble(){
		assertEquals(8, AllThemWarmUps.sumDouble(2, 2));
		assertEquals(3, AllThemWarmUps.sumDouble(1, 2));
		assertEquals(0, AllThemWarmUps.sumDouble(4, -4));
		assertEquals(27, AllThemWarmUps.sumDouble(9, 18));
	}
	
	@Test
	public void makes10(){
		assertTrue(AllThemWarmUps.makes10(10, 0));
		assertTrue(AllThemWarmUps.makes10(0, 10));
		assertTrue(AllThemWarmUps.makes10(6, 10));
		assertTrue(AllThemWarmUps.makes10(6, 4));
		assertTrue(AllThemWarmUps.makes10(10, -10));
		assertFalse(AllThemWarmUps.makes10(40, -10));
		assertFalse(AllThemWarmUps.makes10(-10, 6));
		assertFalse(AllThemWarmUps.makes10(3, 5));
	}
	
	@Test
	public void notString(){
		assertEquals("not x", AllThemWarmUps.notString("x"));
		assertEquals("not ", AllThemWarmUps.notString(""));
		assertEquals("not good", AllThemWarmUps.notString("not good"));
		assertEquals("NOT", AllThemWarmUps.notString("NOT"));
		assertEquals("not", AllThemWarmUps.notString("not"));
		assertEquals("not blueberry", AllThemWarmUps.notString("blueberry"));
	}
	
	@Test
	public void front3(){
		assertEquals("", AllThemWarmUps.front3(""));
		assertEquals("aaa", AllThemWarmUps.front3("a"));
		assertEquals("nonono", AllThemWarmUps.front3("no"));
		assertEquals("xyzxyzxyz", AllThemWarmUps.front3("xyz"));
		assertEquals("doudoudou", AllThemWarmUps.front3("double"));
	}
	
	
}
