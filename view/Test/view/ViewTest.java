package view;

import static org.junit.Assert.*;


import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.UserOrder;

public class ViewTest {


	UserOrder userOrder;
	private KeyEvent L1;
	private String changeMap;
	private KeyEvent D;
	private KeyEvent Z;
	private KeyEvent Q;
	private KeyEvent S;
	
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
	public void Move() {
		assertEquals(KeyEvent(L1));
		assertEquals(KeyEvent(D));
		assertEquals(KeyEvent(Z));
		assertEquals(KeyEvent(Q));
		assertEquals(KeyEvent(S));
		
		
	}


	private String KeyEvent(KeyEvent L1) {
		// TODO Auto-generated method stub
		return changeMap;
	}

	private void assertEquals(String keyEvent) {
		// TODO Auto-generated method stub
		
	}



}
