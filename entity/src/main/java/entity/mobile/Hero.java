package entity.mobile;

import entity.Sprite;

public class Hero extends Alive {
    
    private static final Sprite SPRITE = new Sprite('6',"Hero.png");
    private int numberOfLives;

    public Hero() {
        super(SPRITE);
    }

//    //this methods is called when the hero dies, it decreases his number of lives by one and set his number of diamonds to zero
//    @Override
//    public void die() {
//        this.setNumberOfLives(getNumberOfLives() - 1);
//        //this.setNumberOfDiamonds(0);
//        //we have to add a restart function
//    }
//
//    public int getNumberOfLives() {
//        return numberOfLives;
//    }
//
//    public void setNumberOfLives(int numberOfLives) {
//        this.numberOfLives = numberOfLives;
//    }
//    
//    public void gameOver() {
//        //not yet implemented but we may redirect to a game over screen
//    }

	@Override
	public void permeability() {
		// TODO Auto-generated method stub
		
	}

}