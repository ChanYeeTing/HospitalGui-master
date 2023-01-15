package hospitalgui;

import sun.misc.JavaUtilZipFileAccess;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


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
    static JLabel reasonLabel;
    static JLabel remainingCharLabel;



    //JcomboBox
    static JComboBox<String> durationCB;
    static JComboBox<String> reasonCB;


    //JScrollPane
    static JScrollPane otherReasonSP;


    //JTextArea
    static JTextArea otherReasonTA;


    //Variables or Arrays
    static String selectedDate;
    static String selectedStartTime;
    static String endTime;
    static String appointmentDuration[] = {"15 mins", "30 mins", "1 hour"};
    static String appointmentReasons[] =  {"<Click to select>", "Yearly body checkup", "Sick", "Mental health checkup", "Other"};
    static String selectedDuration = appointmentDuration[0];
    static String selectedReason = appointmentReasons[0];


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

    public static void buildReasonSelection()
    {
        //initialize reasonLabel
        reasonLabel = new JLabel("Appointment Reason: ");
        reasonLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        reasonLabel.setBounds(50, 200, 500, 20);


        //initialize remainingCharLabel
        remainingCharLabel = new JLabel("(0 / 200) characters");
        remainingCharLabel.setBounds(530, 390, 200, 20);
        remainingCharLabel.setVisible(false);


        //initialize otherReasonTA
        otherReasonTA = new JTextArea();
        otherReasonTA.setLineWrap(true);
        otherReasonTA.setWrapStyleWord(true);
        otherReasonTA.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        otherReasonTA.setText("Enter your reason here...");
        otherReasonTA.setForeground(new Color(125, 125, 125));
        otherReasonTA.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(otherReasonTA.getText().equals("Enter your reason here..."))
                    otherReasonTA.setText("");
                otherReasonTA.setForeground(Color.black);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(otherReasonTA.getDocument().getLength() == 0) {
                    otherReasonTA.setText("Enter your reason here...");
                    otherReasonTA.setForeground(new Color(125, 125, 125));
                }
            }
        });
        otherReasonTA.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!otherReasonTA.getText().equals("Enter your reason here...")) {
                    remainingCharLabel.setText(("(" + otherReasonTA.getDocument().getLength()) + " / 200) characters");
                    selectedReason = otherReasonTA.getText();
                }
                if(otherReasonTA.getDocument().getLength() > 200) {
                    remainingCharLabel.setForeground(Color.RED);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                selectedReason = otherReasonTA.getText();
                remainingCharLabel.setText(("(" + otherReasonTA.getDocument().getLength()) + " / 200) characters");
                if(otherReasonTA.getDocument().getLength() <= 200) {
                    remainingCharLabel.setForeground(Color.black);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });


        //initialize otherReasonSP
        otherReasonSP = new JScrollPane (otherReasonTA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        otherReasonSP.setBounds(50, 270, 600, 120);
        otherReasonSP.setVisible(false);


        //initialize reasonCB
        reasonCB = new JComboBox<String>(appointmentReasons);
        reasonCB.setBounds(50, 230, 600, 30);
        reasonCB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        reasonCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedReason = (String) reasonCB.getSelectedItem();

                if(selectedReason == appointmentReasons[0]) {
                    otherReasonSP.setVisible(false);
                    remainingCharLabel.setVisible(false);
                }
                else if(selectedReason == appointmentReasons[appointmentReasons.length - 1]) {
                    otherReasonSP.setVisible(true);
                    remainingCharLabel.setVisible(true);
                }
                else {
                    otherReasonSP.setVisible(false);
                    remainingCharLabel.setVisible(false);
                }

            }
        });

        f.add(reasonLabel);
        f.add(reasonCB);
        f.add(otherReasonSP);
        f.add(remainingCharLabel);
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
        buildReasonSelection();
    }
}
