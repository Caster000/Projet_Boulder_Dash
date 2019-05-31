package entity.mobile;

import entity.Sprite;

public abstract class Block extends Mobile implements IGravity{ 

	protected final int SPEED = 4;
	
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