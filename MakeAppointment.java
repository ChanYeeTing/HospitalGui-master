package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class MakeAppointment {
    static JFrame f;
    static JPanel headerPanel;
    static JPanel p;
    static JPanel p1;
    static JPanel p1Div[];

    static JLabel startDateLabel;
    static JLabel p1Div1Label;

    static JLabel headerLabel;
    static JLabel instructionLabel;
    static JButton dateButton;
    static JScrollPane appointmentScrollBar;
    static JComboBox<String> doctorList;


    static LocalDate myDateObj = LocalDate.now();
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static String selectedDate = myDateObj.format(myFormatObj);
    static String dateArr[] = selectedDate.split("/");
    static int selectedDay = Integer.parseInt(dateArr[0]);
    static int selectedMonth = Integer.parseInt(dateArr[1]);
    static int selectedYear = Integer.parseInt(dateArr[2]);





    static String doctor [] = {"Ali", "James", "Sarah", "Mary Jane"};





    public MakeAppointment() {
        f= new JFrame("Make Appointment");

        headerLabel = new JLabel("Make Appointment");
        headerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        headerLabel.setForeground(Color.white);


        //Title
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(54, 33, 89));
        headerPanel.setBounds(0, 0, 1280, 105);
        headerPanel.setLayout(new GridBagLayout());
        headerPanel.add(headerLabel);
        f.add(headerPanel);


        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);

        instructionLabel = new JLabel("Choose Doctor name and start date:");
        instructionLabel.setFont(new Font(Font.DIALOG, Font.ITALIC|Font.BOLD, 22));
        instructionLabel.setBounds(20, 0, 1200, 100);
        p.add(instructionLabel);


        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,2));
        p1.setBounds(20, 70, 1220, 55);

        dateButton = new JButton();
        dateButton.setPreferredSize(new Dimension(200, 25));
        dateButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        dateButton.setText(selectedDay + "/" + selectedMonth + "/" + selectedYear);


        doctorList = new JComboBox<String>(doctor);
        doctorList.setPreferredSize(new Dimension(200, 25));
        doctorList.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));

        p1Div1Label = new JLabel("Doctor Name: ");
        p1Div1Label.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        startDateLabel = new JLabel("Start Date:  ");
        startDateLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

        p1Div = new JPanel[2];
        p1Div[0] = new JPanel();
        p1Div[0].setLayout(new GridBagLayout());
        p1Div[0].add(p1Div1Label);
        p1Div[0].add(doctorList);
        p1.add(p1Div[0]);

        p1Div[1] = new JPanel();
        p1Div[1].setLayout(new GridBagLayout());
        p1Div[1].add(startDateLabel);
        p1.add(p1Div[1]);


        p1Div[1].add(dateButton);
        p.add(p1);




        p.setPreferredSize(new Dimension(1000, 1400));
        p.setBackground(new Color(39, 192, 169));

        appointmentScrollBar = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        appointmentScrollBar.getVerticalScrollBar().setUnitIncrement(30);
        p.setLayout(null);
        appointmentScrollBar.setBounds(2, 105, 1265, 580);
        f.add(appointmentScrollBar);

        f.getContentPane().setBackground(new Color(121, 71, 220));
        f.setSize(1280,720);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
