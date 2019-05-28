package entity.mobile;

import entity.Entity;
import entity.Permeability;
import entity.Sprite;

public abstract class Mobile extends Entity {
    
    protected boolean isAlive;
    /**
     * Mobile constructor
     */
    public Mobile (Sprite sprite, Permeability permeability) {
        super(sprite, permeability);
    }
    
//    @Override
//    public final int getX() {
//        return this.getPosition().x;
//    }
//    
//    @Override
//    public final int getY() {
//        return this.getPosition().y;
//    }
//    
//    abstract public void setX(int x);
//
//    abstract public void setY(int y);
//    
//    public boolean isAlive() {
//        return this.isAlive;
//    }
//    
//    public void moveUp() {
//        this.setY(this.getY() - 1);
//        //maybe we shall add a hasMoved method like there's in insane vehicle ?
//    }
//    
//    public void moveDown() {
//        this.setY(this.getY() + 1);
//    }
//
//    public void moveRight() {
//        this.setX(this.getX() + 1);
//    }
//    
//    public void moveLeft() {
//        this.setX(this.getX() - 1);
//    }
//    
//    public void doNoting() {
//        //not yet implemented
//    }
//    
}