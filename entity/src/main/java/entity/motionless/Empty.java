package entity.motionless;

import entity.IPermeability;
import entity.Sprite;

public class Empty extends MotionlessEntity implements IPermeability{
	
//	private int id = 0;
	private static final Sprite SPRITE = new Sprite('0',"Empty.png");
	
	/**
     * Empty constructor
     */
	public Empty() {
		super(SPRITE);
		// TODO Auto-generated constructor stub
	}
	
}
