package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public class Hero extends Alive {
    
//    private boolean isAlive = true;
//    private int id = 6;
    private static final Sprite SPRITE = new Sprite('6',"Hero.png");
    private int numberOfLives;
    private int numberOfDiamonds;

    public Hero() {
        super(SPRITE, Permeability.PENETRABLE);
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