package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public abstract class Alive extends Mobile {

//	private static final int SPPEED = 3;
	
	Alive(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
	}
	
	abstract public void die();
//	
//	public int getsPEED() {
//		return this.SPPEED;
//	}

}
