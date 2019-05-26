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

	Hero(int x, int y, Sprite sprite, Permeability permeability) {
		super(x, y, sprite, permeability);
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
		//not yet implemented
	}
	
	public void gameOver() {
		//not yet implemented
	}

	public final void setX(final int x) {
        this.getPosition().x = x;
//      if (this.getPosition() == Monster.getPosition()) {
//          this.die();
//      }else if (this.getPosition() == Diamond.getPosition()) {
//        	Diamond.isTaken();
//      }else if (this.getPosition() == Rock.getPosition()) {
//        	Rock.isDestroyed();
//      }else if (this.getPosition() == Door.getPosition()) {
//        	Door.isUsable();
//      }
    }
	
	public final void setY(final int y) {
        this.getPosition().y = y;
//      if (this.getPosition() == Monster.getPosition()) {
//      	this.die();
// 		}else if (this.getPosition() == Diamond.getPosition()) {
//  		Diamond.isTaken();
//  	}else if (this.getPosition() == Rock.getPosition()) {
//  		Rock.isDestroyed();
//  	}else if (this.getPosition() == Door.getPosition()) {
//  		Door.isUsable();
//  	}
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
