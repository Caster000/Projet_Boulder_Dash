package entity.mobile;

import java.awt.Point;

import entity.Entity;
import entity.IMap;
import entity.Map;
import entity.Permeability;
import entity.Sprite;
import fr.exia.showboard.IBoard;

public abstract class Mobile extends Entity implements IMobile{
    
    int x,y;
    private boolean isAlive;
    private IMap map;
    private Point position;
    private IBoard board;
    
    
    //don't we need to add a Map parameter to the two following method ?
    //I think it may be the reason why it's not working
    Mobile(int x, int y, Sprite sprite, Permeability permeability){
        super(sprite, permeability);
        this.setX(x);
        this.setY(y);
        
    }
    
    public Mobile (Sprite sprite, Permeability permeability) {
        super(sprite, permeability);
    }
    
    @Override
    public final int getX() {
        return this.getPosition().x;
    }
    
    @Override
    public final int getY() {
        return this.getPosition().y;
    }
    
    abstract public void setX(int x);

    abstract public void setY(int y);
    
    public boolean isAlive() {
        return this.isAlive;
    }
    
    public void moveUp() {
        this.setY(this.getY() - 1);
        //maybe we shall add a hasMoved method like there's in insane vehicle ?
    }
    
    public void moveDown() {
        this.setY(this.getY() + 1);
    }

    public void moveRight() {
        this.setX(this.getX() + 1);
    }
    
    public void moveLeft() {
        this.setX(this.getX() - 1);
    }
    
    public void doNoting() {
        //not yet implemented
    }
    
}