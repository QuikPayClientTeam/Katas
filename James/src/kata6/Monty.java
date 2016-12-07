package kata6;

import java.util.Random;

public class Monty {

	public static void main(String[] args) {

		int staysW = game(false);
		int switchesW = game(true);

		System.out.println("Staying Wins: " + staysW);
		System.out.println("Switching Wins: " + switchesW);

	}

	public static int playerChoice() {
		Random rand = new Random();
		
		return rand.nextInt(3) + 1;

	}

	public static int winningDoor() {
		Random rand = new Random();

		return rand.nextInt(3) + 1;
	}

	public static int chooseNewDoor(int choice) {
		int newDoor = playerChoice();

		while (newDoor == choice) {
			newDoor = playerChoice();
		}

		return newDoor;

	}

	public static int game(boolean switchDoors) {

		int counter = 0;
				
		for (int plays = 0; plays < 1000; plays++) {

			// set winning door
			int winner = winningDoor();
			//System.out.println(winner);
			
			// set player choice
			int choice = playerChoice();
			//System.out.println(choice);
			
			// open non winning door

			// switch
			if (!switchDoors) {

				if (winner == choice) {
					counter++;
				}

			} else {

				int newDoor = chooseNewDoor(choice);

				if (winner == newDoor) {
					counter++;
				}

			}

		}

		return counter;

	}

}
