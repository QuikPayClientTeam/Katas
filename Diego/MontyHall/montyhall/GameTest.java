package montyhall;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;

public class GameTest
{
	Game game;
	int totalDoors;

	@Before
	public void setUp()
	{
		totalDoors = 3;
		game = new Game(totalDoors, true);
	}

	@Test
	public void testGame()
	{
		assertNotNull(game);
	}

	@Test
	public void testNewGame()
	{
		try
		{
			for (int i = 0; i < 3; i++)
			{
				game.newGame();
				Field prizeIndex = game.getClass().getDeclaredField("prizeIndex");
				prizeIndex.setAccessible(true);
				assertTrue(i == prizeIndex.getInt(game) ? 
						game.reveal(prizeIndex.getInt(game)).equals((new Car()).surprise()) : 
						game.reveal(i).equals((new Goat()).surprise()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception Thrown!");
		}
		
	}
	
	@Test
	public void testChooseDoor()
	{
		try
		{
			for (int i = 0; i < totalDoors; i++)
			{
				game.newGame();
				game.chooseDoor(i);
				Field playerIndex = game.getClass().getDeclaredField("playerIndex");
				playerIndex.setAccessible(true);
				assertEquals(i, playerIndex.getInt(game));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception Thrown!");
		}
	}

	@Test
	public void testRevealGoatDoor()
	{
		try
		{
			Field prizeIndex = game.getClass().getDeclaredField("prizeIndex");
			prizeIndex.setAccessible(true);
			Field playerIndex = game.getClass().getDeclaredField("playerIndex");
			playerIndex.setAccessible(true);
			Field revealedIndex = game.getClass().getDeclaredField("revealedIndex");
			revealedIndex.setAccessible(true);

			game.newGame();
			int prize = prizeIndex.getInt(game);
			game.chooseDoor(prize);
			int door = game.revealGoatDoor();
			assertTrue(revealedIndex.getInt(game) != prizeIndex.getInt(game) && revealedIndex.getInt(game) != playerIndex.getInt(game));
			assertTrue(revealedIndex.getInt(game) == door);
			assertTrue(game.reveal(door).equals((new Goat()).surprise()));

			game.newGame();
			prize = prizeIndex.getInt(game);
			int i = 0;
			while (i == prize) { i++; }
			game.chooseDoor(i);
			door = game.revealGoatDoor();
			assertTrue(revealedIndex.getInt(game) != prizeIndex.getInt(game) && revealedIndex.getInt(game) != playerIndex.getInt(game));
			assertTrue(revealedIndex.getInt(game) == door);
			assertTrue(game.reveal(door).equals((new Goat()).surprise()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception Thrown!");
		}
	}

	@Test
	public void testSwitchDoor()
	{
		try
		{
			Field playerIndex = game.getClass().getDeclaredField("playerIndex");
			playerIndex.setAccessible(true);
			Field revealedIndex = game.getClass().getDeclaredField("revealedIndex");
			revealedIndex.setAccessible(true);
			Field prizeIndex = game.getClass().getDeclaredField("prizeIndex");
			prizeIndex.setAccessible(true);
			
			game.newGame();
			game.chooseDoor(0);
			game.revealGoatDoor();
			game.switchDoor(revealedIndex.getInt(game) == 1 ? 2 : 1);
			assertTrue(playerIndex.getInt(game) != 0);
			assertTrue(playerIndex.getInt(game) != revealedIndex.getInt(game));
			
			game.newGame();
			game.chooseDoor(1);
			game.revealGoatDoor();
			game.switchDoor(revealedIndex.getInt(game) == 2 ? 0 : 2);
			assertTrue(playerIndex.getInt(game) != 1);
			assertTrue(playerIndex.getInt(game) != revealedIndex.getInt(game));
			
			game.newGame();
			game.chooseDoor(2);
			game.revealGoatDoor();
			game.switchDoor(revealedIndex.getInt(game) == 0 ? 1 : 0);
			assertTrue(playerIndex.getInt(game) != 2);
			assertTrue(playerIndex.getInt(game) != revealedIndex.getInt(game));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception Thrown!");
		}
	}

	@Test
	public void testPlayerWins()
	{
		try
		{
			Field prizeIndex = game.getClass().getDeclaredField("prizeIndex");
			prizeIndex.setAccessible(true);
			Field playerIndex = game.getClass().getDeclaredField("playerIndex");
			playerIndex.setAccessible(true);
			Field revealedIndex = game.getClass().getDeclaredField("revealedIndex");
			revealedIndex.setAccessible(true);
			int sum = 0;
			
			game.newGame();
			game.chooseDoor(prizeIndex.getInt(game));
			game.revealGoatDoor();
			sum = prizeIndex.getInt(game) + revealedIndex.getInt(game);
			game.switchDoor(sum == 1 ? 2 : sum == 2 ? 1 : 0);
			assertFalse(game.playerWins());
			
			game.newGame();
			game.chooseDoor(prizeIndex.getInt(game));
			game.revealGoatDoor();
			game.switchDoor(-1);
			assertTrue(game.playerWins());
			
			game.newGame();
			game.chooseDoor(prizeIndex.getInt(game) == 0 ? 2 : 0);
			game.revealGoatDoor();
			game.switchDoor(-1);
			assertFalse(game.playerWins());
			
			game.newGame();
			game.chooseDoor(prizeIndex.getInt(game) == 2 ? 1 : 2);
			game.revealGoatDoor();
			game.switchDoor(prizeIndex.getInt(game));
			assertTrue(game.playerWins());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail("Exception Thrown!");
		}
	}
}
