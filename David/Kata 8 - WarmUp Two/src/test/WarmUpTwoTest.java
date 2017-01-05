package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.WarmUpTwo;

public class WarmUpTwoTest {

	@Test
	public void stringTimes() {
		assertEquals(WarmUpTwo.stringTimes("Hi", 2), "HiHi");
		assertEquals(WarmUpTwo.stringTimes("Hi", 3), "HiHiHi");
		assertEquals(WarmUpTwo.stringTimes("Hi", 1), "Hi");
		assertEquals(WarmUpTwo.stringTimes("Hi", 0), "");
		assertEquals(WarmUpTwo.stringTimes("Hi", 5), "HiHiHiHiHi");
		assertEquals(WarmUpTwo.stringTimes("Oh Boy!", 2), "Oh Boy!Oh Boy!");
		assertEquals(WarmUpTwo.stringTimes("x", 4), "xxxx");
		assertEquals(WarmUpTwo.stringTimes("", 4), "");
		assertEquals(WarmUpTwo.stringTimes("code", 2), "codecode");
		assertEquals(WarmUpTwo.stringTimes("code", 3), "codecodecode");
	}

	@Test
	public void frontTimes() {
		assertEquals(WarmUpTwo.frontTimes("Chocolate", 2), "ChoCho");
		assertEquals(WarmUpTwo.frontTimes("Chocolate", 3), "ChoChoCho");
		assertEquals(WarmUpTwo.frontTimes("Abc", 3), "AbcAbcAbc");
		assertEquals(WarmUpTwo.frontTimes("Ab", 4), "AbAbAbAb");
		assertEquals(WarmUpTwo.frontTimes("A", 4), "AAAA");
		assertEquals(WarmUpTwo.frontTimes("", 4), "");
		assertEquals(WarmUpTwo.frontTimes("Abc", 0), "");
	}

	@Test
	public void countXX() {
		assertEquals(WarmUpTwo.countXX("abcxx"), 1);
		assertEquals(WarmUpTwo.countXX("xxx"), 2);
		assertEquals(WarmUpTwo.countXX("xxxx"), 3);
		assertEquals(WarmUpTwo.countXX("abc"), 0);
		assertEquals(WarmUpTwo.countXX("Hello there"), 0);
		assertEquals(WarmUpTwo.countXX("Hexxo thxxe"), 2);
		assertEquals(WarmUpTwo.countXX(""), 0);
		assertEquals(WarmUpTwo.countXX("Kittens"), 0);
		assertEquals(WarmUpTwo.countXX("Kittensxxx"), 2);
	}

	@Test
	public void doubleX() {
		assertEquals(WarmUpTwo.doubleX("axxbb"), true);
		assertEquals(WarmUpTwo.doubleX("axaxax"), false);
		assertEquals(WarmUpTwo.doubleX("xxxxx"), true);
		assertEquals(WarmUpTwo.doubleX("xaxxx"), false);
		assertEquals(WarmUpTwo.doubleX("aaaax"), false);
		assertEquals(WarmUpTwo.doubleX(""), false);
		assertEquals(WarmUpTwo.doubleX("abc"), false);
		assertEquals(WarmUpTwo.doubleX("x"), false);
		assertEquals(WarmUpTwo.doubleX("xx"), true);
		assertEquals(WarmUpTwo.doubleX("xax"), false);
		assertEquals(WarmUpTwo.doubleX("xaxx"), false);
	}

	@Test
	public void stringBits() {
		assertEquals(WarmUpTwo.stringBits("Hello"), "Hlo");
		assertEquals(WarmUpTwo.stringBits("Hi"), "H");
		assertEquals(WarmUpTwo.stringBits("Heeololeo"), "Hello");
		assertEquals(WarmUpTwo.stringBits("HiHiHi"), "HHH");
		assertEquals(WarmUpTwo.stringBits(""), "");
		assertEquals(WarmUpTwo.stringBits("Greetings"), "Getns");
		assertEquals(WarmUpTwo.stringBits("Chocoate"), "Coot");
		assertEquals(WarmUpTwo.stringBits("pi"), "p");
		assertEquals(WarmUpTwo.stringBits("Hello Kitten"), "HloKte");
		assertEquals(WarmUpTwo.stringBits("hxaxpxpxy"), "happy");
	}

	@Test
	public void stringSplosion() {
		assertEquals(WarmUpTwo.stringSplosion("Code"), "CCoCodCode");
		assertEquals(WarmUpTwo.stringSplosion("abc"), "aababc");
		assertEquals(WarmUpTwo.stringSplosion("ab"), "aab");
		assertEquals(WarmUpTwo.stringSplosion("x"), "x");
		assertEquals(WarmUpTwo.stringSplosion("fade"), "ffafadfade");
		assertEquals(WarmUpTwo.stringSplosion("There"), "TThTheTherThere");
		assertEquals(WarmUpTwo.stringSplosion("Kitten"), "KKiKitKittKitteKitten");
		assertEquals(WarmUpTwo.stringSplosion("Bye"), "BByBye");
		assertEquals(WarmUpTwo.stringSplosion("Good"), "GGoGooGood");
		assertEquals(WarmUpTwo.stringSplosion("Bad"), "BBaBad");
	}

	@Test
	public void last2() {
		assertEquals(WarmUpTwo.last2("hixxhi"), 1);
		assertEquals(WarmUpTwo.last2("xaxxaxaxx"), 1);
		assertEquals(WarmUpTwo.last2("axxxaaxx"), 2);
		assertEquals(WarmUpTwo.last2("xxaxxaxxaxx"), 3);
		assertEquals(WarmUpTwo.last2("xaxaxaxx"), 0);
		assertEquals(WarmUpTwo.last2("xxxx"), 2);
		assertEquals(WarmUpTwo.last2("13121312"), 1);
		assertEquals(WarmUpTwo.last2("11212"), 1);
		assertEquals(WarmUpTwo.last2("13121311"), 0);
		assertEquals(WarmUpTwo.last2("1717171"), 2);
		assertEquals(WarmUpTwo.last2("hi"), 0);
		assertEquals(WarmUpTwo.last2("h"), 0);
		assertEquals(WarmUpTwo.last2(""), 0);
	}

	@Test
	public void arrayCount9() {
		assertEquals(WarmUpTwo.arrayCount9(new int[]{1, 2, 9}), 1);
		assertEquals(WarmUpTwo.arrayCount9(new int[]{1, 9, 9}), 2);
		assertEquals(WarmUpTwo.arrayCount9(new int[]{1, 9, 9, 3, 9}), 3);
		assertEquals(WarmUpTwo.arrayCount9(new int[]{1, 2, 3}), 0);
		assertEquals(WarmUpTwo.arrayCount9(new int[]{}), 0);
		assertEquals(WarmUpTwo.arrayCount9(new int[]{4, 2, 4, 3, 1}), 0);
		assertEquals(WarmUpTwo.arrayCount9(new int[]{9, 2, 4, 3, 1}), 1);
	}

	@Test
	public void arrayFront9() {
		assertEquals(WarmUpTwo.arrayFront9(new int[]{1, 2, 9, 3, 4}), true);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{1, 2, 3, 4, 9}), false);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{1, 2, 3, 4, 5}), false);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{9, 2, 3}), true);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{1, 9, 9}), true);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{1, 2, 3}), false);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{1, 9}), true);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{5, 5}), false);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{2}), false);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{9}), true);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{}), false);
		assertEquals(WarmUpTwo.arrayFront9(new int[]{3, 9, 2, 3, 3}), true);
	}

	@Test
	public void array123() {
		assertEquals(WarmUpTwo.array123(new int[]{1, 1, 2, 3, 1}), true);
		assertEquals(WarmUpTwo.array123(new int[]{1, 1, 2, 4, 1}), false);
		assertEquals(WarmUpTwo.array123(new int[]{1, 1, 2, 1, 2, 3}), true);
		assertEquals(WarmUpTwo.array123(new int[]{1, 1, 2, 1, 2, 1}), false);
		assertEquals(WarmUpTwo.array123(new int[]{1, 2, 3, 1, 2, 3}), true);
		assertEquals(WarmUpTwo.array123(new int[]{1, 2, 3}), true);
		assertEquals(WarmUpTwo.array123(new int[]{1, 1, 1}), false);
		assertEquals(WarmUpTwo.array123(new int[]{1, 2}), false);
		assertEquals(WarmUpTwo.array123(new int[]{1}), false);
		assertEquals(WarmUpTwo.array123(new int[]{}), false);
	}

	@Test
	public void stringMatch() {
		assertEquals(WarmUpTwo.stringMatch("xxcaazz", "xxbaaz"), 3);
		assertEquals(WarmUpTwo.stringMatch("abc", "abc"), 2);
		assertEquals(WarmUpTwo.stringMatch("abc", "axc"), 0);
		assertEquals(WarmUpTwo.stringMatch("hello", "he"), 1);
		assertEquals(WarmUpTwo.stringMatch("he", "hello"), 1);
		assertEquals(WarmUpTwo.stringMatch("h", "hello"), 0);
		assertEquals(WarmUpTwo.stringMatch("", "hello"), 0);
		assertEquals(WarmUpTwo.stringMatch("aabbccdd", "abbbxxd"), 1);
		assertEquals(WarmUpTwo.stringMatch("aaxxaaxx", "iaxxai"), 3);
		assertEquals(WarmUpTwo.stringMatch("iaxxai", "aaxxaaxx"), 3);
	}

	@Test
	public void stringX() {
		assertEquals(WarmUpTwo.stringX("xxHxix"), "xHix");
		assertEquals(WarmUpTwo.stringX("abxxxcd"), "abcd");
		assertEquals(WarmUpTwo.stringX("xabxxxcdx"), "xabcdx");
		assertEquals(WarmUpTwo.stringX("xKittenx"), "xKittenx");
		assertEquals(WarmUpTwo.stringX("Hello"), "Hello");
		assertEquals(WarmUpTwo.stringX("xx"), "xx");
		assertEquals(WarmUpTwo.stringX("x"), "x");
		assertEquals(WarmUpTwo.stringX(""), "");
	}

	@Test
	public void altPairs() {
		assertEquals(WarmUpTwo.altPairs("kitten"), "kien");
		assertEquals(WarmUpTwo.altPairs("Chocolate"), "Chole");
		assertEquals(WarmUpTwo.altPairs("CodingHorror"), "Congrr");
		assertEquals(WarmUpTwo.altPairs("yak"), "ya");
		assertEquals(WarmUpTwo.altPairs("ya"), "ya");
		assertEquals(WarmUpTwo.altPairs("y"), "y");
		assertEquals(WarmUpTwo.altPairs(""), "");
		assertEquals(WarmUpTwo.altPairs("ThisThatTheOther"), "ThThThth");
	}

	@Test
	public void stringYak() {
		assertEquals(WarmUpTwo.stringYak("yakpak"), "pak");
		assertEquals(WarmUpTwo.stringYak("pakyak"), "pak");
		assertEquals(WarmUpTwo.stringYak("yak123ya"), "123ya");
		assertEquals(WarmUpTwo.stringYak("yak"), "");
		assertEquals(WarmUpTwo.stringYak("yakxxxyak"), "xxx");
		assertEquals(WarmUpTwo.stringYak("HiyakHi"), "HiHi");
		assertEquals(WarmUpTwo.stringYak("xxxyakyyyakzzz"), "xxxyyzzz");
	}

	@Test
	public void array667() {
		assertEquals(WarmUpTwo.array667(new int[]{6, 6, 2}), 1);
		assertEquals(WarmUpTwo.array667(new int[]{6, 6, 2, 6}), 1);
		assertEquals(WarmUpTwo.array667(new int[]{6, 7, 2, 6}), 1);
		assertEquals(WarmUpTwo.array667(new int[]{6, 6, 2, 6, 7}), 2);
		assertEquals(WarmUpTwo.array667(new int[]{1, 6, 3}), 0);
		assertEquals(WarmUpTwo.array667(new int[]{6, 1}), 0);
		assertEquals(WarmUpTwo.array667(new int[]{}), 0);
		assertEquals(WarmUpTwo.array667(new int[]{3, 6, 7, 6}), 1);
		assertEquals(WarmUpTwo.array667(new int[]{3, 6, 6, 7}), 2);
		assertEquals(WarmUpTwo.array667(new int[]{6, 3, 6, 6}), 1);
		assertEquals(WarmUpTwo.array667(new int[]{6, 7, 6, 6}), 2);
		assertEquals(WarmUpTwo.array667(new int[]{1, 2, 3, 5, 6}), 0);
		assertEquals(WarmUpTwo.array667(new int[]{1, 2, 3, 6, 6}), 1);
	}

	@Test
	public void noTriples() {
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 1, 2, 2, 1}), true);
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 1, 2, 2, 2, 1}), false);
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 1, 1, 2, 2, 2, 1}), false);
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 1, 2, 2, 1, 2, 1}), true);
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 2, 1}), true);
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 1, 1}), false);
		assertEquals(WarmUpTwo.noTriples(new int[]{1, 1}), true);
		assertEquals(WarmUpTwo.noTriples(new int[]{1}), true);
		assertEquals(WarmUpTwo.noTriples(new int[]{}), true);
	}

	@Test
	public void has271() {
		assertEquals(WarmUpTwo.has271(new int[]{1, 2, 7, 1}), true);
		assertEquals(WarmUpTwo.has271(new int[]{1, 2, 8, 1}), false);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, 1}), true);
		assertEquals(WarmUpTwo.has271(new int[]{3, 8, 2}), true);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, 3}), true);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, 4}), false);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, -1}), true);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, -2}), false);
		assertEquals(WarmUpTwo.has271(new int[]{4, 5, 3, 8, 0}), true);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, 5, 10, 4}), true);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, -2, 4, 9, 3}), true);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, 5, 10, 1}), false);
		assertEquals(WarmUpTwo.has271(new int[]{2, 7, -2, 4, 10, 2}), false);
	}

}
