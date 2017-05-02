package kata10;

import java.util.Random;

public class MineSweeper {

	public static void main(String[] args) {
		final int NUMBER_OF_MINES = 4;
		final int BOARD_TALL = 10;
		final int BOARD_WIDE = 10;

		String[][] board = createBoard(BOARD_TALL, BOARD_WIDE);

		for (int k = 0; k < NUMBER_OF_MINES; k++) {
			placeMine(board);
		}

		printBoard(board);

	}

	public static String[][] createBoard(int BOARD_TALL, int BOARD_WIDE) {

		String[][] board = new String[BOARD_TALL][BOARD_WIDE];

		for (int i = 0; i < BOARD_TALL; i++) {
			for (int j = 0; j < BOARD_WIDE; j++) {
				board[i][j] = " ";
			}
		}

		return board;

	}

	public static void printBoard(String[][] board) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static String[][] placeMine(String[][] board) {
		Random random = new Random();
		int i = random.nextInt(10);
		int j = random.nextInt(10);

		while (board[i][j].contains(" ")) {
			board[i][j] = "*";
			addProximity(board, i, j);

		}

		return board;

	}

	public static String[][] addProximity(String[][] board, int i, int j) {

		// add proximity
		if((i > 0 && i < 10) && (i > 0 && j < 10)){
		try {
				
			} catch (IndexOutOfBoundsException e) {
			// swallow excption because
		}
		}


		return board;
	}

}
