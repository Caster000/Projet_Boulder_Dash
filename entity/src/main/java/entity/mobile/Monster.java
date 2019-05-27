package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public class Monster extends Alive{
    
    private boolean isAlive = true;
    private int id = 5;
    private static Sprite sprite = new Sprite('5',"Monster.png");
    private Point position;
    //temporary implementation of an hero object for testing purposes
    private Hero hero = new Hero();
    //may just be temporary
    private static int x, y;

    public Monster() {
        super(x, y, sprite, Permeability.PENETRABLE);
    }

    //I don't really know why, but I have to put it here
    @Override
    public void doNothing() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void die() {
        this.isAlive = false;
        //map.setOnTheMap();
        //We have to implement the becoming a diamond part
    }

    public final void setX(final int x) {
        this.getPosition().x = x;
        if (hero.getPosition() == this.getPosition() && this.isAlive) {
            hero.die();
        }
    }
    
    public final void setY(final int y) {
        this.getPosition().y = y;
        if (hero.getPosition() == this.getPosition() && this.isAlive) {
            hero.die();
        }
    }

}