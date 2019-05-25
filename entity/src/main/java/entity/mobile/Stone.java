package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public class Stone extends Block {

	private int id = 2;
	private static Sprite SPRITE = new Sprite('2',"Stone.png");
	private Point position;

	Stone(int x, int y, Sprite sprite, Permeability permeability) {
		super(x, y, sprite, permeability);
	}
	
	public boolean isMovable() {
		//not yet implemented
		return false;
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

}
