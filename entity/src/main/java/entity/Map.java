package entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import entity.IEntity;
import entity.motionless.MotionlessEntityFactory;

public class Map implements IMap {
	 /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the road. */
    private IEntity[][] onTheMap;
    
    /** The id. */
	private int			id;

	/** The key. */
	private String	key;

	/** The message. */
	private String	message;

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
//    	this.setWidth(width);
//    	this.setHeight(height);
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
}