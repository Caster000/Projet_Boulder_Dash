package model;

import java.util.Observable;
import contract.IModel;
import entity.Map;
/**
 * The Class Model.
 * @author Thomas Rivollet and Chevallier Baptiste
 *
 */
public final class Model extends Observable implements IModel {

	/** The map. */
	private Map map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map();
	}

	/**
     * Gets the map.
     *
     * @return the map
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMap
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load map.
     *
     * @param id
     *            the id
     */
	public void loadMap(final int id) {
//		try {
			final DAOMap daoMap = new DAOMap(/*DBConnection.getInstance().getConnection()*/);
			this.setMap(daoMap.find(id));
//		} catch (final SQLException e) {
//			e.printStackTrace();
//		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	/**
	 * Set the map to null
	 */
	@Override
	public void setMapNull() {
		this.map = null;
		
	}

}
