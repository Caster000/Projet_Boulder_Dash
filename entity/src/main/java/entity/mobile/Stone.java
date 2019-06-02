package entity.mobile;

import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public class Stone extends Block {

	/**To assure that the Stone is falling and can kill heroes or monsters. */
	boolean isFalling = false;

	/** The sprite. */
    private static final Sprite SPRITE = new Sprite('2',"Stone.png");
    
    /**
     * Stone Constructor
     */
    public Stone() {
        super(SPRITE);
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
	 * @param boolean
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