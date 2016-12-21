package eights;

import java.util.LinkedList;

public class Main
{
	public static Board place(Board board)
	{
		LinkedList<Position> available = board.getAvailable();
		if (available.isEmpty() && board.getQueens().size() < 8)
		{
			return null;
		}
		else if (board.getQueens().size() == 8)
		{
			return board;
		}
		else
		{
			for (Position position : available)
			{
				Board temp = board.copy();
				temp.placeQueen(position.getX(), position.getY());
				Board solution = place(temp);
				if (solution != null)
				{
					return solution;
				}
			}
			return null;
		}
	}

	public static void main(String[] args)
	{
		int count = 0;
		for (int i = 0; i < Board.LENGTH; i++)
		{
			for (int j = 0; j < Board.LENGTH; j++)
			{
				Board board = new Board();
				board.placeQueen(i, j);
				Board solution = place(board);
				System.out.println("#" + ++count + ":\n" + solution.toString() + "\n");
			}
		}
	}
}
