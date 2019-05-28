package entity.mobile;

import entity.IPermeability;
import entity.Sprite;

public abstract class Alive extends Mobile implements IPermeability{

	protected final int SPEED = 3;
	
	Alive(Sprite sprite) {
		super(sprite);
	}
	
//	
//	public int getsPEED() {
//		return this.SPPEED;
//	}

}
