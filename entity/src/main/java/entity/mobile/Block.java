package entity.mobile;

import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet and Chevallier Baptiste
 *
 */
public abstract class Block extends Mobile implements IGravity{ 

	protected final int SPEED = 4;	//for futur update, to add different speed
	
	/**
     * The Block constructor
     * 
     * @param sprite
     *            the sprite
     */
    Block(Sprite sprite) {
        super(sprite);
    }
    
}