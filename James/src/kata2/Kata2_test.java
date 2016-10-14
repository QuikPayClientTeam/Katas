package kata2;
import org.junit.*;
import static org.junit.Assert.*;


public class Kata2_test {
	
	@Test
    public void isFridayTheMostCommon() {
        
	int[][] testLog = kata2_friday13th.createLogger();
	kata2_friday13th.gatherInfo(testLog);

        boolean expected = false;
        boolean actual = kata2_friday13th.isFridayMost(testLog);
        assertEquals(expected, actual);
    }

}
