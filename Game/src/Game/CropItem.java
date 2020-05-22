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
		
		if (type == "1") {
			cost = 3;
			value = 1;
		} else 	if (type == "2") {
			cost = 3;
			value = 2;
		} else if (type == "3") {
			cost = 3;
			value = 3;
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
}
