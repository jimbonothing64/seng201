package Game;
/* the main game engine that runs the whole game
 *  by tying all classes together
 * static variables that are used throughout the game are instantiated
 * run this class to play the game.
 */
public class Main {
	private Farm farm;
	
	public void setFarm(Farm newFarm) {
		farm = newFarm;
	}
	
	public Farm getFarm() {
		return farm;
	}
	
	public void launchSetupWindow(Main outManager) {
		FarmSetupWindow setupWindow = new FarmSetupWindow(outManager);
	}
	
	public void closeSetupWindow(FarmSetupWindow setupWindow) {
		setupWindow.closeWindow();
		launchGameWindow();
	}
	
	public void launchGameWindow() {
		GameWindow gameWindow = new GameWindow(this);
	}
	
	public void closeGameWindow(GameWindow gameWindow) {
		gameWindow.closeWindow();
		launchMarketWindow();
		
	}
	
	public void launchMarketWindow() {
		MarketWindow marketWindow = new MarketWindow(this);
	}
	
	public void closeMarketWindow(MarketWindow marketWindow) {
		marketWindow.closeWindow();
		launchGameWindow();
	}
	

	
	
	public static void main(String[] args) {
		Main manager = new Main();
		manager.launchSetupWindow(manager);
		
		
	}

}
