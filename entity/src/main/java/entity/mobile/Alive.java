package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public abstract class Alive extends Mobile {

	private static final int SPPEED = 3;
	
	Alive(int x, int y, Sprite sprite, Permeability permeability) {
		super(x, y, sprite, permeability);
	}
	
	abstract public void die();
	
	public int getsPEED() {
		return this.SPPEED;
	}

}
