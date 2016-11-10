package friday;

import java.util.HashMap;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Write a program to show that the 13th day of the month
 * falls more often on a Friday than any other day of the
 * week. The 1st of January 1973 was a Monday.
 * You should aim at producing the clearest possible
 * program, not the fastest.
 * 
 * @author dgodinez
 *
 */
public class Main
{
	public static void runTests()
	{
		Result result = JUnitCore.runClasses(TestSuite.class);
		System.out.println("Total tests failed: " + result.getFailureCount());
		for (Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
	}

	public static void main(String[] args)
	{
		//January 1st, 1973 => Monday
		runTests();
//		Main main = new Main();
//		main.FridayThe13th();
	}

	public boolean FridayThe13th()
	{
		HashMap<String, Integer> buckets = new HashMap<String, Integer>();
		Date date = new Date(1, Month.JANUARY, 1973, Day.MONDAY); //1st, January, 1973, Monday
		String day = "";
		int count = 0;

		while (date.getYear() <= 2016)
		{
			if (date.getDay() == 13)
			{
				if (!buckets.keySet().contains(date.getDayOfWeek().getName()))
				{
					buckets.put(date.getDayOfWeek().getName(), new Integer(0));
				}
				buckets.put(date.getDayOfWeek().getName(), buckets.get(date.getDayOfWeek().getName()) + 1);

				if (day.equals(""))
				{
					day = date.getDayOfWeek().getName();
					count = buckets.get(date.getDayOfWeek().getName()).intValue();
				}
				else
				{
					int thisCount = buckets.get(date.getDayOfWeek().getName()).intValue();
					if (thisCount > count)
					{
						count = thisCount;
						day = date.getDayOfWeek().getName();
					}
				}
			}

			date = date.getNextDate();
		}
		System.out.println("Last Day: " + date.toString() + "\n");

		for (String key : buckets.keySet())
		{
			System.out.println(key + ": " + buckets.get(key).toString());
		}

		System.out.println("\n" + day + ": " + count);
		return day == "Friday";
	}
}
