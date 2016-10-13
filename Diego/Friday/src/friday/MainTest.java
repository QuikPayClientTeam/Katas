package friday;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest
{
	@Test
	public void testMain()
	{
		Main main = new Main();
		boolean result = main.FridayThe13th();
		assertEquals(true, result);
	}
}
