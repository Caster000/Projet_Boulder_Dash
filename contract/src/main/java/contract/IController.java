package contract;

import java.io.IOException;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {

	/**
	 * Control.
	 */
	
	void play() throws InterruptedException;
	public void control();
	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	 IOrderPerformer getOrderPeformer();
}
