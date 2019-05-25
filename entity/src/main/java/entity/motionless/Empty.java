package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Empty extends MotionlessEntity{
	
	private int id = 0;
	private static Sprite SPRITE = new Sprite('0',"Empty.png");
	

	public Empty() {
		super(SPRITE, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}
	
}
