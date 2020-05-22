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
	private int pettingBonus;
	private int happinessBonus;
	private int harvestTimeBonus;
	
	private int money;
	
	// sets farm bonuses based on farm type
	public Farm(String type) {
		farmType = type;
		if (type == "1") {
			//pass
		}
	}
	//setter getters
	
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
	
	public void setMoney(int amount) {
		money = amount;
	}
	public int getMoney() {
		return money;
	}
	public void addAnimal(Animal animal) {
		animals.add(animal);
	}
	public void addCrop(Crop crop) {
		crops.add(crop);
	}
	//matures each crop by 1 day at the end of each day
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
	
	// pet all animals
	public void petAnimals() {
		for (int i = 0; i < animals.size(); i++) {
			animals.get(i).pet(pettingBonus);
		}
	}
	
	
	
/*	public int harvest() {
		int income = 0;
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i).getHarvestable() == 0) {
				income += crops.get(i).getIncome();
			}
		}
	} */
	public int harvest() {
		int total = 0;
		for (Crop crop: crops) {
			if(crop.getHarvestable() == 0) {
				crops.remove(crop);
			}
		}
		return total;
	}
	public static void main(String[] args) {
		Farm farm = new Farm("hhh");
		Crop e = new Crop("ss");
		Cow a = new Cow();
		Chicken b = new Chicken();
		farm.addAnimal(a);
		farm.addAnimal(a);
		farm.addAnimal(b);
		farm.addCrop(e);
		e.mature(2);
		farm.harvest();
		System.out.println(e.getHarvestable());
		System.out.println(farm.getAnimalInfo());
		

	}
}
