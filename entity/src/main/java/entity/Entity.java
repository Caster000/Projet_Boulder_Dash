package entity;

/**
 * The Class Entity.
 *
 * @author Baptiste Chevallier
 */
import java.awt.Image;

public abstract class Entity implements IEntity {
    

    /** The sprite. */
    private Sprite       sprite;

    private int numberOfDiamonds;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     */
    public Entity(final Sprite sprite) {
        this.setSprite(sprite);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.IElement#getSprite()
     */
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.IElement#getImage()
     */
    public final Image getImage() {
        return this.getSprite().getImage();
    }

    public void die() {
		// TODO Auto-generated method stub
		
	}

    public int getNumberOfDiamonds() {
        return numberOfDiamonds;
    }

    public void setNumberOfDiamonds(int numberOfDiamonds) {
        this.numberOfDiamonds = numberOfDiamonds;
    }
}