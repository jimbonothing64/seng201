package Game;
/*
 * items that are consumed to promote crop growth
 */
public class CropItem {
	private String name;
	private int cost;
	private int value;
	
	//sets item values depending on item name
	public CropItem(String type) {
		
		name = type;
		
		if (type == "fertiliser") {
			cost = 20;
			value = 2;
		} else 	if (type == "rootblast") {
			cost = 45;
			value = 5;
		} else if (type == "compost") {
			cost = 35;
			value = 4;
		}
	}
	
	// getter methods to use item values.
	
	public String getName() {
		return name;
	}
	 public int getCost() {
		 return cost;
	 }
	 
	 public int getValue() {
		 return value;
	 }
	 public String toString() {
		 return name + ":  reduce harvest time by " + value + " days";
	 }
}
