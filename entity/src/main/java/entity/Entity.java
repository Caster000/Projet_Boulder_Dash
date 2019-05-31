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

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     */
    public Entity(final Sprite sprite) {
        this.setSprite(sprite);
    }

    /** return the sprite. */
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
    
    /** return the image. */
    public final Image getImage() {
        return this.getSprite().getImage();
    }

}