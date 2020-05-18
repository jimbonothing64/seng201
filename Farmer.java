/*
 * The Farmer class is the character played by the user
 * they may set a name and an age for this character.
 */
public class Farmer {
	
	private String name;
	private int age;
	private int money;
	
	public Farmer(String fname, int num) {
		age = num;
		name = fname;
	}
	// getter methods
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getMoney() {
		return money;
	}
	// setter methods -- name and age can't be changed once set.
	public void setMoney(int amount) {
		money = amount;
	}
	public static void main(String[] args) {
		

	}

}
