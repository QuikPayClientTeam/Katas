package main;

import java.util.ArrayList;

public class HundredDoors {

	public static ArrayList<Door> doors = new ArrayList<Door>();
	public static final Integer NUMBER_OF_DOORS = 100;

	public static void main(String[] args) {
		/* 	100 doors in a row are all initially closed. You make 100 passes by the doors. The first time through, you
			visit every door and toggle the door (if the door is closed, you open it; if it is open, you close it).
			The second time you only visit every 2nd door (door	#2, #4, #6, ...). The third time, every 3rd door
			(door #3, #6, #9, ...), etc, until you only visit the 100th door. */

		init();
		toggleDoors();
		displayDoors();
	}

	public static void init(){
		doors.clear();
		for (int index = 1; index <= NUMBER_OF_DOORS; index++){
			doors.add(new Door(index));
		}
	}

	public static void toggleDoors(){
		for (int interval = 1; interval <= NUMBER_OF_DOORS; interval++){
			for (int index = interval - 1; index < NUMBER_OF_DOORS; index += interval){
				doors.get(index).toggleDoor();
			}
		}
	}

	private static void displayDoors(){
		for (int index = 0; index < NUMBER_OF_DOORS; index++){
			System.out.println(doors.get(index));
		}
	}

}
