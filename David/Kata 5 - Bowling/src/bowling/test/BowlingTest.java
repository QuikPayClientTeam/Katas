package bowling.test;

import static org.junit.Assert.assertEquals;

import java.util.logging.LogManager;

import org.junit.BeforeClass;
import org.junit.Test;

import bowling.model.ScoreLine;

public class BowlingTest {

	@BeforeClass
	public static void setUpBeforeClass(){
		LogManager.getLogManager().reset();
	}

	@Test
	public void score() {
		assertEquals(167, getFinalScore("X|7/|9-|X|-8|8/|-6|X|X|X||81"));
		assertEquals(300, getFinalScore("X|X|X|X|X|X|X|X|X|X||XX||"));
		assertEquals(150, getFinalScore("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"));
		assertEquals(90, getFinalScore("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"));
		assertEquals(12, getFinalScore("--|--|--|--|--|--|--|--|--|X||11"));

		assertEquals(91, getFinalScore("8-|27|43|36|9/|5/|14|35|2/|33|"));
		assertEquals(110, getFinalScore("9-|7/|11|44|1/|4/|8/|7/|44|36|"));
		assertEquals(110, getFinalScore("54|26|5-|62|6/|5/|9/|72|34|9/||3"));

		assertEquals(130, getFinalScore("X|72|9-|9/|61|8-|5/|8/|53|X||83"));

		assertEquals(0, getFinalScore("X|72|9-|9/|61|88|X/|8/|53|X||83"));
		assertEquals(0, getFinalScore("X|//|9-|9/|61|88|X/|8/|53|11||83"));
		assertEquals(0, getFinalScore("X|X|9-|9/|61|8-|1-|8/|53|3/||83"));
		assertEquals(0, getFinalScore("X|72|9-|9/|61|8-|5/|8/|53|11||83"));
		assertEquals(0, getFinalScore("X|72|9-|9/|6|8-|5/|8/|53|X||83"));
		assertEquals(0, getFinalScore("X|72|9-|9/|61|8-|5/|8/|53|X||8/"));

		assertEquals(0, getFinalScore("X|72|9-|9/|61|8-|5/|8/|53|X|X||8/"));
		assertEquals(0, getFinalScore("X|72|9-|9/|61|8-|5/|8/|12|"));
	}

	private int getFinalScore(String scores){
		ScoreLine scoreLine = new ScoreLine();
		scoreLine.setScoreLine(scores);
		return scoreLine.getScore();
	}

}
