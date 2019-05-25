package entity.motionless;

import entity.Entity;
import entity.Permeability;
import entity.Sprite;

public abstract class MotionlessEntity extends Entity{

    MotionlessEntity(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

}
