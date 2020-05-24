package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.Animal;
import Game.AnimalItem;
import Game.Chicken;
import Game.Cow;
import Game.Farm;
import Game.Farmer;
import Game.Pig;

/*
 * creates animals within the farm class array
 * to test all extended functionality
 */
class AnimalTest {
	private Animal cow;
	private Animal pig;
	private Animal chicken;
	private Farmer farmer;
	private Farm farm;
	@BeforeEach
	//instantiate one of each animal object and add them to a new farm class
	public void init() {
		cow = new Cow();
		pig = new Pig();
		chicken = new Chicken();
		farmer = new Farmer("brown", 77);
		farm = new Farm("Swiss Alps Meadow", farmer, 10);
		farm.addAnimal(cow);
		farm.addAnimal(pig);
		farm.addAnimal(chicken);
	}

	@Test
	/*
	 * checks baseline happiness of animals then the result happiness after
	 * petting them and letting their happiness decay
	 */
	void happinessTest() {
		assertEquals(farm.getAnimals().get(0).getHappiness(), 1);
		assertEquals(farm.getAnimals().get(1).getHappiness(), 1);
		farm.petAnimals();
		assertEquals(farm.getAnimals().get(0).getHappiness(), 3);
		assertEquals(farm.getAnimals().get(1).getHappiness(), 3);
		farm.endDay();
		farm.endDay();
		assertEquals(farm.getAnimals().get(0).getHappiness(), 2);
		assertEquals(farm.getAnimals().get(1).getHappiness(), 2);
	}
	
	@Test
	/* tests if money is generated correctly
	 * and transferred to the farm at the end of day
	 */
	void baseRewardTest() {
		int earnings = chicken.getDailyReward() + cow.getDailyReward() + pig.getDailyReward();
		farm.endDay();
		assertEquals(farm.getMoney(), 25 + earnings);
	}
	@Test
	/* tests if an animal is fed, their health
	 * and happiness will increase accordingly.
	 * also tests consumption of animal item from farm inventory
	 */
	void feedTest() {
		AnimalItem food = new AnimalItem("health pellets");
		farm.addAnimalItem(food);
		assertEquals(farm.getAnimalItems().size(), 1);
		int chickenhappiness = farm.getAnimals().get(2).getHappiness();
		int chickenhealth = farm.getAnimals().get(2).getHealth();
		farm.feedAnimals(food);
		farm.consumeAnimalItem(food);
		int currenthappiness = farm.getAnimals().get(2).getHappiness();
		int currenthealth = farm.getAnimals().get(2).getHealth();
		assertEquals(chickenhappiness + food.getHappiness(), currenthappiness);
		assertEquals(chickenhealth + food.getHealth(), currenthealth);
		assertEquals(farm.getAnimalItems().size(), 0);
	}

}
