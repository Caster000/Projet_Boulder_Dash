package entity.Motionless;

import entity.Permeability;

public abstract class MotionlessEntityFactory {
	
	//The Constant Wall
	private static Wall WALL = new Wall(); 
	
	//The Constant Rock
	private static Rock ROCK = new Rock();
	
	//The Constant Empty
	private static Empty EMPTY = new Empty();
	
	//The Constant Door
	private static Door DOOR = new Door();
	
	//The motionless entity is an array of all possible entity

	private static MotionlessEntity[] motionlessEntities = {
		WALL,
		ROCK,
		EMPTY,
		DOOR
	};
	
	//creates a new motionlessEntity object (Wall type)
	
	public static MotionlessEntity createWall() {
		return WALL;
	}
	
	//creates a new motionlessEntity object (Rock type)
	
	public static MotionlessEntity createRock() {
		return ROCK;
	}
	
	//creates a new motionlessEntity object (Empty type)
	
	public static MotionlessEntity createEmpty() {
		return EMPTY;
	}
	
	//creates a new motionlessEntity object (Door type)
	
	public static MotionlessEntity createDoor() {
		return DOOR;
	}

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessEntity getFromFileSymbol(final String fileSymbol) {
        for (final MotionlessEntity motionlessEntity : motionlessEntities) {
            if (motionlessEntity.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessEntity;
            }
        }
        return EMPTY;
    }
	
}
