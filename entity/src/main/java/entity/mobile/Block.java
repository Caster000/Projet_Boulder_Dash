package entity.mobile;

import entity.Sprite;

public abstract class Block extends Mobile implements IGravity{ 

    Block(Sprite sprite) {
        super(sprite);
    }
    
}