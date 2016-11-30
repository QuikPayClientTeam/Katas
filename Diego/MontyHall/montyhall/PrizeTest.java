package montyhall;

import static org.junit.Assert.*;
import org.junit.Test;

public class PrizeTest
{
	@Test
	public void testPrize()
	{
		Prize car = new Car();
		assertEquals("A brand new car!", car.surprise());
		Prize goat = new Goat();
		assertEquals("A slightly used goat!", goat.surprise());
	}
}
