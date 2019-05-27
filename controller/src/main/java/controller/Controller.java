package controller;

import java.io.IOException;


import contract.IController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D','A','G' ou 'I', pour afficher Hello world dans la langue d votre choix.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final UserOrder userOrder) {
		switch (userOrder) {
			case L1:
				this.model.loadMap(1);
				break;
			case L2:
				this.model.loadMap(2);
				break;
			case L3:
				this.model.loadMap(3);
				break;
			case L4:
				this.model.loadMap(4);
				break;
			case L5:
				this.model.loadMap(5);
				break;
			case UP:
				this.model.loadMap(6);
				break;
			case DOWN:
				this.model.loadMap(7);
				break;
			case LEFT:
				break;
			case RIGHT:
				break;
			default:
				break;
			
				
		}
		
	}


	public IView getView() {
		return view;
	}

	public IModel getModel() {
		return model;
	}

}