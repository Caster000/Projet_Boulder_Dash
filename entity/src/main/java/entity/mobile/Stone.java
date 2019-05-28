package entity.mobile;

import entity.IEntity;
import entity.Sprite;

public class Stone extends Block {
    
//    private boolean isAlive = false;
//    private int id = 2;
    private static final Sprite SPRITE = new Sprite('2',"Stone.png");
    /**
     * Stone Constructor
     */
    public Stone() {
        super(SPRITE);
    }
    /**
     * isMovable method
     */
    

//		do nothing method, non-implemented
//    @Override
//    public void doNothing() {
//        // TODO Auto-generated method stub
//        
//    }

}