package main;

public class Door {

	private int index = 0;
	private final String OPEN = "OPEN";
	private final String CLOSED = "CLOSED";

	private String state = CLOSED;

	public Door(int index){
		this.index = index;
	}

	public void toggleDoor(){
		if (isOpen()){
			closeDoor();
		}else{
			openDoor();
		}
	}

	private void openDoor(){
		state = OPEN;
	}

	private void closeDoor(){
		state = CLOSED;
	}

	public boolean isOpen(){
		return state.equals(OPEN);
	}

	public boolean isClosed(){
		return state.equals(CLOSED);
	}

	@Override
	public String toString(){
		return "Door #" + index + ": " + state;
	}

	public int getIndex() {
		return index;
	}

	public String getState() {
		return state;
	}
}
