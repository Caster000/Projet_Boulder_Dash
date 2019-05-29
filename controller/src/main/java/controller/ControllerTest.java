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
	private int heroX = 1;
	private int heroY = 1;
	private Hero hero;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map();
		this.hero = new Hero();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int id = 0;
		this.model.loadMap(id);
		Assert.assertEquals(hero, this.model.getMap().getMessage());
	}

}
