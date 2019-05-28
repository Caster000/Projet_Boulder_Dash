package controller;

import java.io.IOException;


import contract.IController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.Map;

/**
 * The Class Controller.
 */
public final class Controller implements IController{
	private static final int speed = 1;
	private UserOrder stackOrder;
	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	private Map map;
	
	private int heroX = 1;
	
	private int heroY = 1;
	
	private boolean hasMoved;
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model)  {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
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
		this.view.play();
	}
	
	public final void play() throws InterruptedException {
//		while (this.getModel().getHero().isAlive()) {
//			Thread.sleep(speed);
//			switch (this.getStackOrder()) {
//			case UP:
//				this.getModel().getHero().HeromoveUP();
//				break;
//			case DOWN:
//				this.getModel().getHero().HeromoveDOWN();
//				break;
//			case RIGHT:
//				this.getModel().getHero().HeromoveRIGHT();
//				break;
//			case LEFT:
//				this.getModel().getHero().HeromoveDOWN();
//				break;
//				default:
//					this.getModel().getHero().HeroDoNothing();
//					break;	
//			}
//			this.clearStackOrder();
//			if (this.getModel().getHero().isAlive()){
//				this.getModel().getHero().HeroDoNothing();
//			}
//			//this.getView().followMyhero();
//		
//			}
		this.getView().displayMessage("Game Over !");
			
		}
	

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NULL;
	}
	
	
	
	
	private UserOrder getStackOrder() {
		return this.stackOrder;
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
				this.model.getMap().setRequiredNumberOfDiamonds(1);
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
			case L6:
				this.model.loadMap(6);
				break;
			case UP:
				hasMoved = this.model.getMap().heroMoveUp(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
				if (hasMoved) {
					heroY--;
				}
				break;
			case DOWN:
				hasMoved = this.model.getMap().heroMoveDown(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
				if (hasMoved) {
					heroY++;
				}				
				break;
			case LEFT:
				hasMoved = this.model.getMap().heroMoveLeft(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
				if (hasMoved) {
					heroX--;
				}
				break;
			case RIGHT:
				hasMoved = this.model.getMap().heroMoveRight(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
				if (hasMoved) {
					heroX++;
				}
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

	public int getHeroX() {
		return heroX;
	}

	public void setHeroX(int heroX) {
		this.heroX = heroX;
	}

	public int getHeroY() {
		return heroY;
	}

	public void setHeroY(int heroY) {
		this.heroY = heroY;
	}

	public void printDown() {
		System.out.println("Down");
	}

}