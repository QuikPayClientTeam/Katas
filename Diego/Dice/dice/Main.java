package dice;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String response = "";
		List<Die> dice = new LinkedList<Die>();
		
		System.out.println("Inputs:");
		System.out.println("\t- add n => Add new die with n sides");
		System.out.println("\t- reset => Clear all dice");
		System.out.println("\t- roll => roll all dice");
		System.out.println("\t- quit => exit");
		System.out.println("");
		
		while (true)
		{
			System.out.println("Enter command: ");
			response = input.nextLine();
			if (response.equals("quit"))
			{
				System.out.println("Good-bye");
				break;
			}
			else if (response.substring(0, 3).equals("add"))
			{
				try
				{
					int sides = Integer.parseInt(response.substring(4, response.length()));
					dice.add(new Die(sides));
					System.out.println("\tAdded new die");
				}
				catch (Exception e)
				{
					System.out.println("Input was invalid");
				}
			}
			else if (response.equals("reset"))
			{
				dice.clear();
				System.out.println("Dice set cleared");
			}
			else if (response.equals("roll"))
			{
				if (!dice.isEmpty())
				{
					String roll = "Roll: ";
					for (Die die : dice)
					{
						roll = roll + die.roll() + ", ";
					}
					System.out.println(roll.substring(0, roll.length() - 2));
				}
				else
				{
					System.out.println("No dice to roll");
				}
			}
			else
			{
				System.out.println("Command not recognized");
			}
		}
	}
}
