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
/**
 * 
 * @author Thomas Rivollet
 *
 */
public class Map extends Observable implements IMap {
	/** The width. */
	private int          width;

	/** The height. */
	private int          height;

	/** The on the map. */
	private IEntity[][] onTheMap;

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
	
	Timer timer;

	/**
	 * Timer to update the map constantly
	 */
	TimerTask task = new TimerTask() {
		public void run(){
			updateMap();
		}
	};

	/**
     * Gets the map.
     *
     * @return the onTheMap
     */
	public IEntity[][] getOnTheMap() {
		return onTheMap;// returns the map
	}
	/**
	 * Map constructor to create an empty map
	 */
	public Map() {
		timer = new Timer();
		onTheMap=new IEntity[1][1];
	}

//	public Map(final int id, final String key, final String message) {		old constructor
//		this.setId(id);
//		this.setKey(key);
//		this.setMessage(message);
//	}
	/**
	 * Map constructor with timer
	 * @param width
	 * @param height
	 */
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
     * @return the width
	 */
	@Override
	public final int getWidth() {
		return this.width;//return the width
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the new width
	 */
	public void setWidth(final int width) {
		this.width = width;//sets the width
	}

	/**
	 * Method to get the height of the map
	 *
     * @return the height
	 */
	@Override
	public final int getHeight() {
		return this.height;//return the height
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	public void setHeight(final int height) {
		this.height = height;//sets the height
	}

	/**
	 * Method to get an entity from a position on the map
	 *
     * @return the entity
	 */
	@Override
	public final IEntity getOnTheMapXY(final int x, final int y) {
		if (x <= width-1 && y <= height-1) {//if the coordinates are on the map
			return this.onTheMap[x][y];//returns the entity
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
		this.onTheMap[x][y] = entity; // sets the entity
	}

	/**
	 * generic function for moving left
	 * @param x
	 * @param y
	 */
	public void moveLeft(int x, int y) {
		this.onTheMap[x-1][y] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went left");		//debug
	}

	/**
	 * generic function for moving right
	 * @param x
	 * @param y
	 */
	public void moveRight(int x, int y) {
		this.onTheMap[x+1][y] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went right");		//debug
	}

	/**
	 * generic function for moving up
	 * @param x
	 * @param y
	 */
	public void moveUp(int x, int y) {
		this.onTheMap[x][y-1] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went up");		//debug
	}

	/**
	 * generic function for moving down
	 * @param x
	 * @param y
	 */
	public void moveDown(int x, int y) {
		this.onTheMap[x][y+1] = this.onTheMap[x][y];//the entity moves
		this.onTheMap[x][y] = new Empty();//when an entity leaves a space, it creates a new empty entity on the space
		//		System.out.println("Went down");		//debug
	}

	/**
	 * specific function for the hero to move up
	 * @param hero
	 * @param x
	 * @param y
	 * @return the has moved
	 */
	public boolean heroMoveUp(IEntity hero, int x, int y) {
		IEntity topEntity = this.getOnTheMapXY(x, y-1);//checks whant's the entity where the hero wanted to move
		if (topEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(topEntity, x, y);//checks if the hero dies or pick a diamond
			moveUp(x, y);//move the hero
			return true;//the hero has moved
		}else if (topEntity instanceof Door){//if the hero wants to go on a door
//			System.out.println("it's a door");		//debug
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveUp(x, y);//the hero move to the door
				try {
					setLevel(getLevel() + 1);//the level increment itself
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);//wait for the player to understand
					r.keyPress(KeyEvent.VK_1);//the level changes
//					System.out.println("Robot press");		//debug
					Thread.sleep(100);//wait for the player to understand
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;//the hero has moved
			}else {
//				System.out.println("can't move right");		//debug
				return false;//the hero hasn't moved
			}
		}
		return false;//the hero hasn't moved
	}

	/**
	 * specific function for the hero to move down
	 * @param hero
	 * @param x
	 * @param y
	 * @return the has moved
	 */
	public boolean heroMoveDown(IEntity hero, int x, int y) {
		IEntity downEntity = this.getOnTheMapXY(x, y+1);//checks what's the entity where the hero wanted to move
		if (downEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(downEntity, x, y);//checks if the hero dies or pick a diamond
			moveDown(x, y);//the hero move down
			return true;//the hero has moved
		}else if (downEntity instanceof Door){//if the entity is a door
//			System.out.println("it's a door");		//debug
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveDown(x, y);//the hero moves
				try {
					setLevel(getLevel() + 1);//the level increment itself
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);//wait for the player to understand
					r.keyPress(KeyEvent.VK_1);//the level changes
//					System.out.println("Robot press");		//debug
					Thread.sleep(100);//wait for the player to understand
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;//the hero has moved
			}else {
//				System.out.println("can't move right");		//debug
				return false;//the hero hasn't moved
			}
		}
		return false;//the hero hasn't moved
	}

	/**
	 * specific function for the hero to move left
	 * @param hero
	 * @param x
	 * @param y
	 * @return the has moved
	 */
	public boolean heroMoveLeft(IEntity hero, int x, int y) {
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);//checks what's the entity where the hero wanted to move
		if (leftEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(leftEntity, x, y);//checks if the hero dies or pick a diamond
			moveLeft(x, y);//the hero moves
			return true;//the hero has moved
		}else if (leftEntity instanceof Stone) {//if the entity is a stone
			IEntity leftLeftEntity = this.getOnTheMapXY(x-2, y);//checks what's the entity left to where the hero wanted to move
			if(leftLeftEntity instanceof Empty) {//if the stone can be pushed left where the hero wanted to move
				moveLeft(x-1, y);//the stone moves
				moveLeft(x, y);//the hero moves
//				System.out.println("pushed");		//debug
				return true;//the hero has moved
			}else {
				return false;//the hero hasn't moved
			}
		}else if (leftEntity instanceof Door){//if the hero wants to go on a door
//			System.out.println("it's a door");		//debug
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);//the hero moves
//				System.out.println("Win !");		//debug
				try {
					setLevel(getLevel() + 1);//the level increment itself
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);//wait for the player to understand
					r.keyPress(KeyEvent.VK_1);//the level changes
//					System.out.println("Robot press");		//debug
					Thread.sleep(100);//wait for the player to understand
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;//the hero has moved
			}else {
//				System.out.println("can't move right");		//debug
				return false;//the hero hasn't moved
			}
		}
		return false;//the hero hasn't moved
	}

	/**
	 * specific function for the hero to move right
	 * @param hero
	 * @param x
	 * @param y
	 * @return the has moved
	 */
	public boolean heroMoveRight(IEntity hero, int x, int y) {
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);//checks whant's the entity where the hero wanted to move
		if (rightEntity instanceof IPermeability) {//if the entity is penetrable
			HeroMovingChecks(rightEntity, x, y);//checks if the hero dies or pick a diamond
			moveRight(x, y);//the hero moves
			//On Titouan's code there's a function which updates the map, maybe we shall do something like that
			return true;
		}else if (rightEntity instanceof Stone) {//if the entity is a stone
			IEntity rightRightEntity = this.getOnTheMapXY(x+2, y);//checks what's the entity right to where the hero wanted to move
			if(rightRightEntity instanceof Empty) {//if the stone can be pushed left where the hero wanted to move
				moveRight(x+1, y);//the stone moves
				moveRight(x, y);//the hero moves
//				System.out.println("pushed");		//debug
				return true;//the hero has moved
			}
		}else if (rightEntity instanceof Door){//if the hero wants to go on a door
//			System.out.println("it's a door");		//debug
			if(this.getNumberOfDiamonds() >= requiredNumberOfDiamonds) {//when the players enters a door tile, it checks if he has the good number of diamonds and launches the victory cinematic
				moveRight(x, y);//the hero moves
//				System.out.println("Win !");		//debug
				try {
					setLevel(getLevel() + 1);//the level increment itself
					Robot r;
					r = new Robot();
					//    level--;
					Thread.sleep(1000);//wait for the player to understand
					r.keyPress(KeyEvent.VK_1);//the level changes
//					System.out.println("Robot press");		//debug
					Thread.sleep(100);//wait for the player to understand
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				return true;//the hero has moved
			}else {
				System.out.println("can't move right");//print a message for testing purposes
				return false;//the hero hasn't moved
			}
		}
		return false;//the hero hasn't moved
	}

	/**
	 * Method to check the entity where the hero wants to move
	 * @param e
	 * @param x
	 * @param y
	 */
	public void HeroMovingChecks(IEntity e, int x, int y) { 
		if (e instanceof Monster) {//if it's a monster
			killPlayer(x, y);//die because of the monster
		}else if (e instanceof Diamond) {//if it's a diamond
			//System.out.println("supposed to be taken");	//debug
			this.setNumberOfDiamonds(this.getNumberOfDiamonds() + 1);//increases the number of diamonds
			//System.out.println("Taken !");	//debug
			//System.out.println(this.getNumberOfDiamonds());	//debug
		}

	}

	/**
	 * Method for slide function
	 * Diamond and Stone fall when they are superimposed
	 * @param downEntity
	 * @param faller
	 * @param x
	 * @param y
	 * @return the direction the block has slide
	 */
	public int slide(IEntity downEntity, IGravity faller, int x, int y) {
		IEntity downLeftEntity = this.getOnTheMapXY(x-1, y+1);//checks what's the entity down right of the Stone
		IEntity downRightEntity = this.getOnTheMapXY(x+1, y+1);//checks what's the entity down left of the Stone
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);//checks what's the entity left of the stone
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);//checks what's the entity right of the stone

		if(downEntity instanceof Diamond || downEntity instanceof Stone || downEntity instanceof Wall) {//if below the stone, there's an entity the stone can slide on
			if (downLeftEntity instanceof Empty && leftEntity instanceof Empty) {//if both left and left down entity are empty
				slideLeft(downLeftEntity, faller, x, y);//we call the method which allows the entity to slide left
				return 1;//the codes return that the sliding succeed, and that the stone went left
			} else if(downRightEntity instanceof Empty && rightEntity instanceof Empty) {
				slideRight(downRightEntity, faller, x, y);
				return 2;//the codes return that the sliding succeed, and that the stone went right
			}
		}else if(faller.isFalling() == true) {//if the stone is already falling
			if(downLeftEntity instanceof Monster || downLeftEntity instanceof Hero || downLeftEntity instanceof Empty && leftEntity instanceof Empty) {//if there's a hero/monster/empty left down of it and and empty left of it
				slideLeft(downLeftEntity, faller, x, y);//we call the method which allows the entity to slide left
				if (downLeftEntity instanceof Hero) {//if the entity left below the stone if a hero
					killPlayer(x-1, y+1);//the hero dies
				} else if (downLeftEntity instanceof Monster) {//if the entity left below the stone if a monster
					killMonster(x-1, y+1);//the monster dies
				}
				return 1;//the codes return that the sliding succeed, and that the stone went left

			}else if(downRightEntity instanceof Monster || downRightEntity instanceof Hero || downRightEntity instanceof Empty && rightEntity instanceof Empty) {//if there's a hero/monster/empty right down of it and an empty right of it 
				slideRight(downRightEntity, faller, x, y);//we call the method which allows the entity to slide right
				if (downRightEntity instanceof Hero) {//if the entity right below the stone if a hero
					killPlayer(x+1, y+1);//the hero dies
				} else if (downRightEntity instanceof Monster) {//if the entity right below the stone if a monster
					killMonster(x+1, y+1);//the monster dies
				}
				return 2;//the codes return that the sliding succeed, and that the stone went right

			}
		}
		return 0;//the code returns that the sliding failed
	}
	
	/**
	 * Method for slide function to left
	 * @param downLeftEntity
	 * @param faller
	 * @param x
	 * @param y
	 */
	public void slideLeft(IEntity downLeftEntity, IGravity faller, int x, int y) {
		moveLeft(x, y);//the stone moves left
		fallerChecks(downLeftEntity, x, y);//the stone check if it kills some one
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
		moveRight(x, y);//the stone move right
		fallerChecks(downRightEntity, x, y);//the block checks if it kills someone
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
			killMonster(x, y+1);//the monster die because of a block
			return true;
		}else if (e instanceof Hero) {//if the hero is under a stone falling
			killPlayer(x, y+1);//the hero die because of a block
			return true;
		}
		return false;
	}

	/**
	 * Method to get the number of diamond required
	 * @return requiredNumberOfDiamonds
	 */
	public int getRequiredNumberOfDiamonds() {
		return requiredNumberOfDiamonds;
	}
	
	/**
	 * Method to set the number of diamond required
	 * @param requiredNumberOfDiamonds
	 */
	public void setRequiredNumberOfDiamonds(int requiredNumberOfDiamonds) {
		this.requiredNumberOfDiamonds = requiredNumberOfDiamonds;
	}

		public void run() {
//			System.out.println("time : " +getTimeSecond());
//			if(time ==30) {
//				System.out.println("Warning!");
//			}
//			if(time == 0) {
//				cancel();
//				System.out.println("Next level or restart");
//			if(time > 0){
//					System.out.println("You win");
//					this.numberOfDiamonds = 1;
//				}
//			}
//			time --;
		}
	
	/**
	 * Method to get the time
	 * @return time
	 */
	public int getTimeSecond() {
		return time;
	}

	/**
	 * Method to get the actual number of diamond
	 * @return numberOfDiamonds
	 */
	public int getNumberOfDiamonds() {
		return numberOfDiamonds;
	}

	/**
	 * Method to set the actual number of diamond
	 * @param numberOfDiamonds
	 */
	public void setNumberOfDiamonds(int numberOfDiamonds) {
		this.numberOfDiamonds = numberOfDiamonds;
	}

	/**
	 * Method to update the map and apply all the change
	 */
	public void updateMap() {
		int monster1x = 0;//the x position of the first monster
		int monster1y = 0;//the y position of the first monster
		int monster2x = 0;//the x position of the second monster
		int monster2y = 0;//the y position of the second monster
		int monster3x = 0;//the x position of the third monster
		int monster3y = 0;//the y position of the third monster
		int leftOrRight = 0;//for the sliding to know where it shall fall
		//		System.out.println(numberOfUpdates);							//debug
		numberOfUpdates++;//it increases the number of times this function was called
		for(int x=width-1; x > 0; x--)//browse the map vertically 
		{
			for(int y=height-1; y > 0; y--)//browse the map horizontally
			{
//				if (numberOfUpdates == 1) {		//debug
//					System.out.println(getOnTheMapXY(x, y).getClass() +" x : "+ x +" y : "+ y); //debug
//				}		//debug
				if(getOnTheMapXY(x, y) instanceof IGravity)//if there's a block
				{
					IGravity faller = (IGravity) onTheMap[x][y];//the block
					IEntity downEntity = this.getOnTheMapXY(x, y+1);//down the block
					IEntity downDownEntity = this.getOnTheMapXY(x, y+2);//down the entity down the block
					IEntity downDownLeftEntity = this.getOnTheMapXY(x-1, y+2);//left the entity down the entity down the block
					IEntity downDownRightEntity = this.getOnTheMapXY(x+1, y+2);//right the entity down the entity down the block

					if(downEntity instanceof Empty)//if the down entity is empty
					{
//						System.out.println(faller.isFalling());		//debug
						moveDown(x, y);//the block falls
						//						IGravity diam = (IGravity) onTheMap[x][y];//debug
						//						System.out.println("isFalling ? : " + faller.isFalling());//debug
						if (downDownEntity instanceof IPermeability) {//if the entity down the entity down the entity is crossable
							if (downDownEntity instanceof Diamond || downDownEntity instanceof Rock) {//if the entity down the entity down the block is a rock or a diamond
								faller.setIsFalling(false);//the block won't be falling
							}else {
								debug = 0;
								faller.setIsFalling(true);//the block will pursue falling

							}
						}else {
							faller.setIsFalling(false);//the block won't be falling
						}
					}else if (downEntity instanceof IPermeability && faller.isFalling()) {//if the entity down the block is crossable and that the entity is already falling
						if (downEntity instanceof Diamond || downEntity instanceof Rock) {//if the entity down the block is a rock or a diamond
//							System.out.println("no");		//debug
							debug++;//to prevent a bug, 
							if (debug > 40) {//to prevent a bug, if there's plenty of isFalling
								debug = 0;//restart
								faller.setIsFalling(false);//the blocks won't be falling anymore
							}
						}else {
							if(fallerChecks(downEntity, x, y)) {//if the stone killed a monster or a hero
//								System.out.println(faller.isFalling());		//debug
								moveDown(x, y);//fall
								if (downDownEntity instanceof IPermeability) {//if below the entity killed ther's a crossable tile
									if (downDownEntity instanceof Diamond || downDownEntity instanceof Rock) {//if it's a rock or a diamond
										faller.setIsFalling(false);//the block won't be falling anymore
									}else {
										debug = 0;//restart
										faller.setIsFalling(true);//the block will pursue falling

									}
								} else {
									faller.setIsFalling(false);//the block won't be falling anymore
								}
							}
						}
					}else {
						leftOrRight = slide(downEntity, faller, x, y);//sliding method to now where the block will fall
						if(leftOrRight == 1) {//if it's left
							if (downDownLeftEntity instanceof IPermeability) {//if the entity below the new position of the block is crossable
								if (downDownLeftEntity instanceof Diamond || downDownLeftEntity instanceof Rock) {//if it's a rock or a diamond
									faller.setIsFalling(false);//the block won't be falling anymore
								}else {
									debug = 0;//restart
									faller.setIsFalling(true);//the block will pursue falling

								}
							} else {
								faller.setIsFalling(false);//the block won't be falling anymore
							}
						}else if(leftOrRight == 2) {//if it's right
							if (downDownRightEntity instanceof IPermeability) {//if the entity below the new position of the block is crossable
								if (downDownLeftEntity instanceof Diamond || downDownRightEntity instanceof Rock) {//if it's a rock or a diamond
									faller.setIsFalling(false);//the block won't be falling anymore
								}else {
									debug = 0;//restart
									faller.setIsFalling(true);//the block will pursue falling

								}
							} else {
								faller.setIsFalling(false);//the block won't be falling anymore
							}
						}
					}
				} else if(getOnTheMapXY(x, y) instanceof Monster){//if the entity on the map is not a block but a monster
					if (monster1x == 0) {//if there's no referenced monster yet
						monster1x = x;//takes the coordinates
						monster1y = y;//takes the coordinates
					} else if (monster2x == 0){//if there's only one referenced monster yet
						//						System.out.println("il y a au moins deux monstres");			//debug
						monster2x = x;//takes the coordinates
						monster2y = y;//takes the coordinates
					} else {
						//						System.out.println("il y a trois monstres");			//debug
						monster3x = x;//takes the coordinates
						monster3y = y;//takes the coordinates
					}
					//						monsterMoving(x, y);			//debug
					//						System.out.println("A monster was supposed to move");			//debug
				}
			}
		}
		if (numberOfUpdates == 1) {//if it's the first time the function is called		
			if (monster1x != 0) {//if ther's a monster
				latestWhereToMove1 = monsterMoving(monster1x, monster1y, latestWhereToMove1);//the first monster moves
			}
			if (monster2x != 0) {//if ther's two monsters
				latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove2);//the second monster moves
			}
			if (monster3x != 0) {//if ther's three monsters
				latestWhereToMove3 = monsterMoving(monster2x, monster2y, latestWhereToMove3);//the third monster moves
			}
		}else {
			if ((oldMonster1x + 1 == monster1x || oldMonster1x - 1 == monster1x || oldMonster1x == monster1x) && (oldMonster1y + 1 == monster1y || oldMonster1y - 1 == monster1y || oldMonster1y == monster1y)) {//if the first monster is the same of the latest update
				if (monster1x != 0) {//if ther's a monster
					latestWhereToMove1 = monsterMoving(monster1x, monster1y, latestWhereToMove1);//the first monster moves
				}
				if ((oldMonster2x + 1 == monster2x || oldMonster2x - 1 == monster2x || oldMonster2x == monster2x) && (oldMonster2y + 1 == monster2y || oldMonster2y - 1 == monster2y || oldMonster2y == monster2y)) {//if the second monster is the same of the latest update
					if (monster2x != 0) {//if ther's two monsters
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove2);//the second monster moves
					}
					if (monster3x != 0) {//if ther's three monsters
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove3);//the third monster moves
					}
				} else {//if the second monster is the third monster of the latest update
					if (monster2x != 0) {//if ther's two monsters
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove3);//the second monster moves
					}
					if (monster3x != 0) {//if ther's three monsters
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove2);//the third monster moves
					}
				}
			} else if((oldMonster2x + 1 == monster1x || oldMonster2x - 1 == monster1x || oldMonster2x == monster1x) && (oldMonster2y + 1 == monster1y || oldMonster2y - 1 == monster1y || oldMonster2y == monster1y)) {//if the first monster is the second monster of the latest update
				if (monster1x != 0) {//if ther's a monster
					latestWhereToMove1 = monsterMoving(monster1x, monster1y, latestWhereToMove2);//the first monster moves
				}
				if ((oldMonster3x + 1 == monster2x || oldMonster3x - 1 == monster2x || oldMonster3x == monster2x) && (oldMonster3y + 1 == monster2y || oldMonster3y - 1 == monster2y || oldMonster3y == monster2y)) {//if the second monster is the third monster of the latest update
					if (monster2x != 0) {//if ther's two monsters
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove3);//the second monster moves
					}
					if (monster3x != 0) {//if ther's three monsters
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove1);//the third monster moves
					}
				}else {//if the second monster is the same of the latest update
					if (monster2x != 0) {//if ther's two monsters
						latestWhereToMove2 = monsterMoving(monster2x, monster2y, latestWhereToMove1);//the second monster moves
					}
					if (monster3x != 0) {//if ther's three monsters
						latestWhereToMove3 = monsterMoving(monster3x, monster3y, latestWhereToMove3);//the third monster moves
					}
				}
			}
		}
		oldMonster1x = monster1x;//save the coordinates
		oldMonster1y = monster1y;//save the coordinates
		oldMonster2x = monster2x;//save the coordinates
		oldMonster2y = monster2y;//save the coordinates
		oldMonster3x = monster3x;//save the coordinates
		oldMonster3y = monster3y;//save the coordinates


		setChanged();//save the changes
		notifyObservers();//notify the view
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
		this.onTheMap[x][y] = new Door();//the explosion
		this.onTheMap[x][y-1] = new Door();//the explosion
		this.onTheMap[x][y+1] = new Door();//the explosion
		this.onTheMap[x+1][y-1] = new Door();//the explosion
		this.onTheMap[x+1][y+1] = new Door();//the explosion
		this.onTheMap[x+1][y] = new Door();//the explosion
		this.onTheMap[x-1][y] = new Door();//the explosion
		this.onTheMap[x-1][y-1] = new Door();//the explosion
		this.onTheMap[x-1][y+1] = new Door();//the explosion
		try {

			Robot r;
			r = new Robot();
			//    level--;
			Thread.sleep(1000);//wait for the player to understand
			r.keyPress(KeyEvent.VK_1);//System.out.println("Robot press");	debug
			Thread.sleep(100);//wait for the player to understand
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
		//System.out.println("A monster is dead");	debug
		this.onTheMap[x][y] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x][y-1] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x][y+1] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x+1][y-1] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x+1][y+1] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x+1][y] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x-1][y] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x-1][y-1] = new Diamond();//the explosion leaves diamonds
		this.onTheMap[x-1][y+1] = new Diamond();//the explosion leaves diamonds


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
		IEntity downEntity = this.getOnTheMapXY(x, y+1);//the entity below the monster
		IEntity topEntity = this.getOnTheMapXY(x, y-1);//the entity upon the monster
		IEntity leftEntity = this.getOnTheMapXY(x-1, y);//the entity left of the monster
		IEntity rightEntity = this.getOnTheMapXY(x+1, y);//the entity right of the monster
		IEntity downLeftEntity = this.getOnTheMapXY(x-1, y+1);//the entity left below the monster
		IEntity topRightEntity = this.getOnTheMapXY(x+1, y-1);//the entity right upon the monster
		IEntity leftUpEntity = this.getOnTheMapXY(x-1, y-1);//the entity left upon the monster
		IEntity rightDownEntity = this.getOnTheMapXY(x+1, y+1);//the entity right below the monster
		//		System.out.println(downEntity.getClass());			//debug
		//		System.out.println(rightDownEntity.getClass());			//debug
		//		System.out.println(rightEntity.getClass());			//debug
		//		System.out.println(topRightEntity.getClass());			//debug
		//		System.out.println(topEntity.getClass());			//debug
		//		System.out.println(leftUpEntity.getClass());			//debug
		//		System.out.println(leftEntity.getClass());			//debug
		//		System.out.println(downLeftEntity.getClass());			//debug
		if (downEntity instanceof Empty) {//if there's an empty space below the monster
			whereToMove += 4;//0+4
		} else if (downEntity instanceof Hero) {//if there's a hero below the monster
			killPlayer(x, y);//die because of the monster
		}
		if (topEntity instanceof Empty) {//if there's an empty space upon the monster
			whereToMove += 2;//0+2 or 4+2
		}else if (topEntity instanceof Hero) {//if there's a hero upon the monster
			killPlayer(x, y);//die because of the monster
		}
		if (leftEntity instanceof Empty) {//if there's an empty space left of the monster
			whereToMove += 8;//8 or 10 or 14 or 12
		}else if (leftEntity instanceof Hero) {//if there's a hero left of the monster
			killPlayer(x, y);//die because of the monster
		}
		if (rightEntity instanceof Empty) {//if there's an empty space right of the monster
			whereToMove += 1;//1 or 3 or 5...
		}else if (rightEntity instanceof Hero) {//if there's a hero right of the monster
			killPlayer(x, y);//die because of the monster
		}
		if (downLeftEntity instanceof Empty || downLeftEntity instanceof Monster) {

		}else {//if there's something stable left behind the monster
			whereNotToMove += 4;//0+4
		}
		if (topRightEntity instanceof Empty || topRightEntity instanceof Monster) {

		}else {//if there's something stable right upon the monster
			whereNotToMove += 1;//0+1 or 4+1
		}
		if (leftUpEntity instanceof Empty || leftUpEntity instanceof Monster) {

		}else {//if there's something stable left upon the monster
			whereNotToMove += 2;//2 or 3 or 6 or 7
		}
		if (rightDownEntity instanceof Empty || rightDownEntity instanceof Monster) {

		}else {//if there's something stable right behind the monster
			whereNotToMove += 8;// 8 or 9 or 10...
		}
		//		System.out.println(whereToMove);			//debug
		//		System.out.println(whereNotToMove);			//debug
		switch (whereToMove) {//all the different cases
		case 1 ://the monster can only go right
			moveRight(x, y);//the monster moves right
			return 1;//the monster has gone right
		case 2 ://the monster can only go up
			moveUp(x, y);//the monster moves up
			return 2;//the monster has gone up
		case 3 ://the monster can go up or right
			if (latestWhereToMove == 8) {//if he went left last time
				moveUp(x, y);//the monster moves up
				return 2;//the monster has gone up
			}else {//if the monster went down last time
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			}
		case 4 ://the monster can only go down
			moveDown(x, y);//the monster moves down
			return 4;//the monster has gone down
		case 5 ://the monster can go down or right
			if (latestWhereToMove == 8) {//if the monster went left last time
				moveDown(x, y);//the monster moves down
				return 4;//the monster has gone down
			}else {//if the monster went up last time
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			}
		case 6 ://if the monster can go down or up
			if (latestWhereToMove == 2) {//if the monster went up last time
				moveUp(x, y);//the monster moves up
				return 2;//the monster has gone up
			}else {//if the monster went down last time
				moveDown(x, y);//the monster moves down
				return 4;//the monster has gone down
			}
		case 7 ://if the monster can go down, up or right
			if (latestWhereToMove == 4) {//if the monster went down last time
				moveDown(x, y);//the monster moves down
				return 4;//the monster has gone down
			}else if (latestWhereToMove == 8){//if the monster went left last time
				if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {//if there's something stable right upon the monster
					moveUp(x, y);//the monster moves up
					return 2;//the monster has gone up
				}else {//if there isn't something stable right upon the monster
					moveDown(x, y);//the monster moves down
					return 4;//the monster has gone down
				}
			}else {//if the monster up right last time
				moveUp(x, y);//the monster moves up
				return 2;//the monster has gone up
			}
		case 8 ://if the monster can only go left
			moveLeft(x, y);//the monster moves left
			return 8;//the monster has gone left
		case 9 ://if the monster can go left or right
			if (latestWhereToMove == 8) {//if the monster went left last time
				moveLeft(x, y);//the monster moves left
				return 8;//the monster has gone left
			}else {//if the monster went right last time
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			}
		case 10 ://if the monster can only go left or up
			if (latestWhereToMove == 1) {//if the monster went right last time
				moveUp(x, y);//the monster moves up
				return 2;//the monster has gone up
			}else {//if the monster has gone down last time
				moveLeft(x, y);//the monster moves left
				return 8;//the monster has gone left
			}
		case 11 ://if the monster can go left, right or up
			if (latestWhereToMove == 8) {//if the monster went left last time
				if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {//if there's something stable right upon the monster
					moveUp(x, y);//the monster moves up
					return 2;//the monster has gone up
				}else {//if there isn't something stable right upon the monster
					moveLeft(x, y);//the monster moves left
					return 8;//the monster has gone left
				}
			}else if (latestWhereToMove == 1) {//if the monster went right last time
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			}else if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left upon the monster
				moveLeft(x, y);//the monster moves left
				return 8;//the monster has gone left
			}else {//if there isn't something stable left upon the monster
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			}
		case 12 ://if the monster can go left or down
			if (latestWhereToMove == 1) {//if the monster went right last time
				moveDown(x, y);//the monster moves down
				return 4;//the monster has gone down
			} else {//if the monster went down last time
				moveLeft(x, y);//the monster moves left
				return 8;//the monster has gone left
			}
		case 13 :
			if (latestWhereToMove == 1) {//if the monster went right last time
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			} else if (latestWhereToMove == 8) {//if the monster went left last time
				moveLeft(x, y);//the monster moves left
				return 8;//the monster has gone left
			} else if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if the monster went down last time and if there's something stable right below the monster
				moveRight(x, y);//the monster moves right
				return 1;//the monster has gone right
			}else {//if there isn't something stable right below the monster
				moveLeft(x, y);//the monster moves left
				return 8;//the monster has gone left
			}
		case 14 :
			if (latestWhereToMove == 2) {//if the monster went up last time
				moveUp(x, y);//the monster moves up
				return 2;//the monster has gone up
			} else if (latestWhereToMove == 4) {//if the monster went down last time
				if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left upon the monster
					moveLeft(x, y);//the monster moves left
					return 8;//the monster has gone left
				}else {//if there isn't something stable left upon the monster
					moveDown(x, y);//the monster moves down
					return 4;//the monster has gone down
				}
			}else {//if the monster went right last time
				moveDown(x, y);//the monster moves down
				return 4;//the monster has gone down
			}
		case 15 :
			switch(latestWhereToMove) {//all the different previous directions
			case 8 :
				if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {//if there's something stable right upon the monster
					moveUp(x, y);//the monster moves up
					return 2;//the monster has gone up
				}else if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable right below the monster
					moveDown(x, y);//the monster moves down
					return 4;//the monster has gone down
				}else if(whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left upon the monster
					moveUp(x, y);//the monster moves up
					return 2;//the monster has gone up
				}else if (whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left below the monster
					moveDown(x, y);//the monster moves down
					return 4;//the monster has gone down
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);//the monster moves up
						return 2;//the monster has gone up
					} else if (random < 0.5) {
						moveLeft(x, y);//the monster moves left
						return 8;//the monster has gone left
					} else if (random < 0.75) {
						moveDown(x, y);//the monster moves down
						return 4;//the monster has gone down
					}else {
						moveRight(x, y);//the monster moves right
						return 1;//the monster has gone right
					}
				}
			case 4 :
				if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left upon the monster
					moveLeft(x, y);//the monster moves left
					return 8;//the monster has gone left
				}else if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {//if there's something stable right upon the monster
					moveRight(x, y);//the monster moves right
					return 1;//the monster has gone right
				}else if(whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left below the monster
					moveLeft(x, y);//the monster moves left
					return 8;//the monster has gone left
				}else if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable right below the monster
					moveRight(x, y);//the monster moves right
					return 1;//the monster has gone right
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);//the monster moves up
						return 2;//the monster has gone up
					} else if (random < 0.5) {
						moveLeft(x, y);//the monster moves left
						return 8;//the monster has gone left
					} else if (random < 0.75) {
						moveDown(x, y);//the monster moves down
						return 4;//the monster has gone down
					}else {
						moveRight(x, y);//the monster moves right
						return 1;//the monster has gone right
					}
				}
			case 2 :
				if (whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable right below the monster
					moveRight(x, y);//the monster moves right
					return 1;//the monster has gone right
				}else if (whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left below the monster
					moveLeft(x, y);//the monster moves left
					return 8;//the monster has gone left
				}else if(whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {//if there's something stable right upon the monster
					moveRight(x, y);//the monster moves right
					return 1;//the monster has gone right
				}else if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left upon the monster
					moveLeft(x, y);//the monster moves left
					return 8;//the monster has gone left
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);//the monster moves up
						return 2;//the monster has gone up
					} else if (random < 0.5) {
						moveLeft(x, y);//the monster moves left
						return 8;//the monster has gone left
					} else if (random < 0.75) {
						moveDown(x, y);//the monster moves down
						return 4;//the monster has gone down
					}else {
						moveRight(x, y);//the monster moves right
						return 1;//the monster has gone right
					}
				}
			case 1 :
				if (whereNotToMove == 4 || whereNotToMove == 5 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left below the monster
					moveDown(x, y);//the monster moves down
					return 4;//the monster has gone down
				}else if (whereNotToMove == 2 || whereNotToMove == 3 || whereNotToMove == 6 || whereNotToMove == 7 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable left upon the monster
					moveUp(x, y);//the monster moves up
					return 2;//the monster has gone up
				}else if(whereNotToMove == 8 || whereNotToMove == 9 || whereNotToMove == 10 || whereNotToMove == 11 || whereNotToMove == 12 || whereNotToMove == 13 || whereNotToMove == 14 || whereNotToMove == 15) {//if there's something stable right below the monster
					moveDown(x, y);//the monster moves down
					return 4;//the monster has gone down
				}else if (whereNotToMove == 1 || whereNotToMove == 3 || whereNotToMove == 5 || whereNotToMove == 7 || whereNotToMove == 9 || whereNotToMove == 11 || whereNotToMove == 13 || whereNotToMove == 15) {//if there's something stable right upon the monster
					moveUp(x, y);//the monster moves up
					return 2;//the monster has gone up
				}else {
					random = Math.random();
					if (random < 0.25) {
						moveUp(x, y);//the monster moves up
						return 2;//the monster has gone up
					} else if (random < 0.5) {
						moveLeft(x, y);//the monster moves left
						return 8;//the monster has gone left
					} else if (random < 0.75) {
						moveDown(x, y);//the monster moves down
						return 4;//the monster has gone down
					}else {
						moveRight(x, y);//the monster moves right
						return 1;//the monster has gone right
					}
				}
			}
		}
		return 0;
	}

	/**
	 * Method to get the level
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Method to set the level
	 * @param the level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Method to get the number of lives
	 * @return the numberOfLives
	 */
	public int getNumberOfLives() {
		return numberOfLives;
	}

	/**
	 * Method to set the number of lives
	 * @param the numberOfLives
	 */
	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

}