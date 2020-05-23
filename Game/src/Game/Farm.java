package Game;
/*
 * farm class is the environment the player plays in
 * the player may choose between different farm types for 
 * different bonuses
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Farm {
	private Farmer farmer;
	private String farmType;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private ArrayList<AnimalItem> animalItems = new ArrayList<AnimalItem>();
	private ArrayList<CropItem> cropItems = new ArrayList<CropItem>();
	private int pettingBonus;
	private int money = 100;
	private int currentDay;
	private int totalDays;
	private int actionPoints;
	private int happyDecay;	
	

	// sets farm bonuses based on farm type
	public Farm(String type, Farmer owner, int days) {
		farmer = owner;
		farmType = type;
		totalDays = days;
		currentDay = 0;
		happyDecay = 1;
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
	
	// return farmer info
	public String getFarmerInfo() {
		return farmer.getName() + " (" + farmer.getAge() + ")";
	}
	
	public int getCurrentDay() {
		return currentDay;
	}
	
	public int getTotalDays() {
		return totalDays;
	}
	
	public int getActionPoints() {
		return actionPoints;
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
	
	public int getHappyDecay() {
		return happyDecay;
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
	public void addAnimalItem(AnimalItem item) {
		animalItems.add(item);
	}
	public void addCropItem(CropItem item) {
		cropItems.add(item);
	}
	
	public ArrayList<Animal> getAnimals() {
		return animals;
	}
	public ArrayList<Crop> getCrops() {
		return crops;
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
		actionPoints += 1;
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).pet(pettingBonus);
		}
	}
	
	public void tendFarm() {
		actionPoints += 1;
		happyDecay += 3;
	}
	
	public boolean actionValid() {
		return actionPoints < 2;
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
	
	//give rewards for end of day
	public int endDay() {
		int earnings = 0;
		for (Animal animal: animals) {
			earnings += animal.getDailyReward();
		}
		
		if (happyDecay > 0) {
			happyDecay -= 1;
			} else {
				for (Animal animal: animals) {
					animal.setHappiness(animal.getHappiness() - 1);
				}
			}
		
		money += earnings;
		currentDay += 1;
		
		actionPoints = 0;
		return earnings;
	}
	
	public static void main(String[] args) {
		Farmer brown = new Farmer("brown", 26);
		Farm farm = new Farm("Volcanic Soil Plantation", brown, 10);
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

