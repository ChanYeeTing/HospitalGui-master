package hospitalgui;

import sun.misc.JavaUtilZipFileAccess;

import javax.swing.*;
import java.awt.*;


public class SlotComfirmationUI {
    //JFrame
    static JFrame f;


    //JPanels
    static JPanel instructionPanel;
    static JPanel p1;
    static JPanel p1Div[];


    //JLabels
    static JLabel instructionLabel;
    static JLabel dateLabel;
    static JLabel slotLabel;



    //Variables or Arrays
    static String selectedDate;
    static String selectedStartTime;


    public static void buildInstructionPanel()
    {
        //initialize instructionPanel
        instructionPanel = new JPanel();
        instructionPanel.setBounds(0, 0, 700, 50);
        instructionPanel.setLayout(new GridBagLayout());
        instructionPanel.setBackground(Color.pink);


        //initialize instructionLabel
        instructionLabel = new JLabel("Select appointment duration and ensure appointment details");
        instructionLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        instructionPanel.add(instructionLabel);

        f.add(instructionPanel);
    }

    public static void buildP1()
    {
        //initialize dateLabel
        dateLabel = new JLabel("Date: " + selectedDate);
        dateLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        //initialize slotLabel
        slotLabel = new JLabel("Selected Slot: " + selectedStartTime);
        slotLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        //initialize p1Div[0] and p1Div[1]
        p1Div = new JPanel[2];
        p1Div[0] = new JPanel();
        p1Div[0].setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
        p1Div[0].add(dateLabel);

        p1Div[1] = new JPanel();
        p1Div[1].setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
        p1Div[1].add(slotLabel);

        //initialize p1
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        p1.setBounds(0, 50, 700, 50);
        p1.add(p1Div[0]);
        p1.add(p1Div[1]);

        f.add(p1);
    }


    SlotComfirmationUI(int i , int j)
    {
        selectedDate = MakeAppointment.p2DateArray[j];
        selectedStartTime = MakeAppointment.l3[i].getText();

        //initialize and set properties of f
        f = new JFrame("Slot confirm");
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);

        buildInstructionPanel();
        buildP1();
    }
}
