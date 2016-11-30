package doors;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiegoTest
{
	@Test
	public void testDiego()
	{
		Diego diego1 = new Diego();
		assertNotNull(diego1);
	}

	@Test
	public void testToggleDoor()
	{
		Door door1 = new Door();
		Diego diego1 = new Diego();
		assertEquals(false, door1.isOpen());
		diego1.toggleDoor(door1);
		assertEquals(true, door1.isOpen());
	}
}
