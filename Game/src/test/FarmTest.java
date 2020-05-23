package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.Farm;
import Game.Farmer;

class FarmTest {
	private Farm testFarm;
	
	@BeforeEach
	public void init() {
		Farmer brown = new Farmer("brown", 25);
		testFarm = new Farm("Swiss Alps Meadow", brown, 7);
	}

	@Test
	public void test() {
		assertEquals(testFarm.getPettingBonus(),1);
	}

}
