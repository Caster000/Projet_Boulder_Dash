package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public abstract class Block extends Mobile {

	Block(int x, int y, Sprite sprite, Permeability permeability) {
		super(x, y, sprite, permeability);
	}
	
	public void fall(){
		//not yet implemented
	}
	
	public void slide() {
		//not yet implemented
	}
	
	public final void setX(final int x) {
        this.getPosition().x = x;
//      if (this.getPosition() == Hero.getPosition()) {
//          Hero.die();
//      }else if (this.getPosition() == Monster.getPosition()) {
//      	Monster.die();
//      }
    }
	
	public final void setY(final int y) {
        this.getPosition().y = y;
//      if (this.getPosition() == Hero.getPosition()) {
//      	Hero.die();
//  	}else if (this.getPosition() == Monster.getPosition()) {
//  		Monster.die();
//		}
	}
}
