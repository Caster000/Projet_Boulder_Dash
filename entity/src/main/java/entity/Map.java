package entity;

import java.awt.event.KeyEvent;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import entity.IEntity;
import entity.mobile.Block;
import entity.mobile.Diamond;
import entity.mobile.Hero;
import entity.mobile.IGravity;
import entity.mobile.Monster;
import entity.mobile.Stone;
import entity.motionless.Door;
import entity.motionless.Empty;
import entity.motionless.Rock;
import entity.motionless.Wall;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Map extends Observable implements IMap {
	/** The width. */
	private int          width;

	/** The height. */
	private int          height;

	/** The on the road. */
	private IEntity[][] onTheMap;

	/** The id. */
	private int            id;

	/** The key. */
	private String    key;

	/** The message. */
	private String    message;

	private int time = 120 ;

	private int requiredNumberOfDiamonds = 1;

	private int numberOfDiamonds = 0;

	//timer
	TimerTask task = new TimerTask() {
		public void run(){
			updateMap();
		}
	};
	Timer timer;

	public IEntity[][] getOnTheMap() {
		return onTheMap;
	}

	public Map() {
		timer = new Timer();
		onTheMap=new IEntity[1][1];
	}

	public Map(final int id, final String key, final String message) {
		this.setId(id);
		this.setKey(key);
		this.setMessage(message);
	}

	public Map( int width, int height) {
		timer=new Timer();
		timer.schedule(task, 200,200);
		this.setWidth(width);
		this.setHeight(height);
		onTheMap = new Entity[width][height];
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
	public void setWidth(final int width) {
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
	public void setHeight(final int height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
	 */
	@Override
	public final IEntity getOnTheMapXY(final int x, final int y) {
		if (x <= width-1 && y <= height-1) {
			return this.onTheMap[x][y];
		}
		return null;
	}

	/**
	 * Sets the on the map XY.
	 *
	 * @param entity
	 *            the element
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void setOnTheMapXY(final IEntity entity, final int x, final int y) {
		this.onTheMap[x][y] = entity;
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

	//generic function for moving left
	public void moveLeft(int x, int y) {
		this.onTheMap[x-1][y] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went left");
	}

	//generic function for moving right
	public void moveRight(int x, int y) {
		this.onTheMap[x+1][y] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went right");
	}

	//generic function for moving up
	public void moveUp(int x, int y) {
		this.onTheMap[x][y-1] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went up");
	}

	//generic function for moving down
	public void moveDown(int x, int y) {
		this.onTheMap[x][y+1] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went down");
	}

	//specific function for the hero to move up
	public boolean heroMoveUp(IEntity hero, int x, int y) {
		updateMap();
		IEntity topEntity = this.getOnTheMapXY(x, y-1);//checks whant's the entity where the hero wanted to move
		if (topEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(topEntity, hero);
			moveUp(x, y);
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (topEntity instanceof Door){
			System.out.println("it's a door");
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);
				System.out.println("Win !");
				System.out.println("press 1");
				//				level++;
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	//specific function for the hero to move down
	public boolean heroMoveDown(IEntity hero, int x, int y) {
		updateMap();
		IEntity downEntity = this.getOnTheMapXY(x, y+1);//checks what's the entity where the hero wanted to move
		if (downEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(downEntity, hero);
			moveDown(x, y);
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (downEntity instanceof Door){
			System.out.println("it's a door");
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);
				System.out.println("Win !");
				System.out.println("press 1");
				//				level++;
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	//specific function for the hero to move left
	public boolean heroMoveLeft(IEntity hero, int x, int y) {
		updateMap();
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);//checks what's the entity where the hero wanted to move
		if (leftEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(leftEntity, hero);
			moveLeft(x, y);
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (leftEntity instanceof Stone) {
			IEntity leftLeftEntity = this.getOnTheMapXY(x-2, y);//checks what's the entity left to where the hero wanted to move
			if(leftLeftEntity instanceof Empty) {
				moveLeft(x-1, y);
				moveLeft(x, y);
				System.out.println("pushed");
				return true;
			}else {
				return false;
			}

		}else if (leftEntity instanceof Door){
			System.out.println("it's a door");
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);
				System.out.println("Win !");
				System.out.println("press 1");
				//				level++;
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	//specific function for the hero to move right
	public boolean heroMoveRight(IEntity hero, int x, int y) {
		updateMap();
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);//checks whant's the entity where the hero wanted to move
		if (rightEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(rightEntity, hero);
			moveRight(x, y);
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (rightEntity instanceof Stone) {
			IEntity rightRightEntity = this.getOnTheMapXY(x+2, y);//checks what's the entity right to where the hero wanted to move
			if(rightRightEntity instanceof Empty) {
				moveRight(x+1, y);
				moveRight(x, y);
				System.out.println("pushed");
				return true;
			}
		}else if (rightEntity instanceof Door){
			System.out.println("it's a door");
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);
				System.out.println("Win !");
				System.out.println("press 1");
				//				level++;
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	public void HeroMovingChecks(IEntity e, IEntity hero) { 
		if (e instanceof Monster) {//different cases
			hero.die();//die because of the monster
		}else if (e instanceof Diamond) {
			System.out.println("supposed to be taken");
			this.setNumberOfDiamonds(this.getNumberOfDiamonds() + 1);
			System.out.println("Taken !");
			System.out.println(this.getNumberOfDiamonds());
		}

	}

	public boolean fall(int x, int y){
		IGravity faller = (IGravity) onTheMap[x][y];
		//		System.out.println(faller.isFalling());							//debug
		IEntity downEntity = this.getOnTheMapXY(x, y+1);//checks what's the entity down of the Stone
		if(!faller.isFalling()) {
			//			System.out.println("je ne suis pas en train de tomber"); 				//debug
			if(downEntity instanceof Empty){
				moveDown(x, y);
				return true;
			}
		}else if(downEntity instanceof IPermeability){
			//			System.out.println("mais moi oui !");					//debug
			if(downEntity instanceof Diamond || downEntity instanceof Rock){
				return false;
			}else {
				fallerChecks(downEntity, x, y);
				moveDown(x, y);
				return true;
			}
		}
		return false;
	}

	public boolean slide(IEntity downEntity, Block B, int x, int y) {
		IEntity downLeftEntity = this.getOnTheMapXY(x-1, y);//checks what's the entity down right of the Stone
		IEntity downRightEntity = this.getOnTheMapXY(x+1, y);//checks what's the entity down left of the Stone
		IEntity leftEntity = this.getOnTheMapXY(x-1, y-1);//checks what's the entity left of the stone
		IEntity rightEntity = this.getOnTheMapXY(x+1, y-1);//checks what's the entity right of the stone

		if(downEntity instanceof Diamond || downEntity instanceof Stone || downEntity instanceof Wall) {
			if (downLeftEntity instanceof Empty && leftEntity instanceof Empty) {
				slideLeft(downLeftEntity, B, x, y);//we call the method which allows the entity to slide left
				return true;//the codes return that the sliding succeed

			} else if(downRightEntity instanceof Empty && rightEntity instanceof Empty) {
				slideRight(downRightEntity, B, x, y);
				return true;//the codes return that the sliding succeed

			}
		}else if(B.isFalling() == true) {
			if(downLeftEntity instanceof Monster || downLeftEntity instanceof Hero || downLeftEntity instanceof Empty && leftEntity instanceof Empty) {
				slideLeft(downLeftEntity, B, x, y);//we call the method which allows the entity to slide left
				return true;//the codes return that the sliding succeed

			}else if(downRightEntity instanceof Monster || downRightEntity instanceof Hero || downRightEntity instanceof Empty && rightEntity instanceof Empty) {
				slideLeft(downLeftEntity, B, x, y);//we call the method which allows the entity to slide left
				return true;//the codes return that the sliding succeed

			}
		}
		return false;
	}

	public void slideLeft(IEntity downLeftEntity, Block B, int x, int y) {
		moveLeft(x, y);
		try {
			Thread.sleep(10);//a little pause in the execution so that the user can see the sliding
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fallerChecks(downLeftEntity, x, y);
		moveDown(x-1, y);//to slide, you need to move left or right then down
		B.setIsFalling(true);//the stone is now falling so it can kill monsters or hero
	}

	public void slideRight(IEntity downRightEntity, Block B, int x, int y) {
		moveRight(x, y);
		try {
			Thread.sleep(10);//a little pause in the execution so that the user can see the sliding
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fallerChecks(downRightEntity, x, y);
		moveDown(x-1, y);//to slide, you need to move left or right then down
		B.setIsFalling(true);//the stone is now falling so it can kill monsters or hero
	}

	public boolean fallerChecks(IEntity e, int x, int y) { 
		if (e instanceof Monster) {//if a monster is under a stone falling
			e.die();//hero die because of the stone
			killMonster(x, y+1);
			return true;
		}else if (e instanceof Hero) {//if the hero is under a stone falling
			e.die();//hero die because of the stone
			killPlayer(x, y+1);
			return true;
		}
		return false;
	}


	public int getRequiredNumberOfDiamonds() {
		return requiredNumberOfDiamonds;
	}

	public void setRequiredNumberOfDiamonds(int requiredNumberOfDiamonds) {
		this.requiredNumberOfDiamonds = requiredNumberOfDiamonds;
	}

	//	@Override
	//	public void run() {
	//		System.out.println("time : " +getTimeSecond());
	//		if(time ==30) {
	//			System.out.println("Warning!");
	//		}
	//		if(time == 0) {
	//			cancel();
	//			System.out.println("Next level or restart");
	//		if(time > 0){
	//				System.out.println("You win");
	//				this.numberOfDiamonds = 1;
	//			}
	//		}
	//		time --;
	//	}

	public int getTimeSecond() {
		return time;
	}

	public int getNumberOfDiamonds() {
		return numberOfDiamonds;
	}

	public void setNumberOfDiamonds(int numberOfDiamonds) {
		this.numberOfDiamonds = numberOfDiamonds;
	}

	public void updateMap() {
		for(int x=width-1; x > 0; x--)
		{
			for(int y=height-1; y > 0; y--)
			{
				if(getOnTheMapXY(x, y) instanceof IGravity)
				{

					IGravity faller = (IGravity) onTheMap[x][y];
					IEntity downEntity = this.getOnTheMapXY(x, y+1);
					IEntity downDownEntity = this.getOnTheMapXY(x, y+2);

					if(downEntity instanceof Empty)
					{
						System.out.println(faller.isFalling());
						moveDown(x, y);//need to do at end
						//						IGravity diam = (IGravity) onTheMap[x][y];//debug
						//						System.out.println("isFalling ? : " + faller.isFalling());//debug
						if (downDownEntity instanceof IPermeability) {
							if (downDownEntity instanceof Diamond || downDownEntity instanceof Rock) {
								faller.setIsFalling(false);
							}else {
								faller.setIsFalling(true);

							}
						}else {
							faller.setIsFalling(false);
						}
					}else if (downEntity instanceof IPermeability && faller.isFalling()) {
						if (downEntity instanceof Diamond || downEntity instanceof Rock) {
							System.out.println("no");
						}else {
							if(fallerChecks(downEntity, x, y)) {
								System.out.println(faller.isFalling());
								moveDown(x, y);//need to do at end
								if (downDownEntity instanceof IPermeability) {
									if (downDownEntity instanceof Diamond || downDownEntity instanceof Rock) {
										faller.setIsFalling(false);
									}else {
										faller.setIsFalling(true);

									}
								} else {
									faller.setIsFalling(false);
								}
							}
						}


						//					else if(DownEntity(y, x) instanceof ISliding)
						//					{
						//						if( (getRightEntity(y, x) instanceof Air) && (getRightBotEntity(y, x) instanceof Air))
						//						{
						//							moveRight(y, x);
						//						}
						//						else if( (getLeftEntity(y, x) instanceof Air) && (getLeftBotEntity(y, x) instanceof Air))
						//						{
						//							moveLeft(y, x);
						//						}
						//					}
					}
				}
			}
		}


		setChanged();
		notifyObservers();

	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return this;
	}

	//	public int getLevel() {
	//		return level;
	//	}
	//
	//
	//	public void setLevel(int level) {
	//		this.level = level;
	//	}

	private void killPlayer(int x, int y) {
		System.out.println("Hero is dead");
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x][y-1] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x][y+1] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y-1] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y+1] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y-1] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y+1] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space


	}

	private void killMonster(int x, int y) {
		System.out.println("Hero is dead");
		this.onTheMap[x][y] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x][y-1] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x][y+1] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y-1] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y+1] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y-1] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y+1] = new Diamond();//when an entity leaves a space, it creates a new empty entity on the space


	}

}