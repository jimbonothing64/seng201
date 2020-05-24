package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.Animal;
import Game.AnimalItem;
import Game.Crop;
import Game.CropItem;
import Game.Farm;
import Game.Farmer;
import Game.Pig;
/** tests the functionality of the farm class with interactions within
 * and outside of the class. many other classes are contained within the farm
 * as it is the primary class of the game. 
 */
class FarmTest {
	private Farm testFarm;
	Farmer brown;
	
	@BeforeEach
	// instantiates farmer and farm class
	public void init() {
		Farmer brown = new Farmer("brown", 25);
		testFarm = new Farm("Swiss Alps Meadow", brown, 7);
	}
	
	@Test 
	/**
	 *  item stored at array matches same item instance
	 *  crop item is at index 1 since water is at index 0
	 */
	public void itemsTest() {
		AnimalItem aitem = new AnimalItem("hay");
		CropItem citem = new CropItem("fertiliser");
		testFarm.addCropItem(citem);
		testFarm.addAnimalItem(aitem);
		assertEquals(testFarm.getCropItems().get(1), citem);
		assertEquals(testFarm.getAnimalItems().get(0), aitem);
	}
	
	@Test
	// adds item to array, consumes it and check if array size = 0
	public void consumeTest() {
		AnimalItem aitem = new AnimalItem("health pellets");
		CropItem citem = new CropItem("rootblast");
		testFarm.addCropItem(citem);
		testFarm.addAnimalItem(aitem);
		testFarm.consumeCropItem(citem);
		testFarm.consumeAnimalItem(aitem);
		assertEquals(testFarm.getCropItems().size(),1);
		assertEquals(testFarm.getAnimalItems().size(), 0);
	}
	@Test
	//test action point expenditure, validity, and reset 
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
	//tests each farm class and their bonuses
	void classTest() {
		Animal pig = new Pig();
		assertEquals(pig.getHappiness(), 1);
		testFarm.addAnimal(pig);
		testFarm.petAnimals();
		assertEquals(testFarm.getPettingBonus(), 1);
		assertEquals(pig.getHappiness(), 3);
		testFarm = new Farm("Fixer-Upper",brown,5);
		assertEquals(testFarm.getMoney(), 35);
		assertEquals(testFarm.getPettingBonus(), 0);
		testFarm = new Farm("Volcanic Soil Plantation", brown, 5);
		Crop potato = new Crop("potato");
		assertEquals(potato.getHarvestable(),2);
		testFarm.addCrop(potato);
		assertEquals(potato.getHarvestable(), 1);
		testFarm = new Farm("regular joe", brown, 6);
		assertEquals(testFarm.getMoney(),25);
		assertEquals(testFarm.getPettingBonus(),0);
		
	}

}
