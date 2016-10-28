package kata3;

public class ToggleThemDoors {
	
	/*
	 * 100 doors in a row are all initially closed. You make
	 * 100 passes by the doors. The first time through, you
	 * visit every door and toggle the door (if the door is
	 * closed, you open it; if it is open, you close it).
	 * The second time you only visit every 2nd door (door
	 * #2, #4, #6, ...). The third time, every 3rd door
	 * (door #3, #6, #9, ...), etc, until you only visit
	 * the 100th door.
	 */
	
	public static void main(){
		
		boolean[] doors = new boolean[100];
		
		for(int pass = 0; pass <=100; pass++){
			System.out.println(pass +": Door is " + doors[pass]);
		}
		
	}

}
