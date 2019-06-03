package view;

import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import entity.Map;

public class TestView {
	
	private static IModel model;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new FModel();
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
	public void test() {
		ViewPanel viewPanel = new ViewPanel(new ViewFrame(model));
		assertNotNull("View Panel shouldn't be null", viewPanel);
	}

}

class FModel implements IModel{
	@Override
	public Map getMap() {
		return null;
	}
	

	@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return new Observable();
	}

	@Override
	public void setMapNull() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadMap(int id) {
		// TODO Auto-generated method stub
		
	}


	
}