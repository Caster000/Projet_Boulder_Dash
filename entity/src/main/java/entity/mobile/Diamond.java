package entity.mobile;

import java.awt.Point;

import entity.Permeability;
import entity.Sprite;
import entity.mobile.Hero;

public class Diamond extends Block {
    
    private boolean isAlive = true;
    private boolean hasFallen = false;
    private int id = 4;
    private static Sprite sprite = new Sprite('4',"Diamond.png");
    private Point position;
    
    //temporary implementation of an hero object for testing purposes
    private Hero hero = new Hero();
    //may just be temporary
    private static int x, y;

    public Diamond() {
        super(x, y, sprite, Permeability.PENETRABLE);
    }

    //I don't really know why, but I have to put it here
//    @Override
//    public void doNothing() {
//        // TODO Auto-generated method stub
//        
//    }
    
    public void isTaken() {
        if(this.isAlive) {
            this.sprite = new Sprite('0',"Empty.png");
            this.id = 0;
            hero.setNumberOfDiamonds(hero.getNumberOfDiamonds() + 1);
            this.isAlive = false;
        }
    }

}