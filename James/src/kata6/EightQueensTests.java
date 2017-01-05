package kata6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class EightQueensTests {

	@Test
	public void allQueensOnTheBoard(){
		int[][] board = EightQueens.createBoard();
		
		for (int k = 0; k < 8; k++) {
			EightQueens.placeQueen(board);
		}
		
		assertEquals(8, EightQueens.queenCount(board));
	}
	
	@Test
	public void boardSize(){
		int[][] blankBoard = new int[][]
				{
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0} 
				};
				
		int[][] board = EightQueens.createBoard();
		
		assertSame(blankBoard,board);
	}
	
	@Test
	public void threatEstablished(){
		int[][] threatBoard = new int[][]
				{
					{1, 0, 0, 0, 0, 1, 0, 0},
					{0, 1, 0, 0, 0, 1, 0, 0}, 
					{0, 0, 1, 0, 0, 1, 0, 0}, 
					{0, 0, 0, 1, 0, 1, 0, 1}, 
					{0, 0, 0, 0, 1, 1, 1, 0}, 
					{1, 1, 1, 1, 1, 0, 1, 1}, 
					{0, 0, 0, 0, 1, 1, 1, 0}, 
					{0, 0, 0, 1, 0, 1, 0, 1} 
				};
				
		int[][] board = EightQueens.createBoard();
		EightQueens.establishThreat(5, 5, board);
		
		assertSame(threatBoard,board);
	}
	
}
