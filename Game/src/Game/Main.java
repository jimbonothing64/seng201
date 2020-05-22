package Game;
/* the main game engine that runs the whole game
 *  by tying all classes together
 * static variables that are used throughout the game are instantiated
 * run this class to play the game.
 */
public class Main {
	private int day;
	private int totalDays;
	private Farmer farmer;
	
	public void launchSetupWindow(Farm outFarm) {
		FarmSetupWindow setupWindow = new FarmSetupWindow(outFarm);
	}
	
	public static void main(String[] args) {
		Farm farm = new Farm();
		Main manager = new Main();
		manager.launchSetupWindow(farm);
		
	}

}
