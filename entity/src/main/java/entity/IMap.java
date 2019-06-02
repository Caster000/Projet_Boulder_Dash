package entity;


import java.util.Observable;

import entity.IEntity;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public interface IMap {

	/**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IEntity getOnTheMapXY(int x, int y);
    /**
     * Gets the Observable
     * @return
     */
   Observable getObservable();
}

