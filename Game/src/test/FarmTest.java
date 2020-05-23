package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.AnimalItem;
import Game.Crop;
import Game.CropItem;
import Game.Farm;
import Game.Farmer;

class FarmTest {
	private Farm testFarm;
	Farmer brown;
	
	@BeforeEach
	public void init() {
		Farmer brown = new Farmer("brown", 25);
		testFarm = new Farm("Swiss Alps Meadow", brown, 7);
	}

	@Test
	public void pettingTest() {
		assertEquals(testFarm.getPettingBonus(),1);
	}
	@Test 
	public void itemsTest() {
		AnimalItem aitem = new AnimalItem("hay");
		CropItem citem = new CropItem("fertiliser");
		testFarm.addCropItem(citem);
		testFarm.addAnimalItem(aitem);
		assertEquals(testFarm.getCropItems().get(0), citem);
		assertEquals(testFarm.getAnimalItems().get(0), aitem);
	}
	
	@Test
	public void consumeTest() {
		AnimalItem aitem = new AnimalItem("health pellets");
		CropItem citem = new CropItem("rootblast");
		testFarm.addCropItem(citem);
		testFarm.addAnimalItem(aitem);
		testFarm.consumeCropItem(citem);
		testFarm.consumeAnimalItem(aitem);
		assertEquals(testFarm.getCropItems().size(),0);
		assertEquals(testFarm.getAnimalItems().size(), 0);
	}
	@Test
	void actionPointTest() {
		// + maxCrops() test
		assertEquals(0, testFarm.getActionPoints());
		testFarm.petAnimals();
		testFarm.tendFarm();
		assertEquals(2, testFarm.getActionPoints());
		assertFalse(testFarm.actionValid());
		testFarm.endDay();
		assertTrue(testFarm.actionValid());
		testFarm.tendFarm();
		assertEquals(1, testFarm.getActionPoints());
		assertEquals(testFarm.getMaxCrops(), 14);
	}
	@Test
	void classTest() {
		testFarm = new Farm("Fixer-Upper",brown,5);
		assertEquals(testFarm.getMoney(), 200);
		assertEquals(testFarm.getPettingBonus(), 0);
		testFarm = new Farm("Volcanic Soil Plantation", brown, 5);
		Crop potato = new Crop("potato");
		assertEquals(potato.getHarvestable(),2);
		testFarm.addCrop(potato);
		assertEquals(potato.getHarvestable(), 1);
	}	

}
