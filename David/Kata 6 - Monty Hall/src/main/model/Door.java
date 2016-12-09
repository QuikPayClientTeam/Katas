package main.model;

public class Door {

	private int index;
	private String prize;
	private Doors<Door> doors;
	private boolean selected = false;
	private boolean open = false;

	public Door(int index, Doors<Door> doors){
		this.index = index;
		this.doors = doors;
	}

	public void remove(){
		doors.remove(this);
	}

	public void select(){
		selected = true;
		doors.selectDoor(this);
	}

	public void open(){
		open = true;
	}

	public void unselect(){
		selected = false;
	}

	public String getPrize() {
		return prize;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "Door #" + (index + 1) + ": " + prize + (isSelected() ? " (SELECTED)" : "") + (isOpen() ? " (OPEN)" : "");
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public boolean isSelected() {
		return selected;
	}

	public boolean isOpen() {
		return open;
	}

}
