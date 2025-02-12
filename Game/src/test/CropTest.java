package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.Crop;
import Game.CropItem;
import Game.Farm;
import Game.Farmer;
/* tests crop functionality
 *  within the farm class' array with farm methods
 */
class CropTest {
	private Farm farm;
	@BeforeEach
	/* instantiate 1 of each crop then
	 *  create farm with 6 crops.
	 */
	void init() {
		Crop carrot = new Crop("carrot");
		Crop melon = new Crop("melon");
		Crop pumpkin = new Crop("pumpkin");
		Crop wheat = new Crop("wheat");
		Crop potato = new Crop("potato");
		Crop lettuce = new Crop("lettuce");
		Farmer farmer = new Farmer("brown", 18);
		farm = new Farm("Volcanic Soil Plantation", farmer, 8);
		farm.addCrop(carrot);
		farm.addCrop(melon);
		farm.addCrop(pumpkin);
		farm.addCrop(wheat);
		farm.addCrop(potato);
		farm.addCrop(lettuce);
	}

	@Test
	//tests if crop size = 6
	void cropListTest() {
		assertEquals(6, farm.getCrops().size());
	}
	@Test
	/**
	 *  initially 4 days until maturity. matures object 
	 *  outside of array, Farm perk reduces harvestable by 1 when 
	 *  added to farm array. tests if same object inside array matures
	 */
	void matureTest() {
		Crop carrot = farm.getCrops().get(0);
		assertEquals(carrot.toString(),"carrot (Days until harvestble: 3  value: 11)");
		carrot.mature(1);
		assertEquals(farm.getCrops().get(0).getHarvestable(), 2);
		
	}
	@Test
	/* tests harvest() function by checking if there are valid harvests,
	 * then maturing pumpkin until harvestable. checks if pumpkin is removed from
	 * array. Also tests action point use and harvested money
	 */
	
	void harvestTest() {
		//also tests action point use and harvested money
		Crop pumpkin = farm.getCrops().get(2);
		assertEquals(pumpkin.getCost(), 4);
		assertEquals(farm.harvest(), 0);
		pumpkin.mature(7);
		assertEquals(pumpkin.getHarvestable(), 0);
		assertEquals(farm.getActionPoints(), 0);
		assertEquals(farm.harvest(), 20);
		assertEquals(farm.getActionPoints(), 1);
		assertEquals(farm.getMoney(), 45);
		assertEquals(farm.getCrops().size(), 5);
	}
	@Test
	/**
	 * uses item on crop and tests if harvestable
	 * decreases by item's growth value
	 * pumpkin initial harvestable is 7 but is 6 when
	 * added to Farm with crop perk active
	 */
	void cropItemTest() {
		CropItem item = new CropItem("compost");
		Crop pumpkin = farm.getCrops().get(2);
		assertEquals(pumpkin.getHarvestable(), 6);
		assertEquals(item.getGrowth(), 4);
		farm.useCropItem(pumpkin,item);
		assertEquals(farm.getCrops().get(2).getHarvestable(), 6-4);
		
		
		
	}
}	
