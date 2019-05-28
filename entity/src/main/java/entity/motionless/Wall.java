package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Wall extends MotionlessEntity{
	
//	private int id = 1;
	private static final  Sprite SPRITE = new Sprite('1',"Wall.png");
	
	/**
     * Wall constructor
     */
	public Wall() {
		super(SPRITE, Permeability.BLOCKING);
		// TODO Auto-generated constructor stub
	}
	
}
