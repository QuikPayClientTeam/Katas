package kata6;

import static org.junit.Assert.*;

import org.junit.Test;

public class MontyTest {
	
	@Test
	public void doorIsValid(){
		boolean valid = (Monty.winningDoor() <= 3) && (Monty.winningDoor() >= 1);
		assertTrue(valid);
	}
	
	@Test
	public void playerChoiceIsValid(){
		boolean valid = (Monty.playerChoice() <= 3) && (Monty.playerChoice() >= 1);
		assertTrue(valid);
	}
	
	@Test
	public void doorsNotSame(){
		int choice = Monty.playerChoice();
		int newDoor = Monty.chooseNewDoor(choice);
		
		assertNotSame(choice, newDoor);
	}

}
