package hospitalgui;

import sun.misc.JavaUtilZipFileAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SlotComfirmationUI {
    //JFrame
    static JFrame f;


    //JPanels
    static JPanel instructionPanel;
    static JPanel p1;
    static JPanel p1Div[];
    static JPanel p2;
    static JPanel p2Div[];


    //JLabels
    static JLabel instructionLabel;
    static JLabel dateLabel;
    static JLabel slotLabel;
    static JLabel durationLabel;
    static JLabel endTimeLabel;



    //JcomboBox
    static JComboBox<String> durationCB;



    //Variables or Arrays
    static String selectedDate;
    static String selectedStartTime;
    static String endTime;
    static String appointmentDuration[] = {"15 mins", "30 mins", "1 hour"};
    static String selectedDuration = appointmentDuration[0];


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

    public static void buildP2(int i)
    {
        //initialize durationCB
        durationCB = new JComboBox<String>(appointmentDuration);
        durationCB.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        durationCB.setPreferredSize(new Dimension(150, 30));
        durationCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDuration = (String) durationCB.getSelectedItem();
                if(selectedDuration.equals(appointmentDuration[0]))
                    endTime = MakeAppointment.l3[i+1].getText();
                else if (selectedDuration.equals(appointmentDuration[1]))
                    endTime = MakeAppointment.l3[i+2].getText();
                else if (selectedDuration.equals(appointmentDuration[2]))
                    endTime = MakeAppointment.l3[i+4].getText();
                endTimeLabel.setText("End time: " + endTime);
            }
        });

        //initialize durationLabel
        durationLabel = new JLabel("Duration: ");
        durationLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));


        //initiailze endTimeLabel
        endTimeLabel = new JLabel("End time: " + endTime);
        endTimeLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));


        //initialize p2Div
        p2Div = new JPanel[2];

        p2Div[0] = new JPanel();
        p2Div[0].setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
        p2Div[0].add(durationLabel);
        p2Div[0].add(durationCB);

        p2Div[1] = new JPanel();
        p2Div[1].setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
        p2Div[1].add(endTimeLabel);


        //initialize p2
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));
        p2.setBounds(0, 100, 700, 50);
        p2.add(p2Div[0]);
        p2.add(p2Div[1]);

        f.add(p2);
    }


    SlotComfirmationUI(int i , int j)
    {
        //initialize selectedDate, selectedStartTime, endTime
        selectedDate = MakeAppointment.p2DateArray[j];
        selectedStartTime = MakeAppointment.l3[i].getText();
        endTime = MakeAppointment.l3[i+1].getText();


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
        buildP2(i);
    }
}
