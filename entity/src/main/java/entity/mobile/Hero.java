package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;
import entity.motionless.Door;
import entity.motionless.Rock;

public class Hero extends Alive {
    
    private boolean isAlive = true;
    private int id = 6;
    private static final Sprite SPRITE = new Sprite('6',"Hero.png");
    private Point position;
    private int numberOfLives;
    private int numberOfDiamonds;
    //temporary implementation of a Diamond object for testing purposes
    private Diamond diamond = new Diamond();
    //temporary implementation of a Rock object for testing purposes
    private Rock rock = new Rock();
    //temporary implementation of a Door object for testing purposes
    private Door door = new Door();
    //temporary implementation of a Monster object for testing purposes
    private Monster monster = new Monster();
    //may just be temporary
    private static int x, y;

    public Hero() {
        super(x, y, SPRITE, Permeability.PENETRABLE);
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

    //this methods is called when the hero dies, it decreases his number of lives by one and set his number of diamonds to zero
    @Override
    public void die() {
        this.setNumberOfLives(getNumberOfLives() - 1);
        this.setNumberOfDiamonds(0);
        //we have to add a restart function
    }
    
    public void gameOver() {
        //not yet implemented but we may redirect to a game over screen
    }

    //this method changes the position of the hero when he moves, it checks if ther's an event like dying, taking a diamond, entering a door or digging a rock
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.getPosition() == monster.getPosition()) {
            this.die();
        }else if (this.getPosition() == diamond.getPosition()) {
            diamond.isTaken();
        }else if (this.getPosition() == rock.getPosition()) {
            rock.isDestroyed();
        }else if (this.getPosition() == door.getPosition()) {
            door.isUsable();
        }
    }
    
    public final void setY(final int y) {
        this.getPosition().y = y;
        if (this.getPosition() == monster.getPosition() && monster.isAlive()) {
            this.die();
        }else if (this.getPosition() == diamond.getPosition()) {
            diamond.isTaken();
        }else if (this.getPosition() == rock.getPosition()) {
            rock.isDestroyed();
        }else if (this.getPosition() == door.getPosition()) {
            door.isUsable();
        }
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(int numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public int getNumberOfDiamonds() {
        return numberOfDiamonds;
    }

    public void setNumberOfDiamonds(int numberOfDiamonds) {
        this.numberOfDiamonds = numberOfDiamonds;
    }

}