package entity.motionless;

import entity.IPermeability;
import entity.Sprite;

public class Door extends MotionlessEntity implements IPermeability{

//	private int id = 7;
	private static final Sprite SPRITE = new Sprite('7',"Door.png");
	
	/**
     * Door constructor
     */
	public Door() {
		super(SPRITE);
		// TODO Auto-generated constructor stub
	}
	
	//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
	public void isUsable(){
		//not yet implemented
	}

	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}

}
