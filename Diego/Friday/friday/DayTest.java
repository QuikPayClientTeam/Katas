package friday;

import static org.junit.Assert.*;
import org.junit.Test;

public class DayTest
{
	@Test
	public void testDay() {
		Day day1 = Day.MONDAY;
		assertNotNull(day1);
		Day day2 = Day.TUESDAY;
		assertNotNull(day2);
		Day day3 = Day.WEDNESDAY;
		assertNotNull(day3);
	}

	@Test
	public void testDayName()
	{
		Day day1 = Day.MONDAY;
		assertEquals("Monday", day1.getName());
		Day day2 = Day.TUESDAY;
		assertEquals("Tuesday", day2.getName());
		Day day3 = Day.WEDNESDAY;
		assertNotEquals("Thursday", day3.getName());
	}
}
