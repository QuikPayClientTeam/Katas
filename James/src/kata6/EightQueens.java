package kata6;

import java.util.Random;

public class EightQueens {

	public static void main(String[] args) {

		final int NUMBER_OF_QUEENS = 8;

		
		int[][] board = createBoard();
		printBoard(board);

		System.out.println("Queen Count: " + queenCount(board));
		
		for (int k = 0; k < NUMBER_OF_QUEENS; k++) {
			placeQueen(board);
		}
		/*
		 * while(queenCount(board) < NUMBER_OF_QUEENS){ placeQueen(board); }
		 * 
		 */
		System.out.println("Populated Board");
		printBoard(board);

		System.out.println("Queen Count: " + queenCount(board));

	}

	public static int[][] createBoard() {
		int[][] board = new int[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = 0;
			}
		}

		return board;

	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public static int[][] placeQueen(int[][] board) {
		Random random = new Random();
		int i = random.nextInt(8);
		int j = random.nextInt(8);

		while (board[i][j] == 0) {
			establishThreat(i, j, board);
			board[i][j] = 2;
		}

		return board;

	}

	public static int[][] establishThreat(int i, int j, int[][] board) {

		// Horizontal threat
		for (int k = 0; k < 8; k++) {
			board[i][k] = 1;
		}
		// Vertical threat
		for (int k = 0; k < 8; k++) {
			board[k][j] = 1;
		}
		// Southeast
		for (int m = j, k = i; m < 8 && k < 8; m++, k++) {
			board[k][m] = 1;
		}
		// Northeast
		for (int m = j, k = i; m < 8 && k >= 0; m++, k--) {
			board[k][m] = 1;
		}
		// Southwest
		for (int m = j, k = i; m >= 0 && k < 8; m--, k++) {
			board[k][m] = 1;
		}
		// Northwest
		for (int m = j, k = i; m >= 0 && k >= 0; m--, k--) {
			board[k][m] = 1;
		}

		return board;

	}

	public static int queenCount(int[][] board) {
		int count = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 2) {
					count++;
				}
			}
		}

		return count;

	}

}
