package kata7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Warmup2tests {
	
	@Test
	public void stringTimes(){
		assertEquals("", Warmup2.stringTimes("", 1));
		assertEquals("", Warmup2.stringTimes("", 5));
		assertEquals("Hi", Warmup2.stringTimes("Hi", 1));
		assertEquals("", Warmup2.stringTimes("Hi", 0));
		assertEquals("xxxx", Warmup2.stringTimes("x", 4));
	}
	
	@Test
	public void frontTimes(){
		assertEquals("", Warmup2.frontTimes("", 4));
		assertEquals("aaa", Warmup2.frontTimes("a", 3));
		assertEquals("abcabc", Warmup2.frontTimes("abc", 2));
		assertEquals("firfirfir", Warmup2.frontTimes("fire", 3));
	}
	
	@Test
	public void countXX(){
		assertEquals(1, Warmup2.countXX("abcxx"));
		assertEquals(3, Warmup2.countXX("xxxx"));
		assertEquals(0, Warmup2.countXX("xasx"));
		assertEquals(0, Warmup2.countXX("fasa"));
	}
	
	@Test
	public void doubleX(){
		assertTrue(Warmup2.doubleX("axxbb"));
		assertFalse(Warmup2.doubleX("abc"));
		assertFalse(Warmup2.doubleX(""));
		assertFalse(Warmup2.doubleX("axaxax"));
		assertFalse(Warmup2.doubleX("aaaax"));
	}
	
	@Test
	public void last2(){
		assertEquals(1, Warmup2.last2("hixxhi"));
		assertEquals(1, Warmup2.last2("aaacccffffhfffiihixxhi"));
		assertEquals(0, Warmup2.last2(""));
		assertEquals(0, Warmup2.last2("aa"));
		assertEquals(0, Warmup2.last2("a"));
		assertEquals(2, Warmup2.last2("xxaabbxxffccaaxx"));
	}

}
