package contract;

import java.util.Observable;

import entity.Map;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet and Adrien Vandenbossche
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the map 
	 */
	Map getMap();

	/**
	 * Load the map.
	 *
	 * @param code
	 *          the code
	 */
	void loadMap(int id);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * Set the map to null
	 */
	void setMapNull();
}
