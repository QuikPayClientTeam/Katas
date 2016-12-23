package main.model;

import java.util.ArrayList;

public interface Piece {

	public String print();

	public void setRow(int row);

	public void setColumn(int column);

	public int getRow();

	public int getColumn();

	public boolean moveToNextColumn();

	public void addCellToBlockedCells(Cell cell);

	public void removeCellFromBlockedCells(Cell cell);

	public ArrayList<Cell> getBlockedCells();

	public void resetBlockedCells();

}
