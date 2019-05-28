package entity.mobile;

import entity.IPermeability;
import entity.Sprite;

public abstract class Alive extends Mobile implements IPermeability{

//	private static final int SPPEED = 3;
	
	Alive(Sprite sprite) {
		super(sprite);
	}
	
	abstract public void die();
//	
//	public int getsPEED() {
//		return this.SPPEED;
//	}

}
