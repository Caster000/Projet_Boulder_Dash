package entity.mobile;

import entity.IPermeability;
import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public abstract class Alive extends Mobile implements IPermeability{
	
	/**
     * The Alive constructor
     * 
     * @param sprite
     *            the sprite
     */
	Alive(Sprite sprite) {
		super(sprite);
	}

}
