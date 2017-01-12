package romannumerals;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import org.junit.Test;

public class NumeralsTest
{
	@Test
	public void testNumeral()
	{
		Numerals numerals = new Numerals();
		assertNotNull(numerals);
	}

	@Test
	public void testGetNumeral()
	{
		Numerals numerals = new Numerals();
		assertEquals("X", numerals.getNumeral(10));
		assertEquals("IX", numerals.getNumeral(9));
		assertEquals("XX", numerals.getNumeral(20));
		assertEquals("C", numerals.getNumeral(100));
		assertEquals("L", numerals.getNumeral(50));
		assertEquals("MM", numerals.getNumeral(2000));
		assertEquals("MMMM", numerals.getNumeral(4000));
	}

	@Test
	public void testAddZeros()
	{
		try
		{
			Numerals numerals = new Numerals();
			Method addZeros = numerals.getClass().getDeclaredMethod("addZeros", Integer.TYPE, Integer.TYPE);
			addZeros.setAccessible(true);
			assertEquals("000", addZeros.invoke(numerals, 0, 4));
			assertEquals("00", addZeros.invoke(numerals, 1, 4));
			assertEquals("0", addZeros.invoke(numerals, 2, 4));
			assertEquals("", addZeros.invoke(numerals, 3, 4));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception Thrown!");
		}
	}

	@Test
	public void testGetNumeralForm()
	{
		Numerals numerals = new Numerals();
		assertEquals("MCMXC", numerals.getNumeralForm(1990));
		assertEquals("MMVIII", numerals.getNumeralForm(2008));
		assertEquals("XCIX", numerals.getNumeralForm(99));
		assertEquals("XLVII", numerals.getNumeralForm(47));
	}
}
