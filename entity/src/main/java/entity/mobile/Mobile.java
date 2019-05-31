package entity.mobile;

import entity.Entity;
import entity.Sprite;

public abstract class Mobile extends Entity {
    
	/** The speed. */
    protected int SPEED;
    
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