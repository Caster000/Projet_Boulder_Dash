package entity.Motionless;

import entity.Entity;
import entity.Permeability;
import entity.Sprite;

public abstract class MotionlessEntity extends Entity{
	
    /** The permeability. */
    private Permeability permeability;

	public MotionlessEntity(Sprite sprite, Permeability permeability) {
		super(sprite);
        this.setPermeability(permeability);
		// TODO Auto-generated constructor stub
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
