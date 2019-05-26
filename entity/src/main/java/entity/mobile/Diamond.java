package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;
import entity.mobile.Hero;

public class Diamond extends Block {
	
	private boolean isAlive = true;
	private int id = 4;
	private Sprite sprite = new Sprite('4',"Diamond.png");
	private Point position;

	Diamond(int x, int y, Sprite sprite, Permeability permeability) {
		super(x, y, sprite, permeability);
	}

	//I don't really know why, but I have to put it here
	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}
	
	public void isTaken() {
		if(this.isAlive) {
			this.sprite = new Sprite('0',"Empty");
			this.id = 0;
			//Hero.setNumberOfDiamonds(Hero.getNumberOfDiamonds() + 1);
			this.isAlive = false;
		}
	}

}
