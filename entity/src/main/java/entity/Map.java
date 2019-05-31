package entity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import entity.IEntity;
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

	/** The on the map. */
	private IEntity[][] onTheMap;

//	/** The id. */
//	private int            id;
//
//	/** The key. */
//	private String    key;
//
//	/** The message. */
//	private String    message;

	private int time = 120 ;

	/**The number of diamonds the level requires. */
	private int requiredNumberOfDiamonds = 1;

	/**The number of diamonds the hero has. */
	private int numberOfDiamonds = 0;

	/**The latest direction the first monster took. */
	private int latestWhereToMove1 = 1;

	/**The latest direction the second monster took. */
	private int latestWhereToMove2 = 1;

	/**The latest direction the third monster took. */
	private int latestWhereToMove3 = 1;

	/**The number the method updateMap was used. */
	private int numberOfUpdates = 0;

	/**The old x position of the first monster. */
	private int oldMonster1x = 0;

	/**The old y position of the first monster. */
	private int oldMonster1y = 0;

	/**The old x position of the second monster. */
	private int oldMonster2x = 0;

	/**The old y position of the second monster. */
	private int oldMonster2y = 0;

	/**The old x position of the third monster. */
	private int oldMonster3x = 0;

	/**The old y position of the third monster */
	private int oldMonster3y = 0;

	/**the level */
	private int level = 2;

	/** the number of lives the hero has*/
	private int numberOfLives = 3;

	/**A random number between 0 and 1, used to make random decision */
	private double random;

	/**To prevent the blocks to keep the is Falling operator to true even when they're not falling */
	private int debug = 0; 

	//timer
	TimerTask task = new TimerTask() {
		public void run(){
			updateMap();
		}
	};
	Timer timer;

	/**
     * Gets the map.
     *
     * @return the onTheMap
     */
	public IEntity[][] getOnTheMap() {
		return onTheMap;
	}

	public Map() {
		timer = new Timer();
		onTheMap=new IEntity[1][1];
	}

//	public Map(final int id, final String key, final String message) {
//		this.setId(id);
//		this.setKey(key);
//		this.setMessage(message);
//	}

	public Map( int width, int height) {
		timer=new Timer();
		timer.schedule(task, 200,200);
		this.setWidth(width);
		this.setHeight(height);
		onTheMap = new Entity[width][height];
	}

	/**
	 * Method to get the width of the map
	 * 
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

	/**
	 * Method to get the height of the map
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

	/**
	 * Method to get a position on the map
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


//	/**
//	 * Gets the id.
//	 *
//	 * @return the id
//	 */
//	public int getId() {
//		return this.id;
//	}
//
//	/**
//	 * Sets the id.
//	 *
//	 * @param id
//	 *          the new id
//	 */
//	public void setId(final int id) {
//		this.id = id;
//	}
//
//	/**
//	 * Gets the key.
//	 *
//	 * @return the key
//	 */
//	public String getKey() {
//		return this.key;
//	}
//
//	/**
//	 * Sets the key.
//	 *
//	 * @param key
//	 *          the new key
//	 */
//	public void setKey(final String key) {
//		this.key = key;
//	}
//
//	/**
//	 * Gets the message.
//	 *
//	 * @return the message
//	 */
//	public String getMessage() {
//		return this.message;
//	}
//
//	/**
//	 * Sets the message.
//	 *
//	 * @param message
//	 *          the new message
//	 */
//	public void setMessage(final String message) {
//		this.message = message;
//	}

	/**
	 * generic function for moving left
	 * @param x
	 * @param y
	 */
	public void moveLeft(int x, int y) {
		this.onTheMap[x-1][y] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went left");
	}

	/**
	 * generic function for moving right
	 * @param x
	 * @param y
	 */
	public void moveRight(int x, int y) {
		this.onTheMap[x+1][y] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went right");
	}

	/**
	 * generic function for moving up
	 * @param x
	 * @param y
	 */
	public void moveUp(int x, int y) {
		this.onTheMap[x][y-1] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went up");
	}

	/**
	 * generic function for moving down
	 * @param x
	 * @param y
	 */
	public void moveDown(int x, int y) {
		this.onTheMap[x][y+1] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went down");
	}

	/**
	 * specific function for the hero to move up
	 * @param hero
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean heroMoveUp(IEntity hero, int x, int y) {
		IEntity topEntity = this.getOnTheMapXY(x, y-1);//checks whant's the entity where the hero wanted to move
		if (topEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(topEntity, x, y);
			moveUp(x, y);
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (topEntity instanceof Door){
			System.out.println("it's a door");
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);
				try {
					setLevel(getLevel() + 1);
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_1);System.out.println("Robot press");
					Thread.sleep(100);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	/**
	 * specific function for the hero to move down
	 * @param hero
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean heroMoveDown(IEntity hero, int x, int y) {
		IEntity downEntity = this.getOnTheMapXY(x, y+1);//checks what's the entity where the hero wanted to move
		if (downEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(downEntity, x, y);
			moveDown(x, y);
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (downEntity instanceof Door){
			System.out.println("it's a door");
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);
				try {
					setLevel(getLevel() + 1);
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_1);System.out.println("Robot press");
					Thread.sleep(100);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	/**
	 * specific function for the hero to move left
	 * @param hero
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean heroMoveLeft(IEntity hero, int x, int y) {
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);//checks what's the entity where the hero wanted to move
		if (leftEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(leftEntity, x, y);
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
				try {
					setLevel(getLevel() + 1);
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_1);System.out.println("Robot press");
					Thread.sleep(100);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}

	/**
	 * specific function for the hero to move right
	 * @param hero
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean heroMoveRight(IEntity hero, int x, int y) {
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);//checks whant's the entity where the hero wanted to move
		if (rightEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(rightEntity, x, y);
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
				try {
					setLevel(getLevel() + 1);
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);
					r.keyPress(KeyEvent.VK_1);System.out.println("Robot press");
					Thread.sleep(100);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				return true;
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;
			}
		}
		return false;
	}
	/**
	 * Method to check the entity next to the hero
	 * @param e
	 * @param x
	 * @param y
	 */
	
	public void HeroMovingChecks(IEntity e, int x, int y) { 
		if (e instanceof Monster) {//different cases
			killPlayer(x, y);//die because of the monster
		}else if (e instanceof Diamond) {
			//System.out.println("supposed to be taken");	debug
			this.setNumberOfDiamonds(this.getNumberOfDiamonds() + 1);
			//System.out.println("Taken !");	debug
			//System.out.println(this.getNumberOfDiamonds());	debug
		}

	}

//	public boolean fall(int x, int y){
//		IGravity faller = (IGravity) onTheMap[x][y];
//		//		System.out.println(faller.isFalling());							//debug
//		IEntity downEntity = this.getOnTheMapXY(x, y+1);//checks what's the entity down of the Stone
//		if(!faller.isFalling()) {
//			//			System.out.println("je ne suis pas en train de tomber"); 				//debug
//			if(downEntity instanceof Empty){
//				moveDown(x, y);
//				return true;
//			}
//		}else if(downEntity instanceof IPermeability){
//			//			System.out.println("mais moi oui !");					//debug
//			if(downEntity instanceof Diamond || downEntity instanceof Rock){
//				return false;
//			}else {
//				fallerChecks(downEntity, x, y);
//				moveDown(x, y);
//				return true;
//			}
//		}
//		return false;
//	}
	/**
	 * Method for slide function
	 * Diamond and Stone fall when they are superimposed
	 * @param downEntity
	 * @param faller
	 * @param x
	 * @param y
	 * @return
	 */
	public int slide(IEntity downEntity, IGravity faller, int x, int y) {
		IEntity downLeftEntity = this.getOnTheMapXY(x-1, y+1);//checks what's the entity down right of the Stone
		IEntity downRightEntity = this.getOnTheMapXY(x+1, y+1);//checks what's the entity down left of the Stone
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);//checks what's the entity left of the stone
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);//checks what's the entity right of the stone

		if(downEntity instanceof Diamond || downEntity instanceof Stone || downEntity instanceof Wall) {
			if (downLeftEntity instanceof Empty && leftEntity instanceof Empty) {
				slideLeft(downLeftEntity, faller, x, y);//we call the method which allows the entity to slide left
				return 1;//the codes return that the sliding succeed

			} else if(downRightEntity instanceof Empty && rightEntity instanceof Empty) {
				slideRight(downRightEntity, faller, x, y);
				return 2;//the codes return that the sliding succeed

			}
		}else if(faller.isFalling() == true) {
			if(downLeftEntity instanceof Monster || downLeftEntity instanceof Hero || downLeftEntity instanceof Empty && leftEntity instanceof Empty) {
				slideLeft(downLeftEntity, faller, x, y);//we call the method which allows the entity to slide left
				return 1;//the codes return that the sliding succeed

			}else if(downRightEntity instanceof Monster || downRightEntity instanceof Hero || downRightEntity instanceof Empty && rightEntity instanceof Empty) {
				slideLeft(downRightEntity, faller, x, y);//we call the method which allows the entity to slide left
				return 2;//the codes return that the sliding succeed

			}
		}
		return 0;
	}
	/**
	 * Method for slide function to left
	 * @param downLeftEntity
	 * @param faller
	 * @param x
	 * @param y
	 */
	public void slideLeft(IEntity downLeftEntity, IGravity faller, int x, int y) {
		moveLeft(x, y);
		try {
			Thread.sleep(100);//a little pause in the execution so that the user can see the sliding
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fallerChecks(downLeftEntity, x, y);
//		moveDown(x-1, y);//to slide, you need to move left or right then down
		faller.setIsFalling(true);//the stone is now falling so it can kill monsters or hero
	}
	/**
	 * Method for slide function to right
	 * @param downLeftEntity
	 * @param faller
	 * @param x
	 * @param y
	 */
	public void slideRight(IEntity downRightEntity, IGravity faller, int x, int y) {
		moveRight(x, y);
		try {
			Thread.sleep(100);//a little pause in the execution so that the user can see the sliding
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fallerChecks(downRightEntity, x, y);
//		moveDown(x+1, y);//to slide, you need to move left or right then down
		faller.setIsFalling(true);//the stone is now falling so it can kill monsters or hero
	}
	/**
	 * Method to check when fall is call
	 * @param e
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean fallerChecks(IEntity e, int x, int y) { 
		if (e instanceof Monster) {//if a monster is under a stone falling
			killMonster(x, y+1);
			return true;
		}else if (e instanceof Hero) {//if the hero is under a stone falling
			killPlayer(x, y+1);
			return true;
		}
		return false;
	}

	/**
	 * Method to get the number of diamond required
	 * @return
	 */
	public int getRequiredNumberOfDiamonds() {
		return requiredNumberOfDiamonds;
	}
	/**
	 * Method to set the number of diamond required
	 * @return
	 */
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
	/**
	 * Method to get the time
	 * @return
	 */
	public int getTimeSecond() {
		return time;
	}
	/**
	 * Method to get the actual number of diamond
	 * @return
	 */
	public int getNumberOfDiamonds() {
		return numberOfDiamonds;
	}
	/**
	 * Method to set the actual number of diamond
	 * @return
	 */
	public void setNumberOfDiamonds(int numberOfDiamonds) {
		this.numberOfDiamonds = numberOfDiamonds;
	}
	/**
	 * Method to update the map and apply all the change
	 * @return
	 */
	public int updateMap() {
		int monster1x = 0;
		int monster1y = 0;
		int monster2x = 0;
		int monster2y = 0;
		int monster3x = 0;
		int monster3y = 0;
		//		System.out.println(numberOfUpdates);							//debug
		numberOfUpdates++;											//debug


		int leftOrRight = 0;
		for(int x=width-1; x > 0; x--)
		{
			for(int y=height-1; y > 0; y--)
			{
//				if (numberOfUpdates == 1) {
//					System.out.println(getOnTheMapXY(x, y).getClass() +" x : "+ x +" y : "+ y);
//				}
				if(getOnTheMapXY(x, y) instanceof IGravity)
				{
					IGravity faller = (IGravity) onTheMap[x][y];
					IEntity downEntity = this.getOnTheMapXY(x, y+1);
					IEntity downDownEntity = this.getOnTheMapXY(x, y+2);
					IEntity downDownLeftEntity = this.getOnTheMapXY(x-1, y+2);
					IEntity downDownRightEntity = this.getOnTheMapXY(x+1, y+2);

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
							debug++;
							if (debug > 40) {
								debug = 0;
								faller.setIsFalling(false);
							}
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
					}else {
						leftOrRight = slide(downEntity, faller, x, y);
						if(leftOrRight == 1) {
							if (downDownLeftEntity instanceof IPermeability) {
								if (downDownLeftEntity instanceof Diamond || downDownLeftEntity instanceof Rock) {
									faller.setIsFalling(false);
								}else {
									faller.setIsFalling(true);

								}
							} else {
								faller.setIsFalling(false);
							}
						}else if(leftOrRight == 2) {
							if (downDownRightEntity instanceof IPermeability) {
								if (downDownLeftEntity instanceof Diamond || downDownRightEntity instanceof Rock) {
									faller.setIsFalling(false);
								}else {
									faller.setIsFalling(true);

								}
							} else {
								faller.setIsFalling(false);
							}
						}
					}
				} else if(getOnTheMapXY(x, y) instanceof Monster){
					if (monster1x == 0) {
						monster1x = x;
						monster1y = y;
					} else if (monster2x == 0){
						//						System.out.println("il y a au moins deux monstres");			//debug
						monster2x = x;
						monster2y = y;
					} else {
						//						System.out.println("il y a trois monstres");			//debug
						monster3x = x;
						monster3y = y;
					}
					//						monsterMoving(x, y);			//debug
					//						System.out.println("A monster was supposed to move");			//debug
				}


			}
		}
		if (numberOfUpdates == 1) {		
			if (monster1x != 0) {
				latestWhereToMove1 = monsterMoving(monster1x, monster1y, latestWhereToMove1);
			}
			if (monster2x != 0) {
				latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove2);
			}
			if (monster3x != 0) {
				latestWhereToMove3 = monsterMoving(monster2x, monster2y, latestWhereToMove3);
			}
		}else {
			if ((oldMonster1x + 1 == monster1x || oldMonster1x - 1 == monster1x || oldMonster1x == monster1x) && (oldMonster1y + 1 == monster1y || oldMonster1y - 1 == monster1y || oldMonster1y == monster1y)) {
				if (monster1x != 0) {
					latestWhereToMove1 = monsterMoving(monster1x, monster1y, latestWhereToMove1);
				}
				if ((oldMonster2x + 1 == monster2x || oldMonster2x - 1 == monster2x || oldMonster2x == monster2x) && (oldMonster2y + 1 == monster2y || oldMonster2y - 1 == monster2y || oldMonster2y == monster2y)) {
					if (monster2x != 0) {
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove2);
					}
					if (monster3x != 0) {
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove3);
					}
				} else {
					if (monster2x != 0) {
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove3);
					}
					if (monster3x != 0) {
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove2);
					}
				}
			} else if((oldMonster2x + 1 == monster1x || oldMonster2x - 1 == monster1x || oldMonster2x == monster1x) && (oldMonster2y + 1 == monster1y || oldMonster2y - 1 == monster1y || oldMonster2y == monster1y)) {
				if (monster1x != 0) {
					latestWhereToMove1 = monsterMoving(monster1x, monster1y, latestWhereToMove2);
				}
				if ((oldMonster3x + 1 == monster2x || oldMonster3x - 1 == monster2x || oldMonster3x == monster2x) && (oldMonster3y + 1 == monster2y || oldMonster3y - 1 == monster2y || oldMonster3y == monster2y)) {
					if (monster2x != 0) {
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove3);
					}
					if (monster3x != 0) {
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove1);
					}
				}else {
					if (monster2x != 0) {
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove1);
					}
					if (monster3x != 0) {
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove3);
					}
				}
			}
		}
		oldMonster1x = monster1x;
		oldMonster1y = monster1y;
		oldMonster2x = monster2x;
		oldMonster2y = monster2y;
		oldMonster3x = monster3x;
		oldMonster3y = monster3y;


		setChanged();
		notifyObservers();
		return 0;
	}

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return this;
	}
	/**
	 * Method to kill the player
	 * @param x
	 * @param y
	 */
	private void killPlayer(int x, int y){
		setNumberOfLives(getNumberOfLives() - 1);
		//System.out.println("The hero is dead");	debug
		this.onTheMap[x][y] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x][y-1] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x][y+1] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y-1] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y+1] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x+1][y] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y-1] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		this.onTheMap[x-1][y+1] = new Door();//when an entity leaves a space, it creates a new empty entity on the space
		try {

			Robot r;
			r = new Robot();
			//    level--;
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_1);//System.out.println("Robot press");	debug
			Thread.sleep(100);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * Method to kill a monster
	 * @param x
	 * @param y
	 */
	private void killMonster(int x, int y) {
		System.out.println("A monster is dead");
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
	/**
	 * Specific method to move monsters
	 * @param x
	 * @param y
	 * @param latestWhereToMove
	 * @return
	 */
	private int monsterMoving(int x, int y, int latestWhereToMove) {
		int whereToMove = 0;//bouger à droite = 1, bouger en haut = 2, bouger en bas = 4, bouger à gauche = 8
		int whereNotToMove = 0;//mur à droite-haut = 1, bouger en haut-gauche = 2, mur en bas-droite = 8, mur à gauche-bas = 4
		IEntity downEntity = this.getOnTheMapXY(x, y+1);
		IEntity topEntity = this.getOnTheMapXY(x, y-1);
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);
		IEntity downLeftEntity = this.getOnTheMapXY(x-1, y+1);
		IEntity topRightEntity = this.getOnTheMapXY(x+1, y-1);
		IEntity leftUpEntity = this.getOnTheMapXY(x-1, y-1);
		IEntity rightDownEntity = this.getOnTheMapXY(x+1, y+1);
		//		System.out.println(downEntity.getClass());
		//		System.out.println(rightDownEntity.getClass());
		//		System.out.println(rightEntity.getClass());
		//		System.out.println(topRightEntity.getClass());
		//		System.out.println(topEntity.getClass());
		//		System.out.println(leftUpEntity.getClass());
		//		System.out.println(leftEntity.getClass());
		//		System.out.println(downLeftEntity.getClass());
		if (downEntity instanceof Empty) {
			whereToMove += 4;
		} else if (downEntity instanceof Hero) {
			killPlayer(x, y);//die because of the monster
		}
		if (topEntity instanceof Empty) {
			whereToMove += 2;
		}else if (topEntity instanceof Hero) {
			killPlayer(x, y);//die because of the monster
		}
		if (leftEntity instanceof Empty) {
			whereToMove += 8;
		}else if (leftEntity instanceof Hero) {
			killPlayer(x, y);//die because of the monster
		}
		if (rightEntity instanceof Empty) {
			whereToMove += 1;
		}else if (rightEntity instanceof Hero) {
			killPlayer(x, y);//die because of the monster
		}
		if (downLeftEntity instanceof Empty || downLeftEntity instanceof Monster) {

		}else {
			whereNotToMove += 4;
		}
		if (topRightEntity instanceof Empty || topRightEntity instanceof Monster) {

		}else {
			whereNotToMove += 1;
		}
		if (leftUpEntity instanceof Empty || leftUpEntity instanceof Monster) {

		}else {
			whereNotToMove += 2;
		}
		if (rightDownEntity instanceof Empty || rightDownEntity instanceof Monster) {

		}else {
			whereNotToMove += 8;
		}
		//		System.out.println(whereToMove);
		//		System.out.println(whereNotToMove);
		//		try {
		//			Thread.sleep(1000);
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		switch (whereToMove) {
		case 1 :
			moveRight(x, y);
			return 1;
		case 2 :
			moveUp(x, y);
			return 2;
		case 3 :
			if (latestWhereToMove == 8) {
				moveUp(x, y);
				return 2;
			}else {
				moveRight(x, y);
				return 1;
			}
		case 4 :
			moveDown(x, y);
			return 4;
		case 5 :
			if (latestWhereToMove == 8) {
				moveDown(x, y);
				return 4;
			}else {
				moveRight(x, y);
				return 1;
			}
		case 6 :
			if (latestWhereToMove == 2) {
				moveUp(x, y);
				return 2;
			}else {
				moveDown(x, y);
				return 4;
			}
		case 7 :
			if (latestWhereToMove == 4) {
				moveDown(x, y);
				return 4;
			}else if (latestWhereToMove == 8){
				if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {
					moveUp(x, y);
					return 2;
				}else {
					moveDown(x, y);
					return 4;
				}
			}else {
				moveUp(x, y);
				return 2;
			}
		case 8 :
			moveLeft(x, y);
			return 8;
		case 9 :
			if (latestWhereToMove == 8) {
				moveLeft(x, y);
				return 8;
			}else {
				moveRight(x, y);
				return 1;
			}
		case 10 :
			if (latestWhereToMove == 1) {
				moveUp(x, y);
				return 2;
			}else {
				moveLeft(x, y);
				return 8;
			}
		case 11 :
			if (latestWhereToMove == 8) {
				if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {
					moveUp(x, y);
					return 2;
				}else {
					moveLeft(x, y);
					return 8;
				}
			}else if (latestWhereToMove == 1) {
				moveRight(x, y);
				return 1;
			}else if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {
				moveLeft(x, y);
				return 8;
			}else {
				moveRight(x, y);
				return 1;
			}
		case 12 :
			if (latestWhereToMove == 1) {
				moveDown(x, y);
				return 4;
			} else {
				moveLeft(x, y);
				return 8;
			}
		case 13 :
			if (latestWhereToMove == 1) {
				moveRight(x, y);
				return 1;
			} else if (latestWhereToMove == 8) {
				moveLeft(x, y);
				return 8;
			} else if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
				moveRight(x, y);
				return 1;
			}else {
				moveLeft(x, y);
				return 8;
			}
		case 14 :
			if (latestWhereToMove == 2) {
				moveUp(x, y);
				return 2;
			} else if (latestWhereToMove == 4) {
				if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveLeft(x, y);
					return 8;
				}else {
					moveDown(x, y);
					return 4;
				}
			}else {
				moveDown(x, y);
				return 4;
			}
		case 15 :
			switch(latestWhereToMove) {
			case 8 :
				if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {
					moveUp(x, y);
					return 2;
				}else if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveDown(x, y);
					return 4;
				}else if(whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveUp(x, y);
					return 2;
				}else if (whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveDown(x, y);
					return 4;
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);
						return 2;
					} else if (random < 0.5) {
						moveLeft(x, y);
						return 8;
					} else if (random < 0.75) {
						moveDown(x, y);
						return 4;
					}else {
						moveRight(x, y);
						return 1;
					}
				}
			case 4 :
				if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveLeft(x, y);
					return 8;
				}else if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {
					moveRight(x, y);
					return 1;
				}else if(whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveLeft(x, y);
					return 8;
				}else if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveRight(x, y);
					return 1;
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);
						return 2;
					} else if (random < 0.5) {
						moveLeft(x, y);
						return 8;
					} else if (random < 0.75) {
						moveDown(x, y);
						return 4;
					}else {
						moveRight(x, y);
						return 1;
					}
				}
			case 2 :
				if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveRight(x, y);
					return 1;
				}else if (whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveLeft(x, y);
					return 8;
				}else if(whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {
					moveRight(x, y);
					return 1;
				}else if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveLeft(x, y);
					return 8;
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);
						return 2;
					} else if (random < 0.5) {
						moveLeft(x, y);
						return 8;
					} else if (random < 0.75) {
						moveDown(x, y);
						return 4;
					}else {
						moveRight(x, y);
						return 1;
					}
				}
			case 1 :
				if (whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveDown(x, y);
					return 4;
				}else if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveUp(x, y);
					return 2;
				}else if(whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {
					moveDown(x, y);
					return 4;
				}else if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {
					moveUp(x, y);
					return 2;
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);
						return 2;
					} else if (random < 0.5) {
						moveLeft(x, y);
						return 8;
					} else if (random < 0.75) {
						moveDown(x, y);
						return 4;
					}else {
						moveRight(x, y);
						return 1;
					}
				}
			}
		}
		return 0;
	}
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
	/**
	 * Method to get the number of lives
	 * @return
	 */
	public int getNumberOfLives() {
		return numberOfLives;
	}
	/**
	 * Method to set the number of lives
	 * @return
	 */
	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

}