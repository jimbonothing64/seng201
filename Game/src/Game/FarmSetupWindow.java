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
		
		JLabel lblCustomizeFarmerHeading = new JLabel("Customize Your Farmer:");
		lblCustomizeFarmerHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomizeFarmerHeading.setBounds(10, 5, 676, 14);
		lblCustomizeFarmerHeading.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelFarmerInfo.add(lblCustomizeFarmerHeading);
		
		JLabel lblNewLabel_1 = new JLabel("Farmer's Name");
		lblNewLabel_1.setBounds(10, 31, 93, 14);
		panelFarmerInfo.add(lblNewLabel_1);
		
		txtFarmerName = new JTextField();
		txtFarmerName.setText("Bob");
		txtFarmerName.setBounds(104, 28, 203, 20);
		panelFarmerInfo.add(txtFarmerName);
		txtFarmerName.setColumns(10);
		
		JLabel lblFarmerAge = new JLabel("Farmer's Age:");
		lblFarmerAge.setBounds(370, 30, 81, 14);
		panelFarmerInfo.add(lblFarmerAge);
		
		JSlider sliderFarmerAge = new JSlider();
		sliderFarmerAge.setSnapToTicks(true);
		sliderFarmerAge.setMajorTickSpacing(10);
		sliderFarmerAge.setMinorTickSpacing(1);
		sliderFarmerAge.setPaintTicks(true);
		sliderFarmerAge.setValue(25);
		sliderFarmerAge.setMaximum(95);
		sliderFarmerAge.setMinimum(18);
		sliderFarmerAge.setBounds(496, 31, 190, 14);
		panelFarmerInfo.add(sliderFarmerAge);
		
		JLabel lblFarmerAgeDisplay = new JLabel("25");
		lblFarmerAgeDisplay.setBounds(461, 30, 25, 14);
		panelFarmerInfo.add(lblFarmerAgeDisplay);
		
		JPanel panelFarmInfo = new JPanel();
		panelFarmInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFarmInfo.setBounds(10, 108, 696, 204);
		frmFarmSetup.getContentPane().add(panelFarmInfo);
		panelFarmInfo.setLayout(null);
		
		JRadioButton rdbtnVolcanicSoilFarm = new JRadioButton("Volcanic Soil Plantation");
		FarmTypeGroup.add(rdbtnVolcanicSoilFarm);
		rdbtnVolcanicSoilFarm.setBounds(95, 165, 161, 23);
		panelFarmInfo.add(rdbtnVolcanicSoilFarm);
		
		JRadioButton rdbtnSwissAlpsMeadow = new JRadioButton("Swiss Alps Meadow");
		FarmTypeGroup.add(rdbtnSwissAlpsMeadow);
		rdbtnSwissAlpsMeadow.setBounds(95, 139, 131, 23);
		panelFarmInfo.add(rdbtnSwissAlpsMeadow);
		
		JRadioButton rdbtnFixerUpper = new JRadioButton("Fixer-Upper");
		FarmTypeGroup.add(rdbtnFixerUpper);
		rdbtnFixerUpper.setBounds(95, 89, 131, 23);
		panelFarmInfo.add(rdbtnFixerUpper);
		
		JRadioButton rdbtnHumbleRanch = new JRadioButton("Humble Ranch");
		FarmTypeGroup.add(rdbtnHumbleRanch);
		rdbtnHumbleRanch.setBounds(95, 113, 109, 23);
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
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setValue(7);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(10);
		slider.setBounds(355, 31, 331, 26);
		panelFarmInfo.add(slider);
		
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
