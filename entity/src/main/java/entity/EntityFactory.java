package entity;

import entity.mobile.Diamond;
import entity.mobile.Hero;
import entity.mobile.Monster;
import entity.mobile.Stone;
import entity.motionless.Door;
import entity.motionless.Empty;
import entity.motionless.Rock;
import entity.motionless.Wall;
/**
 * 
 * @author Thomas Rivollet & Chevallier Baptiste
 *
 */
public abstract class EntityFactory {
    
    /**
     * The Constant Wall
     */
    private static Wall WALL = new Wall(); 
    
    /**
     * The Constant Rock
     */
    private static Rock ROCK = new Rock();
    
    /**
     * The Constant Empty
     */
    private static Empty EMPTY = new Empty();
    
    /**
     * The Constant Door
     */
    private static Door DOOR = new Door();
    
    /**
     * The Constant Diamond
     */
    private static Diamond DIAMOND = new Diamond();
    
    /**
     * The Constant Stone
     */
    private static Stone STONE = new Stone();
    
    /**
     * The Constant Monster
     */
    private static Monster MONSTER = new Monster();;
    
    /**
     * The Constant Hero
     */
    private static Hero HERO = new Hero();
    
    /**
     * The entity is an array of all possible entity
     */
    private static Entity[] Entities = {
        WALL,
        ROCK,
        EMPTY,
        DOOR,
        DIAMOND,
        STONE,
        MONSTER,
        HERO
    };
    
    /**
     * creates a new motionlessEntity object (Wall type)    
     * @return
     */
    public static Entity createWall() {
        return WALL;
    }
    
    /**
     * creates a new motionlessEntity object (Rock type)    
     * @return
     */
    public static Entity createRock() {
        return ROCK;
    }
    
    /**
     * creates a new motionlessEntity object (Empty type)    
     * @return
     */
    public static Entity createEmpty() {
        return EMPTY;
    }
    
    /**
     * creates a new motionlessEntity object (Door type)    
     * @return
     */
    public static Entity createDoor() {
        return DOOR;
    }
    
    /**
     * creates a new mobile object (Diamond type)    
     * @return
     */
    public static Entity createDiamond() {
        return DIAMOND;
    }
    
    /**
     * creates a new mobile object (Stone type)    
     * @return
     */
    public static Entity createStone() {
        return STONE;
    }
    /**
     * creates a new mobile object (Monster type)    
     * @return
     */
    public static Entity createMonster() {
        return MONSTER;
    }
    
    /**
     * creates a new mobile object (Hero type)    
     * @return
     */
    public static Entity createHero() {
        return HERO;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Entity getFromFileSymbol(final char fileSymbol) {
        for (final Entity Entity : Entities) {
            if (Entity.getSprite().getConsoleImage() == fileSymbol) {
                return Entity;
            }
        }
        return EMPTY;
    }
    
}