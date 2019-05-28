package entity.mobile;

import entity.Sprite;

public class Monster extends Alive {
    
//    private boolean isAlive = true;
//    private int id = 5;
    private static final Sprite SPRITE = new Sprite('5',"Monster.png");

    /**
     * Monster constructor
     */
    public Monster() {
        super(SPRITE);
    }

//	do nothing method, non-implemented
//    @Override
//    public void doNothing() {
//        // TODO Auto-generated method stub
//        
//    }
    /**
     * die method
     */
    @Override
    public void die() {
        this.isAlive = false;
        //map.setOnTheMap();
        //We have to implement the becoming a diamond part
    }

	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}

}