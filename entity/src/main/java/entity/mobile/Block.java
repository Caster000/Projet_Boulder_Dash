package entity.mobile;

import entity.Sprite;

public abstract class Block extends Mobile {   
    
    private boolean isFalling = false;

    Block(Sprite sprite) {
        super(sprite);
    }

	public boolean isFalling() {
		return isFalling;
	}

	public void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}
    
}