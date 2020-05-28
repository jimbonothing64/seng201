package Game;
/* the main game engine that runs the whole game
/** the main game engine that runs the whole game
 *  by tying all classes together
 * static variables that are used throughout the game are instantiated
 * run this class to play the game.
 *  static variables that are used throughout the game are instantiated
 *  run this class to play the game.
 */
public class Main {
	/**
	 * stores player's farm
	 */
	private Farm farm;
	
	/**
	 * sets farm to be used for the game
	 * @param newFarm the new farm object to be used this game
	 */
	public void setFarm(Farm newFarm) {
		farm = newFarm;
	}
	
	/**
	 * used for retrieving farm for this game
	 * @return farm so that it can be read
	 */
	public Farm getFarm() {
		return farm;
	}
	
	/**
	 * starts game by launching setup screen	
	 * @param outManager the Main object to be passed into FarmSetupWindow
	 */
	public void launchSetupWindow(Main outManager) {
		FarmSetupWindow setupWindow = new FarmSetupWindow(outManager);
	}
	
	/**
	 * go from setup to main game screen
	 * @param setupWindow is the previous window which is to be closed
	 */
	public void closeSetupWindow(FarmSetupWindow setupWindow) {
		setupWindow.closeWindow();
		launchGameWindow();
	}
	
	/**
	 * launch new instance of GameWindow passing in Main object
	 */
	public void launchGameWindow() {
		GameWindow gameWindow = new GameWindow(this);
	}
	
	/**
	 * close game window and open marketplace
	 * @param gameWindow is closed
	 */
	public void closeGameWindow(GameWindow gameWindow) {
		gameWindow.closeWindow();
		launchMarketWindow();
		
	}
	
	/**
	 * open new instance of market window passing in Main object
	 */
	public void launchMarketWindow() {
		MarketWindow marketWindow = new MarketWindow(this);
	}
	
	/**
	 * go from market window to main window
	 * @param marketWindow
	 */
	public void closeMarketWindow(MarketWindow marketWindow) {
		marketWindow.closeWindow();
		launchGameWindow();
	}
	
	/**
	 * runs a new game
	 * @param args
	 */
	public static void main(String[] args) {
		Main manager = new Main();
		manager.launchSetupWindow(manager);
		
		
	}

}