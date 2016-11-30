package doors;

import static org.junit.Assert.*;
import org.junit.Test;

public class DoorTest
{
	@Test
	public void testDoor()
	{
		Door door1 = new Door();
		assertNotNull(door1);
		assertEquals(false,door1.isOpen());
	}

	@Test
	public void testToggle()
	{
		Door door1 = new Door();
		assertEquals(false, door1.isOpen());
		door1.toggle();
		assertEquals(true, door1.isOpen());
	}
	
	@Test
	public void testCopy()
	{
		Door door1 = new Door();
		Door copy1 = door1.copy();
		assertEquals(door1.isOpen(), copy1.isOpen());
		assertNotEquals(door1, copy1);
	}
}
