package romannumerals;

import java.util.HashMap;

public class Numerals
{
	private HashMap<Integer, String> numerals;

	public Numerals()
	{
		initialize();
	}

	public String getNumeralForm(int n)
	{
		String number = "" + n;
		String result = "";

		for (int i = 0; i < number.length(); i++)
		{
			result = result + getNumeral(Integer.parseInt(number.charAt(i) + addZeros(i, number.length())));
		}

		return result;
	}

	private String addZeros(int position, int length)
	{
		String zeros = "";

		for (int i = position; i < length - 1; i++)
		{
			zeros = zeros + "0";
		}

		return zeros;
	}

	public String getNumeral(int n)
	{
		String numeral = numerals.get(new Integer(n));
		if (numeral == null)
		{
			return "";
		}
		else
		{
			return numeral;
		}
	}

	private void initialize()
	{
		numerals = new HashMap<Integer, String>();
		
		numerals.put(new Integer(1), "I");
		numerals.put(new Integer(2), "II");
		numerals.put(new Integer(3), "III");
		numerals.put(new Integer(4), "IV");
		numerals.put(new Integer(5), "V");
		numerals.put(new Integer(6), "VI");
		numerals.put(new Integer(7), "VII");
		numerals.put(new Integer(8), "VIII");
		numerals.put(new Integer(9), "IX");

		numerals.put(new Integer(10), "X");
		numerals.put(new Integer(20), "XX");
		numerals.put(new Integer(30), "XXX");
		numerals.put(new Integer(40), "XL");
		numerals.put(new Integer(50), "L");
		numerals.put(new Integer(60), "LX");
		numerals.put(new Integer(70), "LXX");
		numerals.put(new Integer(80), "LXXX");
		numerals.put(new Integer(90), "XC");

		numerals.put(new Integer(100), "C");
		numerals.put(new Integer(200), "CC");
		numerals.put(new Integer(300), "CCC");
		numerals.put(new Integer(400), "CD");
		numerals.put(new Integer(500), "D");
		numerals.put(new Integer(600), "DC");
		numerals.put(new Integer(700), "DCC");
		numerals.put(new Integer(800), "DCCC");
		numerals.put(new Integer(900), "CM");

		numerals.put(new Integer(1000), "M");
		numerals.put(new Integer(2000), "MM");
		numerals.put(new Integer(3000), "MMM");
		numerals.put(new Integer(4000), "MMMM");
	}
}
