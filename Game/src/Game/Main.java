package Game;
/* the main game engine that runs the whole game
 *  by tying all classes together
 * static variables that are used throughout the game are instantiated
 * run this class to play the game.
 */
public class Main {
	private int day;
	private int totalDays;
	private Farm farm;
	
	public void launchSetupWindow(Main outManager) {
		FarmSetupWindow setupWindow = new FarmSetupWindow(outManager);
	}
	
	public void setFarm(Farm newFarm) {
		farm = newFarm;
		System.out.println(farm.getMoney());
	}
	
	public static void main(String[] args) {
		Main manager = new Main();
		manager.launchSetupWindow(manager);
		
		
	}

}
