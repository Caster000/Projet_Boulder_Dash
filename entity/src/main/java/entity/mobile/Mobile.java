package entity.mobile;

import entity.Entity;
import entity.Sprite;

public abstract class Mobile extends Entity {
    
    protected int SPEDD;
    /**
     * Mobile constructor
     */
    public Mobile (Sprite sprite) {
        super(sprite);
    }
    
  
}