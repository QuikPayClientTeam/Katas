package friday;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
