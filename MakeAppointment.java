package hospitalgui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


//MakeAppointment class
class MakeAppointment {
    //JFrame
    static JFrame f;//frame to make appointment


    //JPanel
    static JPanel headerPanel;//panel for headerLabel
    static JPanel p;//panel below headerPanel, all other panel are inside this panel
    static JPanel p1;//panel to place p1Div
    static JPanel p1Div[];//panels to be placed in p1, doctorList and dateButton are placed inside each of this
    static JPanel p2;//for slot table header
    static JPanel p2Div[];//panels to be placed in p2
    static JPanel p3;//panels for table slots
    static JPanel p3Div[][];//panels to be placed in p3


    //JLabel
    static JLabel headerLabel;//label  for make appointment
    static JLabel startDateLabel;//label for start date
    static JLabel p1Div1Label;//label for Doctor Name
    static JLabel instructionLabel;//label for instructions to user
    static JLabel l2[];//labels for each p2Div in p2
    static JLabel l3[];//labels for column Start Time
    static JLabel notAvailableLabel;


    //JButton
    static JButton dateButton;//button what will let user choose starting date
    static JButton slotButton[][];
    static JButton backButton;


    //JScrollPane
    static JScrollPane appointmentScrollBar;//to create scroll bar for user to scroll


    //JComboBox
    static JComboBox<String> doctorList;//doctor drop down list


    //Borders
    static Border p2Border;
    static Border whiteBorder;


    //Variables or Arrays
    //To get date today
    static LocalDate myDateObj = LocalDate.now();
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static String selectedDate = myDateObj.format(myFormatObj);


    //To seperated date into day, month, year
    static String dateArr[] = selectedDate.split("/");
    static int selectedDay = Integer.parseInt(dateArr[0]);
    static int selectedMonth = Integer.parseInt(dateArr[1]);
    static int selectedYear = Integer.parseInt(dateArr[2]);


    static int numOfRows = 36;//number of rows in table p3


    //Arrays
    static String doctor [] = {"Ali", "James", "Sarah", "Mary Jane"};//doctor name array
    static String dayTypeArr [] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};//day type array
    static String p2DateArray[];

    static String selectedDoctor = doctor[0];


    //function to get number of days at specific month
    public static int getNumOfDays(int monthInt, int yearInt)
    {
        //compute extra day for February
        int febExtra = 0;
        if(yearInt % 4 == 0)
            febExtra = 1;

        //array of number of days in each month
        int numDay[] = {31, 28 + febExtra , 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        return numDay[monthInt -1];
    }

    //function to get day name, example: "SUNDAY"
    public static String getDayName (String date) throws ParseException {
        Date sdf = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Format f = new SimpleDateFormat("EE");
        String str = f.format(sdf);
        return str;
    }

    //create an array which store 5 consecutive dates from the date the user selected
    public static void buildP2DateArray(int d, int m, int y)
    {
        int numDays = getNumOfDays(m, y);
        for(int i = 0 ; i < p2DateArray.length; i++)
        {
            p2DateArray[i] = d + "/" + m + "/" + y;
            d++;
            if(d > numDays)
            {
                d = 1;
                m++;
                if(m > 12) {
                    m = 1;
                    y++;
                }
            }
        }
    }




    //function that buildP2
    public static void buildP2(String date) throws ParseException {
        selectedDate = date;

        //p2 for header of slot table
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 6));//6 cols: 1 for start time label, others for 5 consecutive days
        p2.setBounds(20, 130, 1220, 40);


        //initialize l2[0]
        l2 = new JLabel[6];
        l2[0] = new JLabel("Start Time");
        l2[0].setFont(new Font(Font.DIALOG, Font.BOLD, 20));


        //initialize p2Border
        p2Border = BorderFactory.createLineBorder(Color.BLACK, 2);


        //add l2[0] to p2Div[0] to p2 to p
        p2Div = new JPanel[6];
        p2Div[0] = new JPanel();
        p2Div[0].setBorder(p2Border);
        p2Div[0].add(l2[0]);
        p2.add(p2Div[0]);



        //get starting dayTypeArr index
        int dayTypeIndex = 0;
        String dayName = getDayName(date);
        for(int j = 0; j < dayTypeArr.length; j++)
        {
            if(dayName.equals(dayTypeArr[j])) {
                dayTypeIndex = j;
                break;
            }
        }



        //get the day, month, year of date selected
        dateArr = date.split("/");
        int day = selectedDay = Integer.parseInt(dateArr[0]);
        int month = selectedMonth = Integer.parseInt(dateArr[1]);
        int year = selectedYear = Integer.parseInt(dateArr[2]);

        //create an array which store 5 consecutive dates from the date the user selected
        buildP2DateArray(day, month, year);

        //get number of days in current month
        int numDays = getNumOfDays(month, year);

        //use for loop to initialize remaining l2 element and set their values to day type and day of the month for the consecutive 5 days
        for(int i = 1 ; i < p2Div.length; i++) {
            l2[i] = new JLabel();
            l2[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            l2[i].setText(dayTypeArr[dayTypeIndex] + ", " + day);

            p2Div[i] = new JPanel();
            p2Div[i].add(l2[i]);
            p2Div[i].setBorder(p2Border);

            dayTypeIndex++;
            if(dayTypeIndex >= 7)
                dayTypeIndex = 0;

            day++;
            if(day > numDays)
                day = 1;

            p2.add(p2Div[i]);
        }
        p.add(p2);
    }


    public static void fillOccupiedSlotP3(int colI, int rowSI, int rowEI)
    {
        whiteBorder = BorderFactory.createLineBorder(Color.WHITE, 2);
        while(rowSI != rowEI)
        {
            notAvailableLabel = new JLabel("Not Available");
            p3Div[rowSI][colI].add(notAvailableLabel);
            p3Div[rowSI][colI].setBorder(whiteBorder);
            p3Div[rowSI][colI].setBackground(Color.red);
            rowSI++;
        }
    }

    public static void fillDoctorScheduleP3()
    {
        String doctorInfo [];
        int p3ColIndex = 0, p3RowStartIndex = 0, p3RowEndIndex = 0;
        try {
            File myObj = new File("Doctor_Schedule.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("\t");
            while (myReader.hasNext()) {
                doctorInfo = (myReader.nextLine()).split("\t");
                if(doctorInfo[0].equals(selectedDoctor))
                {
                    for(int i = 0 ; i < p2DateArray.length ; i++)
                    {
                        if(p2DateArray[i].equals(doctorInfo[1]))
                        {
                            p3ColIndex = i + 1;
                            for(int j = 0 ; j < l3.length ; j++)
                            {
                                if(doctorInfo[2].equals(l3[j].getText()))
                                    p3RowStartIndex = j;
                                if(doctorInfo[3].equals(l3[j].getText())) {
                                    p3RowEndIndex = j;
                                    fillOccupiedSlotP3(p3ColIndex, p3RowStartIndex, p3RowEndIndex);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    //function to build up the array of string to be used in labels of Start Time
    public static void buildL3Array()
    {
        int min = 0;
        int hour = 9;
        l3 = new JLabel[40];
        for(int i = 0; i < l3.length; i++)
        {
            l3[i] = new JLabel();
            if(min == 0){
                l3[i].setText(hour + ":00");
            }else
                l3[i].setText(hour + ":" + min);
            min+=15;
            if(min == 60)
            {
                min = 0;
                hour++;
            }
        }
    }

    public static void buildP3AvailableSlot()
    {
        slotButton = new JButton[36][5];
        for(int i = 0 ; i < 36; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(!(p3Div[i][j+1].getBackground().toString().equals("java.awt.Color[r=255,g=0,b=0]"))) {
                    slotButton[i][j] = new JButton("Make Appointment");
                    slotButton[i][j].setBounds(0, 0, 200, 30);
                    slotButton[i][j].setFocusPainted(false);
                    slotButton[i][j].setBackground(new Color(167, 253, 87));
                    int finalI = i;
                    int finalJ = j;
                    slotButton[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(slotButton[finalI][finalJ].getText().equals("Pending...")) {
                            }else
                                new SlotComfirmationUI(finalI, finalJ);
                        }
                    });
                    p3Div[i][j + 1].setLayout(null);
                    p3Div[i][j + 1].add(slotButton[i][j]);
                }
            }
        }
    }

    public static void buildPendingP3() throws FileNotFoundException {
        String pendingAppointmentInfo[];
        File myObj = new File("appointmentRequest.txt");
        Scanner myReader = new Scanner(myObj);
        myReader.useDelimiter("\t");
        while (myReader.hasNext()) {
            pendingAppointmentInfo = (myReader.nextLine()).split("\t");
            if(pendingAppointmentInfo[0].equals(PatientInfo.account) && pendingAppointmentInfo[1].equals(selectedDoctor)) {
                for (int i = 0; i < p2DateArray.length; i++) {
                    if (pendingAppointmentInfo[2].equals(p2DateArray[i])) {
                        for (int j = 0; j < 36; j++) {
                            if (pendingAppointmentInfo[3].equals(l3[j].getText())) {
                                slotButton[j][i].setText("Pending...");
                                slotButton[j][i].setBackground(Color.red);
                                for (int k = j + 1; k < 36; k++) {
                                    if (pendingAppointmentInfo[4].equals(l3[k].getText())) {
                                        break;
                                    } else {
                                        slotButton[k][i].setText("Pending...");
                                        slotButton[k][i].setBackground(Color.red);
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        myReader.close();;
    }


    //function that buildP3
    public static void buildP3() throws FileNotFoundException {
        buildL3Array();

        //initialize p3
        p3 = new JPanel();
        p3.setLayout(new GridLayout(numOfRows,6));//36 x 6 dimension
        p3.setBounds(20, 170, 1220, 1200);

        //initialize p3Div and set color to each of them, add it to p3 to p
        p3Div = new JPanel[numOfRows][6];
        for(int i = 0 ; i < numOfRows ; i++)
        {
            for(int j = 0; j < 6; j++)
            {
                p3Div[i][j] = new JPanel();
                if((i+j) % 2 == 0)
                    p3Div[i][j].setBackground(new Color(240, 242, 245));
                else
                    p3Div[i][j].setBackground(new Color(250, 250, 251));
                p3.add(p3Div[i][j]);
            }
            p3Div[i][0].add(l3[i]);
        }
        fillDoctorScheduleP3();
        buildP3AvailableSlot();
        buildPendingP3();
        p.add(p3);
    }


    //Constructor
    public MakeAppointment() throws ParseException, FileNotFoundException {
        //create new frame
        f= new JFrame("Make Appointment");

        //initialize headerLabel
        headerLabel = new JLabel("Make Appointment");
        headerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 35));
        headerLabel.setForeground(Color.white);


        //initialize headerPanel
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(54, 33, 89));
        headerPanel.setBounds(0, 0, 1280, 105);
        headerPanel.setLayout(new GridBagLayout());


        //initialize backButton
        backButton = new JButton("Back");
        backButton.setFont(new Font("Calibri", Font.BOLD, 20));
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(231, 183, 183));
        backButton.setBounds(10, 10, 100, 40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new HospitalGUI();
            }
        });
        f.add(backButton);


        //initialize p
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(1000, 1400));
        p.setBackground(new Color(39, 192, 169));
        p.setLayout(null);


        //initialize instructionLabel
        instructionLabel = new JLabel("Select doctor and start date then click the \"Make Appointment\" button on the slots you wish to attend :)");
        instructionLabel.setFont(new Font(Font.DIALOG, Font.ITALIC|Font.BOLD, 22));
        instructionLabel.setBounds(20, 0, 1200, 100);


        //initialize p1
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,2));
        p1.setBounds(20, 70, 1220, 55);


        //initialize appointmentScrollBar
        appointmentScrollBar = new JScrollPane(p, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        appointmentScrollBar.getVerticalScrollBar().setUnitIncrement(30);
        appointmentScrollBar.setBounds(2, 105, 1265, 580);


        //initialize dateButton
        dateButton = new JButton();
        dateButton.setPreferredSize(new Dimension(200, 25));
        dateButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        dateButton.setText(selectedDay + "/" + selectedMonth + "/" + selectedYear);
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DateSelectionUI();
            }
        });


        //initialize doctorList
        doctorList = new JComboBox<String>(doctor);
        doctorList.setPreferredSize(new Dimension(200, 25));
        doctorList.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        doctorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDoctor = (String) doctorList.getSelectedItem();
                p3.setVisible(false);
                try {
                    buildP3();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //initialize p1Div1Label
        p1Div1Label = new JLabel("Doctor Name: ");
        p1Div1Label.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));


        //initialize startDateLabel
        startDateLabel = new JLabel("Start Date:  ");
        startDateLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));


        //initialize p1Div[0]
        p1Div = new JPanel[2];
        p1Div[0] = new JPanel();
        p1Div[0].setLayout(new GridBagLayout());


        //initialize p1Div[1]
        p1Div[1] = new JPanel();
        p1Div[1].setLayout(new GridBagLayout());


        //add items into panels or frame
        headerPanel.add(headerLabel);
        f.add(headerPanel);

        p.add(instructionLabel);

        p1Div[0].add(p1Div1Label);
        p1Div[0].add(doctorList);
        p1.add(p1Div[0]);

        p1Div[1].add(startDateLabel);
        p1Div[1].add(dateButton);
        p1.add(p1Div[1]);
        p.add(p1);

        f.add(appointmentScrollBar);


        p2DateArray = new String[5];
        //calls functions build p2 and p3
        buildP2(selectedDate);
        buildP3();


        //set properties of f
        f.getContentPane().setBackground(new Color(121, 71, 220));
        f.setSize(1280,720);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);
    }
}
