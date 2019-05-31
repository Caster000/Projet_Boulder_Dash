package entity.motionless;

import entity.Sprite;

public class Wall extends MotionlessEntity{
	
	/** The sprite. */
	private static final  Sprite SPRITE = new Sprite('1',"Wall.png");
	
	/**
     * Wall constructor
     */
	public Wall() {
		super(SPRITE);
		// TODO Auto-generated constructor stub
	}
	
}
