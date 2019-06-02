package entity.motionless;

import entity.Entity;
import entity.Sprite;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public abstract class MotionlessEntity extends Entity{

	/**
     * Motionless constructor
     * 
     * @param sprite
     *            the sprite
     */
    MotionlessEntity(final Sprite sprite) {
        super(sprite);
    }

}
