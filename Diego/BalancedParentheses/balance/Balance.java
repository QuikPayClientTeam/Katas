package balance;

import java.util.Stack;

public class Balance
{
	private static final String OPEN = "({[";
	private static final String CLOSE = ")}]";

	public Balance()
	{
		
	}

	public boolean isBalanced(String s)
	{
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++)
		{
			char current = s.charAt(i);
			if (OPEN.contains("" + current))
			{
				stack.push(current);
			}
			else if (CLOSE.contains("" + current))
			{
				char last = stack.pop();
				if (OPEN.indexOf(last) != CLOSE.indexOf(current))
				{
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
