package Game;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
/**
 * The main GUI for the game used to view animals, crops
 * , items, do actions and view the marketplace
 */
public class GameWindow {
/**
 *  Object for GUI
 */
	// GUI objects that interact with each-other are declared here
	private JFrame frmFarmOwnerSimulator;
	private JLabel lblDaysLeft;
	private JLabel lblActions;
	private JLabel lblMoney;
	private JLabel lblFarmerInfo;
	private JList<String> listLivestock;
	private JList<String> listCrops;
	private JList<String> listCropsCropItem;
	private JList<String> listCropItems;
	private JList<String> listFeedingList;
	private JPanel panelFeedLivestock;
	private JPanel panelLivestock;
	private JPanel panelCropItems;
	private JPanel panelCrops;
	/**
	 * Main class to be passed around when changing windows
	 */
	private Main manager;
	/**
	 * player's farm object
	 */
	private Farm farm;
	/**
	 * used to store animals for display
	 */
	private String[] animals = new String[100];
	/**
	 * used to store crops for display
	 */
	private String[] crops = new String[100];
	/**
	 * used to store crop items for display
	 */
	private String[] cropItems = new String[100];
	/**
	 * used to store animal items for display
	 */
	private String[] animalItems = new String[100];
	/**
	 * used to store crop types player has for display
	 */
	private String[] cropVarieties = new String [50];
	
	

	/**
	 * Launch the application.
	 * @param args arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frmFarmOwnerSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
	}
	
	public GameWindow(Main incomingManager) {
		manager = incomingManager;
		farm = manager.getFarm();
		initialize();
		frmFarmOwnerSimulator.setVisible(true);
		updateFarmInfo();
	}
	/**
	 * close the window
	 */
	public void closeWindow() {
		frmFarmOwnerSimulator.dispose();
	}
	/**
	 * pass object back so other windows can be opened before closing
	 */
	public void finishedWindow() {
		manager.closeGameWindow(this);
	}
	/**
	 * generate animal list for display based on current animals
	 * @return list of animals for display
	 */
	public String[] animalList() {
		for (int i = 0; i < farm.getAnimals().size(); i++) {
			animals[i] = farm.getAnimals().get(i).toString();
		}
		return animals;
	}
	/**
	 * generate crop list for the display
	 * @return crop list for display
	 */
	public String[] cropList() {
		crops = new String[100];
		for (int i=0; i < farm.getCrops().size(); i++) {
			crops[i] = farm.getCrops().get(i).toString();
		}
		return crops;
	}
	/**
	 * generate list of crop varieties owned
	 * @return list of crop varieties
	 */
	public String[] cropVarieties() {
		return farm.getCropVarieties().toArray(cropVarieties);
	}
	/**
	 * generate crop item list for the display
	 * @return crop item list for display
	 */
	public String[] cropItemList() {
		cropItems = new String[100];
		for (int i = 0; i < farm.getCropItems().size(); i++) {
			cropItems[i] = farm.getCropItems().get(i).toString();
		}
		return cropItems;
	}
	/**
	 * generate animal item list for the display
	 * @return animal item list for display
	 */
	public String[] animalItemList() {
		animalItems = new String[100];
		for (int i = 0; i < farm.getAnimalItems().size(); i++) {
			animalItems[i] = farm.getAnimalItems().get(i).toString();
		}
		return animalItems;
	}
	/**
	 * use a food item using farm methods
	 * @param inString string provided by GUI
	 */
	public void useFoodItem(String inString) {
		AnimalItem animalItem;
		if (inString.contains("hay")) {
			animalItem = new AnimalItem("hay");
		} else if (inString.contains("health pellets")) {
			animalItem = new AnimalItem("health pellets");
		} else {
			animalItem = new AnimalItem("grain");
		}
		
		farm.feedAnimals(animalItem);
		farm.consumeAnimalItem(animalItem);
		listLivestock.setListData(animalList());
	}
	/**
	 * use a crop item using farm methods
	 * @param inStringCropItem string repr of cropitem
	 * @param inStringCrop string repr of Crop
	 */
	public void useCropItem(String inStringCropItem, String inStringCrop) {
		CropItem cropItem;
		Crop crop;
		if (inStringCropItem.contains("fertiliser")) {
			cropItem = new CropItem("fertiliser");
		} else if (inStringCropItem.contains("rootblast")) {
			cropItem = new CropItem("rootblast");
		} else {
			cropItem = new CropItem("compost");
		}
		
		if (inStringCrop.contains("potato")) {
			crop = new Crop("potato");
		} else if (inStringCrop.contains("wheat")) {
			crop = new Crop("wheat");
		} else if (inStringCrop.contains("carrot")) {
			crop = new Crop("carrot");
		} else if (inStringCrop.contains("pumpkin")) {
			crop = new Crop("pumpkin");
		} else if (inStringCrop.contains("melon")) {
			crop = new Crop("melon");		
		} else  {
			crop = new Crop("lettuce");
		}
		
		farm.useCropItem(crop, cropItem);
		farm.consumeCropItem(cropItem);
		listCrops.setListData(cropList());
		}
	/**
	 * update GUI labels (used when action is performed)
	 */
	public void updateFarmInfo() {
			lblDaysLeft.setText("Day: " + farm.getCurrentDay() + "/" + farm.getTotalDays());
			lblActions.setText("Actions: " + farm.getActionPoints() + "/2");
			lblMoney.setText("Money: $" + farm.getMoney() );
			lblFarmerInfo.setText(farm.getFarmerInfo());
		}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmOwnerSimulator = new JFrame();
		frmFarmOwnerSimulator.setTitle("Farm Owner Simulator 2020");
		frmFarmOwnerSimulator.setBounds(100, 100, 821, 597);
		frmFarmOwnerSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmOwnerSimulator.getContentPane().setLayout(null);
		
		panelCrops = new JPanel();
		panelCrops.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCrops.setLayout(null);
		panelCrops.setBounds(408, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelCrops);
		
		JLabel lblCrops = new JLabel("Crops  (" + farm.getCrops().size() + "/" + farm.getMaxCrops() + ")");
		lblCrops.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrops.setBounds(10, 11, 367, 14);
		panelCrops.add(lblCrops);
		
		JButton btnUseCropItem = new JButton("Use Crop Item (One Variety)");
		btnUseCropItem.setToolTipText("Uses 1 action point to speed up harvest");
		btnUseCropItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farm.getCrops().size() == 0) {
					JOptionPane.showMessageDialog(null,"You don't have any crops yet!");
				} else if (!farm.actionValid()) {
					JOptionPane.showMessageDialog(null,"no action points left"); 
				} else {
				listCropItems.setListData(cropItemList());
				listCropsCropItem.setListData(cropVarieties());
				panelCrops.setVisible(false);
				panelCropItems.setVisible(true);
				updateFarmInfo();
				}
			}
		});
		btnUseCropItem.setBounds(196, 346, 181, 52);
		panelCrops.add(btnUseCropItem);
		
		JButton btnHarvest = new JButton("Harvest");
		btnHarvest.setBounds(10, 346, 181, 52);
		panelCrops.add(btnHarvest);
		btnHarvest.setToolTipText("Uses 1 action point to harvest all crops ready to harvest");
		
		JScrollPane scrollPaneCrops = new JScrollPane();
		scrollPaneCrops.setBounds(10, 36, 367, 299);
		panelCrops.add(scrollPaneCrops);
		
		listCrops = new JList<String>();
		scrollPaneCrops.setViewportView(listCrops);
		listCrops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCrops.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = cropList();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!farm.actionValid()) {
					JOptionPane.showMessageDialog(null,"no action points left");
				} else {
					int income = farm.harvest();
					if (income == 0) {
						JOptionPane.showMessageDialog(null,"no crops ready for harvest");
				} else {
					JOptionPane.showMessageDialog(null,"$" + income + " earned from harvest");
					lblCrops.setText("Crops  (" + farm.getCrops().size() + "/" + farm.getMaxCrops() + ")");
					updateFarmInfo();
					listCrops.setListData(cropList());
				}
			}
			}
		});
		
		panelCropItems = new JPanel();
		panelCropItems.setLayout(null);
		panelCropItems.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCropItems.setBounds(408, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelCropItems);
		panelCropItems.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 39, 367, 126);
		panelCropItems.add(scrollPane);
		
		listCropItems = new JList<String>();
		scrollPane.setViewportView(listCropItems);
		listCropItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCropItems.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = cropItemList();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton buttonUseCropItem = new JButton("Use Crop Item");
		buttonUseCropItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedCrop = listCropsCropItem.getSelectedValue();
				String selectedCropItem = listCropItems.getSelectedValue();
				if ((selectedCrop == null) || (selectedCropItem == null)) {
					JOptionPane.showMessageDialog(null,"please select both an item and a crop veriety to use it on.");
				} else {
					useCropItem(selectedCropItem, selectedCrop);
					listCrops.setListData(cropList());
					panelCropItems.setVisible(false);
					panelCrops.setVisible(true);
					updateFarmInfo();
				}
			}
		});
		buttonUseCropItem.setToolTipText("Uses 1 action point to speed up harvest");
		buttonUseCropItem.setBounds(196, 346, 181, 52);
		panelCropItems.add(buttonUseCropItem);
		
		JButton buttonReutrnCrops = new JButton("Back");
		buttonReutrnCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCropItems.setVisible(false);
				panelCrops.setVisible(true);
				updateFarmInfo();
			}
		});
		buttonReutrnCrops.setToolTipText("Uses 1 action point to harvest all crops ready to harvest");
		buttonReutrnCrops.setBounds(10, 346, 181, 52);
		panelCropItems.add(buttonReutrnCrops);
		
		JLabel labelCropItems = new JLabel("Crop Items");
		labelCropItems.setHorizontalAlignment(SwingConstants.CENTER);
		labelCropItems.setBounds(10, 11, 367, 14);
		panelCropItems.add(labelCropItems);
		
		listCropsCropItem = new JList<String>();
		listCropsCropItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCropsCropItem.setBounds(10, 201, 367, 134);
		listCropsCropItem.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = cropVarieties();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		panelCropItems.add(listCropsCropItem);
		
		JLabel lblCropsCropItems = new JLabel("Select Crop for Item");
		lblCropsCropItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblCropsCropItems.setBounds(10, 176, 367, 14);
		panelCropItems.add(lblCropsCropItems);
		
		panelLivestock = new JPanel();
		panelLivestock.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLivestock.setBounds(11, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelLivestock);
		panelLivestock.setLayout(null);
		
		JLabel lblLivestock = new JLabel("Livestock");
		lblLivestock.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivestock.setBounds(10, 11, 367, 14);
		panelLivestock.add(lblLivestock);

		
		JButton btnPlayWithAnimals = new JButton("Play");
		btnPlayWithAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!farm.actionValid()) {
					JOptionPane.showMessageDialog(null,"no action points left");
				} else if (farm.getAnimals().size() == 0) {
					JOptionPane.showMessageDialog(null,"You have no animals to play with");
				} else {
				farm.petAnimals();
				listLivestock.setListData(animalList());
				updateFarmInfo();
			}
			}
		});
		btnPlayWithAnimals.setToolTipText("Uses 1 action point to increase happiness");
		btnPlayWithAnimals.setBounds(196, 346, 181, 52);
		panelLivestock.add(btnPlayWithAnimals);
		
		JButton btnFeedAnimals = new JButton("Feed");
		btnFeedAnimals.setToolTipText("Uses 1 action point to increase health");
		btnFeedAnimals.setBounds(10, 346, 181, 52);
		panelLivestock.add(btnFeedAnimals);
		
		JScrollPane scrollPaneLivestock = new JScrollPane();
		scrollPaneLivestock.setBounds(10, 39, 367, 296);
		panelLivestock.add(scrollPaneLivestock);
		
		listLivestock = new JList<String>();
		scrollPaneLivestock.setViewportView(listLivestock);
		listLivestock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLivestock.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = animalList();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		btnFeedAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!farm.actionValid()) {
					JOptionPane.showMessageDialog(null,"no action points left");
				} else if (farm.getAnimals().size() == 0) {
					JOptionPane.showMessageDialog(null,"You have no animals to feed");
				} else {
					panelLivestock.setVisible(false);
					panelFeedLivestock.setVisible(true);
				}
				listLivestock.setListData(animalList());
				updateFarmInfo();
			}
		});
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setBounds(11, 11, 785, 32);
		frmFarmOwnerSimulator.getContentPane().add(panelInfo);
		panelInfo.setLayout(null);
		
		lblDaysLeft = new JLabel("Day: 0/10");
		lblDaysLeft.setBounds(706, 11, 57, 14);
		panelInfo.add(lblDaysLeft);
		
		lblActions = new JLabel("Actions: 0/2");
		lblActions.setBounds(564, 11, 81, 14);
		panelInfo.add(lblActions);
		
		lblMoney = new JLabel("Money: $0");
		lblMoney.setBounds(418, 11, 95, 14);
		panelInfo.add(lblMoney);
		
		lblFarmerInfo = new JLabel("Farmer (Age)");
		lblFarmerInfo.setBounds(10, 11, 380, 14);
		panelInfo.add(lblFarmerInfo);
		
		JPanel panelMisc = new JPanel();
		panelMisc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMisc.setBounds(11, 469, 784, 73);
		frmFarmOwnerSimulator.getContentPane().add(panelMisc);
		panelMisc.setLayout(null);
		
		JButton btnTendToFarmland = new JButton("Tend To Farmland");
		btnTendToFarmland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!farm.actionValid()) {
					JOptionPane.showMessageDialog(null,"no action points left");
				} else {
					farm.tendFarm();
					updateFarmInfo();
					lblCrops.setText("Crops  (" + farm.getCrops().size() + "/" + farm.getMaxCrops() + ")");
			}
			}
		});
		btnTendToFarmland.setToolTipText("Uses 1 action and slows down decay of animal happiness");
		btnTendToFarmland.setBounds(10, 11, 179, 51);
		panelMisc.add(btnTendToFarmland);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int earnings = farm.endDay();
				updateFarmInfo();
				listLivestock.setListData(animalList());
				listCrops.setListData(cropList());
				if (earnings > 0) {
					JOptionPane.showMessageDialog(null,"You earned $" + earnings + " today from livestock!");
				}
				if (farm.getHappyDecay() == 0) {
					JOptionPane.showMessageDialog(null,"Your farm is in bad shape! Tend to it or your animals will become less happy");
				}
				
				if (farm.getTotalDays() - 1 == farm.getCurrentDay()) {
					btnNextDay.setText("Finish Game");
				}
				
				if(farm.getTotalDays() <= farm.getCurrentDay()) {
						JOptionPane.showMessageDialog(null,"Congratulations! "
								+ farm.getFarmerInfo()  + " has finished the game with a total of $" + farm.getMoney()
								+ " in " + farm.getTotalDays() + " days"
								+ " and a score of " + farm.getScore() + "!");
						closeWindow();
				}
				
			}
		});
		btnNextDay.setBounds(595, 11, 179, 51);
		panelMisc.add(btnNextDay);
		
		JButton btnVisitStore = new JButton("Visit Store");
		btnVisitStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnVisitStore.setBounds(406, 11, 179, 51);
		panelMisc.add(btnVisitStore);
		
		panelFeedLivestock = new JPanel();
		panelFeedLivestock.setLayout(null);
		panelFeedLivestock.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFeedLivestock.setBounds(11, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelFeedLivestock);
		panelFeedLivestock.setVisible(false);
		
		JLabel labelLivestockInventory = new JLabel("Livestock Feeding Inventory");
		labelLivestockInventory.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivestockInventory.setBounds(10, 11, 367, 14);
		panelFeedLivestock.add(labelLivestockInventory);
		
		JButton buttonUseFood = new JButton("Confirm (Use Item)");
		buttonUseFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String animalItemString = listFeedingList.getSelectedValue();
				if (animalItemString == null) {
					JOptionPane.showMessageDialog(null,"please select an item");
				} else {
					useFoodItem(animalItemString);
					listFeedingList.setListData(animalItemList());
					panelLivestock.setVisible(true);
					panelFeedLivestock.setVisible(false);
					updateFarmInfo();
				}

			}
		});
		buttonUseFood.setToolTipText("Uses 1 action point to increase happiness");
		buttonUseFood.setBounds(196, 346, 181, 52);
		panelFeedLivestock.add(buttonUseFood);
		
		JButton buttonLivestockReturn = new JButton("Back");
		buttonLivestockReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelLivestock.setVisible(true);
				panelFeedLivestock.setVisible(false);
				updateFarmInfo();
			}
		});
		buttonLivestockReturn.setToolTipText("Uses 1 action point to increase health");
		buttonLivestockReturn.setBounds(10, 346, 181, 52);
		panelFeedLivestock.add(buttonLivestockReturn);
		
		JScrollPane scrollPaneFeedLivestock = new JScrollPane();
		scrollPaneFeedLivestock.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneFeedLivestock.setBounds(10, 39, 367, 296);
		panelFeedLivestock.add(scrollPaneFeedLivestock);
		
		listFeedingList = new JList<String>();
		scrollPaneFeedLivestock.setViewportView(listFeedingList);
		listFeedingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFeedingList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = animalItemList();
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
	}
	
}
