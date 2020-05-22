package Game;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;

public class MarketWindow {

	private JFrame frame;
	private int money = 100;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketWindow window = new MarketWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 398);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JList<String> list = new JList<String>();
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"potato         $3",
					"lettuce        $2","pumpkin      $6","carrot         $5",
					"wheat         $3","melon         $7"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 24, 111, 116);
		frame.getContentPane().add(list);
		
		JLabel moneyLabel = new JLabel("money = " + money);
		moneyLabel.setBounds(162, 263, 76, 14);
		frame.getContentPane().add(moneyLabel);
		
		JButton purchase1 = new JButton("Purchase");
		purchase1.setBounds(10, 141, 89, 23);
		frame.getContentPane().add(purchase1);
		purchase1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemString = list.getSelectedValue();
				int value = itemString.charAt(itemString.length()-1);
				money -= itemString.charAt(itemString.length()-1) -'0';
				moneyLabel.setText("money = " + money);
			}
			});
		

		
	}
}
