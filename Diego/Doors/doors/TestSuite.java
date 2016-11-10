package doors;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(
	{
		DoorTest.class,
		DiegoTest.class,
		RunTest.class
	}
)

public class TestSuite
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
}
