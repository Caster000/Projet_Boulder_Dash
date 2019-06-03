package entity.mobile;

import entity.Entity;
import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet and Chevallier Baptiste
 *
 */
public abstract class Mobile extends Entity {
    
	/** The speed. */
    protected int SPEED;	//to add speed in next update
    
    /**
     * Mobile constructor
     * 
     * @param sprite
     *            the sprite
     */
    public Mobile (Sprite sprite) {
        super(sprite);
    }
    
  
}