package Game;
/**
 * the Crop class defines each crop the player may grow
 * or purchase from the shop, each with different attributes
 * which are set upon construction based on the string type
 */
public class Crop {
	/**
	 * the name of the crop object used to 
	 * differentiate different crops and 
	 * setting their appropriate attributes
	 */
	private String name;
	/**
	 * the price of the crop object 
	 * to purchase from the shop
	 */
	private int cost;
	/**
	 * the amount of days required to pass
	 * before the crop is able to be harvested
	 * for money.
	 */
	private int harvestable = 3;
	/**
	 * the amount of money generated
	 * once the crop is harvested
	 */
	private int income;
	
	/**
	 * constructor of Crop object which takes
	 * @param type which is a string of the object name.
	 * this will determine the other attributes of the crop object.
	 */
	public Crop(String type) {
		name = type;
		if (type == "potato") {
			cost = 2;
			harvestable = 2;
			income = 5;
		} else if (type == "wheat") {
			cost = 6;
			harvestable = 3;
			income = 10;
	    } else if (type == "carrot") {
	    	cost = 5;
			harvestable = 4;
			income = 11;
	    } else if (type == "pumpkin") {
	    	cost = 4;
			harvestable = 7;
			income = 20;
	    } else if (type == "melon") {
	    	cost = 7;
			harvestable = 4;
			income = 15;
	    } else if (type == "lettuce") {
			cost = 3;
			harvestable = 3;
			income = 8;
	    }
    }
	
	/**
	 * name getter method
	 * @return the string name of the crop
	 */
	public String getName() {
		return name;
	}
	/**
	 * gets days remaining until harvestable
	 * @return amount of days
	 * 0 if harvestable
	 */
	public int getHarvestable() {
		return harvestable;
	}
	/**
	 * the price of the crop item
	 * sold in the store
	 * @return the price of the crop item
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * displays the crop object in a 
	 * readable format with relevant attributes
	 * @return a string representation of the object
	 */
	public String toString() {
		return name + " (Days until harvestble: " + harvestable + "  value: " + income + ")";
	}
	/**
	 * @return the income the crop will generate
	 * once harvested 
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * decrease the days required to be ready for harvest specified by
	 * @param i - integer number of days reduced
	 * with 0 as lower bound
	 */
	public void mature(int i) {
		harvestable -= i;
		if (harvestable < 0) { // sets to 0 if negative
			harvestable = 0;
		}
	}
	/**
	 * uses crop item on crop to decrease harvestable duration by
	 * @param item's growth attribute 
	 */
	public void useItem(CropItem item) {
		if (harvestable - item.getGrowth() > 0) {
			harvestable -= item.getGrowth();
		} else {
			harvestable = 0;
		}
	}
}
