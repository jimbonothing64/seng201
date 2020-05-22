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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {

	private JFrame frmFarmOwnerSimulator;
	private JLabel lblDaysLeft;
	private JLabel lblActions;
	private JLabel lblMoney;
	private JLabel lblFarmerInfo;
	
	
	private Main manager;
	

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
		
		JList listLivestock = new JList();
		listLivestock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLivestock.setBounds(10, 36, 367, 299);
		panelLivestock.add(listLivestock);
		
		JButton btnPlayWithAnimals = new JButton("Play");
		btnPlayWithAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.getFarm().petAnimals();
				updateFarmInfo();
			}
		});
		btnPlayWithAnimals.setToolTipText("Uses 1 action point to increase happiness");
		btnPlayWithAnimals.setBounds(196, 346, 181, 52);
		panelLivestock.add(btnPlayWithAnimals);
		
		JButton btnFeedAnimals = new JButton("Feed");
		btnFeedAnimals.setToolTipText("Uses 1 action point to increase health");
		btnFeedAnimals.setBounds(10, 346, 181, 52);
		panelLivestock.add(btnFeedAnimals);
		
		JPanel panelCrops = new JPanel();
		panelCrops.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelCrops.setLayout(null);
		panelCrops.setBounds(408, 54, 387, 409);
		frmFarmOwnerSimulator.getContentPane().add(panelCrops);
		
		JLabel lblCrops = new JLabel("Crops");
		lblCrops.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrops.setBounds(10, 11, 367, 14);
		panelCrops.add(lblCrops);
		
		JList listCrops = new JList();
		listCrops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCrops.setBounds(10, 36, 367, 299);
		panelCrops.add(listCrops);
		
		JButton btnWater = new JButton("Water (One Veriety)");
		btnWater.setToolTipText("Uses 1 action point to speed up harvest");
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWater.setBounds(10, 346, 181, 52);
		panelCrops.add(btnWater);
		
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
				manager.getFarm().tendFarm();
				updateFarmInfo();
			}
		});
		btnTendToFarmland.setToolTipText("Uses 1 action and slows down decay of animal happiness");
		btnTendToFarmland.setBounds(10, 11, 179, 51);
		panelMisc.add(btnTendToFarmland);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int earnings = manager.getFarm().endDay();
				updateFarmInfo();
				if (earnings > 0) {
					JOptionPane.showMessageDialog(null,"You earned $" + earnings + " today from livestock!");
				}
				if (manager.getFarm().getHappyDecay() == 0) {
					JOptionPane.showMessageDialog(null,"Your farm is in bad shape! Tend to it or your animals will become less happy");
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
		btnVisitStore.setBounds(199, 11, 179, 51);
		panelMisc.add(btnVisitStore);
	}
	
	// update all labels presenting user with basic farm info
	void updateFarmInfo() {
		lblDaysLeft.setText("Day: " + manager.getFarm().getCurrentDay() + "/" + manager.getFarm().getTotalDays());
		lblActions.setText("Actions: " + manager.getFarm().getActionPoints() + "/2");
		lblMoney.setText("Money: $" + manager.getFarm().getMoney() );
		lblFarmerInfo.setText(manager.getFarm().getFarmerInfo());
	}
}
