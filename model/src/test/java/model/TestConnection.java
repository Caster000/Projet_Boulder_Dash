package model;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;

public class TestConnection {

		private TestConnection connection;
		private DAOMap DAOMap;
		private Map map;
		
		@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		connection = new TestConnection();
		map = new Map(5,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assert this.connection != null;
		this.map.getLevel();
		this.map.getWidth();
		this.map.getHeight();
		this.getDAOMap();
	}

	public DAOMap getDAOMap() {
		return DAOMap;
	}

	public void setDAOMap(DAOMap dAOMap) {
		DAOMap = dAOMap;
	}
	
	/*@Test
    public void testGetInstance() {
        assertEquals("DBConnection should implement singleton pattern", connection, connection.testGetInstance());
    }

    @Test
    public void testGetInstanceNotNull() {
        assertNotNull("DBConnection shouldn't be null", connection.testGetInstance());
    }

    @Test
    public void testGetConnection() {
        assertNotNull("Connection shouldn't be null", DAOMap.);
    }*/

}
