package Game;
/**
 * farm class is the environment the player plays in.
 * the player may choose between different farm types for different bonuses.
 * This is the biggest class and ties many of the other classes together
 * through its methods and stores objects within its ArrayLists
 */
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Farm {
	/**
	 * stores the farmer character that the
	 * player creates at the start of the game.
	 */
	private Farmer farmer;
	/**
	 * a string that represents the different types
	 * of farm classes that have different perks
	 */
	private String farmType;
	/**
	 * container to store animal objects that
	 * are currently owned by the farm
	 */
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	/**
	 * container to store crop objects 
	 * that are currently grown by the farm
	 */
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	/**
	 * container to store animal item objects that
	 * the farm currently owns
	 */
	private ArrayList<AnimalItem> animalItems = new ArrayList<AnimalItem>();
	/**
	 * container for storing crop items that are
	 * possessed by the farm 
	 */
	private ArrayList<CropItem> cropItems = new ArrayList<CropItem>();
	/**
	 * class perk for increased happiness when
	 * petting animals. set to 1 if enabled; else 0 
	 */
	private int pettingBonus;
	/**
	 * default starting money once game starts
	 * except for a specified farm class
	 */
	private int money = 100;
	/**
	 * the current day the game is at
	 */
	private int currentDay;
	/**
	 * the total days the game will play for
	 * set by player in setup screen
	 */
	private int totalDays;
	/**
	 * amount of action points the player has used
	 * up to a max of 2
	 * resets upon day ending
	 */
	private int actionPoints;
	/**
	 * a counter that specifies the amount of days
	 * the player has not tended to farm.
	 * animals will decrease in happiness each day
	 * after a period of time
	 */
	private int happyDecay;	
	/**
	 * the default maximum amount of crops a player
	 * may plant at once. this increases each time
	 * the player tends to the farm
	 */
	private int maxCrops = 10;
	

	/**
	 * farm constructor with
	 * @param type string name to determine perk type
	 * @param owner Farmer object of character created
	 * @param days - total days the game will play for
	 */
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
	
	/**
	 * @return a string of the farmer's name and age
	 * to be displayed at the top of the game screen
	 */
	public String getFarmerInfo() {
		return farmer.getName() + " (" + farmer.getAge() + ")";
	}
	/**
	 * @return the current day the game is at
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	/**
	 * @return the total days the game will last
	 */
	public int getTotalDays() {
		return totalDays;
	}
	/**
	 * @return the amount of action points
	 * currently spent by the player this day 
	 */
	public int getActionPoints() {
		return actionPoints;
	}

	/**
	 * @param sets the amount of money for the farm 
	 */
	public void setMoney(int amount) {
		money = amount;
	}
	/**
	 * @return gets the current amount of money owned by farm
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @return 1 if class perk petting bonus enabled
	 * 0 otherwise
	 */
	public int getPettingBonus() {
		return pettingBonus;
	}
	/**
	 * @return the amount of days remaining before
	 * animals will decay in happiness per day 
	 */
	public int getHappyDecay() {
		return happyDecay;
	}
	/**
	 * calculates the final score of the player at the end of the game
	 * @return a numerical value based off the player's current animals,
	 * money and total game duration
	 */
	public float getScore() {
		int animalBonus = 0;
		
		for (Animal animal: animals) {
			animalBonus += animal.getDailyReward();
		}
		return (animalBonus + money) / totalDays;
	}
	/**
	 * @param animal added to farm container
	 */
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	/**
	 * @param crop added to farm container
	 * harvestable 1 day earlier if class perk enabled
	 */
	public void addCrop(Crop crop) {
		crops.add(crop);
		if (farmType == "Volcanic Soil Plantation") {
			crop.mature(1);
		}
	}
	/**
	 * @param animal item added into farm inventory
	 */
	public void addAnimalItem(AnimalItem item) {
		animalItems.add(item);
	}
	/**
	 * @param crop item added into farm inventory
	 */
	public void addCropItem(CropItem item) {
		cropItems.add(item);
	}
	/**
	 * @return a list of animal objects currently owned by the farm
	 */
	public ArrayList<Animal> getAnimals() {
		return animals;
	}
	/**
	 * @return a list of animal item objects owned by the farm
	 */
	public ArrayList<AnimalItem> getAnimalItems() {
		return animalItems;
	}
	/**
	 * @return a list of crops currently grown by the farm
	 */
	public ArrayList<Crop> getCrops() {
		return crops;
	}
	/**
	 * @return a list of the types of crop objects owned by farm
	 * which is used to determine which type of crop to use items on.
	 */
	public ArrayList<String> getCropVarieties() {
		 ArrayList<String> cropVarieties = new ArrayList<String>();
		for (Crop crop : crops) {
			if (!(cropVarieties.contains(crop.getName()))) {
				cropVarieties.add(crop.getName());
			}
		}
		return cropVarieties;
	}
	/**
	 * @return the list of crop items owned by farm
	 */
	public ArrayList<CropItem> getCropItems() {
		return cropItems;
	}
	/**
	 * @return maximum amount of crops allowed to be grown at once
	 */
	public int getMaxCrops() {
		return maxCrops;
	}
	/**
	 * matures each crop in farm by
	 * @param amount of days 
	 * crops grow by 1 at the end of each day
	 */
	public void growCrops(int day) {
		for (int i = 0; i < crops.size(); i++) {
			crops.get(i).mature(day);
		}
		
	}
	/**
	 * called after animal item is used for feeding
	 * @param item is removed from inventory
	 */
	public void consumeAnimalItem(AnimalItem item) {
		for (AnimalItem animalItem : animalItems) {
			if (animalItem.getName() == item.getName()) {
				animalItems.remove(animalItem);
				break;
			}
		}
	}
	/**
	 * called after crop item is consumed by crops
	 * @param item is removed from inventory
	 */
	public void consumeCropItem(CropItem item) {
		for (CropItem cropItem : cropItems) {
			if (cropItem.getName() == item.getName()) {
				cropItems.remove(cropItem);
				break;
			}
		}
	}
	/**
	 * checks if each crop in the farm matches and uses item
	 * on all crops of that type
	 * @param inCrop -the crop type selected for item use
	 * @param inCropItem -item benefits gained by the crop type
	 */
	public void useCropItem(Crop inCrop, CropItem inCropItem) {
		actionPoints += 1;
		for (Crop crop : crops) {
			if (crop.getName() == inCrop.getName()) {
				crop.useItem(inCropItem);
			}
		}
	}
	
	/**
	 *  feed all animals with
	 * @param item health and happiness
	 * added to fed animals in farm
	 */
	public void feedAnimals(AnimalItem item) {
		actionPoints += 1;
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).feedItem(item);
		}
	}
	
	/**
	 *  pet all animals, increasing their
	 *  happiness by 1 or by 2 if class perk
	 *  petting bonus enabled
	 */
	public void petAnimals() {
		actionPoints += 1;
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).pet(pettingBonus);
		}
	}
	/**
	 * farm action to tend to farm
	 * spends 1 action point, increases crop size
	 * and increase time until happiness decay of
	 * farm animals 
	 */
	public void tendFarm() {
		actionPoints += 1;
		maxCrops += 2;
		happyDecay += 3;
	}
	/**
	 * @return boolean whether an action
	 * point is available to be spent
	 */
	public boolean actionValid() {
		return actionPoints < 2;
	}
	/**
	 * harvests all crops ready to be harvested and
	 * @return the amount of income generated
	 * 0 income if no harvest is ready
	 * otherwise action point is expended
	 * harvested crops are removed from the farm
	 */
	public int harvest() {
		int total = 0;
		for (Crop crop: crops) {
			if(crop.getHarvestable() == 0) {
				total += crop.getIncome();
			}
		}
		if (total == 0) return 0;
		actionPoints += 1;
		ArrayList<Crop> updatedArray = new ArrayList<Crop>();
		for (Crop crop: crops) {
			if (crop.getHarvestable() != 0) {
				updatedArray.add(crop);
			}
		}
		money += total;
		crops = updatedArray;
		return total;
	}
	
	/**
	 * give rewards for end of day for each animal
	 * @return the money generated from farm animals
	 * grows crops by 1 and decreases animal happiness
	 * if farm has not been tended to in a while
	 */
	public int endDay() {
		int earnings = 0;
		growCrops(1);
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
	

}

