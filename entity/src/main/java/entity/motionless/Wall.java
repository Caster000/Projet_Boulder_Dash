package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Wall extends MotionlessEntity{
	
	private int id = 1;
	private static Sprite SPRITE = new Sprite('1',"Wall.png");
	

	public Wall() {
		super(SPRITE, Permeability.BLOCKING);
		// TODO Auto-generated constructor stub
	}
	
}
