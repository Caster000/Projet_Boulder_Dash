package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.IEntity;
import entity.Map;
import entity.mobile.Hero;

public class ControllerTest {
	
	private IModel model;
	private Map map;
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
		map = new Map();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int heroX = 1;
		int heroY = 1;
		
		assert this.map.heroMoveDown(hero, heroX + 1, heroY);
	}

}
