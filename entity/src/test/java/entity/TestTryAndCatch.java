package entity;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTryAndCatch {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void thisShouldFailIfExceptionCaught() {
		
		try {
			Thread.sleep(10);//a little pause in the execution so that the user can see the sliding
		} catch (InterruptedException e) {
			Assert.fail("Exception" + e);
		}
	}
}

