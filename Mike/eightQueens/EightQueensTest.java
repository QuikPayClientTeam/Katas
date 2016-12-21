package eightQueens;

import static org.junit.Assert.*;

import org.junit.Test;

public class EightQueensTest {

    @Test
    public void placeQueensTest() {
//        int row = 0;
//        int queen = 1;
//        boolean expected = true;
//        EightQueens.placeQueens(row, queen);
//        assertEquals(expected, expected);
    }

    @Test
    public void isSquareAvailableTest() {
        int row = 0;
        int queen = 1;
        boolean expected = true;
        boolean results = EightQueens.isSquareAvailable(row, queen);
        assertEquals(expected, results);
    }

    @Test
    public void printBoardTest() {
//        fail("Not yet implemented");
    }

}
