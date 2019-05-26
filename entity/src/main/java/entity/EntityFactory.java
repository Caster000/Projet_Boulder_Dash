package entity;

import entity.Permeability;
import entity.motionless.Door;
import entity.motionless.Empty;
import entity.motionless.Rock;
import entity.motionless.Wall;

public abstract class EntityFactory {
	
	//The Constant Wall
	private static Wall WALL = new Wall(); 
	
	//The Constant Rock
	private static Rock ROCK = new Rock();
	
	//The Constant Empty
	private static Empty EMPTY = new Empty();
	
	//The Constant Door
	private static Door DOOR = new Door();
	
	//The motionless entity is an array of all possible entity

	private static Entity[] Entities = {
		WALL,
		ROCK,
		EMPTY,
		DOOR
	};
	
	//creates a new motionlessEntity object (Wall type)
	
	public static Entity createWall() {
		return WALL;
	}
	
	//creates a new motionlessEntity object (Rock type)
	
	public static Entity createRock() {
		return ROCK;
	}
	
	//creates a new motionlessEntity object (Empty type)
	
	public static Entity createEmpty() {
		return EMPTY;
	}
	
	//creates a new motionlessEntity object (Door type)
	
	public static Entity createDoor() {
		return DOOR;
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
