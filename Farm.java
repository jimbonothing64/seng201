/*
 * farm class is the environment the player plays in
 * the player may choose between different farm types for 
 * different bonuses
 */
import java.util.ArrayList;

public class Farm {
	private String farmType;
	private ArrayList<Animal> animals;
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private int money;
	
	// sets farm bonuses based on farm type
	public Farm(String type) {
		farmType = type;
		if (type == "1") {
			//pass
		}
	}
	//setter getters
	public void setMoney(int amount) {
		money = amount;
	}
	public int getMoney() {
		return money;
	}
	public void addAnimal(Animal e) {
		animals.add(e);
	}
	public void addCrop(Crop e) {
		crops.add(e);
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
		//Cow a = new Cow();
		//farm.addAnimal(a);
		farm.addCrop(e);
		e.mature(2);
		farm.harvest();
		System.out.println(e.getHarvestable());
		

	}
}
