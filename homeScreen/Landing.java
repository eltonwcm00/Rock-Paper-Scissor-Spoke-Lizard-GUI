// Main Interface ( Welcome Landing Page )

package homeScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import userInfo.Information;
public class Landing extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JComboBox comboBox;

	private Color returnBackground;

	/**
	 *  Create an object of Information.java class to access the next frame
	 */
	Information frameInfo = new Information();

	public Landing()  {

		/**
		 * Create a JPanel and  an empty border to it sp that it can use later to hold the component 
		 */
		contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		/**
		 * Create JLabel, set it to the center of the frame and a JComboBox to hold the option of
		 * the color selection, the JComboBox is then added into the contentPane (a container) that has
		 * been created
		 */
		comboBox = new JComboBox();
		JLabel lblNewLabel = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1, 11, 781, 14);
		contentPane.add(lblNewLabel);
		comboBox.setBounds(352, 150, 89, 22);
		contentPane.add(comboBox);
		
		comboBox.addItem("Choose");
		comboBox.addItem("Red");
		comboBox.addItem("Green");
		comboBox.addItem("Blue");
		comboBox.addItem("Yellow");
		comboBox.addItem("Grey");

		/**
		 * Create two JLable "Welcome!" and "Please select the background color before you proceed:"
		 * add these label to the contentPane and set the location of the label
		 */
		JLabel lblNewLabel_1 = new JLabel("Welcome!");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(0, 76, 782, 14);
			contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please select the background color before you proceed:");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(0, 94, 783, 14);
			contentPane.add(lblNewLabel_2);

		/**
		 * Create a JButton named "PROCEED" and add into the contentPane
		 */
		btnNewButton = new JButton("PROCEED");
			btnNewButton.setBounds(337, 374, 122, 23);
			contentPane.add(btnNewButton);
		
		/**
		 * Create another JPanel set the default color value to rgb(255, 105, 0) and add the panel to the first JPanel
		 * that has been created previously
		 */
		JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 105, 0));
			panel.setBounds(0, 0, 784, 33);
			contentPane.add(panel);

		/**
		 * Add a actionListener to the "PROCEED" button
		 */
		btnNewButton.addActionListener(this);

		/**
		 * Add a actionListener to the JComboBox
		 */
		comboBox.addItemListener(new ItemListener() {
			/**
			 * Change the background of the JPanel based on the color option that user chosen
			 */
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==ItemEvent.SELECTED) {
					
					if(comboBox.getSelectedItem().toString().equals("Red")) {
						getContentPane().setBackground(Color.RED);
			
					} else if (comboBox.getSelectedItem().toString().equals("Green")) {
						getContentPane().setBackground(Color.GREEN);

					} else if (comboBox.getSelectedItem().toString().equals("Blue")) {
						getContentPane().setBackground(Color.BLUE);

					} else if (comboBox.getSelectedItem().toString().equals("Yellow")) {
						getContentPane().setBackground(Color.YELLOW);

					} else if (comboBox.getSelectedItem().toString().equals("Grey")) {
						getContentPane().setBackground(Color.GRAY);
					}	
				}
					returnBackground = getContentPane().getBackground();
			}
		});
	}

	/**
	 * Return the current background color value of the JPanel to the next frame
	 */
	public Color returnBackgroundToNext() {
		
		return returnBackground;
	}

	/**
	 * Call the next frame (Information.java) when the "PROCEED" button is clicked,
	 * the JFrame (Information.java) is then created and setup 
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNewButton) {

        	try {
				
				frameInfo.setBounds(100, 100, 757, 500);
        		frameInfo.setTitle("Player Information");
        		frameInfo.setVisible(true);
        		frameInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				/**
				 * Set the following panel that returned back from the next frame
				 * with the background color that has been selected by the player
				 */
				frameInfo.getInfoP2().setBackground(returnBackground); 
				frameInfo.getInfoP3().setBackground(returnBackground); 
				frameInfo.getInfoP4().setBackground(returnBackground);

				frameInfo.getInfoAddPlayer1Team1().setBackground(returnBackground); 
				frameInfo.getInfoAddPlayer1Team2().setBackground(returnBackground); 
				frameInfo.getInfoAddPlayer2Team1().setBackground(returnBackground);
				frameInfo.getInfoAddPlayer2Team2().setBackground(returnBackground); 
				frameInfo.getInfoButtonSize1().setBackground(returnBackground); 
				frameInfo.getInfoButtonSize2().setBackground(returnBackground);

                String info_text = "'Enter' button on the left hand side is to start the match for Player 1 game\n 'Enter' button on the right hand side is to start the match for Player 2 game";
                JOptionPane.showMessageDialog(null, info_text, "Warning!", 1);

			} catch(Exception err) {

				err.printStackTrace();
			}
        }
	}
}
