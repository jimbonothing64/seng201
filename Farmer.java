	
public class Farmer {
	
	private String name;
	
	public Farmer(String fname) {
		name = fname;
	}
	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		Farmer farmer = new Farmer("Brown");
		System.out.println(farmer);

	}

}
