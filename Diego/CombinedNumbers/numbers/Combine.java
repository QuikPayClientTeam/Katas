package numbers;

import java.util.LinkedList;
import java.util.List;

public class Combine
{
	public Combine()
	{
		
	}

	public int getMax(String numbers)
	{
		List<String> numberList = new LinkedList<String>();
		for (String number : numbers.replaceAll("[ \\[\\]]", "").split(","))
		{
			numberList.add(number);
		}

		if (!validate(numberList))
		{
			return -1;
		}

		return Integer.parseInt(combine(numberList));
	}

	public boolean validate(List<String> numbers)
	{
		try
		{
			for (String number : numbers)
			{
				if (number.replaceAll("[0-9]", "").length() > 0)
				{
					return false;
				}
			}
		}
		catch (Exception e)
		{
			return false;
		}

		return true;
	}

	public String combine(List<String> numbers)
	{
		String thing = "";

		while (numbers.size() > 0)
		{
			String max = doStuff(numbers, 0);
			thing = thing + max;
			numbers.remove(max);
		}

		return thing;
	}

	public String doStuff(List<String> numbers, int position)
	{
		if (numbers.size() == 1)
		{
			return numbers.get(0);
		}

		int maxDigit = 0;
		int maxLength = 0;
		List<String> bag = new LinkedList<String>();

		for (String number : numbers)
		{
			maxLength = (number.length() > maxLength ? number.length() : maxLength);
			int digit = Integer.parseInt("" + number.charAt(position % number.length()));
			if (bag.isEmpty())
			{
				bag.add(number);
				maxDigit = digit;
			}
			else
			{
				if (digit > maxDigit)
				{
					maxDigit = digit;
					bag.clear();
					bag.add(number);
				}
				else if (digit == maxDigit)
				{
					bag.add(number);
				}
			}
		}

		if (position + 1 > maxLength)
		{
			return bag.get(0);
		}
		else
		{
			return doStuff(bag, position + 1);
		}
	}
}
