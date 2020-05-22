package Game;
/*
 * the Crop class defines each crop the player may grow
 * or purchase from the shop, each with different values.
 */
public class Crop {
	private String name;
	private int cost;
	private int harvestable = 3;
	private int income;
	
	// creates a crop object with different values based on name

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
	    } else if (type == "carrot ") {
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
	
	//getter and setter methods
	public int getHarvestable() {
		return harvestable;
	}
	public int getCost() {
		return cost;
	}
	public String toString() {
		return name + ": Days until harvestble: " + harvestable + "  value: " + income;
	}
	public int getIncome() {
		return income;
	}

	// functionality methods
	public void mature(int i) {
		harvestable -= i;
		if (harvestable < 0) { // sets to 0 if negative
			harvestable = 0;
		}
	}
	
	
	

}
