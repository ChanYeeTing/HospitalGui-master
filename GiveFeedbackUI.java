package hospitalgui;

import javax.swing.*;
import java.awt.*;

public class GiveFeedbackUI {
    //Jframe
    JFrame f;


    //JPanel
    JPanel headerPanel;

    //JLabel
    JLabel headerLabel;

    public void buildHeaderPanel()
    {
        headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1280, 100);
        headerPanel.setBackground(new Color(236, 181, 181));
        headerPanel.setLayout(new GridBagLayout());
        headerLabel = new JLabel("Give Feedback");
        headerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        headerPanel.add(headerLabel);
        f.add(headerPanel);
    }


    public GiveFeedbackUI()
    {
        f = new JFrame("Give Feedback");

        buildHeaderPanel();



        f.setSize(1280,720);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
