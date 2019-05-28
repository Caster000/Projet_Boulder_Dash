package entity.motionless;

import entity.Sprite;

public class Door extends MotionlessEntity{

	private static final Sprite SPRITE = new Sprite('7',"Door.png");
	
	/**
     * Door constructor
     */
	public Door() {
		super(SPRITE);
	}	
}
