package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


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

    //JButton
    static JButton dateButton;//button what will let user choose starting date

    //JScrollPane
    static JScrollPane appointmentScrollBar;//to create scroll bar for user to scroll

    //JComboBox
    static JComboBox<String> doctorList;//doctor drop down list


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

        //add l2[0] to p2Div[0] to p2 to p
        p2Div = new JPanel[6];
        p2Div[0] = new JPanel();
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

        //get number of days in current month
        int numDays = getNumOfDays(month, year);

        //use for loop to initialize remaining l2 element and set their values to day type and day of the month for the consecutive 5 days
        for(int i = 1 ; i < p2Div.length; i++) {
            l2[i] = new JLabel();
            l2[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            l2[i].setText(dayTypeArr[dayTypeIndex] + ", " + day);

            p2Div[i] = new JPanel();
            p2Div[i].add(l2[i]);

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

    //function that buildP3
    public static void buildP3(){
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
                    p3Div[i][j].setBackground(new Color(0, 152, 203));
                else
                    p3Div[i][j].setBackground(new Color(77, 196, 236));
                p3.add(p3Div[i][j]);
            }
        }
        p.add(p3);
    }


    //Constructor
    public MakeAppointment() throws ParseException {
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


        //initialize p
        p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.white);
        p.setPreferredSize(new Dimension(1000, 1400));
        p.setBackground(new Color(39, 192, 169));
        p.setLayout(null);


        //initialize instructionLabel
        instructionLabel = new JLabel("Choose Doctor name and start date:");
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


        //initialize doctorList
        doctorList = new JComboBox<String>(doctor);
        doctorList.setPreferredSize(new Dimension(200, 25));
        doctorList.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));


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
