package entity.mobile;

import entity.Sprite;

public class Stone extends Block {
	protected final int SPEED = 2;
	boolean isFalling = false;

    private static final Sprite SPRITE = new Sprite('2',"Stone.png");
    /**
     * Stone Constructor
     */
    public Stone() {
        super(SPRITE);
    }
    
//	@Override
//	public void gravity() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void fall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
		
	}

	@Override
	public boolean isFalling() {
		return this.isFalling;
	}
}