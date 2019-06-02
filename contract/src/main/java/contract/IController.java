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
	 * @param controllerOrder
	 *          the controller order
	 */
	void orderPerform(UserOrder keyCodeToUserOrder);
}
