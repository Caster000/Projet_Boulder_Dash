package entity.mobile;

import entity.Sprite;

public abstract class Block extends Mobile implements IGravity{   
    
	private int x = 0;
	private int y = 0;
	
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
    
}