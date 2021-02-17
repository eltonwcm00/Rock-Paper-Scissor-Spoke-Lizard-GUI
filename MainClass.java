import homeScreen.Landing;
import java.awt.*;
import javax.swing.*;

public class MainClass {  
  
  static Landing frame = new Landing();
  public static void main(String args[]) {
      
    callLanding();
  }

  public static void callLanding() {

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {

          frame.setVisible(true);
          frame.setTitle("Assignment");
		      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setBounds(100, 100, 800, 500);
          

        } catch (Exception e) {
          
          e.printStackTrace();
        }
      }
    });
  }

}  