package minefield;

public class Minefield
{
	private int length;
	private int width;
	private char[][] field;

	public Minefield()
	{
		
	}

	public boolean setField(String field)
	{
		try
		{
			String[] lines = field.split("\n");

			String[] dimensions = lines[0].split(" ");
			this.length = Integer.parseInt(dimensions[0]);
			this.width = Integer.parseInt(dimensions[1]);
			this.field = new char[length][width];

			if (dimensions.length > 2 || length + 1 < lines.length)
			{
				throw new Exception("BAD DIMENSIONS");
			}

			for (int i = 0; i < length; i++)
			{
				String line = lines[i + 1];

				if (line.length() > width)
				{
					throw new Exception("BAD DIMENSIONS");
				}

				for (int j = 0; j < width; j++)
				{
					if ("*.".indexOf(line.charAt(j)) < 0)
					{
						throw new Exception("BAD CHARACTERS");
					}
					this.field[i][j] = line.charAt(j);
				}
			}
			return true;
		}
		catch (Exception e)
		{
			this.field = null;
			this.length = 0;
			this.width = 0;
			return false;
		}
	}

	public String getHint()
	{
		String hint = "";

		for (int i = 0; i < length; i++)
		{
			if (i > 0)
			{
				hint = hint + "\n";
			}

			for (int j = 0; j < width; j++)
			{
				if (field[i][j]=='*')
				{
					hint = hint + "*";
				}
				else
				{
					hint = hint + countMines(i, j);
				}
			}
		}

		return hint;
	}

	public int countMines(int row, int col)
	{
		int count = 0;

		for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, length - 1); i++)
		{
			for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, width - 1); j++)
			{
				if (!(i == row && j == col) && field[i][j] == '*')
				{
					count++;
				}
			}
		}

		return count;
	}

	public int getLength()
	{
		return length;
	}

	public int getWidth()
	{
		return width;
	}
}
