package entity.motionless;

import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public class Door extends MotionlessEntity{
    
	/** The sprite. */
	private static final Sprite SPRITE = new Sprite('7',"Door.png");
	
	/**
     * Door constructor
     */
	public Door() {
		super(SPRITE);
	}	
}
