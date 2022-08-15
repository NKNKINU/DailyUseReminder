package GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        /**
         * Launch the application.
         */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUI frame = new MainGUI();
                    frame.setSize(430,350);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
