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