package Game;
/*
 * item class for animals 
 * items are consumed by animals to
 * increase happiness or health levels
 */
public class AnimalItem {
	private String name;
	private int cost;
	private int health;
	private int happiness;
	
	// matches the string to create item with corresponding values
	public AnimalItem(String type) {
		name = type;
		
		if (type == "1") {
			cost = 1;
			health = 1;
			happiness = 1;
		} else if (type == "4") {
			cost = 1;
			health = 1;
			happiness = 1;
		} else if (type == "2") {
			cost = 1;
			health = 1;
			happiness = 1;
		} else if (type == "3") {
			cost = 1;
			health = 1;
			happiness = 1;
		}
	}
	
	// getter methods
	
	public String getName() {
		return name;
	}
	public int getCost() {
		return cost;
	}
	public int getHappiness() {
		return happiness;
	}
	public int getHealth() {
		return health;
	}
}

