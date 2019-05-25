package model;

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
    Map(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }
    public Map() {
		this(0, "", "");
	}
    public Map(final int id, final String key, final String message) {
		this.setId(id);
		this.setKey(key);
		this.setMessage(message);
	}
    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IEntity[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheRoadXY(MotionlessEntityFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
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
    private void setWidth(final int width) {
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
    private void setHeight(final int height) {
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
     * Sets the on the road XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    private void setOnTheRoadXY(final IEntity element, final int x, final int y) {
        this.onTheMap[x][y] = element;
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
