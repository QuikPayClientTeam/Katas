import static org.junit.Assert.*;

import org.junit.Test;


public class ThirteenthTest {

    @Test
    public void fridayTrueTest() {
        
        int fridayIsBig[] = new int[] {0,0,0,0,1,0,0};
        boolean isBig = Thirteenth.isBig(fridayIsBig);
        assertTrue(isBig);
    }

    @Test
    public void fridayFalseTest() {
        
        int fridayIsNotBig[] = new int[] {0,1,0,0,0,0,0};
        boolean isBig = Thirteenth.isBig(fridayIsNotBig);
        assertFalse(isBig);
    }

}
