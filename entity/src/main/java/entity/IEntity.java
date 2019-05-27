package entity;

import java.awt.Image;
import java.awt.Point;

import fr.exia.showboard.ISquare;

public interface IEntity extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();
   
    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
   
    Image getImage();

	Point getPosition();
	
	int getId();

	void isTaken();

	void isUsable();

	void die();

	boolean isMovable(IEntity e);

}
