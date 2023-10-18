package bakaraw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WaterTankGUI {

	private JFrame frame;
	private JTextField capacityTF;
	private JTextField currStateTF;
	private JTextField currLevelTF;
	WaterTank waterTank = new CreateWaterTank();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaterTankGUI window = new WaterTankGUI();
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
	public WaterTankGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 65, 65));
		frame.setBounds(100, 100, 480, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(365, 0, 106, 262);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Water Tank Status");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 173, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tank Capacity:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(62, 62, 123, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		capacityTF = new JTextField();
		capacityTF.setForeground(new Color(255, 255, 255));
		capacityTF.setBackground(new Color(107, 107, 107));
		capacityTF.setBounds(162, 65, 132, 20);
		capacityTF.setText(waterTank.currentLevel()+"");
		frame.getContentPane().add(capacityTF);
		capacityTF.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Current State:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(62, 97, 90, 24);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		currStateTF = new JTextField();
		currStateTF.setForeground(Color.WHITE);
		currStateTF.setColumns(10);
		currStateTF.setBackground(new Color(107, 107, 107));
		currStateTF.setBounds(162, 100, 132, 20);
		currStateTF.setText(waterTank.currState());
		frame.getContentPane().add(currStateTF);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Current Level:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(62, 132, 90, 24);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		currLevelTF = new JTextField();
		currLevelTF.setForeground(Color.WHITE);
		currLevelTF.setColumns(10);
		currLevelTF.setBackground(new Color(107, 107, 107));
		currLevelTF.setBounds(162, 135, 132, 20);
		currLevelTF.setText(waterTank.currentLevel()+"");
		frame.getContentPane().add(currLevelTF);
		
		JButton btnNewButton = new JButton("Add Water");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("How much do you want to add?");
				float addWaterVal = Float.parseFloat(input);
				waterTank.addWater(addWaterVal);
				if(waterTank.isFull()==false) {
					capacityTF.setText(waterTank.currentLevel()+"");
					currStateTF.setText(waterTank.currState());
					currLevelTF.setText(waterTank.currentLevel()+"");
				}else {
					JOptionPane.showMessageDialog(null, "Cannot add!\nnot enough tank space");
					waterTank.removeWater(addWaterVal);
					capacityTF.setText(waterTank.currentLevel()+"");
					currStateTF.setText(waterTank.currState());
					currLevelTF.setText(waterTank.currentLevel()+"");
				}
				
			}
		});
		btnNewButton.setBackground(new Color(44, 191, 199));
		btnNewButton.setBounds(34, 196, 166, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemoveWater = new JButton("Remove Water");
		btnRemoveWater.setBackground(new Color(255, 255, 255));
		btnRemoveWater.setBounds(210, 196, 125, 40);
		frame.getContentPane().add(btnRemoveWater);
	}
}

abstract class WaterTank{
	public abstract void watertank( );
	public abstract void addWater(float gallons);
	public abstract void removeWater(float gallons);
	public abstract float currentLevel( );
	public abstract boolean isFull( );
	public abstract boolean isEmpty( );
	public abstract String currState();
}

class CreateWaterTank extends WaterTank{
	
	private float level = 0f;
	private float capacity = 10000;
	@Override
	public void watertank() {
		
		
	}

	@Override
	public void addWater(float gallons) {
		level += gallons;
		
	}

	@Override
	public void removeWater(float gallons) {
		level -= gallons;
	}

	@Override
	public float currentLevel() {
		return level;
	}

	@Override
	public boolean isFull() {
		if(level >= capacity) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(level <= 0 ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@Override
	public String currState() {
		if(isEmpty() == true) {
			return "Empty";
		}else if(isFull()== true) {
			return "Full";
		}else {
			return "Not Full";
		}
	}
	
}