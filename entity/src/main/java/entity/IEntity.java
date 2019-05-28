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
   

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
   
    Image getImage();

	Point getPosition();
	
	int getId();
	
	void isUsable();

	void die();

	int getNumberOfDiamonds();

	void setNumberOfDiamonds(int i);

}
