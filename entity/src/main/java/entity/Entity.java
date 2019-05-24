package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */

import java.awt.Image;

//import fr.exia.showboard.ISquare;

/**
 * <h1>The Element Class.</h1>
 *
 * @author Jade
 * @version 0.4
 * @see ISquare
 */
public abstract class Entity implements IEntity {
	
	/** The id. */
	private int id; 

    /** The sprite. */
    private Sprite       sprite;

    

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
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

	abstract public int getId();

	abstract public void setId(int id);
}
