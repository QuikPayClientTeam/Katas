package friday;

import static org.junit.Assert.*;
import org.junit.Test;

public class MonthTest
{
	@Test
	public void testMonth()
	{
		Month month1 = Month.MARCH;
		assertNotNull(month1);
		Month month2 = Month.OCTOBER;
		assertNotNull(month2);
	}

	@Test
	public void testMonthName()
	{
		Month month1 = Month.JANUARY;
		assertEquals("January", month1.getName());
		Month month2 = Month.DECEMBER;
		assertEquals("December", month2.getName());
	}

	@Test
	public void testMonthDays()
	{
		Month month1 = Month.MAY;
		assertEquals(31, month1.getMaxDays());
		Month month2 = Month.FEBRUARY;
		assertEquals(28, month2.getMaxDays());
	}
	
	@Test
	public void testMonthNumber()
	{
		Month month1 = Month.MAY;
		assertEquals(5, month1.getNumber());
		Month month2 = Month.FEBRUARY;
		assertEquals(2, month2.getNumber());
	}
}
