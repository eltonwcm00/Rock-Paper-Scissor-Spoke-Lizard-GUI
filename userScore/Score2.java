package userScore;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import userResult.FinalResult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;
public class Score2 extends JFrame implements ActionListener  {

    private JPanel p1, p2, p3, p4, p5, button, button2;
    private JLabel empty, rounds, picture1, picture2, player1name, player2name;
    private JButton boom1, boom2;

    private ImageIcon image[] = { new ImageIcon(getClass().getResource("image/scissors.png")),
            new ImageIcon(this.getClass().getResource("image/paper.png")),
            new ImageIcon(this.getClass().getResource("image/rock.png")),
            new ImageIcon(this.getClass().getResource("image/spock.png")),
            new ImageIcon(this.getClass().getResource("image/lizard.png")) };
    private JTable table;
    private String score[] = { "0", "1" };
    private String iconfilename, iconfilename2, fileName, fileName2;
    private DefaultTableModel model;
    private int bringScorePlayer;
    private long clickCount1, clickCount2;

    public Score2() {

        /**
         * Create a panel p1 to store a JLabel with title "Rock-Paper-Scissors-Lizard-Spock", and set the 
         * background color of this panel to the orange
         */
        p1 = new JPanel(); 
            empty = new JLabel("");
            JLabel gametitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock"); 
            p1.add(gametitle);
                gametitle.setFont(new Font("Verdana", Font.BOLD, 15));
            p1.setBackground(new Color(255, 105, 0));

        /**
         * Crete a panel p2 to store a JLabel that use to display matches round
         */
        p2 = new JPanel(); // create panel for rounds text
            rounds = new JLabel("Round 1"); // text for rounds
                rounds.setHorizontalAlignment(SwingConstants.CENTER);
                rounds.setFont(new Font("Verdana", Font.BOLD, 20));
        p2.add(rounds);

        /**
         * Create a panel p3 that add the JLabel that contains name of player 1 from team 1,
         * a default image of the game
         */
        p3 = new JPanel();
            player1name = new JLabel("Player 1");
                player1name.setHorizontalAlignment(SwingConstants.CENTER);
                player1name.setFont(new Font("Verdana", Font.BOLD, 15));
            p3.add(empty); p3.add(player1name);
        picture1 = new JLabel(image[0]); 
            p3.add(picture1);

        /**
         * Create a panel with GridLayout to store a JButton - "BOOM" that start the game, and place to the left side
         * of the panel next to the image. The button is clickable for player 1 from team 1.
         */
        button = new JPanel();
            boom1 = new JButton("BOOM!"); // Boom Button for player 1
                boom1.setLayout(new FlowLayout());
                boom1.setPreferredSize(new Dimension(80, 30));
        p3.setLayout(new GridLayout(2, 2, 1, 1));
        button.add(boom1);
        p3.add(button);
        
        /**
         * Create a panel p4 that add the JLabel that contains name of player 1 from team 2,
         * a default image of the game
         */
        p4 = new JPanel(); 
            picture2 = new JLabel(image[4]);
                picture2.setHorizontalAlignment(SwingConstants.CENTER);
                picture2.setBounds(400, 250, 400, 200);
        p4.add(empty); p4.add(empty);
        p4.add(picture2);
        player2name = new JLabel("Player 2");// Name for player2
            player2name.setHorizontalAlignment(SwingConstants.CENTER);
            player2name.setFont(new Font("Verdana", Font.BOLD, 15));
        p4.add(player2name);

        /**
         * Create a panel with GridLayout to store a JButton - "BOOM" that start the game, and place to the right side
         * of the panel next to the image. The button is clickable for player 1 from team 2.
         */
        button2 = new JPanel();
            boom2 = new JButton("BOOM!"); // boom button for player 2
                boom2.setLayout(new FlowLayout());
                boom2.setPreferredSize(new Dimension(80, 30));
        button2.add(boom2); // adding button for player 2 in Button2 JPanel
        p4.add(empty); p4.add(button2);
        p4.setLayout(new GridLayout(2, 2, 1, 1));

        /**
         * Create a panel to store the result table for player 1 from team 1 and team 2
         */
        p5 = new JPanel();
            JPanel tablepanel = new JPanel();
                String[][] playername = { { "Team 1: ", }, { "Team 2: ", } };               // Create row for table
                String[] column = { "Player 2", "Round 1", "Round 2", "Round 3", "Total" }; // Create column for table 
        model = new DefaultTableModel(playername, column);
        table = new JTable(model);                                                          // Set the table with row and column with the variable 
            table.setRowHeight(60);
        JScrollPane sp = new JScrollPane(table);                                            // Create a scroll pane for the table
            sp.setPreferredSize(new Dimension(600, 143));
        tablepanel.add(sp);                                                                 // Add in the scroll pane into the panel that has been created
            sp.setBounds(21, 2, 2, 2);
        p5.add(tablepanel);                                                                 // Add the panel into the p5 panel 

        /**
         * Create a BorderLayout to store all the created panel into inside, so that the location
         * of the paenl can be specified
         */
        setLayout(new BorderLayout());
            add(p1, BorderLayout.NORTH);
            add(p2, BorderLayout.CENTER);
            add(p3, BorderLayout.WEST);
            add(p4, BorderLayout.EAST);
            add(p5, BorderLayout.SOUTH);

        /**
         * Add an actionListener to the button of player 1 from team 1 and team 2
         */
        boom1.addActionListener(this);
        boom2.addActionListener(this);
    }

    /**
     * Return these JPanel back to Landing.java, so that the background color of these panel can be overwritten.
     * Return these JLabel back to Information.java, so that the label can be set with the player name that has 
     * been key-in by the player before this in the previous frame. Return DefaultTableModel back to Information.java,
     * so that
     */
    public JPanel getScoreP2() {return p2;}
    public JPanel getScoreP3() {return p3;}
    public JPanel getScoreP4() {return p4;}
    public JPanel getScoreP5() {return p5;}
    public JPanel getButtonPanel() {return button;}
    public JPanel getButtonPanel2() {return button2;}
    public JLabel getNameLabel() {return player1name;}
    public JLabel getNameLabel2() {return player2name;}
    public DefaultTableModel getTablePlayerName() {return model;}


    public void actionPerformed(ActionEvent e) {
        
        /**
         * Create an object fr to access FinalResult.java frame (Final Result) 
         */
        FinalResult fr = new FinalResult();
        
        /**
        * If the "BOOM" button from team 1 side is clicked, pass the array of image file into Random() to generate
        * a random image of the game. A variable call iconfilename is then created to detect the random generated image
        * and pass it into the variabe call fileName to remove the path "/" before the image format. The counter for this 
        * button will be increased upon the amount of the button click time
        */
        if (e.getSource() == boom1) {

            try {

                Random rand = new Random();
                int index = rand.nextInt(image.length);
                picture1.setIcon(image[index]);

                iconfilename = picture1.getIcon().toString();
                fileName = iconfilename.substring(iconfilename.lastIndexOf("/") + 1);

                clickCount1++;
                System.out.println("counter1 is " + clickCount1);

            } catch (Exception err) {

                err.printStackTrace();
            }

        /**
         * If the "BOOM" button from team 2 side is clicked, pass the array of image file into Random() to generate
         * a random image of the game. A variable call iconfilename2 is then created to detect the random generated image
         * and pass it into the variabe call fileNam2 to remove the path "/" before the image format. The counter for this 
         * button will be increased upon the amount of the button click time
         */    

        } else if (e.getSource() == boom2) {

            try {

                Random rand = new Random();
                int index2 = rand.nextInt(image.length);
                picture2.setIcon(image[index2]);

                iconfilename2 = picture2.getIcon().toString();
                fileName2 = iconfilename2.substring(iconfilename2.lastIndexOf("/") + 1);

                clickCount2++;
                System.out.println("counter2 is " + clickCount2);

            } catch (Exception err) {

                err.printStackTrace();
            }
        }

        /**
         * Return a function that involve the game logic
         */
        returnMatchPoint();

        /**
         * When player either click on the left or right hand side BOOM button, the condition will check if the buttons were clicked
         * for 3 times already. If it is true, will need to create a variable called nCol to get the column count of the table but 
         * minus by one due to the fact that we need to extract points data starting from column 1. The for-loop will loop through the table 
         * to extract the point data and sum up the data row by row and set the final to the table row 0 column 4 and table row 1 column 4
         */
        if (e.getSource() == boom1 || e.getSource() == boom2) {

            if (clickCount1 == 3 || clickCount2 == 3) {

                int nCol = table.getColumnCount() - 1;
                int score_amountPlayer1, score_amountPlayer2, totalPlayer1 = 0, totalPlayer2 = 0;

                for (int j = 1; j < nCol; j++) {

                    score_amountPlayer1 = Integer.parseInt(table.getValueAt(0, j).toString());
                    score_amountPlayer2 = Integer.parseInt(table.getValueAt(1, j).toString());

                    totalPlayer1 += score_amountPlayer1;
                    totalPlayer2 += score_amountPlayer2;
                }

                model.setValueAt(totalPlayer1, 0, 4);
                model.setValueAt(totalPlayer2, 1, 4);

                /**
                 * Create a variable to detect the numbe of column the table, variable : String passTeam1Name, passTeam2Name;int passScoreCol1, passScoreCol2
                 * The passTeam1Name variable is to get the row of 0,0 and column of 1,0 of the table in order to extract the name of player 1 and player 2.
                 * A for loop is then use loop through the table to get the game score from the table, the loop is initialized at x=1, is because to start extracting
                 * the score data only after the player 1 and player 2. After gotten the score data, the score data will then set to the 2nd table inside the FinalResult.java
                 */
                int nCol2 = table.getColumnCount();

                String passTeam1Name, passTeam2Name;
                int passScoreCol1, passScoreCol2;

                passTeam1Name = table.getValueAt(0, 0).toString();
                passTeam2Name = table.getValueAt(1, 0).toString();

                fr.returnTablePlayer2Name().setValueAt(passTeam1Name, 0, 0);
                fr.returnTablePlayer2Name().setValueAt(passTeam2Name, 1, 0);

                for (int x = 1; x < nCol2; x++) {

                    passScoreCol1 = Integer.parseInt(table.getValueAt(0, x).toString());
                    passScoreCol2 = Integer.parseInt(table.getValueAt(1, x).toString());

                    fr.returnTablePlayer2Name().setValueAt(passScoreCol1, 0, x);
                    fr.returnTablePlayer2Name().setValueAt(passScoreCol2, 1, x);
                }
                
                /**
                 * FinalResult.java frame will be created and initialised when clickCount of "BOOM" button has reached 3
                 */
                fr.setBounds(100, 100, 1000, 600);
                fr.setTitle("Final Result");
                fr.setVisible(true);
                fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                /**
                 * This section is to put the data of Team 1 that extract from the previous txt, into the FinalResult.java
                 * first table. 
                 * First at all, will create an object br, to read the file, 
                 * String firstLine to trim() all the white spaces within the texfile
                 * String[] columnName is to take the variable firstLine that has trimmed the spaces and split(","), so that it will ignore the "," isnide the file
                 * DefaultTableModel is to get the table model of first table from FinalResul.java
                 * Object[] tableLines is to read the txt file line by line, pass to toArray() method and extract the data as Object type
                 * model.setColumnIdentifiers(columnName) will then set the JTable header data with the trimmed data, which is "Player 1 , 	Round 1, 	Round 2, 	Round 3, 	Total"
                 * Next, the for-loop will loop through the FinalResult.java table and add table row with the extracted data, after the first line data "Player 1 , 	Round 1, 	Round 2, 	Round 3, 	Total"
                 */ 
                try {

                    String filePath = "Data.txt";
                    File file = new File(filePath);

                    BufferedReader br = new BufferedReader(new FileReader(file));

                    String firstLine = br.readLine().trim();
                    String[] columnName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) fr.returnJTablePlayer1Name().getModel();
                    model.setColumnIdentifiers(columnName);

                    Object[] tableLines = br.lines().toArray();

                    for (int i = 0; i < (tableLines.length); i++) {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }

                    file.delete();

                } catch (FileNotFoundException | NoSuchElementException err) {

                    err.printStackTrace();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                /**
                 * This section is to sum up the total score of player 1 from team 1 and team 2. Sum up the total score of player 2 
                 * from team 1 and team 2. total_score_player1_team1, total_score_player1_team2 are the variables to get the score data from FinalResult.java
                 * table
                 */
                String total_score_player1_team1, total_score_player1_team2;
                int total_score_player2_team1 = 0, total_score_player2_team2 = 0;
                int total_score_player1 = 0, total_score_player2 = 0;

                // player 1 final score
                total_score_player1_team1 = fr.returnJTablePlayer1Name().getValueAt(0, 4).toString().trim();
                total_score_player1_team2 = fr.returnJTablePlayer1Name().getValueAt(1, 4).toString().trim();

                // player 2 final score
                total_score_player2_team1 = Integer.parseInt(table.getValueAt(0, 4).toString());
                total_score_player2_team2 = Integer.parseInt(table.getValueAt(1, 4).toString());
                
                // team 1 and team 2 final score
                total_score_player1 = Integer.parseInt(total_score_player1_team1) + total_score_player2_team1;
                total_score_player2 = Integer.parseInt(total_score_player1_team2) + total_score_player2_team2;

                /**
                 * Show the message "Congrawtulation..." to the winning team. If the total score of team 1 is greater than team 2, set a text "Congratulation !! Team 1"
                 * to the JLabel that return back from FinalResult.java
                 */
                if(total_score_player1 > total_score_player2) {
                    fr.returnCongratsMsg().setText("Congratulation !! Team 1");

                } else {
                    fr.returnCongratsMsg().setText("Congratulation !! Team 2");
                }
           
                // set total score for perspective team at the returned JLabel of FinalResult.java 
                fr.returnTeam1ScoreLabel().setText("Team 1: " + total_score_player1);
                fr.returnTeam2ScoreLabel().setText("Team 2: " + total_score_player2);

                /**
                 * Set the background color of the panels from FinalResult.java
                 */
                fr.returnColorPanel1().setBackground(p2.getBackground()); fr.returnColorPanel2().setBackground(p2.getBackground());
                fr.returnColorPanel3().setBackground(p2.getBackground()); fr.returnColorPanel4().setBackground(p2.getBackground());
                fr.returnColorPanel5().setBackground(p2.getBackground()); fr.returnColorTablepanel().setBackground(p2.getBackground());
                fr.returnColorTablepanel2().setBackground(p2.getBackground());

            } else if(clickCount1 == 4) { }
        }            
        
    }

    /**
     * Game logic part, where this function use to compare the random generated image file with the image files that contained inside this project. 
     * The comparison compare between team 1 player 1 and team 1 player 2. 
     * For example, if the image file that was random generated at the player 1 side
     * is scissors.png and paper.png for player 2 side, the player 1 will win the current round and will be assigned a value 1,
     * value 2 : if player 2 won the current round
     * value 3 : if it is a tie
     */ 
    public int returnMatch() {
         
        // player 1 win condition
        if("scissors.png".equals(fileName) && "paper.png".equals(fileName2)) { System.out.println("P1 win : Scissors cuts Paper");  bringScorePlayer = 1;}
            else if("paper.png".equals(fileName) && "rock.png".equals(fileName2)) { System.out.println("P1 win : Paper covers Rock"); bringScorePlayer = 1;} 
            else if("rock.png".equals(fileName) && "lizard.png".equals(fileName2)) { System.out.println("P1 win : Rock crushes Lizard"); bringScorePlayer = 1;} 
            else if("lizard.png".equals(fileName) && "spock.png".equals(fileName2)) { System.out.println("P1 win : Lizard poisons Spock"); bringScorePlayer = 1;} 
            else if("spock.png".equals(fileName) && "scissors.png".equals(fileName2)) { System.out.println("P1 win : Spock smashes Scissors"); bringScorePlayer = 1;} 
            else if("scissors.png".equals(fileName) && "lizard.png".equals(fileName2)) { System.out.println("P1 win : Scissors decapitates Lizard"); bringScorePlayer = 1;} 
            else if("lizard.png".equals(fileName) && "paper.png".equals(fileName2)) { System.out.println("P1 win : Lizard eats Paper"); bringScorePlayer = 1;} 
            else if("paper.png".equals(fileName) && "spock.png".equals(fileName2)) { System.out.println("P1 win : Paper disproves Spock"); bringScorePlayer = 1;} 
            else if("spock.png".equals(fileName) && "rock.png".equals(fileName2)) { System.out.println("P1 win : Spock vaporizes Rock"); bringScorePlayer = 1;}
            else if("rock.png".equals(fileName) && "scissors.png".equals(fileName2)) { System.out.println("P1 win : Rock crushes Scissors"); bringScorePlayer = 1;}

            // player 2 win condition
            else if("lizard.png".equals(fileName) && "rock.png".equals(fileName)) { System.out.println("P2 win : Rock crushes Lizard"); bringScorePlayer = 2;}
            else if("lizard.png".equals(fileName) && "scissors.png".equals(fileName2)) { System.out.println("P2 win : Scissors decapitate Lizard"); bringScorePlayer = 2;}
            else if("paper.png".equals(fileName) && "lizard.png".equals(fileName2)) { System.out.println("P2 win : Lizard eats Paper"); bringScorePlayer = 2;}
            else if("paper.png".equals(fileName) && "scissors.png".equals(fileName2)) { System.out.println("P2 win : Scissors cuts Paper"); bringScorePlayer = 2;}
            else if("rock.png".equals(fileName) && "paper.png".equals(fileName2)) { System.out.println("P2 win : Paper covers Rock"); bringScorePlayer = 2;}
            else if("rock.png".equals(fileName) && "spock.png".equals(fileName2)) { System.out.println("P2 win : Spock vaporizes Rock"); bringScorePlayer = 2;}
            else if("scissors.png".equals(fileName) && "rock.png".equals(fileName2)) { System.out.println("P2 win : Rock crushes Scissors"); bringScorePlayer = 2;}
            else if("scissors.png".equals(fileName) && "spock.png".equals(fileName2)) { System.out.println("P2 win : Spock smashes Scissors"); bringScorePlayer = 2;}
            else if("spock.png".equals(fileName) && "lizard.png".equals(fileName2)) { System.out.println("P2 win : Lizard poisons Spock"); bringScorePlayer = 2;}
            else if("spock.png".equals(fileName) && "paper.png".equals(fileName2)) { System.out.println("P2 win : Paper disproves Spock"); bringScorePlayer = 2;}

            //tie condition
            else if("lizard.png".equals(fileName) && "lizard.png".equals(fileName2)) { System.out.println("Tie"); bringScorePlayer = 0;}
            else if("paper.png".equals(fileName) && "paper.png".equals(fileName2)) { System.out.println("Tie"); bringScorePlayer = 0;}
            else if("rock.png".equals(fileName) && "rock.png".equals(fileName2)) { System.out.println("Tie"); bringScorePlayer = 0;}
            else if("scissors.png".equals(fileName) && "scissors.png".equals(fileName2)) { System.out.println("Tie"); bringScorePlayer = 0;}
            else if("spock.png".equals(fileName) && "spock.png".equals(fileName2)) { System.out.println("Tie"); bringScorePlayer = 0;}

            return bringScorePlayer;
    }

    /**
     * This function is a allocate the point either 0 or 1 to the player 1 or player 2 based on the value (1 || 2 || 3) the function returnMatch() returns back to
     * this function. Before the allocation of game points to the player, the condition will need to check if the click count of the "BOOM" button is equalavent to
     * either 1, 2 or 3. If the condition is met, this function will call the returnMatch() function. The value is returned from returnMatch() if it is = 1, the table
     * row 0, column 1 will be set with score[1] = 1 and row 1, column 1 will be set with score[0] = 0.
     */
    public void returnMatchPoint() {

        if(clickCount1 == 1 && clickCount2 == 1) {
            
            int convertScorePlayer=0;

            convertScorePlayer = returnMatch();

            if(convertScorePlayer == 1) {
                model.setValueAt(score[1], 0, 1);
                model.setValueAt(score[0], 1, 1);
        
            } else if(convertScorePlayer == 2) {
                model.setValueAt(score[0], 0, 1); 
                model.setValueAt(score[1], 1, 1);
        
             } else  {
                model.setValueAt(score[0], 0, 1);
                model.setValueAt(score[0], 1, 1);
             }

        } else if(clickCount1 == 2 && clickCount2 == 2) {
                    
            int convertScorePlayer=0;

                System.out.println("Round 2 code logic execute");

                rounds.setText("Round 2");
                
                convertScorePlayer = returnMatch();

                if(convertScorePlayer == 1) {
                    model.setValueAt(score[1], 0, 2); 
                    model.setValueAt(score[0], 1, 2);
    
                } else if(convertScorePlayer == 2) {
                    model.setValueAt(score[0], 0, 2); 
                    model.setValueAt(score[1], 1, 2);
    
                } else  {
                    model.setValueAt(score[0], 0, 2);
                    model.setValueAt(score[0], 1, 2);
                }
    
        } else if(clickCount1 == 3 && clickCount2 == 3) {
                    
            int convertScorePlayer=0;

                System.out.println("Round 3 code logic execute");

                rounds.setText("Round 3");
                
                convertScorePlayer = returnMatch();

                if(convertScorePlayer == 1) {
                    model.setValueAt(score[1], 0, 3); 
                    model.setValueAt(score[0], 1, 3);
    
                } else if(convertScorePlayer == 2) {
                    model.setValueAt(score[0], 0, 3); 
                    model.setValueAt(score[1], 1, 3);
    
                } else  {
                    model.setValueAt(score[0], 0, 3);
                    model.setValueAt(score[0], 1, 3);
                }

        } 
    }
    
}
