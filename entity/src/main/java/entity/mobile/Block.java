package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public abstract class Block extends Mobile {
    
	//it's now useles and I know it, but it'll be easier for me in the future if I let it here
    //temporary implementation of an hero object for testing purposes
    private Hero hero = new Hero();
    //temporary implementation of a monster object for testing purposes
    private Monster monster = new Monster();
    
    private boolean hasFallen = false;

    Block(int x, int y, Sprite sprite, Permeability permeability) {
        super(x, y, sprite, permeability);
    }
    
  //it's now useles and I know it, but it'll be easier for me in the future if I let it here
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.getPosition() == hero.getPosition()) {
            hero.die();
        }else if (this.getPosition() == monster.getPosition()) {
            monster.die();
        }
    }
    
  //it's now useles and I know it, but it'll be easier for me in the future if I let it here
    public final void setY(final int y) {
        this.getPosition().y = y;
        if (this.getPosition() == hero.getPosition()) {
            hero.die();
        }else if (this.getPosition() == monster.getPosition()) {
            monster.die();
        }
    }

	public boolean hasFallen() {
		return hasFallen;
	}

	public void setHasFallen(boolean hasFallen) {
		this.hasFallen = hasFallen;
	}
    
}