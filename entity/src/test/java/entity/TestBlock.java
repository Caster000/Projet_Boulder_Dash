package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBlock {

	int id = 1;
	TestBlock block;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		block = new TestBlock();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int expected = id;
		assertEquals(expected, block.id);
		System.out.println("Good Job!");
		
	}

}
