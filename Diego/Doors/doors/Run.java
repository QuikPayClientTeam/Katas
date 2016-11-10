package doors;

import java.util.ArrayList;

public class Run
{
	private ArrayList<Door> doors;
	private Diego diego;

	public Run(int totalDoors)
	{
		initialize(totalDoors);
		diego = new Diego();
	}

	public int totalDoors()
	{
		return doors.size();
	}

	private boolean initialize(int totalDoors)
	{
		doors = new ArrayList<Door>(totalDoors);
		for (int i = 0; i < totalDoors; i++)
		{
			doors.add(i, new Door());
		}
		
		return true;
	}

	public ArrayList<Door> pass(int increment)
	{
		ArrayList<Door> copy = new ArrayList<Door>(doors.size());
		for (int i = 0; i < doors.size(); i++)
		{
			if ((i + 1) % increment == 0)
			{
				diego.toggleDoor(doors.get(i));
			}
			copy.add(i, doors.get(i).copy());
		}

		return copy;
	}
}
