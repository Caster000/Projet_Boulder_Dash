package controller;

import contract.IController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;

/**
 * The Class Controller.
 * @author Adrien Vandenbossche
 */
public final class Controller implements IController{
	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;
	/** The hero position in X. */
	private int heroX = 1;
	/** The hero position in y. */
	private int heroY = 1;
	/** The level. */
	private int level ;
	/** The number of lives. */
	private int lives ;
	/** boolean to set if the hero has moved. */
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
		this.setModel(model);;
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
	 * orderPerform to answer at the player
	 * @param UserOrder
	 * 				the user Order
	 */
	public void orderPerform(final UserOrder userOrder) {
		switch (userOrder) {
		case L1:											//start the default game
			level = this.model.getMap().getLevel();
			lives = this.model.getMap().getNumberOfLives();
			//System.out.println(lives);	debug
			if(this.model.getMap().getNumberOfLives() == 0) {
				this.model.getMap().setLevel(1);
				level = this.model.getMap().getLevel();
			}
			this.model.loadMap(this.model.getMap().getLevel());
			this.model.getMap().setNumberOfLives(lives);
			this.model.getMap().setLevel(level);
			this.model.getMap().setNumberOfDiamonds(0);
			//System.out.println(/*this.model.getMap().getLevel()*/level);	//debug
			switch(this.model.getMap().getLevel()) {
			case 1 :													//config the die display
				this.model.getMap().setRequiredNumberOfDiamonds(0);
				//this.model.getMap().setLevel(1);		//debug
				//this.heroX = 1;
				//this.heroY = 1;
				this.model.getMap().setLevel(2);
				this.model.getMap().setNumberOfLives(3);
				break;
			case 2 :													//config the level 1
				this.model.getMap().setRequiredNumberOfDiamonds(8);
				//this.model.getMap().setLevel(2);		//debug
				this.heroX = 2;
				//System.out.println(heroX);	//debug
				this.heroY = 2;
				break;
			case 3 :													//config the level 2
				this.model.getMap().setRequiredNumberOfDiamonds(8);
				//				this.model.getMap().setLevel(3);		//debug
				this.heroX = 2;
				this.heroY = 2;
				break;
			case 4 :													//config the level 3
				this.model.getMap().setRequiredNumberOfDiamonds(10);
				//				this.model.getMap().setLevel(4);		//debug
				this.heroX = 2;
				this.heroY = 2;
				break;
			case 5 :													//config the level 4
				this.model.getMap().setRequiredNumberOfDiamonds(8);
				//				this.model.getMap().setLevel(5);		//debug
				this.heroX = 2;
				this.heroY = 2;
				break;
			case 6 :													//config the level 5
				this.model.getMap().setRequiredNumberOfDiamonds(13);
				//				this.model.getMap().setLevel(6);		//debug
				this.heroX = 1;
				this.heroY = 2;
				break;
			case 7 :													//config the win display
				this.model.getMap().setRequiredNumberOfDiamonds(0);
				//				this.model.getMap().setLevel(6);		//debug
				//this.heroX = 0;
				//this.heroY = 0;
				this.model.getMap().setLevel(2);
				this.model.getMap().setNumberOfLives(3);
				break;
			}
			break;
			//			case L2:							//old case to switch level with keyboard
			//				this.model.loadMap(2);
			//				break;
			//			case L3:
			//				this.model.loadMap(3);
			//				break;
			//			case L4:
			//				this.model.loadMap(4);
			//				break;
			//			case L5:
			//				this.model.loadMap(5);
			//				break;
			//			case L6:
			//				this.model.loadMap(6);
			//				break;								
		case UP:										//To move the hero up														
			hasMoved = this.model.getMap().heroMoveUp(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
			if (hasMoved) {
				heroY--;
			}
			break;
		case DOWN:										//To move the hero down	
			hasMoved = this.model.getMap().heroMoveDown(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
			if (hasMoved) {
				heroY++;
			}				
			break;
		case LEFT:										//To move the hero left	
			hasMoved = this.model.getMap().heroMoveLeft(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
			if (hasMoved) {
				heroX--;
			}
			break;
		case RIGHT:										//To move the hero right	
			hasMoved = this.model.getMap().heroMoveRight(this.model.getMap().getOnTheMapXY(heroX, heroY), heroX, heroY);
			if (hasMoved) {
				heroX++;
			}
			break;
		default:
			break;

		}

	}

	/**
	 * Method to get the View
	 * @return
	 */
	public IView getView() {
		return view;
	}
	/**
	 * Method to get the model
	 * @return
	 */
	public IModel getModel() {
		return model;
	}
	/**
	 * Method to get the x positon of the hero
	 * @return
	 */
	public int getHeroX() {
		return heroX;
	}
	/**
	 * Method to set the x positon of the hero
	 * @return
	 */
	public void setHeroX(int heroX) {
		this.heroX = heroX;
	}
	/**
	 * Method to get the y positon of the hero
	 * @return
	 */
	public int getHeroY() {
		return heroY;
	}
	/**
	 * Method to set the y positon of the hero
	 * @return
	 */
	public void setHeroY(int heroY) {
		this.heroY = heroY;
	}

	//	public void printDown() {			debug
	//		System.out.println("Down");
	//	}
	/**
	 * Method to get the level
	 * @return
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * Method to set the level
	 * @return
	 */
	public void setLevel(int level) {
		this.level = level;
	}

}