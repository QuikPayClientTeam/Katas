package main.model;

import java.awt.Color;

public class Cell {

	private Board board;

	private int frequency = 0;

	private int index;
	private int row;
	private int column;

	private boolean empty = true;
	private boolean available = true;

	private Piece blockingPiece;
	private Piece piece;

	public Cell(int index, int row, int column, Board board){
		this.row = row;
		this.column = column;
		this.board = board;
	}

	public void reset(){
		empty = true;
		available = true;
		blockingPiece = null;
	}

	public boolean placePiece(Piece piece){
		if (empty && available){
			setPiece(piece);
			empty = false;
			available = false;
			getBoard().getAvailableCells().remove(this);
			getBoard().getCellsWithPieces().add(this);
			markUnavailableCells();
			frequency++;
			return true;
		}else{
			return false;
		}
	}

	public void removePiece(){
		markAvailableCells(piece);
		setPiece(null);
		empty = true;
		available = true;
		getBoard().getAvailableCells().add(this);
		getBoard().getCellsWithPieces().remove(this);
		frequency--;
	}

	public void markUnavailableCells(){
		getBoard().markUnavailableCells(piece);
	}

	public void markAvailableCells(Piece piece){
		getBoard().markAvailableCells(piece);
	}

	public void changeAvailability(boolean available, Piece blockingPiece){
		if (isAvailable() != available && isEmpty() == !available){
			setAvailable(available);
			if (available){
				getBoard().getAvailableCells().add(this);
				setBlockingPiece(null);
			}else{
				getBoard().getAvailableCells().remove(this);
				setBlockingPiece(blockingPiece);
				blockingPiece.addCellToBlockedCells(this);
			}
		}
	}

	public Color getBackgroundColor() {
		return (row + column) % 2 == 0 ? Color.black : Color.white;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public boolean isEmpty() {
		return empty;
	}
	public boolean isAvailable() {
		return available;
	}

	@Override
	public String toString() {
		return getName();//"Cell " + getName() + " [row=" + row + ", column=" + column + ", empty=" + empty + ", available=" + available + "]";
	}

	public String print(){
		return !isEmpty() ? getPiece().print() : !isAvailable() ? " · " : " - ";
	}

	public String printFrequency(){
		return " " + (getFrequency() < 10 ? " " + getFrequency() : getFrequency()) + " ";
	}

	public Board getBoard() {
		return board;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return String.valueOf((char)(column + 96)) + Math.abs(row - 9);
	}

	public int getFrequency() {
		return frequency;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getBlockingPiece() {
		return blockingPiece;
	}

	public void setBlockingPiece(Piece blockingPiece) {
		this.blockingPiece = blockingPiece;
	}
}
