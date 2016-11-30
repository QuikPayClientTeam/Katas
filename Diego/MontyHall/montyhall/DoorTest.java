package montyhall;

import static org.junit.Assert.*;
import org.junit.Test;

public class DoorTest
{
	@Test
	public void testDoor()
	{
		Door door1 = new Door(new Goat());
		assertNotNull(door1);
		assertEquals("A slightly used goat!", door1.openDoor().surprise());
		
		Door door2 = new Door(new Car());
		assertNotNull(door2);
		assertEquals("A brand new car!", door2.openDoor().surprise());
	}
}
