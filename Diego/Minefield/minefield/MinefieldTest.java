package minefield;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinefieldTest
{
	Minefield field;

	@Before
	public void setUp() throws Exception
	{
		field = new Minefield();	
	}

	@After
	public void tearDown() throws Exception
	{
	
	}

	@Test
	public void testMinefield()
	{
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
	}

	@Test
	public void testSetField()
	{
		assertTrue(field.setField("3 4\n*...\n..*.\n...."));
		assertEquals(3, field.getLength());
		assertEquals(4, field.getWidth());
		assertTrue(field.setField("4 4\n*...\n..*.\n....\n..*."));
		assertEquals(4, field.getLength());
		assertEquals(4, field.getWidth());
		assertFalse(field.setField("5 5\n*....\n...*.\n....."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("2 4\n*...\n..*.\n...."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("4 4\n*...\n..*.\n...."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("4 2\n*..\n*.\n..\n.."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("4 3\n*.\n*.\n..\n.."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("4\n*...\n..*.\n...."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("5 4 4\n*...\n..*.\n...."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
		assertFalse(field.setField("3 4 \n*...\n.+*.\n..@."));
		assertEquals(0, field.getLength());
		assertEquals(0, field.getWidth());
	}

	@Test
	public void testGetHint()
	{
		field.setField("3 4\n*...\n..*.\n....");
		assertEquals("*211\n12*1\n0111", field.getHint());
	}

	@Test
	public void testCountMines()
	{
		field.setField("3 4\n*...\n..*.\n....");
		assertEquals(2, field.countMines(1, 1));
		assertEquals(0, field.countMines(0, 0));
		assertEquals(0, field.countMines(2, 0));
		assertEquals(2, field.countMines(0, 1));
		assertEquals(1, field.countMines(2, 3));
	}
}
