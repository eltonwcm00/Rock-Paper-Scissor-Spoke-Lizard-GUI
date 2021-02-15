package homeScreen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import userInfo.Information;
import userScore.Score;
//import userResult.FinalResult

public class Landing extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JComboBox comboBox;

	Information frameInfo = new Information();
	Score GM = new Score();

	public Landing()  {
		
		setTitle("Assignment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
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
		
		JLabel lblNewLabel_1 = new JLabel("Welcome!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 76, 782, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please select the background color before you proceed:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 94, 783, 14);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton = new JButton("PROCEED");
		btnNewButton.setBounds(337, 374, 122, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 105, 0));
		panel.setBounds(0, 0, 784, 33);
		contentPane.add(panel);

		btnNewButton.addActionListener(this);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange()==ItemEvent.SELECTED) {
					
					if(comboBox.getSelectedItem().toString().equals("Red")) {
						getContentPane().setBackground(Color.RED);
						frameInfo.getInfoP2().setBackground(Color.RED); frameInfo.getInfoP3().setBackground(Color.RED); frameInfo.getInfoP4().setBackground(Color.RED);
						GM.getScoreP1().setBackground(Color.RED);GM.getScoreP2().setBackground(Color.RED); GM.getScoreP3().setBackground(Color.RED); GM.getScoreP4().setBackground(Color.RED); GM.getScoreP5().setBackground(Color.RED);

					} else if (comboBox.getSelectedItem().toString().equals("Green")) {
						getContentPane().setBackground(Color.GREEN);
						frameInfo.getInfoP2().setBackground(Color.GREEN); frameInfo.getInfoP3().setBackground(Color.GREEN); frameInfo.getInfoP4().setBackground(Color.GREEN);
						GM.getScoreP1().setBackground(Color.GREEN); GM.getScoreP2().setBackground(Color.GREEN); GM.getScoreP3().setBackground(Color.GREEN); GM.getScoreP4().setBackground(Color.GREEN); GM.getScoreP5().setBackground(Color.GREEN);

					} else if (comboBox.getSelectedItem().toString().equals("Blue")) {
						getContentPane().setBackground(Color.BLUE);
						frameInfo.getInfoP2().setBackground(Color.BLUE); frameInfo.getInfoP3().setBackground(Color.BLUE); frameInfo.getInfoP4().setBackground(Color.BLUE);
						GM.getScoreP1().setBackground(Color.BLUE); GM.getScoreP2().setBackground(Color.BLUE); GM.getScoreP3().setBackground(Color.BLUE); GM.getScoreP4().setBackground(Color.BLUE); GM.getScoreP5().setBackground(Color.BLUE);

					} else if (comboBox.getSelectedItem().toString().equals("Yellow")) {
						getContentPane().setBackground(Color.YELLOW);
						frameInfo.getInfoP2().setBackground(Color.YELLOW); frameInfo.getInfoP3().setBackground(Color.YELLOW); frameInfo.getInfoP4().setBackground(Color.YELLOW);
						GM.getScoreP1().setBackground(Color.YELLOW); GM.getScoreP2().setBackground(Color.YELLOW); GM.getScoreP3().setBackground(Color.YELLOW); GM.getScoreP4().setBackground(Color.YELLOW); GM.getScoreP5().setBackground(Color.YELLOW);

					} else if (comboBox.getSelectedItem().toString().equals("Grey")) {
						getContentPane().setBackground(Color.GRAY);
						frameInfo.getInfoP2().setBackground(Color.GRAY); frameInfo.getInfoP3().setBackground(Color.GRAY); frameInfo.getInfoP4().setBackground(Color.GRAY);
						GM.getScoreP1().setBackground(Color.GRAY); GM.getScoreP2().setBackground(Color.GRAY); GM.getScoreP3().setBackground(Color.GRAY); GM.getScoreP4().setBackground(Color.GRAY); GM.getScoreP5().setBackground(Color.GRAY);
					}	
				}
			}
		});
	}

	// call Information.java
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnNewButton) {

        	frameInfo.setSize(900,600);
        	frameInfo.setTitle("Assignment");
        	frameInfo.setVisible(true);
        	frameInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.getContentPane().setBackground(Color.yellow);
			
		}

	}
	
}
