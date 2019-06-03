package entity.motionless;

import entity.IPermeability;
import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet and Chevallier Baptiste
 *
 */
public class Empty extends MotionlessEntity implements IPermeability{
	
	/** The sprite. */
	private static final Sprite SPRITE = new Sprite('0',"Empty.png");
	
	/**
     * Empty constructor
     */
	public Empty() {
		super(SPRITE);
	}
    
    /**
     * permeability method 
     */
	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}
	
}
