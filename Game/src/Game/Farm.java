package Game;
/*
 * farm class is the environment the player plays in
 * the player may choose between different farm types for 
 * different bonuses
 */
import java.util.ArrayList;

public class Farm {
	private Farmer farmer;
	private String farmType;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private ArrayList<AnimalItem> animalItems = new ArrayList<AnimalItem>();
	private ArrayList<CropItem> cropItems = new ArrayList<CropItem>();
	private int pettingBonus;
	private int money = 100;
	private int daysLeft;
	
	
	//temp fix later
	public Farm() {
		money = 200;
	}
	// sets farm bonuses based on farm type
	public Farm(String type, Farmer owner, int days) {
		farmer = owner;
		farmType = type;
		daysLeft = days;
		if (type == "Swiss Alps Meadow") {
			pettingBonus = 1;
		} else if(type == "Fixer-Upper") {
			money = 200;
		}
	}
	
	// returns string of formatted crop and animal info
	
	public String getAnimalInfo () {
		String animalInfo = "Animal List:\n";
		
		if (animals.size() < 1) {
			animalInfo = "You have no animals";
		}
		
		for (int i = 0; i < animals.size(); i++) {
			animalInfo += animals.get(i).toString() + "\n";
		}
		
		return animalInfo;
	}
	
	public String getCropInfo() {
		String cropInfo = "Crop list:\n";
		
		if (crops.size() < 1) {
			cropInfo = "You have no crops";
		}
		for (int i = 0; i < crops.size(); i++) {
			cropInfo += crops.get(i).toString() + "\n";
		}
		
		return cropInfo;
	}
	//setter getters
	
	public void setMoney(int amount) {
		money = amount;
	}
	public int getMoney() {
		return money;
	}
	public int getPettingBonus() {
		return pettingBonus;
	}
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	public void addCrop(Crop crop) {
		crops.add(crop);
		if (farmType == "Volcanic Soil Plantation") {
			crop.mature(1);
		}
	}
	//matures each crop by 1 day at the end of each day
	public void growCrops(int day) {
		for (int i = 0; i < crops.size(); i++) {
			crops.get(i).mature(day);
		}
		
	}
	// consumes item by removing it from the inventory
	public void consumeAnimalItem(AnimalItem item) {
		animalItems.remove(item);
	}
	public void consumeCropItem(CropItem item) {
		cropItems.remove(item);
	}
	
	
	// feed all animals with item
	public void feedAnimals(AnimalItem item) {
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).feedItem(item);
		}
	}
	
	// pet all animals
	public void petAnimals() {
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).pet(pettingBonus);
		}
	}
	
	public int harvest() {
		int total = 0;
		for (Crop crop: crops) {
			if(crop.getHarvestable() == 0) {
				total += crop.getIncome();
			}
		}
		ArrayList<Crop> updatedArray = new ArrayList<Crop>();
		for (Crop crop: crops) {
			if (crop.getHarvestable() != 0) {
				updatedArray.add(crop);
			}
		}
		crops = updatedArray;
		
		return total;
	}
	
	public static void main(String[] args) {
		Farmer brown = new Farmer("brown", 26);
		Farm farm = new Farm("Volcanic Soil Plantation", brown);
		Crop e = new Crop("lettuce");
		Crop ee = new Crop("pumpkin");
		Cow a = new Cow();
		Chicken b = new Chicken();
		farm.addAnimal(a);
		farm.addAnimal(a);
		farm.addAnimal(b);
		farm.addCrop(e);
		farm.addCrop(ee);
		farm.growCrops(3);
		//farm.harvest();
		System.out.println(farm.getCropInfo());
		//System.out.println(farm.getAnimalInfo());
		

	}


}

