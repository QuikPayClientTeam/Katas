package main.model;

import java.util.ArrayList;

import main.EightQueens;

public class Queen implements Piece {

	private int row;
	private int column;

	private ArrayList<Cell> blockedCells = new ArrayList<Cell>();

	public Queen(int row){
		this.row = row;
		this.column = 1;
	}

	@Override
	public int getRow() {
		return row;
	}

	@Override
	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public boolean moveToNextColumn(){
		if (column < EightQueens.COLUMNS){
			column++;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "Queen [row=" + row + ", column=" + column + "]";
	}

	@Override
	public String print() {
		return " X ";
	}

	@Override
	public ArrayList<Cell> getBlockedCells() {
		return blockedCells;
	}

	@Override
	public void addCellToBlockedCells(Cell cell) {
		blockedCells.add(cell);
	}

	@Override
	public void removeCellFromBlockedCells(Cell cell) {
		blockedCells.remove(cell);
	}

	@Override
	public void resetBlockedCells() {
		blockedCells.clear();
	}

}
