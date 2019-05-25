package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Rock extends MotionlessEntity{
	
	private int id = 3;
	private static Sprite SPRITE = new Sprite('3',"Rock.png");
	

	public Rock() {
		super(SPRITE, Permeability.PENETRABLE);
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
