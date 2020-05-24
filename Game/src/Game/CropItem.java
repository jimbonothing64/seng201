package Game;
/**
 * item class for crop objects
 *  that are consumed to promote crop growth
 */
public class CropItem {
	/**
	 * String representation of the type of crop item
	 */
	private String name;
	/**
	 * the cost of purchasing item from shop
	 */
	private int cost;
	/**
	 * the amount of days the item reduces 
	 * for the crop's harvestable time.
	 */
	private int growth;
	
	/**
	 * crop item constructor that takes
	 * @param type to differentiate the type of
	 * crop item and assign appropriate attribute values
	 */
	public CropItem(String type) {
		
		name = type;
		
		if (type == "fertiliser") {
			cost = 2;
			growth = 2;
		} else 	if (type == "rootblast") {
			cost = 4;
			growth = 5;
		} else if (type == "compost") {
			cost = 3;
			growth = 4;
		} else if (type == "water") {
			cost = 0;
			growth = 1;
		}
	}
	
	/**
	 * @return the string name of the item object
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the cost of the item to purchase in the shop
	 */
	 public int getCost() {
		 return cost;
	 }
	 /**
	  * @return the amount of days taken away from
	  * a crop's harvestable duration once item is consumed
	  */
	 public int getGrowth() {
		 return growth;
	 }
	 /**
	  * @return string representation of the item
	  * displays name and growth attributes 
	  */
	 public String toString() {
		 return name + ":  reduce harvest time by " + growth + " days";
	 }
}
