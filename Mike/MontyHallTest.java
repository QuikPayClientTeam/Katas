package montyHall;

import static org.junit.Assert.*;

import org.junit.Test;

public class MontyHallTest {

    @Test
    public void testSet() {
        int doors = 3;
        int [] results = MontyHall.setDoors(doors);
        int carSet = 0;
        for (int i=0;i<doors;i++) {
            carSet += results[i];
        }
        assertTrue(carSet == 1);
    }
    
    @Test
    public void testPick() {
        int doors = 3;
        int results = MontyHall.pickDoor(doors);
        assertTrue(results >= 0 && results < doors);
    }
    
    @Test
    public void testReveal() {
        int doors = 3;
        int pick = 1;
        int [] doorSet = {1,0,0};
        int results = MontyHall.revealDoor(doors, pick, doorSet);
        assertTrue(results == 2);
    }
    
    @Test
    public void testSmall() {
        int doors = 3;
        int switches = 100;
        int [] results = MontyHall.theGame(doors, switches);
        assertTrue(results[1] == switches-results[0]);
        assertTrue(results[1]>results[0]);
    }

    @Test
    public void testMinimum() {
        int doors = 3;
        int switches = 1000;
        int [] results = MontyHall.theGame(doors, switches);
        assertTrue(results[1] == switches-results[0]);
        assertTrue(results[1]>results[0]);
    }

    @Test
    public void testBig() {
        int doors = 3;
        int switches = 5000000;
        int [] results = MontyHall.theGame(doors, switches);
        assertTrue(results[1] == switches-results[0]);
        assertTrue(results[1] > results[0]);
    }


}
