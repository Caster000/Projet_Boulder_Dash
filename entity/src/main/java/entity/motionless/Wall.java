package entity.motionless;

import entity.IPermeability;
import entity.Sprite;

public class Wall extends MotionlessEntity implements IPermeability{
	
//	private int id = 1;
	private static final  Sprite SPRITE = new Sprite('1',"Wall.png");
	
	/**
     * Wall constructor
     */
	public Wall() {
		super(SPRITE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}
	
}
