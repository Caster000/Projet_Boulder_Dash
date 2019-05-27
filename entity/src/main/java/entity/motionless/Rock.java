package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Rock extends MotionlessEntity{
	
	private int id = 3;
	private static final Sprite SPRITE = new Sprite('3',"Rock.png");
	

	public Rock() {
		super(SPRITE, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}

}
