package kata5;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTest {
	
	@Test
	public void TestScores(){
		
		assertEquals(90, Bowling.parseScore("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"));
		assertEquals(300, Bowling.parseScore("X|X|X|X|X|X|X|X|X|X|X|X"));
		assertEquals(150, Bowling.parseScore("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/|5"));
		assertEquals(167, Bowling.parseScore("X|7/|9-|X|-8|8/|-6|X|X|X|81"));
	}

}
