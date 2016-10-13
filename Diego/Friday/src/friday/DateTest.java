package friday;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest
{
	@Test
	public void testDay()
	{
		Date date1 = new Date(1, Month.JANUARY, 1973, Day.MONDAY);
		assertNotNull(date1);
	}

	@Test
	public void testDate()
	{
		Date date1 = new Date(1, Month.JANUARY, 1973, Day.MONDAY);
		assertEquals(1, date1.getDay());
		assertEquals(Month.JANUARY, date1.getMonth());
		assertEquals(1973, date1.getYear());
		assertEquals(Day.MONDAY, date1.getDayOfWeek());

		Date date2 = new Date(14, Month.DECEMBER, 1976, Day.THURSDAY);
		assertNotEquals(1, date2.getDay());
		assertNotEquals(Month.JANUARY, date2.getMonth());
		assertNotEquals(1973, date2.getYear());
		assertNotEquals(Day.MONDAY, date2.getDayOfWeek());
	}

	@Test
	public void testToString()
	{
		Date date1 = new Date(1, Month.JANUARY, 1973, Day.MONDAY);
		assertEquals("Monday January 1, 1973", date1.toString());

		Date day2 = new Date(23, Month.DECEMBER, 1986, Day.THURSDAY);
		assertEquals("Thursday December 23, 1986", day2.toString());
	}

	@Test
	public void testNextDate()
	{
		Date date1 = new Date(1, Month.JANUARY, 1973, Day.MONDAY);
		Date nextDate1 = date1.getNextDate();
		assertEquals("Tuesday January 2, 1973", nextDate1.toString());

		Date date2 = new Date(28, Month.FEBRUARY, 1980, Day.WEDNESDAY);
		Date nextDate2 = date2.getNextDate();
		assertEquals("Thursday February 29, 1980", nextDate2.toString());

		Date date3 = new Date(28, Month.FEBRUARY, 1981, Day.WEDNESDAY);
		Date nextDate3 = date3.getNextDate();
		assertEquals("Thursday March 1, 1981", nextDate3.toString());

		Date date4 = new Date(31, Month.DECEMBER, 1999, Day.SUNDAY);
		Date nextDate4 = date4.getNextDate();
		assertEquals("Monday January 1, 2000", nextDate4.toString());
	}
}
