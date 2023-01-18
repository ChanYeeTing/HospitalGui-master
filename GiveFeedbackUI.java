package hospitalgui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GiveFeedbackUI {
    //Jframe
    JFrame f;


    //JPanel
    JPanel headerPanel;
    JPanel p1;

    //JLabel
    JLabel headerLabel;
    JLabel feedbackTypeLabel;
    JLabel remainingChar;


    //JButton
    JButton p1Button[];


    //JComboBox
    JComboBox<String> feedbackTypeCB;



    //JTextArea
    JTextArea ta1;


    //JScrollPane
    JScrollPane sp1;


    //Variables or Arrays
    String feedbackTypeArr[] = {"Bugs Report", "Improvement", "Others"};
    static String selectedFeedbackType;

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
        p1Button[1].setVisible(false);


        //initialize p1
        p1 = new JPanel();
        p1.setBounds(0, 590, 1280, 100);
        p1.setBackground(new Color(236, 181, 181));
        p1.add(p1Button[0]);
        p1.add(p1Button[1]);

        f.add(p1);
    }


    //build feedback type selection drop down list
    public void buildFeedBackTypeSelection()
    {
        //initialize feedbackTypeCB
        feedbackTypeCB = new JComboBox<String>(feedbackTypeArr);
        feedbackTypeCB.setBounds(200, 130, 500, 30);
        feedbackTypeCB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        feedbackTypeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFeedbackType = (String) feedbackTypeCB.getSelectedItem();
            }
        });

        feedbackTypeLabel = new JLabel("Feedback Type: ");
        feedbackTypeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        feedbackTypeLabel.setBounds(50, 130, 300, 30);

        f.add(feedbackTypeLabel);
        f.add(feedbackTypeCB);
    }

    public void buildRemainingCharLabel()
    {
        remainingChar = new JLabel("(0 / 200) characters");
        remainingChar.setBounds(1080, 540, 200, 20);
        f.add(remainingChar);
    }


    public void buildFeedbackTextArea() {
        //initialize ta1
        ta1 = new JTextArea();
        ta1.setLineWrap(true);
        ta1.setWrapStyleWord(true);
        ta1.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        ta1.setText("Enter your feedback here...");
        ta1.setForeground(new Color(125, 125, 125));

        ta1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(ta1.getText().equals("Enter your feedback here..."))
                    ta1.setText("");
                ta1.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(ta1.getDocument().getLength() == 0) {
                    ta1.setText("Enter your feedback here...");
                    ta1.setForeground(new Color(125, 125, 125));
                }
            }
        });

        ta1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!ta1.getText().equals("Enter your feedback here...")) {
                    remainingChar.setText(("(" + ta1.getDocument().getLength()) + " / 200) characters");
                    p1Button[1].setVisible(true);
                }
                if(ta1.getDocument().getLength() > 200) {
                    remainingChar.setForeground(Color.RED);
                    p1Button[1].setVisible(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                remainingChar.setText(("(" + ta1.getDocument().getLength()) + " / 200) characters");
                if(ta1.getDocument().getLength() == 0)
                    p1Button[1].setVisible(false);
                else if(ta1.getDocument().getLength() <= 200) {
                    remainingChar.setForeground(Color.black);
                    p1Button[1].setVisible(true);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });



        //initialize sp1
        sp1 = new JScrollPane (ta1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setBounds(50, 180, 1160, 360);


        f.add(sp1);
    }


    public GiveFeedbackUI()
    {
        f = new JFrame("Give Feedback");

        buildHeaderPanel();

        buildFeedBackTypeSelection();

        buildFeedbackTextArea();

        buildRemainingCharLabel();

        buildP1();

        f.setSize(1280,720);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
