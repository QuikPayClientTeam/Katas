package dice;

import java.util.Random;

public class Die
{
	protected Random generator;
	protected int sides;
	
	public Die(int sides)
	{
		this.sides = sides;
		generator = new Random();
	}
	
	public int roll()
	{
		return generator.nextInt(sides)+1;
	}
}
