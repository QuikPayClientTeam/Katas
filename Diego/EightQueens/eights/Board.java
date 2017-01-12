package eights;

import java.util.LinkedList;

public class Board
{
	public static final int LENGTH = 8;
	private Position[][] board;
	private LinkedList<Position> queens;

	public Board()
	{
		queens = new LinkedList<Position>();
		board = new Position[LENGTH][LENGTH];
		for (int i = 0; i < LENGTH; i++)
		{
			for (int j = 0; j < LENGTH; j++)
			{
				board[i][j] = new Position(i, j);
			}
		}
	}

	public boolean placeQueen(int x, int y)
	{
		Position position = board[x][y];
		if (position.occupy())
		{
			queens.add(position);
			threatenPositions(position);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public LinkedList<Position> getQueens()
	{
		return queens;
	}

	public LinkedList<Position> getAvailable()
	{
		LinkedList<Position> available = new LinkedList<Position>();
		for (int i = 0; i < LENGTH; i++)
		{
			for (int j = 0; j < LENGTH; j++)
			{
				if (!(board[i][j].checkIsOccupied() || board[i][j].checkIsThreatened()))
				{
					available.add(board[i][j]);
				}
			}
		}
		return available;
	}

	public void threatenPositions(Position queen)
	{
		for (Position position : getAvailable())
		{
			if (position.getX() == queen.getX())
			{
				position.threaten();
			}
			else if (position.getY() == queen.getY())
			{
				position.threaten();
			}
			else if (checkDiagonal(queen, position))
			{
				position.threaten();
			}
		}
	}

	public boolean checkDiagonal(Position queen, Position position)
	{
		for (int i = 1; i < LENGTH; i++)
		{
			if ((queen.getX() + i == position.getX() || queen.getX() - i == position.getX()) 
					&& (queen.getY() + i == position.getY() || queen.getY() - i == position.getY()))
			{
				return true;
			}
		}

		return false;
	}

	public Board copy()
	{
		Board copy = new Board();
		for (Position queen : queens)
		{
			copy.placeQueen(queen.getX(), queen.getY());
		}
		
		return copy;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < LENGTH; i++)
		{
			sb.append("|");
			for (int j = 0; j < LENGTH; j++)
			{
				if (board[j][i].checkIsOccupied())
				{
					sb.append("Q");
				}
				else if (board[j][i].checkIsThreatened())
				{
					sb.append("X");
				}
				else
				{
					sb.append(" ");
				}
				sb.append("|");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
