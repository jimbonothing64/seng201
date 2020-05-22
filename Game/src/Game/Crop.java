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
		if (type == "1") {
			cost = 1;
		} else if (type == "2") {
			cost = 1;
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
