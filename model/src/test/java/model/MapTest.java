package model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;

public class MapTest {
	static Map map;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new Map(5,1);
	}
	
	@Test
	public void ExistMap() {
		assert this.map.getWidth() >= 1: "Error : id should be <=1";
		assert this.map.getHeight() >=1: "Error : id should be <=1";
	}
	
	@Test
	public void ID() {
		assertEquals(map.getId());
	}
	private void assertEquals(int id) {
		// TODO Auto-generated method stub
		
	}

}
