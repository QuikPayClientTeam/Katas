package eights;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PositionTest
{
	Position position;

	@Before
	public void setUp() throws Exception
	{
		position = new Position(1, 5);
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testPosition()
	{
		assertNotNull(position);
	}

	@Test
	public void testGetXY()
	{
		assertEquals(5, position.getY());
		assertEquals(1, position.getX());
	}

	@Test
	public void testOccupy()
	{
		assertFalse(position.checkIsOccupied());
		assertTrue(position.occupy());
		assertTrue(position.checkIsOccupied());
	}

	@Test
	public void testThreatened()
	{
		assertFalse(position.checkIsThreatened());
		assertTrue(position.threaten());
		assertTrue(position.checkIsThreatened());
	}
}
