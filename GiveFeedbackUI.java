package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GiveFeedbackUI {
    //Jframe
    JFrame f;


    //JPanel
    JPanel headerPanel;
    JPanel p1;

    //JLabel
    JLabel headerLabel;


    //JButton
    JButton p1Button[];

    //build header panel
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

    //build p1
    public void buildP1()
    {
        //initialize p1Button
        p1Button = new JButton[2];
        p1Button[0] = new JButton("CANCEL");
        p1Button[0].setFocusPainted(false);
        p1Button[0].setBackground(new Color(169, 213, 121));
        p1Button[0].setPreferredSize(new Dimension(180, 60));

        p1Button[1] = new JButton("SEND FEEDBACK");
        p1Button[1].setFocusPainted(false);
        p1Button[1].setBackground(new Color(169, 213, 121));
        p1Button[1].setPreferredSize(new Dimension(240, 60));


        //initialize p1
        p1 = new JPanel();
        p1.setBounds(0, 590, 1280, 100);
        p1.setBackground(new Color(236, 181, 181));
        p1.add(p1Button[0]);
        p1.add(p1Button[1]);

        f.add(p1);
    }


    public GiveFeedbackUI()
    {
        f = new JFrame("Give Feedback");

        buildHeaderPanel();
        buildP1();


        f.setSize(1280,720);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
