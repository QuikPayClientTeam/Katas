package eights;

public class Position
{
	private final int x;
	private final int y;
	private boolean isOccupied;
	private boolean isThreatened;

	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isOccupied = false;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean occupy()
	{
		if (isOccupied || isThreatened)
		{
			return false;
		}
		else
		{
			isOccupied = true;
			return isOccupied;
		}
	}

	public boolean checkIsOccupied()
	{
		return isOccupied;
	}

	public boolean threaten()
	{
		if (isThreatened || isOccupied)
		{
			return false;
		}
		else
		{
			isThreatened = true;
			return isThreatened;
		}
	}

	public boolean checkIsThreatened()
	{
		return isThreatened;
	}

	public Position copy()
	{
		Position position = new Position(this.x, this.y);
		if (isOccupied)
		{
			position.occupy();
		}
		else if (isThreatened)
		{
			position.threaten();
		}
		return position;
	}
}
