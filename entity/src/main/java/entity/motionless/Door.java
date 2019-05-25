package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Door extends MotionlessEntity{

	private int id = 1;
	private static Sprite SPRITE = new Sprite('7',"Door.jpg");
	
	
	public Door() {
		super(SPRITE, Permeability.BLOCKING);
		// TODO Auto-generated constructor stub
	}
	
	//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
	public void isUsable(){
		//not yet implemented
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;		
	}

	

}
