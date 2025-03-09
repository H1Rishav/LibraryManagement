

 import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainClass {
    MainFrame mainFrame=new MainFrame();

    public static void main(String[] args) {
        
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainClass window = new MainClass();
                    window.mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

}
