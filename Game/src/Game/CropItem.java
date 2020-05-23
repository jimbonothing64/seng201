package Game;
/*
 * items that are consumed to promote crop growth
 */
public class CropItem {
	private String name;
	private int cost;
	private int growth;
	
	//sets item values depending on item name
	public CropItem(String type) {
		
		name = type;
		
		if (type == "fertiliser") {
			cost = 20;
			growth = 2;
		} else 	if (type == "rootblast") {
			cost = 45;
			growth = 5;
		} else if (type == "compost") {
			cost = 35;
			growth = 4;
		}
	}
	
	// getter methods to use item values.
	
	public String getName() {
		return name;
	}
	 public int getCost() {
		 return cost;
	 }
	 
	 public int getGrowth() {
		 return growth;
	 }
	 public String toString() {
		 return name + ":  reduce harvest time by " + growth + " days";
	 }
}
