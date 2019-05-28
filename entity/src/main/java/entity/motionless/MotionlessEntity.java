package entity.motionless;

import entity.Entity;
import entity.Sprite;

public abstract class MotionlessEntity extends Entity{

    MotionlessEntity(final Sprite sprite) {
        super(sprite);
    }
    
    //there's a lot of methods for Map managing in Mobile, why don't we add them here ?
    //that may be an another reason for the non working code we did

}
