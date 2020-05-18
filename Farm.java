/*
 * farm class is the environment the player plays in
 * the player may choose between different farm types for 
 * different bonuses
 */
import java.util.ArrayList;

public class Farm {
	private String farmType;
	private ArrayList<Animal> animals;
	private ArrayList<Crop> crops;
	
	// sets farm bonuses based on farm type
	public Farm(String type) {
		farmType = type;
		if (type == "1") {
			//pass
		}
	}
	
	public void growCrops() {
		for (int i = 0; i < crops.size(); i++) {
			crops.get(i).mature(1);
		}
		
	}
	
	// feed all animals with item
	public void feedAnimals(AnimalItem item) {
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).feedItem(item);
		}
	}
}
