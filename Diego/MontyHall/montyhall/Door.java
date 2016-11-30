package montyhall;

public class Door
{
	private Prize prize;

	public Door(Prize prize)
	{
		this.prize= prize;
	}

	public Prize openDoor()
	{
		return prize;
	}
}
