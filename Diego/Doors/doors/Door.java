package doors;

public class Door
{
	private boolean isOpen;
	
	public Door()
	{
		this.isOpen = false;
	}

	public boolean isOpen()
	{
		return isOpen;
	}
	
	public void toggle()
	{
		isOpen = !isOpen;
	}
	
	public Door copy()
	{
		Door door = new Door();
		if (isOpen)
		{
			door.toggle();
		}
		return door;
	}
}
