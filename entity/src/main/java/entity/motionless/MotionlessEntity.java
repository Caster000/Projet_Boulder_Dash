package entity.motionless;

import entity.Entity;
import entity.Sprite;

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
