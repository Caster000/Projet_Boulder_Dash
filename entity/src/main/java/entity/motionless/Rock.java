package entity.motionless;

import entity.IPermeability;
import entity.Sprite;

public class Rock extends MotionlessEntity implements IPermeability{
	
//	private int id = 3;
	private static final Sprite SPRITE = new Sprite('3',"Rock.png");
	
	/**
     * Rock constructor
     */
	public Rock() {
		super(SPRITE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}

}
