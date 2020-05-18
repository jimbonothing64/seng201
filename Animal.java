
public class Animal {
	private String animalType;
	private int purchacePrice;
	private int happiness;
	private int baseReward;
	private int health;
	
	public Animal(String type, int price, int happy, int reward, int healthLevel) {
		animalType = type;
		purchacePrice = price;
		happiness = happy;
		baseReward = reward;
		health = healthLevel;
	}
	
	public String getAnimalType() {
		return animalType;
	}
	
	public int getPurchacePrice() {
		return purchacePrice;
	}
	
	public int getHappiness() {
		return happiness;
	}
	
	public int getBaseReward() {
		return baseReward;
	}
	
	public int getHealth() {
		return health;
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(farmer);
	}

}

public class Cow extends Animal {
	public Cow() {
		super("Cow", 200, 2, 200, 5);
	}
}
