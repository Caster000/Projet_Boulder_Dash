package entity.mobile;

import entity.Sprite;

public class Hero extends Alive {
    
	/** The sprite. */
    private static final Sprite SPRITE = new Sprite('6',"Hero.png");

    /**
     * Hero constructor
     */
    public Hero() {
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