package entity.mobile;

import entity.IPermeability;
import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet and Chevallier Baptiste
 *
 */
public class Diamond extends Block implements IPermeability{
	
	/**To assure that the Diamond is falling and can kill heroes or monsters. */
    boolean isFalling = false;
    
    /** The sprite. */
    private static final Sprite SPRITE = new Sprite('4',"Diamond.png");
    
    /**
     * Diamond constructor
     */
    public Diamond() {
        super(SPRITE);
    }
    
    /**
     * permeability method 
     */
	@Override
	public void permeability() {
		// TODO Auto-generated method stub
	}

	/**
     * the fall method 
     */
	@Override
	public void fall() {
		// TODO Auto-generated method stub
	}

	/**To sets that the Diamond is falling or not. 
	 * 
	 * @param isFalling
     *            the isFalling
	 */
	@Override
	public void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	/**
     * Gets the isFalling.
     *
     * @return the isFalling
     */
	@Override
	public boolean isFalling() {
		return this.isFalling;
	}

}