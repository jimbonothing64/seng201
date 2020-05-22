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

