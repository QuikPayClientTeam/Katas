package main.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.Main;
import main.model.Door;

public class MontyHallTest {

	@Before
	public void setUp(){
		Main.init();
	}

	@Test
	public void assertOnlyOneDoorContainsACar() {
		int numberOfCars = 0;
		for (Door door : Main.getDoors()){
			if (door.getPrize().equals(Main.CAR)){
				numberOfCars++;
			}
		}
		assertEquals(1, numberOfCars);
	}

	@Test
	public void assertAllDoorsExceptOneContainGoats() {
		int numberOfGoats = 0;
		for (Door door : Main.getDoors()){
			if (door.getPrize().equals(Main.GOAT)){
				numberOfGoats++;
			}
		}
		assertEquals(Main.getDoors().size() - 1, numberOfGoats);
	}

}
