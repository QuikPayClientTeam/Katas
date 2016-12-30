package warmup2;

public class Warmup
{
	public String stringTimes(String str, int n)
	{
		String s = "";

		for (int i = 0; i < n; i++)
		{
			s = s + str;
		}

		return s;
	}

	public String frontTimes(String str, int n)
	{
		String temp = str.length() > 3 ? str.substring(0, 3) : str;
		String s = "";

		for (int i = 0; i < n; i++)
		{
			s = s + temp;
		}

		return s;
	}

	public int countXX(String str)
	{
		int count = 0;

		if (str.length() >= 2)
		{
			for (int i = 1; i < str.length(); i++)
			{
				if (str.substring(i - 1, i + 1).equals("xx"))
				{
					count++;
				}
			}
		}

		return count;
	}

	public boolean doubleX(String str)
	{
		int i = str.indexOf('x');

		if ((i > -1) && (i < str.length() - 1))
		{
			return str.charAt(i + 1) == 'x';
		}

		return false;
	}

	public String stringBits(String str)
	{
		String s = "";

		for (int i = 0; i < str.length(); i++)
		{
			if (i % 2 == 0)
			{
				s = s + str.charAt(i);
			}
		}

		return s;
	}

	public String stringSplosion(String str)
	{
		String s = "";

		for (int i = 0; i < str.length(); i++)
		{
			s = s + str.substring(0, i + 1);
		}

		return s;
	}

	public int last2(String str)
	{
		int count = 0;

		for (int i = 1; i < str.length() - 1; i++)
		{
			if (str.substring(i - 1, i + 1).equals(str.substring(str.length() - 2)))
			{
				count++;
			}
		}

		return count;
	}

	public int arrayCount9(int[] nums)
	{
		int count = 0;

		for (int i : nums)
		{
			if (i == 9)
			{
				count++;
			}
		}

		return count;
	}

	public boolean arrayFront9(int[] nums)
	{
		for (int i = 0; i < 4 && i < nums.length; i++)
		{
			if (nums[i] == 9)
			{
				return true;
			}
		}

		return false;
	}

	public boolean array123(int[] nums)
	{
		for (int i = 0; i < nums.length - 2; i++)
		{
			if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3)
			{
				return true;
			}
		}

		return false;
	}

	public int stringMatch(String a, String b)
	{
		int count = 0;

		for (int i = 1; i < a.length() && i < b.length(); i++)
		{
			if (a.substring(i - 1, i + 1).equals(b.substring(i - 1, i + 1)))
			{
				count++;
			}
		}

		return count;
	}

	public String stringX(String str)
	{
		String s = "";

		if (str.length() > 0)
		{
			s = s + str.charAt(0);
			for (int i = 1; i < str.length(); i++)
			{
				if (str.charAt(i) != 'x')
				{
					s = s + str.charAt(i);
				}
				else if (i == str.length() - 1)
				{
					s = s + str.charAt(i);
				}
			}
		}

		return s;
	}

	public String altPairs(String str)
	{
		String s = "";

		for (int i = 0; i < str.length(); i++)
		{
			if (i % 4 < 2)
			{
				s = s + str.charAt(i);
			}
		}

		return s;
	}

	public String stringYak(String str)
	{
		String s = "";

		s = str.replaceAll("yak", "");

		return s;
	}

	public int array667(int[] nums)
	{
		int count = 0;

		if (nums.length > 1)
		{
			for (int i = 0; i < nums.length - 1; i++)
			{
				if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i + 1] == 7))
				{
					count++;
				}
			}
		}

		return count;
	}

	public boolean noTriples(int[] nums)
	{
		for (int i = 0; i < nums.length - 2; i++)
		{
			if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2])
			{
				return false;
			}
		}

		return true;
	}

	public boolean has271(int[] nums)
	{
		for (int i = 0; i < nums.length - 2; i++)
		{
			if ((nums[i + 1] == (nums[i] + 5)) && ((nums[i + 2] >= nums[i] - 3) && (nums[i + 2] <= nums[i] + 1)))
			{
				return true;
			}
		}

		return false;
	}
}
