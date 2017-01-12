package lcd;

import java.util.HashMap;

public class LCD
{
	public HashMap<Integer, Digit> lcd;
	
	public LCD()
	{
		initialize();
	}

	public String getDigitalForm(int n)
	{
		StringBuilder sb = new StringBuilder();
		String number = "" + n;

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < number.length(); j++)
			{
				sb.append(lcd.get(Integer.parseInt("" + number.charAt(j))).toString().split(",")[i]);
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	private void initialize()
	{
		lcd = new HashMap<Integer, Digit>();

		lcd.put(new Integer(1), Digit.ONE);
		lcd.put(new Integer(2), Digit.TWO);
		lcd.put(new Integer(3), Digit.THREE);
		lcd.put(new Integer(4), Digit.FOUR);
		lcd.put(new Integer(5), Digit.FIVE);
		lcd.put(new Integer(6), Digit.SIX);
		lcd.put(new Integer(7), Digit.SEVEN);
		lcd.put(new Integer(8), Digit.EIGHT);
		lcd.put(new Integer(9), Digit.NINE);
		lcd.put(new Integer(0), Digit.ZERO);
	}
	
}
