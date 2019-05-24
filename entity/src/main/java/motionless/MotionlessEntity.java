package motionless;

import entity.Entity;
import entity.Permeability;
import entity.Sprite;

/**
 * <h1>The MotionlessElement Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
abstract class MotionlessEntity extends Entity {

    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessEntity(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

}
