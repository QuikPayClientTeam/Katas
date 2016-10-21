package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Door;
import main.HundredDoors;

public class HundredDoorsTest {

	private final int HUNDRED = 100;

	@Before
	public void setUp() {
		HundredDoors.init();
	}

	@Test
	public void assertThereAreAHundredDoors(){
		assertEquals("There should be " + HUNDRED + " doors", HUNDRED, HundredDoors.doors.size());
	}

	@Test
	public void assertAllDoorsAreInitiallyClosed(){
		for (Door door : HundredDoors.doors){
			assertEquals("Door # " + door.getIndex() + " should be closed", true, door.isClosed());
		}
	}

	@Test
	public void assertAllDoorsCanBeToggled(){
		for (Door door: HundredDoors.doors){
			boolean closed = door.isClosed();
			door.toggleDoor();
			assertNotEquals("Door #" + door.getIndex() + " is broken (does not " + (door.isClosed() ? "open" : "close") + ")", closed, door.isClosed());
			door.toggleDoor();
			assertEquals("Door #" + door.getIndex() + " is broken (does not " + (door.isClosed() ? "open" : "close") + ")", closed, door.isClosed());
		}
	}

	@Test
	public void assertDoorsAreToggledTheRightNumberOfTimes(){
		for (int interval = 1; interval <= HundredDoors.NUMBER_OF_DOORS; interval++){
			for (int index = interval - 1; index < HundredDoors.NUMBER_OF_DOORS; index += interval){
				int doorNumber = index + 1;
				boolean shouldBeToggled = (doorNumber % interval == 0);
				assertEquals("Door #" + doorNumber + " shouldn't be toggled on interval " + interval, shouldBeToggled, true);
			}
		}
	}

	@Test
	public void assertFinalResultIsCorrect(){
		ArrayList<Door> doors = new ArrayList<Door>();
		for (int index = 1; index <= HundredDoors.NUMBER_OF_DOORS; index++){
			doors.add(new Door(index));
		}
		for (Door door : doors){
			for (int interval = 1; interval <= doors.size(); interval++){
				boolean shouldBeToggled = (door.getIndex() % interval == 0);
				if (shouldBeToggled){
					door.toggleDoor();
				}
			}
		}
		HundredDoors.toggleDoors();
		for (Door door : doors){
			assertEquals("Door #" + door.getIndex() + " should be " + door.getState(), door.isClosed(), HundredDoors.doors.get(door.getIndex() - 1).isClosed());
		}
	}
}
