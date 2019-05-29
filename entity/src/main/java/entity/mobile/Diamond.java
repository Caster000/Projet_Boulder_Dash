package entity.mobile;

import entity.IPermeability;
import entity.Sprite;

public class Diamond extends Block implements IPermeability{
    
//    private boolean hasFallen = false;
//    private int id = 4;
	
    private boolean isFalling = false;
    
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