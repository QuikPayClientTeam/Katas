package friday;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(
	{
		DayTest.class,
		MonthTest.class,
		DateTest.class,
		MainTest.class
	}
)

public class TestSuite
{

}
