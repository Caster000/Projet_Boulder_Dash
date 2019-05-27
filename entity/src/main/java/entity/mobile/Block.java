package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;

public abstract class Block extends Mobile {
    
    //temporary implementation of an hero object for testing purposes
    private Hero hero = new Hero();
    //temporary implementation of a monster object for testing purposes
    private Monster monster = new Monster();

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
        if (this.getPosition() == hero.getPosition()) {
            hero.die();
        }else if (this.getPosition() == monster.getPosition()) {
            monster.die();
        }
    }
    
    public final void setY(final int y) {
        this.getPosition().y = y;
        if (this.getPosition() == hero.getPosition()) {
            hero.die();
        }else if (this.getPosition() == monster.getPosition()) {
            monster.die();
        }
    }
    
}