package model;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.Map;

public class MapTest {
	static Map map;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new Map(5,5);
	}
	
	@Test
	public void MapExist() {
		assert MapTest.map.getWidth() >= 1: "Error : id should be <=1";
		assert MapTest.map.getHeight() >=1: "Error : id should be <=1"; 
	}

}
