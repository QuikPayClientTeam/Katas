package doors;

import java.util.ArrayList;

public class Main
{
	public static void main(String[] args)
	{
		Run run = new Run(1000);
		ArrayList<Door> doors = new ArrayList<Door>();
		for (int i = 0; i < run.totalDoors(); i++)
		{
			doors = run.pass(i + 1);
//			for (int j = 0; j < doors.size(); j++)
//			{
//				System.out.print(doors.get(j).isOpen() ? "open " : "closed ");
//			}
//			System.out.println();
		}
//		System.out.println();
		
		ArrayList<String> closed = new ArrayList<String>();
		ArrayList<String> open = new ArrayList<String>();
		for (int i = 0; i < doors.size(); i++)
		{
			if (doors.get(i).isOpen())
			{
				open.add("Door " + (i + 1));
			}
			else
			{
				closed.add("Door " + (i + 1));
			}
		}

		System.out.println("Closed Doors: ");
		for (String door : closed)
		{
			System.out.print(door + "  ");
		}
		System.out.println("\n");
		
		System.out.println("Open Doors: ");
		for (String door : open)
		{
			System.out.print(door + "  ");
		}
	}
}
