package entity.motionless;

import entity.Entity;
import entity.Permeability;
import entity.Sprite;

public abstract class MotionlessEntity extends Entity{
	
    /** The permeability. */
    private Permeability permeability;

    MotionlessEntity(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
		

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
     */
    public final Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Sets the permeability.
     *
     * @param permeability
     *            the new permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

}
