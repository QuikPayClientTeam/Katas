package main.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Board {

	private int rows;
	private int columns;

	private HashMap<String, Cell> cells = new HashMap<String, Cell>();
	private ArrayList<Cell> availableCells = new ArrayList<Cell>();
	private ArrayList<Cell> cellsWithPieces = new ArrayList<Cell>();
	private ArrayList<Queen> queens = new ArrayList<Queen>();

	public Board(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		clearBoard();
	}

	public void clearBoard(){
		for (int rowNumber = 1; rowNumber <= rows; rowNumber++){
			for (int columnNumber = 1; columnNumber <= columns; columnNumber++){
				Cell cell = cells.get(String.valueOf(rowNumber) + String.valueOf(columnNumber));
				if (cell == null){
					cell = new Cell((rowNumber - 1) * columns + columnNumber - 1, rowNumber, columnNumber, this);
				}else{
					cell.reset();
				}
				cells.put(String.valueOf(rowNumber) + String.valueOf(columnNumber), cell);
				availableCells.add(cell);
			}
		}
		cellsWithPieces.clear();
	}

	public void markUnavailableCells(Piece piece){
		markCellsInColumn(piece, false);
		markCellsInRow(piece, false);
		markCellsInDiagonal(piece, false);
	}

	public void  markCellsInDiagonal(Piece piece, boolean available){
		int rowIndex = piece.getRow();
		int columnIndex = piece.getColumn();
		for (int index = piece.getRow(); index < rows; index++){
			rowIndex++;
			columnIndex++;
			if (rowIndex <= rows && columnIndex <= columns){
				Cell unavailableCell = cells.get(String.valueOf(rowIndex) + String.valueOf(columnIndex));
				unavailableCell.changeAvailability(available, piece);
			}
		}

		rowIndex = piece.getRow();
		columnIndex = piece.getColumn();
		for (int index = piece.getRow(); index > 0; index--){
			rowIndex--;
			columnIndex--;
			if (rowIndex > 0 && columnIndex > 0){
				Cell unavailableCell = cells.get(String.valueOf(rowIndex) + String.valueOf(columnIndex));
				unavailableCell.changeAvailability(available, piece);
			}
		}

		rowIndex = piece.getRow();
		columnIndex = piece.getColumn();
		for (int index = piece.getRow(); index < rows; index++){
			rowIndex++;
			columnIndex--;
			if (rowIndex <= rows && columnIndex > 0){
				Cell unavailableCell = cells.get(String.valueOf(rowIndex) + String.valueOf(columnIndex));
				unavailableCell.changeAvailability(available, piece);
			}
		}

		rowIndex = piece.getRow();
		columnIndex = piece.getColumn();
		for (int index = piece.getRow(); index > 0; index--){
			rowIndex--;
			columnIndex++;
			if (rowIndex > 0 && columnIndex <= columns){
				Cell unavailableCell = cells.get(String.valueOf(rowIndex) + String.valueOf(columnIndex));
				unavailableCell.changeAvailability(available, piece);
			}
		}
	}

	public void  markCellsInColumn(Piece piece, boolean available){
		for (int rowNumber = 1; rowNumber <= rows; rowNumber++){
			Cell unavailableCell = cells.get(String.valueOf(rowNumber) + piece.getColumn());
			unavailableCell.changeAvailability(available, piece);
		}
	}

	public void  markCellsInRow(Piece piece, boolean available){
		for (int columnNumber = 1; columnNumber <= columns; columnNumber++){
			Cell unavailableCell = cells.get(piece.getRow() + String.valueOf(columnNumber));
			unavailableCell.changeAvailability(available, piece);
		}
	}

	public Cell removePreviousPiece(){
		if (cellsWithPieces.size() > 0){
			Cell availableCell = cellsWithPieces.get(cellsWithPieces.size() - 1);
			availableCell.removePiece();
			return availableCell;
		}else{
			return null;
		}
	}

	public void markAvailableCells(Piece piece){
		ArrayList<Cell> cells = piece.getBlockedCells();
		Iterator<Cell> cellIterator = cells.iterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			availableCells.add(cell);
			cell.setAvailable(true);
			cell.setBlockingPiece(null);
			cellIterator.remove();
			piece.removeCellFromBlockedCells(cell);
		}
	}

	public boolean placePieceOnCell(Cell cell, Piece piece){
		if (cell != null && cell.placePiece(piece)){
			return true;
		}else{
			return false;
		}
	}

	public HashMap<String, Cell> getCells() {
		return cells;
	}

	public ArrayList<Cell> getAvailableCells() {
		return availableCells;
	}

	public ArrayList<Cell> getCellsWithPieces() {
		return cellsWithPieces;
	}

	@Override
	public String toString() {
		String boardString = "";
		for (int rowNumber = 1; rowNumber <= rows; rowNumber++){
			for (int columnNumber = 1; columnNumber <= columns; columnNumber++){
				Cell cell = cells.get(String.valueOf(rowNumber) + String.valueOf(columnNumber));
				boardString += cell.print();
			}
			boardString += "\n";
		}
		return boardString;
	}

	public String showFrequency() {
		String boardString = "";
		for (int rowNumber = 1; rowNumber <= rows; rowNumber++){
			for (int columnNumber = 1; columnNumber <= columns; columnNumber++){
				Cell cell = cells.get(String.valueOf(rowNumber) + String.valueOf(columnNumber));
				boardString += cell.printFrequency();
			}
			boardString += "\n";
		}
		return boardString;
	}

	public ArrayList<Queen> getQueens() {
		return queens;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

}
