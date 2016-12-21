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
	
	public static void main(String[] args){
		
		//Door[] doors = new Door[2];
		boolean[] doors = new boolean[10];
		
		for(int i = 1; i < doors.length + 1; i++){
			for (int x = 0; x < doors.length; x += i){
				//doors[i].toggle();
				if(doors[i-1] == true){
					doors[i-1] = false;
				} else {
					doors[i-1] = true;
				}
				
				//x = x + i;
			}

		}
		
		for(int i = 0; i < doors.length; i++){
			System.out.println(i + ": Door :" + doors[i]);
		}
	}

}
