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
    	//not yet implemented but I have no idea what to do with this
    }
    
    //in the diagrams we made with VisualParadigm, there's this two methods, but as they also are in Model, I'm not sure that they're useful
    public void setMap(final IMap map) {
    	this.map = map;
    	//I set it like that but I'm wondering if we have to add some things to this method
    }//as there's a setMap method in this class, don't we have to add a getMap method there ?
    
    public void loadMap(String code) {
    	//I don't really now what we wanted to do with this
    }
    
    //In VisualParadigm, we added a Observable method, but I don't know how we wanted to do that
    
}