package entity.mobile;

import entity.Sprite;

public class Monster extends Alive{
    
	/** The sprite. */
    private static final Sprite SPRITE = new Sprite('5',"Monster.png");

    /**
     * Monster constructor
     */
    public Monster() {
        super(SPRITE);
    }
    
    /**
     * permeability method 
     */
	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}

}