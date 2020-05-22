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

public class FarmSetupWindow {

	private JFrame frmFarmSetup;
	private JTextField txtFarmerName;

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
		frmFarmSetup.setBounds(100, 100, 732, 565);
		frmFarmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFarmSetup.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Farm Owner Simulator 2020");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWelcome.setBounds(10, 11, 696, 14);
		frmFarmSetup.getContentPane().add(lblWelcome);
		
		JPanel panelFarmerInfo = new JPanel();
		panelFarmerInfo.setBounds(0, 36, 706, 74);
		frmFarmSetup.getContentPane().add(panelFarmerInfo);
		panelFarmerInfo.setLayout(null);
		
		JLabel lblCustomizeFarmerHeading = new JLabel("Customize Your Farmer:");
		lblCustomizeFarmerHeading.setBounds(260, 5, 135, 14);
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
		
		JLabel lblFarmerAge = new JLabel("Farmer's Age");
		lblFarmerAge.setBounds(393, 30, 102, 14);
		panelFarmerInfo.add(lblFarmerAge);
		
		JSlider sliderFarmerAge = new JSlider();
		sliderFarmerAge.setValue(25);
		sliderFarmerAge.setMaximum(95);
		sliderFarmerAge.setMinimum(18);
		sliderFarmerAge.setBounds(496, 31, 200, 14);
		panelFarmerInfo.add(sliderFarmerAge);
	}
}
