package userResult;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import userScore.Score;

public class FinalResult extends JFrame implements ActionListener {

    Score scr = new Score();
    
    private JButton btExit;
    private JLabel gametitle, imagelabel, team1, team2, congrat, scoreteam1, scoreteam2;
    private ImageIcon image = new ImageIcon(new ImageIcon("userResult/image/Celebrate.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    private String score[] = {"0","1"};
    private JTable table, table1;
    private JPanel p1, p2, p3, p4, p5, tablepanel, tablepanel2;
    private JScrollPane sp, sp1;
    private DefaultTableModel model, model2;
    
    public FinalResult() {

        p1 = new JPanel ();
        p2 = new JPanel ();
        p3 = new JPanel ();
        p4 = new JPanel ();
        p5 = new JPanel ();
        btExit = new JButton("EXIT");
        
        gametitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
        imagelabel = new JLabel(image);
        team1 = new JLabel("Team 1 : 4");
        team2 = new JLabel("Team 2 : 1");
        team1.setFont(new Font("Verdana",Font.BOLD,19));
        team2.setFont(new Font("Verdana",Font.BOLD,19));
        congrat = new JLabel("Congratulation !! Team 1");
        congrat.setFont(new Font("Verdana",Font.BOLD,19));
    
        p4.setLayout(new GridLayout(2,5,1,1));
        p4.add(team1);p4.add(new JLabel(""));p4.add(team2);
        p4.add(new JLabel(""));p4.add(congrat);
        p1.add(gametitle);
        gametitle.setFont(new Font("Verdana",Font.BOLD,15));
        p1.setBackground(Color.ORANGE); //set background for the title to orange
        p2.add(imagelabel);
        p3.add(btExit);
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.WEST);
        add(p3,BorderLayout.EAST);
        add(p4,BorderLayout.CENTER);
        add(p5,BorderLayout.SOUTH);

        //Border border = LineBorder.createBlackLineBorder();
        
        //PLAYER 1 PANE
        tablepanel = new JPanel();
        /*String [][] playername  = { {"Team 1: ",},{"Team 2: ",} };//create row for table
        String [] column = {"Player 1","Round 1","Round 2","Round 3","Total"}; //create column for table*/
        model = new DefaultTableModel();
        table = new JTable(model); //set the table with row and column variables

        table.setRowHeight(60);
        sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(600,143));
        tablepanel.add(sp);
        sp.setBounds(21,2,2,2);
        p5.add(tablepanel); //work in progress
        
        //PLAYER 2 PANE
        tablepanel2 = new JPanel();
        String [][] playername1  = { {"Team 1: ",},{"Team 2: ",} };//create row for table
        String [] column1 = {"Player 2","Round 1","Round 2","Round 3","Total"}; //create column for table
        model2 = new DefaultTableModel(playername1, column1);
        table1 = new JTable(model2); //set the table with row and column variables
        table1.setRowHeight(60);
        //table1.setGridColor(Color.black);
        //table1.setBorder(border);
        sp1 = new JScrollPane(table1);
        //sp1.setBorder(border);
        sp1.setPreferredSize(new Dimension(600,143));
        tablepanel2.add(sp1);
        sp1.setBounds(21,2,2,2);
        p5.add(tablepanel2); //work in progress
        p5.setLayout(new GridLayout(2,1,10,10));

        btExit.addActionListener(this);

    }

    public JLabel returnCongratsMsg() { return congrat; }
    public JLabel returnTeam1ScoreLabel() { return team1; }
    public JLabel returnTeam2ScoreLabel() { return team2; }
    public DefaultTableModel returnTablePlayer1Name() { return model; }
    public DefaultTableModel returnTablePlayer2Name() { return model2; }
    public JPanel returnColorPanel1() { return p1; }
    public JPanel returnColorPanel2() { return p2; }
    public JPanel returnColorPanel3() { return p3; }
    public JPanel returnColorPanel4() { return p4; }
    public JPanel returnColorPanel5() { return p5; }
    public JPanel returnColorTablepanel() { return tablepanel; }
    public JPanel returnColorTablepanel2() { return tablepanel2; }
    public JTable returnJTablePlayer1Name() { return table; }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btExit) {
           
            System.exit(0);
        }
    }
            
}

