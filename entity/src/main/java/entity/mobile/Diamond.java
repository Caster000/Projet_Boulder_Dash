package entity.mobile;

import entity.IPermeability;
import entity.Sprite;

public class Diamond extends Block implements IPermeability{
    
//    private boolean hasFallen = false;
//    private int id = 4;
	
    boolean isFalling = false;
    
    private static final Sprite SPRITE = new Sprite('4',"Diamond.png");
    /**
     * Diamond constructor
     */
    public Diamond() {
        super(SPRITE);
    }
    /**
     * permeability method 
     */
	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}
	
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