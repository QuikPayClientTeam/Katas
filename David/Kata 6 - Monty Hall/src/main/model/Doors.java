package main.model;

import java.util.ArrayList;
import java.util.ListIterator;

public class Doors<E> extends ArrayList<E> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Door selectedDoor;
	private int closedDoors = 0;

	public void selectDoor(Door door){
		if (selectedDoor != null){
			selectedDoor.unselect();
			closedDoors++;
		}
		selectedDoor = door;
		closedDoors--;
	}

	public void open(Door door){
		//super.remove(door);
		door.open();
		closedDoors--;
	}

	public int closedDoors(){
		return closedDoors;
	}

	public Door getSelectedDoor() {
		return selectedDoor;
	}

	public Door getLastDoor() {
		Door door = null;
		@SuppressWarnings("unchecked")
		ListIterator<Door> doorIterator = (ListIterator<Door>) super.listIterator();
		while (doorIterator.hasNext()) {
			door = doorIterator.next();
			if (!door.equals(selectedDoor) && !door.isOpen()){
				break;
			}
		}
		return door;
	}

	@Override
	public boolean add(E e) {
		closedDoors++;
		return super.add(e);
	}

	@Override
	public void clear() {
		super.clear();
		closedDoors = 0;
		selectedDoor = null;
	}

}
