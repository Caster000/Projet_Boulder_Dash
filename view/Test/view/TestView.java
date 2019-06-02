package view;

import static org.junit.Assert.*;

import java.awt.Frame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.Map;

public class TestView {

	ViewFrame viewFrame;
	Map map;
	private IModel model;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		map = new Map(5,5);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		this.viewFrame.setVisible(true);
		assert this.viewFrame.getModel() != null;
	}

}
