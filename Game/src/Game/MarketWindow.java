package Game;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

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
	private Farmer farmer = new Farmer("brown", 15);
	private Farm farm = new Farm("asd", farmer, 5);

	/**
	 * Launch the application.
	 */
	public void addCrop(Farm farm, int amount) {
		if (amount == 2) {
			Crop plant = new Crop("potato");
			farm.addCrop(plant);
		} else if (amount == 3) {
			Crop plant = new Crop("lettuce");
			farm.addCrop(plant);
		} else if (amount == 4) {
			Crop plant = new Crop("pumpkin");
			farm.addCrop(plant);
		} else if (amount == 5) {
			Crop plant = new Crop("carrot");
			farm.addCrop(plant);
		}else if (amount == 6) {
			Crop plant = new Crop("wheat");
			farm.addCrop(plant);
		}else if (amount == 7) {
			Crop plant = new Crop("melon");
			farm.addCrop(plant);
		}
	}
	public void addCropItem(Farm farm, int amount) {
		if (amount == 2) {
			CropItem item = new CropItem("fertiliser");
			farm.addCropItem(item);
		} else if (amount == 3) {
			CropItem item = new CropItem("compost");
			farm.addCropItem(item);
		} else if (amount == 4) {
			CropItem item = new CropItem("rootblast");
			farm.addCropItem(item);
		}
	}
	
	public void addAnimalItem(Farm farm, int amount) {
		if (amount == 2) {
			CropItem item = new CropItem("fertiliser");
			farm.addCropItem(item);
		} else if (amount == 3) {
			CropItem item = new CropItem("compost");
			farm.addCropItem(item);
		} else if (amount == 4) {
			CropItem item = new CropItem("rootblast");
			farm.addCropItem(item);
		}
	}
	
	public void addAnimal(Farm farm, int amount) {
		if (amount == 3) {
			Animal animal = new Chicken();
			farm.addAnimal(animal);
		} else if (amount == 7) {
			Animal animal = new Pig();
			farm.addAnimal(animal);
		} else if (amount == 9) {
			Animal animal = new Cow();
			farm.addAnimal(animal);
		}
	}
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
			String[] values = new String[] {"potato         $2",
					"lettuce        $3","pumpkin      $4","carrot         $5",
					"wheat         $6","melon         $7"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(40, 24, 111, 116);
		frame.getContentPane().add(list);
		
		JLabel moneyLabel = new JLabel("money = " + farm.getMoney());
		moneyLabel.setBounds(162, 263, 76, 14);
		frame.getContentPane().add(moneyLabel);
		
		JButton purchase1 = new JButton("Purchase");
		purchase1.setBounds(45, 141, 89, 23);
		frame.getContentPane().add(purchase1);
		purchase1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemString = list.getSelectedValue();
				if(itemString == null) {
					JOptionPane.showMessageDialog(null,"please select an item");
				}
				else {
					int value = itemString.charAt(itemString.length()-1);
					if (farm.getMoney() < value - '0') {
						JOptionPane.showMessageDialog(null,"insufficient funds"); 
				} 
					else {
						int num = itemString.charAt(itemString.length()-1) -'0';
						farm.setMoney(farm.getMoney() - num);
						addCrop(farm, num);
						moneyLabel.setText("money = " + farm.getMoney());
				}
			}
			}
			});
		JList<String> list2 = new JList<String>();
		list2.setBackground(Color.WHITE);
		list2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list2.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"fertiliser        $2",
					"compost        $3","rootblast       $4",};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		list2.setBounds(180, 24, 111, 116);
		frame.getContentPane().add(list2);
		
		JButton purchase2 = new JButton("Purchase");
		purchase2.setBounds(190, 141, 89, 23);
		frame.getContentPane().add(purchase2);
		
		JList<String> list3 = new JList<String>();
		list3.setBounds(330, 26, 111, 116);
		frame.getContentPane().add(list3);
		purchase2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemString = list2.getSelectedValue();
				if(itemString == null) {
					JOptionPane.showMessageDialog(null,"please select an item");
				}
				else {
					int value = itemString.charAt(itemString.length()-1);
					if (farm.getMoney() < value - '0') {
						JOptionPane.showMessageDialog(null,"insufficient funds"); 
				} 
					else {
						int num = itemString.charAt(itemString.length()-1) -'0';
						farm.setMoney(farm.getMoney() - num);
						addCropItem(farm, num);
						moneyLabel.setText("money = " + farm.getMoney());
				}
			}
			}
			});
		
	}
}
