package hospitalgui;

import javax.swing.*;
import java.awt.*;

public class DateSelectionUI {
    //JFrame
    static JFrame f;

    //JPanel
    static JPanel headerPanel;


    //JLabel
    static JLabel headerLabel;

    public static void buildHeaderPanel()
    {
        headerPanel = new JPanel();
        headerPanel.setBounds(0,0, 700, 75);
        headerPanel.setBackground(new Color(54, 33, 89));
        headerPanel.setLayout(new GridBagLayout());

        //Label for header
        headerLabel = new JLabel("Select Date");
        headerLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 50));
        headerLabel.setForeground(Color.white);

        headerPanel.add(headerLabel);
        f.add(headerPanel);
    }

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


        buildHeaderPanel();

    }
}
