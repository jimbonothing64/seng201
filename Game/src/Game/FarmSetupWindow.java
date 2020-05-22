package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FarmSetupWindow {

	private JFrame frmFarmSetup;
	private JTextField txtFarmerName;
	private final ButtonGroup FarmTypeGroup = new ButtonGroup();
	private JTextField textFarmTypeInfo;
	private JTextField textFarmName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmSetupWindow window = new FarmSetupWindow();
					window.frmFarmSetup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FarmSetupWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFarmSetup = new JFrame();
		frmFarmSetup.setTitle("Farm Setup");
		frmFarmSetup.setBounds(100, 100, 732, 398);
		frmFarmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSetup.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Farm Owner Simulator 2020");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWelcome.setBounds(10, 11, 696, 14);
		frmFarmSetup.getContentPane().add(lblWelcome);
		
		JPanel panelFarmerInfo = new JPanel();
		panelFarmerInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFarmerInfo.setBounds(10, 36, 696, 61);
		frmFarmSetup.getContentPane().add(panelFarmerInfo);
		panelFarmerInfo.setLayout(null);
		
		JLabel lblFarmerAgeDisplay = new JLabel("(25 years)");
		lblFarmerAgeDisplay.setBounds(401, 30, 67, 14);
		panelFarmerInfo.add(lblFarmerAgeDisplay);
		
		JLabel lblCustomizeFarmerHeading = new JLabel("Customize Your Farmer:");
		lblCustomizeFarmerHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomizeFarmerHeading.setBounds(10, 5, 676, 14);
		lblCustomizeFarmerHeading.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelFarmerInfo.add(lblCustomizeFarmerHeading);
		
		JLabel lblFarmerName = new JLabel("Farmer's Name");
		lblFarmerName.setBounds(10, 31, 93, 14);
		panelFarmerInfo.add(lblFarmerName);
		
		txtFarmerName = new JTextField();
		txtFarmerName.setText("Bob");
		txtFarmerName.setBounds(104, 28, 203, 20);
		panelFarmerInfo.add(txtFarmerName);
		txtFarmerName.setColumns(10);
		
		JLabel lblFarmerAge = new JLabel("Farmer's Age");
		lblFarmerAge.setBounds(317, 30, 81, 14);
		panelFarmerInfo.add(lblFarmerAge);
		
		JSlider sliderFarmerAge = new JSlider();
		sliderFarmerAge.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblFarmerAgeDisplay.setText("(" + sliderFarmerAge.getValue() + " years)");
			}
		});
		sliderFarmerAge.setSnapToTicks(true);
		sliderFarmerAge.setMajorTickSpacing(10);
		sliderFarmerAge.setMinorTickSpacing(1);
		sliderFarmerAge.setPaintTicks(true);
		sliderFarmerAge.setValue(25);
		sliderFarmerAge.setMaximum(95);
		sliderFarmerAge.setMinimum(18);
		sliderFarmerAge.setBounds(478, 31, 208, 14);
		panelFarmerInfo.add(sliderFarmerAge);
		
		JPanel panelFarmInfo = new JPanel();
		panelFarmInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFarmInfo.setBounds(10, 108, 696, 204);
		frmFarmSetup.getContentPane().add(panelFarmInfo);
		panelFarmInfo.setLayout(null);
		
		JLabel lblYearsDisplay = new JLabel("(7 days)");
		lblYearsDisplay.setBounds(359, 36, 64, 14);
		panelFarmInfo.add(lblYearsDisplay);
		
		JRadioButton rdbtnVolcanicSoilFarm = new JRadioButton("Volcanic Soil Plantation");
		FarmTypeGroup.add(rdbtnVolcanicSoilFarm);
		rdbtnVolcanicSoilFarm.setBounds(95, 165, 161, 23);
		panelFarmInfo.add(rdbtnVolcanicSoilFarm);
		
		JRadioButton rdbtnSwissAlpsMeadow = new JRadioButton("Swiss Alps Meadow");
		FarmTypeGroup.add(rdbtnSwissAlpsMeadow);
		rdbtnSwissAlpsMeadow.setBounds(95, 139, 161, 23);
		panelFarmInfo.add(rdbtnSwissAlpsMeadow);
		
		JRadioButton rdbtnFixerUpper = new JRadioButton("Fixer-Upper");
		FarmTypeGroup.add(rdbtnFixerUpper);
		rdbtnFixerUpper.setBounds(95, 89, 161, 23);
		panelFarmInfo.add(rdbtnFixerUpper);
		
		JRadioButton rdbtnHumbleRanch = new JRadioButton("Humble Ranch");
		FarmTypeGroup.add(rdbtnHumbleRanch);
		rdbtnHumbleRanch.setBounds(95, 113, 161, 23);
		panelFarmInfo.add(rdbtnHumbleRanch);
		
		JLabel lblFarmType = new JLabel("Farm Type");
		lblFarmType.setBounds(10, 68, 62, 14);
		panelFarmInfo.add(lblFarmType);
		
		JLabel lblFarmCustomizeHeader = new JLabel("Customize Your Farm:");
		lblFarmCustomizeHeader.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFarmCustomizeHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarmCustomizeHeader.setBounds(10, 11, 676, 14);
		panelFarmInfo.add(lblFarmCustomizeHeader);
		
		textFarmTypeInfo = new JTextField();
		textFarmTypeInfo.setEditable(false);
		textFarmTypeInfo.setBounds(274, 89, 412, 103);
		panelFarmInfo.add(textFarmTypeInfo);
		textFarmTypeInfo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Farm Type Bonuses:");
		lblNewLabel.setBounds(274, 68, 231, 14);
		panelFarmInfo.add(lblNewLabel);
		
		JLabel lblFarmsName = new JLabel("Farm's Name");
		lblFarmsName.setBounds(10, 36, 95, 14);
		panelFarmInfo.add(lblFarmsName);
		
		textFarmName = new JTextField();
		textFarmName.setText("Rolling Meadows");
		textFarmName.setBounds(95, 33, 161, 20);
		panelFarmInfo.add(textFarmName);
		textFarmName.setColumns(10);
		
		JLabel lblGameLength = new JLabel("Game Length");
		lblGameLength.setBounds(274, 36, 75, 14);
		panelFarmInfo.add(lblGameLength);
		
		JSlider sliderDays = new JSlider();
		sliderDays.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblYearsDisplay.setText("(" + sliderDays.getValue() + " days)");
			}
		});
		sliderDays.setSnapToTicks(true);
		sliderDays.setValue(7);
		sliderDays.setPaintLabels(true);
		sliderDays.setPaintTicks(true);
		sliderDays.setMinorTickSpacing(1);
		sliderDays.setMinimum(5);
		sliderDays.setMaximum(10);
		sliderDays.setBounds(424, 31, 262, 26);
		panelFarmInfo.add(sliderDays);
		
		JButton btnStart = new JButton("Start Adventure!");
		btnStart.setBackground(new Color(51, 204, 0));
		btnStart.setBounds(561, 323, 145, 23);
		frmFarmSetup.getContentPane().add(btnStart);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBackground(new Color(255, 0, 0));
		btnQuit.setBounds(10, 323, 145, 23);
		frmFarmSetup.getContentPane().add(btnQuit);
	}
}
