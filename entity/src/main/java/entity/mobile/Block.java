package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public abstract class Block extends Mobile {   
    
    private boolean isFalling = false;

    Block(Sprite sprite, Permeability permeability) {
        super(sprite, permeability);
    }

	public boolean isFalling() {
		return isFalling;
	}

	public void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}
    
}