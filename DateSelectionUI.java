package hospitalgui;

import javax.swing.*;
import java.awt.*;

public class DateSelectionUI {
    JFrame f;
    DateSelectionUI()
    {
        //set properties of f
        f = new JFrame("Select Date");
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
