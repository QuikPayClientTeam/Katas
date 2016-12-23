package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import main.model.Board;
import main.model.Cell;
import main.model.Queen;

public class EightQueens {

	private static Board board;
	public static final int ROWS = 8;
	public static final int COLUMNS = 8;

	public static final int NUMBER_OF_QUEENS = 8;
	private static HashMap<Integer, ArrayList<Cell>> solutions = new HashMap<Integer, ArrayList<Cell>>();
	private static int solutionIndex = 0;

	public static void init(){
		createBoard(ROWS, COLUMNS);
		createQueens(board, NUMBER_OF_QUEENS);
		solutions = new HashMap<Integer, ArrayList<Cell>>();
		solutionIndex = 0;
	}

	public static void main(String[] args) {
		init();
		findAllSolutions();
	}

	public static void findAllSolutions(){
		boolean solutionFound = false;
		do{
			solutionFound = findSolution(false);
			if (!solutionFound){
				solutions.remove(solutionIndex);
				showStatistics();
			}else{
				System.out.println("Solution #" + (solutionIndex + 1) + ": " + solutions.get(solutionIndex));
				System.out.println(board);
				solutionIndex++;
			}
		}while (solutionFound);
	}

	public static boolean findSolution(boolean randomColumn){
		board.clearBoard();
		resetCellsBlockedByQueens();
		solutions.put(solutionIndex, new ArrayList<Cell>());

		Queen queen = board.getQueens().get(0);
		if (randomColumn){
			queen.setColumn(getRandomColumn());
		}
		return placeQueen(queen);
	}

	private static int getRandomColumn(){
		int min = 1;
		int max = COLUMNS;
		return new Random().nextInt((max - min) + 1) + min;
	}

	private static void showStatistics(){
		System.out.println("There are "  + (solutions.size() == 0 ? "no solutions." : solutions.size() + " solutions."));
		if (solutions.size() > 0){
			System.out.println("Frequency for each cell: \n\n" + board.showFrequency());
		}
	}

	private static boolean placeQueen(Queen queen){
		boolean availableCell = false;

		for (int column = queen.getColumn() - 1; column < COLUMNS; column++){
			Cell cell = board.getCells().get(String.valueOf(queen.getRow()) + String.valueOf(column + 1));
			queen.setColumn(column + 1);
			availableCell = board.placePieceOnCell(cell, queen);
			if (availableCell){
				ArrayList<Cell> cells = solutions.get(solutionIndex);
				cells.add(cell);
				solutions.put(solutionIndex, cells);
				if (cell.getRow() < ROWS || (solutions.get(solutionIndex).size() == NUMBER_OF_QUEENS && checkValidSolution())){
					//queen.setColumn(cell.getColumn());
					if (queen.getRow() < ROWS){
						Queen nextQueen = board.getQueens().get(queen.getRow());
						if (!placeQueen(nextQueen)){
							availableCell = false;
							removePreviousPiece(cell);
							nextQueen.setColumn(1);
						}else{
							break;
						}
					}else{
						break;
					}
				}else{
					availableCell = false;
					removePreviousPiece(cell);
				}
			}
		}

		return availableCell;
	}

	private static void removePreviousPiece(Cell cell){
		ArrayList<Cell> cells = solutions.get(solutionIndex);
		board.removePreviousPiece();
		cells = solutions.get(solutionIndex);
		cells.remove(cell);
		solutions.put(solutionIndex, cells);
	}

	public static boolean checkValidSolution(){
		boolean validSolution = true;
		ArrayList<Cell> currentSolution = solutions.get(solutions.size() - 1);
		for (int solution = solutions.size() - 2; solution >= 0 && validSolution; solution--){
			ArrayList<Cell> previousSolution = solutions.get(solution);
			validSolution = false;
			for (int index = 0; index < currentSolution.size(); index++){
				Cell currentCell = currentSolution.get(index);
				Cell previousCell = previousSolution.get(index);
				if (!currentCell.getName().equals(previousCell.getName())){
					validSolution = true;
					break;
				}
			}
			if (!validSolution){
				break;
			}
		}
		return validSolution;
	}

	public static void createBoard(int rows, int columns){
		board = new Board(rows, columns);
	}

	public static void createQueens(Board board, int numberOfQueens){
		board.getQueens().clear();
		for (int index = 1; index <= numberOfQueens; index++){
			Queen queen = new Queen(index);
			board.getQueens().add(queen);
		}
	}

	public static void resetCellsBlockedByQueens(){
		for (Queen queen : board.getQueens()){
			queen.resetBlockedCells();
		}
	}

	public static Board getBoard() {
		return board;
	}

	public static HashMap<Integer, ArrayList<Cell>> getSolutions() {
		return solutions;
	}


}
