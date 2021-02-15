import homeScreen.Landing;
import java.awt.*;
  
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

        } catch (Exception e) {
          
          e.printStackTrace();
        }
      }
    });
  }

}  