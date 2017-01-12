package lcd;

public enum Digit
{
	ONE("   ,  |,  |"),
	TWO(" _ , _|,|_ "),
	THREE(" _ , _|, _|"),
	FOUR("   ,|_|,  |"),
	FIVE(" _ ,|_ , _|"),
	SIX(" _ ,|_ ,|_|"),
	SEVEN(" _ ,  |,  |"),
	EIGHT(" _ ,|_|,|_|"),
	NINE(" _ ,|_|,  |"),
	ZERO(" _ ,| |,|_|");
	
	private String lcd;

	Digit(String lcd)
	{
		this.lcd = lcd;
	}

	@Override
	public String toString()
	{
		return lcd;
	}
}
