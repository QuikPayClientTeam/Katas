package minefield;

import java.util.Random;

public class Main
{
	public static String generateField()
	{
		String field = "";
		Random generator = new Random();

		int length = generator.nextInt(10) + 1;
		int width = generator.nextInt(10) + 1;
		field = length + " " + width + "\n";
		;

		for (int row = 0; row < length; row++)
		{
			if (row > 0)
			{
				field = field + "\n";
			}

			for (int col = 0; col < width; col++)
			{
				if (generator.nextDouble() > 0.9)
				{
					field = field + "*";
				}
				else
				{
					field = field + ".";
				}
			}
		}

		return field;
	}

	public static void main(String[] args)
	{
		Minefield thing = new Minefield();
		String field = generateField();
		System.out.println(field);
		System.out.println();
		thing.setField(field);
		System.out.println(thing.getHint());
	}
}
