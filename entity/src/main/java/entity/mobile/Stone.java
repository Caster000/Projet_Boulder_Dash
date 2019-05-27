package entity.mobile;

import java.awt.Point;

import entity.IEntity;
import entity.Permeability;
import entity.Sprite;

public class Stone extends Block {
    
    private boolean isAlive = false;
    private int id = 2;
    private static final Sprite SPRITE = new Sprite('2',"Stone.png");
    private Point position;
    //may just be temporary
    private static int x, y;

    public Stone() {
        super(x, y, SPRITE, Permeability.BLOCKING);
    }
    
    public boolean isMovable(IEntity e) {
    	if (e.getId() == 0) {
    		return true;
    	}else {
        return false;
    	}
    }

    //I don't really know why, but I have to put it here
//    @Override
//    public void doNothing() {
//        // TODO Auto-generated method stub
//        
//    }

    @Override
    public Point getPosition() {
        return this.position;
    }

}