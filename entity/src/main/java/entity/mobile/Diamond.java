package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public class Diamond extends Block {
	
	private boolean isAlive = false;
	private int id = 4;
	private static Sprite SPRITE = new Sprite('4',"Diamond.png");
	private Point position;

	Diamond(int x, int y, Sprite sprite, Permeability permeability) {
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
	
	public static void isTaken() {
		
	}

}
