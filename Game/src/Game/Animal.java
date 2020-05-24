package Game;
/**
 * parent Class for farm animals
 * which are stored in the farm class.
 * animals are purchased through the store
 * and will generate income each day 
 * depending on their health and happiness
 * levels which are raised through feeding and playing.
 * hunger and happiness decay if not fed or tended to.
 */

public class Animal {
	/**
	 * animal type is a string that
	 * differentiates the type of child class
	 * and is used to appoint correct attributes
	 */
	private String animalType;
	/**
	 * the price its costs to purchase
	 * from the shop
	 */
	private int purchacePrice;
	/**
	 * the base happiness the animal has
	 * once purchased from the shop
	 */
	private int happiness;
	/**
	 * the baseline money that is produced
	 * per day by the animal
	 */
	private int baseReward;
	/**
	 * the base health the animal has when
	 * purchased from the store
	 */
	private int health;
	
	/**
	 * super constructor which is called through child classes
	 * @param type - string that denotes which type of animal it is
	 * @param price - price that it is sold for in the shop
	 * @param happy - base happiness when purchased
	 * @param reward - base income generated daily when purchased
	 * @param healthLevel - the health the animal has when purchased
	 */	
	public Animal(String type, int price, int happy, int reward, int healthLevel) {
		animalType = type;
		purchacePrice = price;
		happiness = happy;
		baseReward = reward;
		health = healthLevel;
	}
	
	/**
	 * the getter method for animal type
	 * @return - the string name the animal has
	 */
	public String getAnimalType() {
		return animalType;
	}
	/**
	 * price at which the animal sells for in the shop
	 * @return the int amount the animal sells for
	 */
	public int getPurchacePrice() {
		return purchacePrice;
	}
	/**
	 * gets the happiness of the animal
	 * @return - the current happiness of the animal
	 */
	public int getHappiness() {
		return happiness;
	}
	/**
	 * the minimum daily money that is generated
	 * by the animal
	 * @return the int minimum value
	 */
	public int getBaseReward() {
		return baseReward;
	}
	/**
	 * the current health (hunger) of the animal
	 * @return int health level
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * calculates the total daily money generated
	 * by each animal as a function of their
	 * happiness, health and base reward
	 * @return the total income generated at the end of the day
	 */
	public int getDailyReward() {
		return (happiness + health) * baseReward;
	}
	
	/**
	 * sets animal happiness to 
	 * @param value which is capped
	 * from range 0 - 10
	 */
	public void setHappiness(int value) {
		if ((value <= 10) && (value >= 0)) {
			happiness = value;
		} else if (value <= 0) {
			happiness = 0;
		} else {
			happiness = 10;
		}
	}
	/**
	 * sets animal health to
	 * @param value which is capped
	 * from range 0 - 10
	 */
	public void setHealth(int value) {
		if ((value <= 10) && (value >= 0)) {
			health = value;
		} else if (value <= 0) {
			health = 0;
		} else {
			health = 10;
		}
	}
	/**
	 * returns a
	 * @return string representation of the
	 * animal to display all relevant
	 * attributes
	 */
	public String toString() {
		return animalType + " (" + "Health:" + health + " Happiness:" + happiness + " Daily Reward:" + getDailyReward() + ")";
	}
	/**
	 * animal is fed an
	 * @param item object and increases
	 * the animal's happiness and/or health
	 * by specified amount in item object
	 */
	public void feedItem(AnimalItem item) {
		setHappiness(item.getHappiness() + happiness);
		setHealth(item.getHealth() + health);
		
	}
	
	/**
	 * animal is pet and increases 
	 * happiness level by at least 1
	 * @param pettingBonus is a farm class perk
	 * which increases happiness by an additional 1.
	 */
	public void pet(int pettingBonus) {
		setHappiness(happiness + 1 + pettingBonus);
	}
	

}

