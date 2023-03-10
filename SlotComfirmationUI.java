package hospitalgui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileWriter;
import java.io.IOException;


public class SlotComfirmationUI {
    //JFrame
    static JFrame f;


    //JPanels
    static JPanel instructionPanel;
    static JPanel p1;
    static JPanel p1Div[];
    static JPanel p2;
    static JPanel p2Div[];
    static JPanel p3;


    //JLabels
    static JLabel instructionLabel;
    static JLabel dateLabel;
    static JLabel slotLabel;
    static JLabel durationLabel;
    static JLabel endTimeLabel;
    static JLabel reasonLabel;
    static JLabel remainingCharLabel;


    //JButtons
    static JButton p3Button1;
    static JButton p3Button2;



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
    static String selectedDoctor;
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
                    p3Button2.setVisible(true);
                    selectedReason = otherReasonTA.getText().replace('\n', ' ');
                }
                if(otherReasonTA.getDocument().getLength() > 200) {
                    remainingCharLabel.setForeground(Color.RED);
                    p3Button2.setVisible(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                selectedReason = otherReasonTA.getText();
                remainingCharLabel.setText(("(" + otherReasonTA.getDocument().getLength()) + " / 200) characters");
                if(otherReasonTA.getDocument().getLength() == 0)
                      p3Button2.setVisible(false);
                else if(otherReasonTA.getDocument().getLength() <= 200) {
                    remainingCharLabel.setForeground(Color.black);
                    p3Button2.setVisible(true);
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
                    p3Button2.setVisible(false);
                    remainingCharLabel.setVisible(false);
                }
                else if(selectedReason == appointmentReasons[appointmentReasons.length - 1]) {
                    otherReasonSP.setVisible(true);
                    remainingCharLabel.setVisible(true);
                    if(otherReasonTA.getText().equals("Enter your reason here...") || otherReasonTA.getDocument().getLength() == 0 || otherReasonTA.getDocument().getLength() > 200)
                        p3Button2.setVisible(false);
                    else
                        p3Button2.setVisible(true);
                }
                else {
                    p3Button2.setVisible(true);
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

    public static void buildP3(int i , int j)
    {
        p3Button1 = new JButton("CANCEL");
        p3Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        p3Button1.setFocusPainted(false);
        p3Button1.setPreferredSize(new Dimension(100, 30));

        p3Button2 = new JButton("OK");
        p3Button2.setFocusPainted(false);
        p3Button2.setPreferredSize(new Dimension(100, 30));
        p3Button2.setVisible(false);
        p3Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPendingMAP3(i, j);
                insertAppointmentRequest();
                f.dispose();
            }
        });

        p3 = new JPanel();
        p3.setBackground(Color.pink);
        p3.setBounds(0, 410, 700, 60);
        p3.add(p3Button1);
        p3.add(p3Button2);

        f.add(p3);
    }

    public static void addPendingMAP3(int i , int j)
    {
        int numSlot = 0;
        if(selectedDuration.equals(appointmentDuration[0]))
            numSlot = 1;
        else if (selectedDuration.equals(appointmentDuration[1]))
            numSlot = 2;
        else if (selectedDuration.equals(appointmentDuration[2]))
            numSlot = 4;

        for(int k = 0; k < numSlot; k++)
        {
            if(MakeAppointment.slotButton[i][j] != null) {
                MakeAppointment.slotButton[i][j].setText("Pending...");
                MakeAppointment.slotButton[i][j].setBackground(Color.red);
                MakeAppointment.p3Div[i][j + 1].setBackground(Color.red);
                i++;
            }
            if (i >= 36)
                break;
        }
    }

    public static void insertAppointmentRequest()
    {
        try {
            FileWriter myWriter = new FileWriter("appointmentRequest.txt", true);
            myWriter.write(PatientInfo.account + "\t" + selectedDoctor + "\t" + selectedDate + "\t" + selectedStartTime + "\t" + endTime + "\t" + selectedReason + "\n");
            myWriter.close();
        }catch(IOException e) {
            System.out.println("Something went wrong");
        }
    }


    SlotComfirmationUI(int i , int j)
    {
        //initialize selectedDate, selectedStartTime, endTime, selectedDoctor
        selectedDate = MakeAppointment.p2DateArray[j];
        selectedStartTime = MakeAppointment.l3[i].getText();
        endTime = MakeAppointment.l3[i+1].getText();
        selectedDoctor = MakeAppointment.selectedDoctor;

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
        buildP3(i, j);
    }
}
