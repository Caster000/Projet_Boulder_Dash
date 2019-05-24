package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Rock extends MotionlessEntity{
	
	private int id = 2;
	private static Sprite SPRITE = new Sprite("Ro","Rock.jpg");
	

	public Rock() {
		super(SPRITE, Permeability.BLOCKING);
		// TODO Auto-generated constructor stub
	}
	
	//when the players digs a rock
	public void whenRockDestroyed() {
		//not yet implemented
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;		
	}

}
