package userResult;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTable; 
public class FinalResult extends JFrame {
    
    private JButton btExit;
    private JLabel gametitle, imagelabel, team1, team2, congrat, scoreteam1, scoreteam2;
    private ImageIcon image = new ImageIcon(new ImageIcon("userResult/image/Celebrate.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    private String score[] = {"0","1"};
    private JTable table, table1;
    private JPanel p1, p2, p3, p4, p5, tablepanel, tablepanel2;
    private JScrollPane sp1;
    
    public static void main(String[] args) {
        
        FinalResult as1 = new FinalResult();
        as1.setBounds(100, 100, 1000, 500);
        as1.setTitle("Assignment Sample");
        as1.setVisible(true);
        as1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public FinalResult() {

        p1 = new JPanel ();
        p2 = new JPanel ();
        p3 = new JPanel ();
        p4 = new JPanel ();
        p5 = new JPanel ();
        btExit = new JButton("Exit");
        
        gametitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
        imagelabel = new JLabel(image);
        team1 = new JLabel("Team 1:    4");
        team2 = new JLabel("Team 2:    2");
        team1.setFont(new Font("Verdana",Font.BOLD,19));
        team2.setFont(new Font("Verdana",Font.BOLD,19));
        congrat = new JLabel("Congratulation !! Team 1");
        congrat.setFont(new Font("Verdana",Font.BOLD,19));
        scoreteam1 = new JLabel("ScoreTeam1:4");
        scoreteam2 = new JLabel("ScoreTeam2:2");
    
        p4.setLayout(new GridLayout(2,5,1,1));
        p4.add(team1);p4.add(new JLabel(""));p4.add(team2);
        p4.add(new JLabel(""));p4.add(congrat);
        p1.add(gametitle);
        gametitle.setFont(new Font("Verdana",Font.BOLD,15));
        p1.setBackground(Color.orange); //set background for the title to orange
        p2.add(imagelabel);
        p3.add(btExit);
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.CENTER);
        add(p5,BorderLayout.SOUTH);
        
        //PLAYER 1 PANE
        tablepanel = new JPanel();
        String [][] playername  = {{"Team 1: Syed",""+score[1],"","",""},{"Team 2: Elton",""+score[0],"","",""}};//create row for table
        String [] column = {"Player","Round 1","Round 2","Round 3","Total"}; //create column for table
        table = new JTable(playername,column); //set the table with row and column variables
        table.setRowHeight(60);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(600,143));
        tablepanel.add(sp);
        sp.setBounds(21,2,2,2);
        p5.add(tablepanel); //work in progress
        
        //PLAYER 2 PANE
        tablepanel2 = new JPanel();
        String [][] playername1  = {{"Team 1: Steven",""+score[1],"","",""},{"Team 2: Elton",""+score[0],"","",""}};//create row for table
        String [] column1 = {"Player","Round 1","Round 2","Round 3","Total"}; //create column for table
        table1 = new JTable(playername1,column1); //set the table with row and column variables
        table1.setRowHeight(60);
        sp1 = new JScrollPane(table1);
        sp1.setPreferredSize(new Dimension(600,143));
        tablepanel2.add(sp1);
        sp1.setBounds(21,2,2,2);
        p5.add(tablepanel2); //work in progress
        p5.setLayout(new GridLayout(2,1,10,10));
    }
            
}

