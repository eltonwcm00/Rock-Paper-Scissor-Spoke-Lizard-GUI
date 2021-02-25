/**
* Class Section: TT3V
* Trimester 2 2020/21
* Members:
* ELTON WONG CHUN MENG | 1181203056 | 011-11207201
* LOH YU JIN | 1181202945 | 011-10528527
* SYED IMRAN AL - MUFADHAL BIN SYED SALEH | 1191202684 | 019-2777122
* NAGENDRAAN A/L VIJAYASEGARAN | 1191202423 | 018-3191995
* STEVEN LEE KANG ZHENG | 1191202105 | 014-6839511
*/


// Main Class

import homeScreen.Landing;
import java.awt.*;
import javax.swing.*;

public class MainClass {  
  
  /**
   * Create an object of Landing.java class to access the next frame
   */
  static Landing frame = new Landing();
  public static void main(String args[]) {
    
    /**
     * Call the function callLanding() where the function itself contain code to create and 
     * setup the Landing.java JFrame
     */
    callLanding();
    String info_text = "Welcome to Elton Group's ROCK PAPER SCISSORS LIZARD SPOCK Mini Game";
    JOptionPane.showMessageDialog(null, info_text, "Welcome!", 1);
  }

  public static void callLanding() {

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {

          frame.setVisible(true);
          frame.setTitle("Main Interface");
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setBounds(100, 100, 800, 500);
          
        } catch (Exception e) {
          
          e.printStackTrace();
        }
      }
    });
  }
}  