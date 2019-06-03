package entity;

import java.awt.Image;
/**
 * 
 * @author Thomas Rivollet and Chevallier Baptiste
 *
 */
public interface IEntity  {

	/**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();
    
    /**
     * Gets the image.
     *
     * @return the image
     */
    Image getImage();
}
