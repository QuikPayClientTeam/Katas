package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.EightQueens;
import main.model.Cell;
import main.model.Queen;

public class EightQueensTest {

	@Before
	public void setUp() throws Exception {
		EightQueens.init();
	}

	@Test
	public void assertWeHaveCorrectNumberOfQueensOnTheBoard() {
		EightQueens.findSolution(true);
		ArrayList<Cell> solution = EightQueens.getSolutions().get(0);
		assertEquals(EightQueens.NUMBER_OF_QUEENS, solution.size());
	}

	@Test
	public void checkForThreats() {
		Queen queen = EightQueens.getBoard().getQueens().get(0);

		Cell cell = EightQueens.getBoard().getCells().get("11");
		EightQueens.getBoard().placePieceOnCell(cell, queen);

		Cell threatenedCell = EightQueens.getBoard().getCells().get("12");
		assertEquals(threatenedCell.getBlockingPiece(), queen);

		threatenedCell = EightQueens.getBoard().getCells().get("13");
		assertEquals(threatenedCell.getBlockingPiece(), queen);

		threatenedCell = EightQueens.getBoard().getCells().get("18");
		assertEquals(threatenedCell.getBlockingPiece(), queen);

		threatenedCell = EightQueens.getBoard().getCells().get("21");
		assertEquals(threatenedCell.getBlockingPiece(), queen);

		threatenedCell = EightQueens.getBoard().getCells().get("81");
		assertEquals(threatenedCell.getBlockingPiece(), queen);
	}

	@Test
	public void checkForAvailableCellsAfterRemovingPiece() {
		Queen queen = EightQueens.getBoard().getQueens().get(0);

		Cell cell = EightQueens.getBoard().getCells().get("11");
		EightQueens.getBoard().placePieceOnCell(cell, queen);
		EightQueens.getBoard().removePreviousPiece();

		Cell availableCell = EightQueens.getBoard().getCells().get("12");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("13");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("18");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("21");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("81");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);
	}

	@Test
	public void checkForAvailableCells() {
		Queen queen = EightQueens.getBoard().getQueens().get(0);

		Cell cell = EightQueens.getBoard().getCells().get("11");
		EightQueens.getBoard().placePieceOnCell(cell, queen);

		Cell availableCell = EightQueens.getBoard().getCells().get("23");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("82");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("75");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);

		availableCell = EightQueens.getBoard().getCells().get("64");
		assertEquals(availableCell.isAvailable(), true);
		assertEquals(availableCell.getBlockingPiece(), null);
	}

	@Test
	public void checkCorrectBoardSize(){
		assertEquals(EightQueens.getBoard().getRows(), EightQueens.ROWS);
		assertEquals(EightQueens.getBoard().getColumns(), EightQueens.COLUMNS);
	}

}
