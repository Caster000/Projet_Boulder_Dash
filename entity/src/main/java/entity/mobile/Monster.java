package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public class Monster extends Alive{
	
	private boolean isAlive = true;
	private int id = 5;
	private static final Sprite SPRITE = new Sprite('5',"Monster.png");
	private Point position;

	Monster(int x, int y, Sprite sprite, Permeability permeability) {
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

	public final void setX(final int x) {
        this.getPosition().x = x;
//      if (hero.getPosition() == this.getPosition()) {
//      	hero.die();
    }
	
	public final void setY(final int y) {
        this.getPosition().y = y;
//      if (hero.getPosition() == this.getPosition()) {
//  		hero.die();
//      }
	}

}