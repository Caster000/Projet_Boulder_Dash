package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class Testdiamond {

	int id = 1;
	Testdiamond diamond;
	boolean isFalling = false;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		diamond = new Testdiamond();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * tests if the diamond have the correct id
	 */
	
	@Test
	public void test() { 
		int expected = id;
		assertEquals(expected, diamond.id);
	}
	
	
	
	@Test
	public void testisFalling() throws Exception {	
		diamond = new Testdiamond();
		assertFalse(diamond.isFalling);
	}

}
