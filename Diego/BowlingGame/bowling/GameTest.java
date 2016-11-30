package bowling;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import org.junit.Test;

public class GameTest
{
	/*
	Games:
	X|X|X|X|X|X|X|X|X|X||XX -> 300
	9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||	-> 90
	5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5 -> 150
	X|7/|9-|X|-8|8/|-6|X|X|X||81 -> 167
	*/
	@Test
	public void testGame()
	{
		Game game = new Game("X|7/|9-|X|-8|8/|-6|X|X|X||81");
		assertNotNull(game);
	}

	@Test
	public void testGenerate()
	{
		try
		{
			Game game = new Game("X|X|X|X|X|X|X|X|X|X||XX");
			Method gen = game.getClass().getDeclaredMethod("generate");
			gen.setAccessible(true);
			assertEquals(300, gen.invoke(game));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	public void testBallScore()
	{
		try
		{
			Game game = new Game("X|X|X|X|X|X|X|X|X|X||XX");
			Method score = game.getClass().getDeclaredMethod("ballScore", Character.TYPE);
			score.setAccessible(true);
			assertEquals(10, score.invoke(game, 'X'));
			assertEquals(1, score.invoke(game, '1'));
			assertEquals(4, score.invoke(game, '4'));
			assertEquals(8, score.invoke(game, '8'));
			assertEquals(0, score.invoke(game, '-'));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception thrown");
		}
	}

	@Test
	public void testGetScore()
	{
		Game game = new Game("X|X|X|X|X|X|X|X|X|X||XX");
		assertEquals(300, game.getScore());
		
		game = new Game("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||");
		assertEquals(90, game.getScore());
		
		game = new Game("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
		assertEquals(150, game.getScore());
		
		game = new Game("X|7/|9-|X|-8|8/|-6|X|X|X||81");
		assertEquals(167, game.getScore());
		
		game = new Game("X|X|X|X|X|X|X|X|X|9/||X");
		assertEquals(279, game.getScore());
		
		game = new Game("9|3/|61|3/|81|5/|0/|8-|7/|8/||8");
		assertEquals(131, game.getScore());
	}
}
