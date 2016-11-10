package bowling;

import java.util.Stack;

public class Game
{
	private char[] game;
	private int score;

	public Game(String game)
	{
		this.game = game.replace("||", "|").toCharArray();
		this.score = generate();
	}

	private int generate()
	{
		int totalScore = 0;
		int start = game.length - 1;
		Stack<Character> bonusBalls = new Stack<Character>();

		while (game[start] != '|')
		{
			bonusBalls.push(game[start--]);
		}
		start--;

		for (int i = start; i >= 0; i--)
		{
			char ball = game[i];
			if ("0123456789".contains("" + ball))
			{
				totalScore += ballScore(ball);
				bonusBalls.push(ball);
			}
			else if (ball == 'X')
			{
				char bonus1 = bonusBalls.pop();
				totalScore += 10 + ballScore(bonus1) + ballScore(bonusBalls.pop());
				bonusBalls.push(bonus1);
				bonusBalls.push(ball);
			}
			else if (ball == '/')
			{
				totalScore += 10 + ballScore(bonusBalls.pop());
				char nextBall = game[i - 1];
				bonusBalls.push(((10 - ballScore(nextBall)) + "").charAt(0));
				bonusBalls.push(nextBall);
				i--;
			}
			else if (ball == '-')
			{
				bonusBalls.push(ball);
			}
		}
		return totalScore;
	}

	private int ballScore(char ball)
	{
		if (ball == 'X')
			return 10;
		else if (ball == '-')
			return 0;
		else
			return Integer.parseInt("" + ball);
	}

	public int getScore()
	{
		return score;
	}
}
