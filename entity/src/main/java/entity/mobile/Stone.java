package entity.mobile;

import entity.Sprite;

public class Stone extends Block {
	protected final int SPEED = 2;

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
	public void setFalling(boolean bool) {
		// TODO Auto-generated method stub
		
	}

}