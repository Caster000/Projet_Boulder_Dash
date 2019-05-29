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
	public void test() {
		assert this.map.getWidth() >= 1: "Error : id should be <=1";
	}

}
