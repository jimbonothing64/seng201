package Game;
/**
 * The Farmer class is the character played by the user
 * they may set a name and an age for this character.
 */
public class Farmer {
	
	private String name;
	private int age;
	
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
	
	// setter methods -- name and age can't be changed once set.

	public static void main(String[] args) {
		

	}

}
