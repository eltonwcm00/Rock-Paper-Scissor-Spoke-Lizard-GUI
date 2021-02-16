package userInfo;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import userScore.Score;
public class Information extends JFrame implements ActionListener {
    
    private JTextField tfPlayer1,tfPlayer2,tfPlayer3,tfPlayer4;
    private JButton btEnter,btEnter1;
    private JPanel p1, p2, p3, p4;

    private String player1nameLabel;
    private String player2nameLabel;

    Score GM = new Score();
  
    public Information() {

         p1 = new JPanel();
         p2 = new JPanel(new GridLayout(4,3));
         p3 = new JPanel(new GridLayout(4,3));
         p4 = new JPanel();

        JLabel Information = new JLabel("Rock-Paper-Scissors-Lizard-Spock"); //Title
        p1.add(Information);
        Information.setFont(new Font("Verdana",Font.BOLD,15));
        p1.setBackground(Color.orange);
        
        JLabel Team = new JLabel("Team 1"); 
        Team.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel Player = new JLabel("Enter player names:");
        Player.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel Team2 = new JLabel("Team 2"); 
        Team2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel Player2 = new JLabel("Enter player names:");
        Player2.setHorizontalAlignment(SwingConstants.CENTER);
       
        p2.setLayout(new GridLayout(5,3));
        p2.add(new JLabel(""));p2.add(Team); p2.add(new JLabel(""));
        p2.add(new JLabel(""));p2.add(Player); p2.add(new JLabel(""));
        
        p2.add(new JLabel("Player 1 :"));
        p2.add(tfPlayer1= new JTextField(15));
        p2.add(new JLabel(""));
        
        p2.add(new JLabel("Player 2 :"));
        p2.add(tfPlayer2 = new JTextField(15));
        p2.add(new JLabel(""));      
        
        p3.setLayout(new GridLayout(5,3));
        p3.add(new JLabel("")); p3.add(Team2);p3.add(new JLabel(""));
        p3.add(new JLabel("")); p3.add(Player2);p3.add(new JLabel(""));
        p3.add(new JLabel("Player 1 :"));
        p3.add(tfPlayer3 = new JTextField(15));
        p3.add(new JLabel(""));
        p3.add(new JLabel("Player 2 :"));
        p3.add(tfPlayer4 = new JTextField(15));
        p3.add(new JLabel(""));
        
        p4.setLayout(new GridLayout(1,6));
        btEnter = new JButton("Enter");
        btEnter1 = new JButton("Enter");
        p4.add(new JLabel(""));
        p4.add(btEnter); p4.add(new JLabel(""));
        p4.add(new JLabel("")); p4.add(btEnter1); p4.add(new JLabel(""));

        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.SOUTH);

        btEnter.addActionListener(this);
        btEnter1.addActionListener(this);
    }

    public JPanel getInfoP2() {return p2;}
    public JPanel getInfoP3() {return p3;}
    public JPanel getInfoP4() {return p4;}

    // call Score.java
    public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btEnter /*|| e.getSource() == btEnter1*/) {
			
            try {

                player1nameLabel = tfPlayer1.getText();
                player2nameLabel = tfPlayer2.getText();

                GM.setBounds(100,100,200,500);
                GM.setTitle("Assignment");
                GM.setSize(900,600);
                GM.setVisible(true);
                GM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                GM.getScoreP2().setBackground(p2.getBackground()); GM.getScoreP3().setBackground(p2.getBackground()); 
                GM.getScoreP4().setBackground(p2.getBackground()); GM.getScoreP5().setBackground(p2.getBackground());
                GM.getButtonPanel().setBackground(p2.getBackground()); GM.getButtonPanel2().setBackground(p2.getBackground());
    
                GM.getNameLabel().setText(player1nameLabel);
                GM.getNameLabel2().setText(player2nameLabel);

            } catch(Exception err) {
                 
                err.printStackTrace();
            }  
        }
	}  
}

