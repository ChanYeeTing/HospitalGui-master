package hospitalgui;

import javax.swing.*;

public class SlotComfirmationUI {
    static JFrame f;
    SlotComfirmationUI(int i , int j)
    {
        f = new JFrame("Slot confirm");
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
