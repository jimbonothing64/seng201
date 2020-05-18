
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
	
	// Getter Methods
	
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
	
	public int getDailyReward() {
		return (happiness + health) * baseReward;
	}
	
	// Setter Methods
	
	public void setHappiness(int value) {
		if ((happiness + value <= 10) && (happiness + value >= 0)) {
			happiness = value;
		} else if (happiness + value >= 0) {
			happiness = 0;
		} else {
			happiness = 10;
		}
	}
	
	public void setHealth(int value) {
		if ((health + value <= 10) && (health + value >= 0)) {
			health = value;
		} else if (health + value >= 0) {
			health = 0;
		} else {
			health = 10;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		System.out.println(farmer);
	}
	
	
	public void feedItem(AnimalItem item) {
		item.getHappiness()
		item.getHealth()
	}
	

}

public class Cow extends Animal {
	public Cow() {
		super("cow", 200, 2, 20, 5);
	}
}

public class Chicken extends Animal {
	public Chicken() {
		super("chicken", 50, 5, 10, 5);
	}
}

public class Pig extends Animal {
	public Pig() {
		super("pig", 150, 2, 20, 2);
	}
}