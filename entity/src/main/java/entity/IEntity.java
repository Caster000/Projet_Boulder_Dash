package entity;

import java.awt.Image;

public interface IEntity  {

	/**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();
   

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
   
    Image getImage();

	void die();

}
