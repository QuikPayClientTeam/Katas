package warmup1;

public class Warmup
{
	public boolean sleepIn(boolean weekday, boolean vacation)
	{
		return !weekday || vacation;
	}
	
	public boolean monkeyTrouble(boolean aSmile, boolean bSmile)
	{
		return !(aSmile^bSmile);
	}
	
	public int sumDouble(int a, int b)
	{
		int sum = a + b;
		return a == b ? sum * 2 : sum;
	}
	
	public int diff21(int n)
	{
		int difference = Math.abs(21 - n);
		return n > 21 ? difference * 2: difference;
	}
	
	public boolean parrotTrouble(boolean talking, int hour)
	{
		return talking && (hour < 7 || hour > 20);
	}
	
	public boolean makes10(int a, int b)
	{
		return (a == 10) || (b == 10) || (a + b == 10);
	}
	
	public boolean nearHundred(int n)
	{
		return (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10);
	}
	
	public boolean posNeg(int a, int b, boolean negative)
	{
		boolean aNeg = a < 0 ? true : false;
		boolean bNeg = b < 0 ? true : false;
		return (!negative && (aNeg^bNeg)) || (negative && aNeg && bNeg);
	}
	
	public String notString(String str)
	{
		if (str.length() < 3 || !str.substring(0, 3).equals("not"))
		{
			str = "not " + str;
		}
		return str;
	}
	public String missingChar(String str, int n)
	{
		return str.substring(0, n) + str.substring(n + 1, str.length());
	}
	
	public String frontBack(String str)
	{
		char[] strChar = str.toCharArray();
		if (str.length() > 0)
		{
			char temp = strChar[0];
			strChar[0] = strChar[strChar.length - 1];
			strChar[strChar.length - 1] = temp;
		}
		return new String(strChar);
	}
	
	public String front3(String str)
	{
		String temp = str.length() < 3 ? str : str.substring(0, 3);
		return temp + temp + temp;
	}
	
	public String backAround(String str)
	{
		char temp = str.charAt(str.length() - 1);
		return temp + str + temp;
	}
	
	public boolean or35(int n)
	{
		return (n % 3 == 0) || (n % 5 == 0);
	}
	
	public String front22(String str)
	{
		String temp = str.length() < 2 ? str : str.substring(0, 2);
		return temp + str + temp;
	}
	
	public boolean startHi(String str)
	{
		return str.length() < 2 ? false : str.substring(0, 2).equals("hi");
	}
	
	public boolean icyHot(int temp1, int temp2)
	{
		return temp1 < 0 ? temp2 > 100 : temp1 > 100 ? temp2 < 0 : false;
	}
}
