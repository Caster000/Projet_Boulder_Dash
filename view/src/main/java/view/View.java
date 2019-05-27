package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;


import contract.IController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static UserOrder keyCodeToUserOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return UserOrder.UP;
			case KeyEvent.VK_S:
				return UserOrder.DOWN;
			case KeyEvent.VK_D:
				return UserOrder.RIGHT;
			case KeyEvent.VK_Q:
				return UserOrder.LEFT;
			case KeyEvent.VK_1:
				return UserOrder.L1;
			case KeyEvent.VK_2:
				return UserOrder.L2;
			case KeyEvent.VK_3:
				return UserOrder.L3;
			case KeyEvent.VK_4:
				return UserOrder.L4;
			case KeyEvent.VK_5:
				return UserOrder.L5;
				
				
			default:
				return UserOrder.NULL;
				
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
