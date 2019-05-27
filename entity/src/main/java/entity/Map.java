package entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import entity.IEntity;
import entity.mobile.Diamond;
import entity.mobile.Hero;
import entity.mobile.Monster;
import entity.mobile.Stone;
import entity.motionless.Door;
import entity.motionless.Empty;
import entity.motionless.Rock;
import entity.motionless.Wall;

public class Map implements IMap {
     /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the road. */
    private IEntity[][] onTheMap;
    
    /** The id. */
    private int            id;

    /** The key. */
    private String    key;

    /** The message. */
    private String    message;
    
    //for testing purposes
    private Hero hero = new Hero();
    private Monster monster = new Monster();
    private Diamond diamond = new Diamond();
    private Stone stone = new Stone();
    private Rock rock = new Rock();
    private Door door = new Door();
    private Empty empty = new Empty();
    private Wall wall = new Wall();

    /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
//    Map(final String fileName) throws IOException {
//        super();
//        this.loadFile(fileName);
//    }
    
    public Map() {
        this(0, "", "");
    }
    
    public Map(final int id, final String key, final String message) {
        this.setId(id);
        this.setKey(key);
        this.setMessage(message);
    }
    public Map(/*final int id,*/ int width, int height) {
        //this.setId(id);
//        this.setWidth(width);
//        this.setHeight(height);
        onTheMap = new Entity[width][height];
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }
/**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    public void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    public void setHeight(final int height) {
        this.height = height;
    }
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
     */
    @Override
    public final IEntity getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }

    /**
     * Sets the on the map XY.
     *
     * @param entity
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void setOnTheMapXY(final IEntity entity, final int x, final int y) {
        this.onTheMap[x][y] = entity;
    }
    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the new id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }
    /**
     * Sets the key.
     *
     * @param key
     *          the new key
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *          the new message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    //generic function for moving left
    public void moveLeft(int x, int y) {
        this.onTheMap[x-1][y] = this.onTheMap[x][y];//the entity moves
        this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
        System.out.println("Went left");
    }
    
    //generic function for moving right
    public void moveRight(int x, int y) {
        this.onTheMap[x+1][y] = this.onTheMap[x][y];//the entity moves
        this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
        System.out.println("Went right");
    }
    
    //generic function for moving up
    public void moveUp(int x, int y) {
        this.onTheMap[x][y-1] = this.onTheMap[x][y];//the entity moves
        this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
        System.out.println("Went up");
    }
    
    //generic function for moving down
    public void moveDown(int x, int y) {
        this.onTheMap[x][y+1] = this.onTheMap[x][y];//the entity moves
        this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
        System.out.println("Went down");
    }
    
    //specific function for the hero to move up
    public void heroMoveUp(int x, int y) {
    	IEntity topEntity = this.getOnTheMapXY(x, y);//checks whant's the entity where the hero wanted to move
    	if (topEntity.getPermeability() == Permeability.PENETRABLE) {//if the entity is penetrable
    		moveUp(x, y);
    		//On Titouan's code there's a function which updates the map, maybe we shall do something like that
    		HeroMovingChecks();
    	}else {
    		System.out.println("can't move up");//print a message for testing purposes
    	}
    	
    }
    
    //specific function for the hero to move down
    public void heroMoveDown(int x, int y) {
    	IEntity topEntity = this.getOnTheMapXY(x, y);//checks whant's the entity where the hero wanted to move
    	if (topEntity.getPermeability() == Permeability.PENETRABLE) {//if the entity is penetrable
    		moveDown(x, y);
    		//On Titouan's code there's a function which updates the map, maybe we shall do something like that
    		HeroMovingChecks();
    	}else {
    		System.out.println("can't move up");//print a message for testing purposes
    	}
    	
    }
    
    //specific function for the hero to move left
    public void heroMoveLeft(int x, int y) {
    	IEntity topEntity = this.getOnTheMapXY(x, y);//checks whant's the entity where the hero wanted to move
    	if (topEntity.getPermeability() == Permeability.PENETRABLE) {//if the entity is penetrable
    		moveLeft(x, y);
    		//On Titouan's code there's a function which updates the map, maybe we shall do something like that
    		HeroMovingChecks();
    	}else {
    		System.out.println("can't move up");//print a message for testing purposes
    	}
    	
    }
    
    //specific function for the hero to move right
    public void heroMoveRight(int x, int y) {
    	IEntity topEntity = this.getOnTheMapXY(x, y);//checks whant's the entity where the hero wanted to move
    	if (topEntity.getPermeability() == Permeability.PENETRABLE) {//if the entity is penetrable
    		moveRight(x, y);
    		//On Titouan's code there's a function which updates the map, maybe we shall do something like that
    		HeroMovingChecks();
    	}else {
    		System.out.println("can't move up");//print a message for testing purposes
    	}
    	
    }
    
    public void HeroMovingChecks() { 
    	if (hero.getPosition() == monster.getPosition()) {//different cases
    		hero.die();//die because of the monster
    	}else if (hero.getPosition() == diamond.getPosition()) {
    		diamond.isTaken();//the hero enters on the diamond so he can take it
    	}else if (hero.getPosition() == rock.getPosition()) {
    		rock.isDestroyed();//the hero digs a rock
    	}else if (hero.getPosition() == door.getPosition()) {
    		door.isUsable();//the hero checks if he can use the door he is on
    	}
    	
    }

}