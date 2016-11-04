package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.WarmUpOne;

public class WarmUpOneTest {

	@Test
	public void sleepIn() {
		assertEquals(true, WarmUpOne.sleepIn(false, false));
		assertEquals(false, WarmUpOne.sleepIn(true, false));
		assertEquals(true, WarmUpOne.sleepIn(false, true));
	}

	@Test
	public void monkeyTrouble() {
		assertEquals(true, WarmUpOne.monkeyTrouble(true, true));
		assertEquals(true, WarmUpOne.monkeyTrouble(false, false));
		assertEquals(false, WarmUpOne.monkeyTrouble(true, false));
		assertEquals(false, WarmUpOne.monkeyTrouble(false, true));
	}

	@Test
	public void sumDouble() {
		assertEquals(3, WarmUpOne.sumDouble(1, 2));
		assertEquals(5, WarmUpOne.sumDouble(3, 2));
		assertEquals(8, WarmUpOne.sumDouble(2, 2));
	}

	@Test
	public void diff21() {
		assertEquals(2, WarmUpOne.diff21(19));
		assertEquals(11, WarmUpOne.diff21(10));
		assertEquals(0, WarmUpOne.diff21(21));
		assertEquals(18, WarmUpOne.diff21(30));
	}

	@Test
	public void parrotTrouble() {
		assertEquals(true, WarmUpOne.parrotTrouble(true, 6));
		assertEquals(false, WarmUpOne.parrotTrouble(true, 7));
		assertEquals(false, WarmUpOne.parrotTrouble(false, 6));
		assertEquals(false, WarmUpOne.parrotTrouble(false, 21));
		assertEquals(true, WarmUpOne.parrotTrouble(true, 22));
	}

	@Test
	public void makes10() {
		assertEquals(true, WarmUpOne.makes10(9, 10));
		assertEquals(false, WarmUpOne.makes10(9, 9));
		assertEquals(true, WarmUpOne.makes10(1, 9));
	}

	@Test
	public void nearHundred() {
		assertEquals(true, WarmUpOne.nearHundred(93));
		assertEquals(true, WarmUpOne.nearHundred(90));
		assertEquals(false, WarmUpOne.nearHundred(89));
		assertEquals(true, WarmUpOne.nearHundred(190));
	}

	@Test
	public void posNeg() {
		assertEquals(true, WarmUpOne.posNeg(1, -1, false));
		assertEquals(true, WarmUpOne.posNeg(-1, 1, false));
		assertEquals(true, WarmUpOne.posNeg(-4, -5, true));
	}

	@Test
	public void notString() {
		assertEquals("not candy", WarmUpOne.notString("candy"));
		assertEquals("not x", WarmUpOne.notString("x"));
		assertEquals("not bad", WarmUpOne.notString("not bad"));
	}

	@Test
	public void missingChar() {
		assertEquals("ktten", WarmUpOne.missingChar("kitten", 1));
		assertEquals("itten", WarmUpOne.missingChar("kitten", 0));
		assertEquals("kittn", WarmUpOne.missingChar("kitten", 4));
	}

	@Test
	public void frontBack() {
		assertEquals("eodc", WarmUpOne.frontBack("code"));
		assertEquals("a", WarmUpOne.frontBack("a"));
		assertEquals("ba", WarmUpOne.frontBack("ab"));
	}

	@Test
	public void front3() {
		assertEquals("JavJavJav", WarmUpOne.front3("Java"));
		assertEquals("ChoChoCho", WarmUpOne.front3("Chocolate"));
		assertEquals("abcabcabc", WarmUpOne.front3("abc"));
	}

	@Test
	public void backAround() {
		assertEquals("tcatt", WarmUpOne.backAround("cat"));
		assertEquals("oHelloo", WarmUpOne.backAround("Hello"));
		assertEquals("aaa", WarmUpOne.backAround("a"));
	}

	@Test
	public void or35() {
		assertEquals(true, WarmUpOne.or35(3));
		assertEquals(true, WarmUpOne.or35(10));
		assertEquals(false, WarmUpOne.or35(8));
	}

	@Test
	public void front22() {
		assertEquals("kikittenki", WarmUpOne.front22("kitten"));
		assertEquals("HaHaHa", WarmUpOne.front22("Ha"));
		assertEquals("ababcab", WarmUpOne.front22("abc"));
	}

	@Test
	public void startHi() {
		assertEquals(true, WarmUpOne.startHi("hi there"));
		assertEquals(true, WarmUpOne.startHi("hi"));
		assertEquals(false, WarmUpOne.startHi("hello hi"));
	}

	@Test
	public void icyHot() {
		assertEquals(true, WarmUpOne.icyHot(120, -1));
		assertEquals(true, WarmUpOne.icyHot(-1, 120));
		assertEquals(false, WarmUpOne.icyHot(2, 120));
	}

	@Test
	public void in1020() {
		assertEquals(true, WarmUpOne.in1020(12, 99));
		assertEquals(true, WarmUpOne.in1020(21, 12));
		assertEquals(false, WarmUpOne.in1020(8, 99));
	}

	@Test
	public void hasTeen() {
		assertEquals(true, WarmUpOne.hasTeen(13, 20, 10));
		assertEquals(true, WarmUpOne.hasTeen(20, 19, 10));
		assertEquals(true, WarmUpOne.hasTeen(20, 10, 13));
	}

	@Test
	public void loneTeen() {
		assertEquals(true, WarmUpOne.loneTeen(13, 99));
		assertEquals(true, WarmUpOne.loneTeen(21, 19));
		assertEquals(false, WarmUpOne.loneTeen(13, 13));
	}

	@Test
	public void delDel() {
		assertEquals("abc", WarmUpOne.delDel("adelbc"));
		assertEquals("aHello", WarmUpOne.delDel("adelHello"));
		assertEquals("adedbc", WarmUpOne.delDel("adedbc"));
	}

	@Test
	public void mixStart() {
		assertEquals(true, WarmUpOne.mixStart("mix snacks"));
		assertEquals(true, WarmUpOne.mixStart("pix snacks"));
		assertEquals(false, WarmUpOne.mixStart("piz snacks"));
	}

	@Test
	public void startOz() {
		assertEquals("o", WarmUpOne.startOz("o"));
		assertEquals("oz", WarmUpOne.startOz("ozymandias"));
		assertEquals("z", WarmUpOne.startOz("bzoo"));
		assertEquals("o", WarmUpOne.startOz("oxx"));
	}

	@Test
	public void intMax() {
		assertEquals(3, WarmUpOne.intMax(1, 2, 3));
		assertEquals(3, WarmUpOne.intMax(1, 3, 2));
		assertEquals(3, WarmUpOne.intMax(3, 2, 1));
	}

	@Test
	public void close10() {
		assertEquals(8, WarmUpOne.close10(8, 13));
		assertEquals(8, WarmUpOne.close10(13, 8));
		assertEquals(0, WarmUpOne.close10(13, 7));
	}

	@Test
	public void in3050() {
		assertEquals(true, WarmUpOne.in3050(30, 31));
		assertEquals(false, WarmUpOne.in3050(30, 41));
		assertEquals(true, WarmUpOne.in3050(40, 50));
	}

	@Test
	public void max1020() {
		assertEquals(19, WarmUpOne.max1020(11, 19));
		assertEquals(19, WarmUpOne.max1020(19, 11));
		assertEquals(11, WarmUpOne.max1020(11, 9));
		assertEquals(0, WarmUpOne.max1020(21, 9));
	}

	@Test
	public void stringE() {
		assertEquals(true, WarmUpOne.stringE("Hello"));
		assertEquals(true, WarmUpOne.stringE("Heelle"));
		assertEquals(false, WarmUpOne.stringE("Heelele"));
	}

	@Test
	public void lastDigit() {
		assertEquals(true, WarmUpOne.lastDigit(7, 17));
		assertEquals(false, WarmUpOne.lastDigit(6, 17));
		assertEquals(true, WarmUpOne.lastDigit(3, 113));
	}

	@Test
	public void endUp() {
		assertEquals("HeLLO", WarmUpOne.endUp("Hello"));
		assertEquals("hi thERE", WarmUpOne.endUp("hi there"));
		assertEquals("HI", WarmUpOne.endUp("hi"));
	}

	@Test
	public void everyNth() {
		assertEquals("Mrce", WarmUpOne.everyNth("Miracle", 2));
		assertEquals("aceg", WarmUpOne.everyNth("abcdefg", 2));
		assertEquals("adg", WarmUpOne.everyNth("abcdefg", 3));
	}
}
