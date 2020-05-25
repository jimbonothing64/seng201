package Game;
/**
 * item class for animals 
 * items are consumed by animals to
 * increase happiness or health levels
 */
public class AnimalItem {
	/**
	 * name identifies the name of the
	 * animal item to differentiate item type
	 * and thus its other attributes
	 */
	private String name;
	/**
	 * cost denotes the cost to purchase
	 * the item in the shop
	 */
	private int cost;
	/**
	 * health indicates how much health
	 * the item will restore to the
	 * animal when consumed
	 */
	private int health;
	/**
	 * happiness indicates how much happiness
	 * the item will restore to the 
	 * animal when consumed
	 */
	private int happiness;
	
	/**
	 * matches the string to create item with corresponding values
	 * @param type: the string differentiates which item type will be instantiated when constructed
	 *  
	 */
	public AnimalItem(String type) {
		/**
		 * sets string name attribute to @param
		 */
		name = type;
		
		if (type == "hay") {
			cost = 3;
			health = 2;
			happiness = 0;
		} else if (type == "health pellets") {
			cost = 7;
			health = 4;
			happiness = 2;
		} else if (type == "grain") {
			cost = 5;
			health = 3;
			happiness = 1;
		}
	}
	

	/**
	 * name getter method
	 * @return String name of animal item
	 */
	public String getName() {
		return name;
	}
	/**
	 * cost getter method
	 * @return int cost of the animal item from shop 
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * happiness getter method 
	 * @return the happiness restored to
	 * the animal when item is consumed
	 */
	public int getHappiness() {
		return happiness;
	}
	/**
	 * health getter method
	 * @return the health restored
	 * to animal when item is consumed
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * prints the animal item in 
	 * a readable format to see the attribute 
	 * restored amounts for the reader
	 * @return String consisting of item name and its restore values 
	 */
	public String toString() {
		return name + ":  restores " + health + " and " + happiness + " happiness"; 
	}
}

