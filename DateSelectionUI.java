package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DateSelectionUI {
    //JFrame
    static JFrame f;//frame for DateSelectionUI

    //JPanel
    static JPanel headerPanel;//panel for header
    static JPanel p1;//panel for p1Div to be inserted
    static JPanel p1Div[];//3 small panels for 2 arrow button and a calendar month and year label
    static JPanel p2;//panel for calendar
    static JPanel p2Div[];//49 panels to be put into p2


    //JLabel
    static JLabel headerLabel;//headerLabel
    static JLabel monthLabel;//label for month of the label
    static JLabel l[];//labels for day type name in calendar


    //JButton
    static JButton bPreviousMonth;//button to allow user view previous month calendar
    static JButton bNextMonth;//button to allow user view next month calendar
    static JButton b[];//buttons in calendar


    //Variables or Arrays
    static int daySelected;//store day of month selected
    static int monthSelected;//store month selected
    static int yearSelected;//store year selected
    static int day1DayTypeArrIndex;//store the index of dayTypeArr which the value is the day type of first day of month
    static int displacementAccumulator;//accumulate the displacement needed, the value used to determine location of button in calendar
    static String dateSelected;//store date selectec
    static LocalDate myDateObj = LocalDate.now();//date object

    //array of month names
    static String monthStr [] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    //array of day type name in 3 characters
    static String dayTypeArr [] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};



    //function to build headerPanel
    public static void buildHeaderPanel()
    {
        headerPanel = new JPanel();
        headerPanel.setBounds(0,0, 700, 75);
        headerPanel.setBackground(new Color(54, 33, 89));
        headerPanel.setLayout(new GridBagLayout());

        //Label for header
        headerLabel = new JLabel("Select Date");
        headerLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 50));
        headerLabel.setForeground(Color.white);

        headerPanel.add(headerLabel);
        f.add(headerPanel);
    }

    //function to build p1
    public static void buildP1()
    {
        //get information of calendar
        daySelected = myDateObj.getDayOfMonth();
        monthSelected = myDateObj.getMonthValue();
        yearSelected = myDateObj.getYear();



        //initialize Panel 1
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3));
        p1.setBounds(45, 105, 600,40);


        //initialize month-year label
        monthLabel = new JLabel(monthStr[monthSelected -1] + " " + yearSelected);
        monthLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        monthLabel.setBounds(45, 25, 500,150);




        //initialize button for previous month
        bPreviousMonth = new JButton("<");
        bPreviousMonth.setForeground(Color.white);
        bPreviousMonth.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 35));
        bPreviousMonth.setFocusPainted(false);
        bPreviousMonth.setContentAreaFilled(false);
        bPreviousMonth.setPreferredSize(new Dimension(60, 35));
        bPreviousMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //update the month and year
                monthSelected--;
                if (monthSelected <= 0) {
                    monthSelected = 12;
                    yearSelected--;
                }

                //every time move to previous month set default day selected is 1
                daySelected = 1;

                //reset monthLabel
                monthLabel.setText(monthStr[monthSelected -1] + " " + yearSelected);

                //get number of days and displacement needed to rebuild p2
                int numDays = MakeAppointment.getNumOfDays(monthSelected, yearSelected);
                int displacement = numDays;

                //rebuild p2
                p2.setVisible(false);
                buildP2(numDays, -displacement);
                f.add(p2);
                f.add(p1);
            }
        });


        //initialize button for next month
        bNextMonth = new JButton(">");
        bNextMonth.setForeground(Color.white);
        bNextMonth.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 35));
        bNextMonth.setFocusPainted(false);
        bNextMonth.setContentAreaFilled(false);
        bNextMonth.setPreferredSize(new Dimension(60, 35));
        bNextMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get the displacement needed to rebuild p2
                int displacement = MakeAppointment.getNumOfDays(monthSelected, yearSelected);

                //update the month and year
                monthSelected++;
                if (monthSelected > 12) {
                    monthSelected = 1;
                    yearSelected++;
                }

                //every time move to next month set default day selected is 1
                daySelected = 1;

                //reset monthLabel
                monthLabel.setText(monthStr[monthSelected -1] + " " + yearSelected);

                //get number of days needed to rebuild p2
                int numDays = MakeAppointment.getNumOfDays(monthSelected, yearSelected);

                //rebuild p2
                p2.setVisible(false);
                buildP2(numDays, displacement);
                f.add(p2);
                f.add(p1);
            }
        });

        //initialize p1Div
        p1Div = new JPanel[3];
        for(int i = 0 ; i < p1Div.length; i++)
        {
            p1Div[i] = new JPanel();
            p1Div[i].setLayout(new GridBagLayout());
            p1Div[i].setBackground(new Color(167, 252, 175));
            p1.add(p1Div[i]);
        }
        p1Div[0].add(bPreviousMonth);
        p1Div[1].add(monthLabel);
        p1Div[2].add(bNextMonth);

        f.add(p1);
    }


    public static void buildP2(int numDays, int displacement) {
        //get dateSelected in day/month/year format
        dateSelected = "" + daySelected + "/" + monthSelected + "/" + yearSelected;

        //initialize p2
        p2 = new JPanel();
        p2.setBounds(45, 150, 600, 240);
        p2.setBackground(new Color(163, 248, 235));
        p2.setLayout(new GridLayout(7, 7));//7x7 dimension calender


        //initialize l
        l = new JLabel[7];
        for (int i = 0; i < l.length; i++) {
            l[i] = new JLabel(dayTypeArr[i]);
            l[i].setFont(new Font(Font.SERIF, Font.BOLD, 25));
        }


        //initialize p2Div
        p2Div = new JPanel[49];//array of 49 panels
        for (int i = 0; i < p2Div.length; i++) {
            p2Div[i] = new JPanel();
            p2Div[i].setLayout(new GridBagLayout());
            //add dayType label to the first row
            if (i < 7) {
                p2Div[i].add(l[i]);
                p2Div[i].setBackground(new Color(190, 235, 239));
            } else {
                p2Div[i].setLayout(null);
                p2Div[i].setBackground(new Color(227, 235, 239));
            }

            //add small panel to main panel
            p2.add(p2Div[i]);
        }
        f.add(p2);


        //to obtain the index from dayTypeArr where its value is equal to the day type of the first day of the month
        String dayType = myDateObj.getDayOfWeek().toString().substring(0, 3);
        for(int i = 0 ; i < dayTypeArr.length; i++)
        {
            if(dayTypeArr[i].equals(dayType))
                day1DayTypeArrIndex = i - myDateObj.getDayOfMonth() + 1;
        }
        while(day1DayTypeArrIndex < 0)
            day1DayTypeArrIndex += 7;


        //accumulate the displacement
        displacementAccumulator += (displacement % 7);
        if ((day1DayTypeArrIndex + displacementAccumulator) > 6)
            displacementAccumulator -= 7;
        if((day1DayTypeArrIndex + displacementAccumulator) < 0)
            displacementAccumulator += 7;




        //create the button with amount same as number of day in that month
        b = new JButton[numDays];

        for(int i = 0; i < numDays ; i++)
        {
            b[i] = new JButton("" + (i+1));
            b[i].setFocusPainted(false);
            b[i].setBounds(1,1 , 85, 30);
            if(i == daySelected - 1) {
                b[i].setBackground(new Color(249, 166, 18));
                b[daySelected -1].setForeground(Color.white);
            }
            else
                b[i].setBackground(new Color(46, 172, 221));
            b[i].setFont(new Font("Arial", Font.PLAIN, 20));

            p2Div[day1DayTypeArrIndex + displacementAccumulator + 7 + i].add(b[i]);//+7 because the first row is used by the day type label already
        }

    }


    DateSelectionUI()
    {
        //set properties of f
        f = new JFrame("Select Date");
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);


        buildHeaderPanel();
        buildP1();


        int numDaysThisMonth = MakeAppointment.getNumOfDays(myDateObj.getMonthValue(),myDateObj.getYear());
        buildP2(numDaysThisMonth, 0);

    }
}
