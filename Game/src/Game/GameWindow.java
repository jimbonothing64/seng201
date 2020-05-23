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

public class GameWindow {

	private JFrame frmFarmOwnerSimulator;
	private JLabel lblDaysLeft;
	private JLabel lblActions;
	private JLabel lblMoney;
	private JLabel lblFarmerInfo;
	private Farm farm;
	private String[] animals = new String[50];
	private String[] crops = new String[50];
	private Main manager;
	private JList<String> listLivestock;
	private JList<String> listCrops;
	

	/**
	 * Launch the application.
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
	
	public void closeWindow() {
		frmFarmOwnerSimulator.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGameWindow(this);
	}
	// returns a list of animal / crop descriptions to show in game panel
	public String[] animalList() {
		for (int i = 0; i < farm.getAnimals().size(); i++) {
			animals[i] = farm.getAnimals().get(i).toString();
		}
		return animals;
	}
	
	public String[] cropList() {
		crops = new String[50];
		for (int i=0; i < farm.getCrops().size(); i++) {
			crops[i] = farm.getCrops().get(i).toString();
		}
		return crops;
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
		
		JPanel panelLivestock = new JPanel();
		panelLivestock.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLivestock.setBounds(11, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelLivestock);
		panelLivestock.setLayout(null);
		
		JLabel lblLivestock = new JLabel("Livestock");
		lblLivestock.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivestock.setBounds(10, 11, 367, 14);
		panelLivestock.add(lblLivestock);
		
		listLivestock = new JList<String>();
		listLivestock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLivestock.setBounds(10, 36, 367, 299);
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
		panelLivestock.add(listLivestock);

		
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
		btnFeedAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!farm.actionValid()) {
					JOptionPane.showMessageDialog(null,"no action points left");
				} else if (farm.getAnimals().size() == 0) {
					JOptionPane.showMessageDialog(null,"You have no animals to feed");
				} else {
				//item = getselecteditem();
				//farm.feedAnimals(item);
				listLivestock.setListData(animalList());
				updateFarmInfo();
				}
			}
		});
		
		JPanel panelCrops = new JPanel();
		panelCrops.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCrops.setLayout(null);
		panelCrops.setBounds(408, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelCrops);
		
		JLabel lblCrops = new JLabel("Crops  (" + farm.getCrops().size() + "/" + farm.getMaxCrops() + ")");
		lblCrops.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrops.setBounds(10, 11, 367, 14);
		panelCrops.add(lblCrops);
		
		listCrops = new JList<String>();
		listCrops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCrops.setBounds(10, 36, 367, 299);
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
		panelCrops.add(listCrops);
		
		JButton btnUseCropItem = new JButton("Use Crop Item (One Veriety)");
		btnUseCropItem.setToolTipText("Uses 1 action point to speed up harvest");
		btnUseCropItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUseCropItem.setBounds(196, 346, 181, 52);
		panelCrops.add(btnUseCropItem);
		
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
				
				if(farm.getTotalDays() < farm.getCurrentDay()) {
						JOptionPane.showMessageDialog(null,"Congratulations! "
								+ "you have finished the game with a total of $" + farm.getMoney()
								+ " and a score of " + farm.getScore() + "!");
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
		
		JButton btnHarvest = new JButton("Harvest");
		btnHarvest.setBounds(199, 10, 181, 52);
		panelMisc.add(btnHarvest);
		btnHarvest.setToolTipText("Uses 1 action point to harvest all crops ready to harvest");
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
	}
	
	// update all labels presenting user with basic farm info
	void updateFarmInfo() {
		lblDaysLeft.setText("Day: " + farm.getCurrentDay() + "/" + farm.getTotalDays());
		lblActions.setText("Actions: " + farm.getActionPoints() + "/2");
		lblMoney.setText("Money: $" + farm.getMoney() );
		lblFarmerInfo.setText(farm.getFarmerInfo());
	}
}
