package entity.mobile;
/**
 * 
 * @author Thomas Rivollet
 *
 */
public interface IGravity {

	/**The fall method */
	public void fall();

	/**To sets that the Block is falling or not. 
	 * 
	 * @param boolean
     *            the isFalling
	 */
	public void setIsFalling(boolean bool);

	/**
     * Gets the isFalling.
     *
     * @return the isFalling
     */
	public boolean isFalling();

}
