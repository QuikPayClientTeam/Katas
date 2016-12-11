package montyHall;

import java.util.Arrays;
import java.util.Random;

public class MontyHall {

    static Random door = new Random();

    public static void main(String[] args) {
        int doorCount = 3;
        int totalPlays = 100000;
        int results[] = theGame(doorCount, totalPlays);

        System.out.println("Keeping it wins: " + results[0]);
        System.out.println("Changin it wins: " + results[1]);
    }
    
    public static int[] theGame(int count, int plays) {
        int keepers = 0;
        int changers = 0;

        for (int i = 0; i < plays; i++) {
            
            int[] doors = setDoors(count); 
            int initPick = pickDoor(count);
            int open = revealDoor(count, initPick, doors);
            
            keepers += doors[initPick];
            changers += doors[count - initPick - open];
            }
        return new int[] {keepers, changers};
    }
    
    public static int[] setDoors(int passedCount) {
        int [] doors = new int [passedCount];
        Arrays.fill(doors, 0);
        doors[door.nextInt(passedCount)] = 1;
        return doors;
    }
    static int pickDoor(int passedCount) {
        return door.nextInt(passedCount);
    }
    static int revealDoor(int passedCount, int passedPick, int[] passedDoors) {
        int opened;        do {
            opened = door.nextInt(passedCount);
        } while (passedDoors[opened] == 1 || opened == passedPick);
        return opened;
    }
}
