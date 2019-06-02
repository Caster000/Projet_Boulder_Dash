package controller;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;
import entity.mobile.Hero;

public class MovementTest {
	
	private static Map map;
	private Hero hero;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero();
		map = new Map(5,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMovingHero() {
		int heroX = 1;
		int heroY = 1;
		MovementTest.map.moveDown(heroX, heroY+1);
		MovementTest.map.hasChanged();
		equals(MovementTest.map.heroMoveDown(hero, 1, 2));
		System.out.println("HerosHasMove");
		
	}

}