package eights;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest
{
	private Board board;
	@Before
	public void setUp() throws Exception
	{
		board = new Board();
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testBoard()
	{
		assertNotNull(board);
	}

	@Test
	public void testCheckDiagonal()
	{
		assertTrue(board.checkDiagonal(new Position(3, 3), new Position(0, 0)));
		assertTrue(board.checkDiagonal(new Position(3, 3), new Position(6, 6)));
		assertTrue(board.checkDiagonal(new Position(3, 3), new Position(0, 6)));
		assertTrue(board.checkDiagonal(new Position(3, 3), new Position(6, 0)));
		assertTrue(board.checkDiagonal(new Position(0, 0), new Position(2, 2)));
		assertTrue(board.checkDiagonal(new Position(0, 0), new Position(6, 6)));
		assertTrue(board.checkDiagonal(new Position(1, 5), new Position(2, 6)));
		assertTrue(board.checkDiagonal(new Position(5, 4), new Position(2, 7)));
	}

	@Test
	public void testToString()
	{
		System.out.println(board.toString());
		board.placeQueen(3, 4);
		System.out.println(board.toString());
		board.placeQueen(0, 0);
		System.out.println(board.toString());
		board.placeQueen(7, 3);
		System.out.println(board.toString());
	}
}
