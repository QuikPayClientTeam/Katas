package kata3;

public class Door {
	
	//open = true
	//closed = false
	private boolean status = false; 
	
	public Door(int i){
		
	}
	
	public void toggle(){
		if(this.status == false){
			this.status = true;
		} else {
			this.status = false;
		}
	}
	
	public boolean getStatus(){
		return status;
	}

}
