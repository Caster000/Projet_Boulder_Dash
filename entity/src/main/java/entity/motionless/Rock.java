package entity.motionless;

import entity.IPermeability;
import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public class Rock extends MotionlessEntity implements IPermeability{
	
	/** The sprite. */
	private static final Sprite SPRITE = new Sprite('3',"Rock.png");
	
	/**
     * Rock constructor
     */
	public Rock() {
		super(SPRITE);
		// TODO Auto-generated constructor stub
	}
    
    /**
     * permeability method 
     */
	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}

}
