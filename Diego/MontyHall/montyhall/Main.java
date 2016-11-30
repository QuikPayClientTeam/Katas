package montyhall;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main
{
	public static boolean play(Game game, int playerDoor, boolean switchDoor)
	{
		List<Integer> availableDoors = new LinkedList<Integer>();
		game.newGame();
		game.chooseDoor(playerDoor);
		Random generator = new Random();
		
		for (int i = 0; i < game.getNumberDoors(); i++)
		{
			if (playerDoor != i)
			{
				availableDoors.add(new Integer(i));
			}
		}

		while (availableDoors.size() > 1)
		{
			int nextRevealed = game.revealGoatDoor();
			availableDoors.remove(new Integer(nextRevealed));
			if (switchDoor)
			{
				int nextDoor = availableDoors.get(new Integer(generator.nextInt(availableDoors.size())));
				availableDoors.remove(new Integer(nextDoor));
				availableDoors.add(new Integer(playerDoor));
				playerDoor = nextDoor;
			}
			game.switchDoor(switchDoor ? playerDoor : -1);
		}
		return game.playerWins();
	}

	public static void main(String[] args)
	{
		for (int j = 0; j < 10; j++)
		{
			int totalDoors = 3;
			int numGames = 1000;
			Random generator = new Random();
			Game game = new Game(totalDoors, false);
			List<Boolean> strategySwitch = new LinkedList<Boolean>();
			List<Boolean> strategyNoSwitch = new LinkedList<Boolean>();
			
			for (int i = 0; i < numGames; i++)
			{
				strategySwitch.add(play(game, generator.nextInt(totalDoors), true));
				strategyNoSwitch.add(play(game, generator.nextInt(totalDoors), false));
			}
			System.out.println("Round " + (j + 1) + ":");
			System.out.print("Results for switching");
			statisticify(strategySwitch);
			System.out.print("Results for not switching");
			statisticify(strategyNoSwitch);
		}
	}
	
	public static void statisticify(List<Boolean> results)
	{
		int totalWon = 0;
		for (Boolean result : results)
		{
			totalWon += result ? 1 : 0;
		}
		System.out.println("Percentage Won: " + ((double)totalWon) / ((double)results.size()));
	}
}
