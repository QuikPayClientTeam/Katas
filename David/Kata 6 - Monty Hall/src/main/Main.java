package main;

import java.util.ArrayList;
import java.util.Random;

import main.model.Door;
import main.model.Doors;

public class Main {

	private static int NUMBER_OF_DOORS = 3;
	private static int NUMBER_OF_GAMES = 1000;
	private static Doors<Door> doors = new Doors<Door>();
	private static ArrayList<String> prizes = new ArrayList<String>();

	public static String GOAT = "GOAT";
	public static String CAR = "CAR";

	public static void main(String[] args){
		playSwitchingDoors(NUMBER_OF_GAMES);
		playWithoutSwitchingDoors(NUMBER_OF_GAMES);
	}

	private static void playSwitchingDoors(int numberOfTimes){
		play(numberOfTimes, true);
	}

	private static void playWithoutSwitchingDoors(int numberOfTimes){
		play(numberOfTimes, false);
	}

	private static void play(int numberOfTimes, boolean switchDoors){
		double cars = 0.0;
		for (int index = 0; index < numberOfTimes; index++){
			init();
			doors.get(getRandomNumber(0, (doors.size() - 1))).select();

			while (doors.closedDoors() > 1){
				Door nextDoor = getRandomDoorWithGoat();
				doors.open(nextDoor);
			}

			Door lastDoor = doors.getLastDoor();
			if (switchDoors){
				lastDoor.select();
			}
			if (doors.getSelectedDoor().getPrize().equals(CAR)){
				cars++;
			}
		}
		System.out.println("If you " + (switchDoors ? "" : "don't ") + "switch doors you could win the car " + String.format("%.2f", (cars * 100) / NUMBER_OF_GAMES) + "% of the time.");
	}

	public static void init(){
		doors.clear();
		prizes.clear();
		prizes.add(CAR);
		for (int index = 0; index < NUMBER_OF_DOORS - 1; index++){
			prizes.add(GOAT);
		}
		for (int index = 0; index < NUMBER_OF_DOORS; index++){
			Door door = new Door(index, doors);
			int number = getRandomNumber(0, (prizes.size() - 1));
			door.setPrize(prizes.get(number));
			prizes.remove(number);
			doors.add(door);
		}
	}

	private static Door getRandomDoorWithGoat(){
		Door door = getRandomDoor();
		while (!door.isOpen() && !door.getPrize().equals(GOAT) || door.equals(doors.getSelectedDoor())){
			door = getRandomDoor();
		}
		return door;
	}

	private static Door getRandomDoor(){
		return doors.get(getRandomNumber(0, doors.size() - 1));
	}

	private static int getRandomNumber(int min, int max){
		return new Random().nextInt((max - min) + 1) + min;
	}

	public static ArrayList<Door> getDoors() {
		return doors;
	}

}
