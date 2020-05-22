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
	
	public void launchSetupWindow() {
		new FarmSetupWindow(this);
	}
	
	public void setFarm(Farm newFarm) {
		farm = newFarm;
		System.out.println(farm.getMoney());
	}
	
	public static void main(String[] args) {
		Main manager = new Main();
<<<<<<< HEAD
		manager.launchSetupWindow();
		//System.out.println(manager.farm.getMoney());
=======
		manager.launchSetupWindow(manager);
		
>>>>>>> bb52fb0228a1f0bf73eb774654f08f186887de67
		
	}

}
