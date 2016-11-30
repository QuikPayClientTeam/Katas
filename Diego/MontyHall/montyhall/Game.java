package montyhall;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
	private boolean log;
	private Door[] doors;
	private int prizeIndex;
	private int playerIndex;
	private int revealedIndex;
	private ArrayList<Integer> goatDoors;
	private Random generator;
	private int totalDoors;

	public Game(int totalDoors, boolean log)
	{
		this.totalDoors = totalDoors;
		doors = new Door[totalDoors];
		generator = new Random();
		this.log = log;
	}

	public void newGame()
	{
		if (log)
			System.out.println("Starting new game");
		this.prizeIndex = generator.nextInt(totalDoors);
		this.goatDoors = new ArrayList<Integer>(2);
		for (int i = 0; i < doors.length; i++)
		{
			if (i == this.prizeIndex)
			{
				doors[i] = new Door(new Car());
			}
			else
			{
				doors[i] = new Door(new Goat());
				goatDoors.add(i);
			}
		}
	}

	public String reveal(int index)
	{
		if (log)
			System.out.println("Revealing door " + (index + 1));
		return doors[index].openDoor().surprise();
	}

	public void chooseDoor(int index)
	{
		this.playerIndex = index;
		if (log)
			System.out.println("Player chooses door " + (playerIndex + 1));
	}

	public boolean playerWins()
	{
		boolean playerWon = prizeIndex == playerIndex;
		if (log)
		{
			System.out.println("Time to open player's door");
			System.out.println(reveal(playerIndex));
			if (playerWon)
			{
				System.out.println("Player won!");
			}
			else
			{
				System.out.println("Player lost!");
			}
		}
		return playerWon;
	}

	public void switchDoor(int newIndex)
	{
		if (newIndex >= 0 && newIndex != playerIndex && newIndex != revealedIndex)
		{
			playerIndex = newIndex;
			if (log)
				System.out.println("Player switches to door " + (playerIndex + 1));
		}
		else
		{
			if (log)
				System.out.println("Player sticks with door " + (playerIndex + 1));
		}
	}

	public int revealGoatDoor()
	{
		if (goatDoors.contains(playerIndex))
		{
			for (Integer i : goatDoors)
			{
				if (i.intValue() != playerIndex)
				{
					revealedIndex = i.intValue();
					goatDoors.remove(i);
					break;
				}
			}
		}
		else
		{
			int temp = generator.nextInt(goatDoors.size());
			revealedIndex = goatDoors.get(temp).intValue();
			goatDoors.remove(temp);
		}
		if (log)
		{
			System.out.println("Revealing a goat door\n" + reveal(revealedIndex));
		}
		return revealedIndex;
	}
	
	public int getNumberDoors()
	{
		return totalDoors;
	}
}
