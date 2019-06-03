package contract;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet and Adrien Vandenbossche
 */
public interface IController {

	/**
	 * Order perform.
	 *
	 * @param keyCodeToUserOrder
	 *          the controller order
	 */
	void orderPerform(UserOrder keyCodeToUserOrder);
}
