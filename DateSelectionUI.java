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


    //JLabel
    static JLabel headerLabel;//headerLabel
    static JLabel monthLabel;//label for month of the label


    //JButton
    static JButton bPreviousMonth;//button to allow user view previous month calendar
    static JButton bNextMonth;//button to allow user view next month calendar


    //Variables or Arrays
    static int daySelected;//store day of month selected
    static int monthSelected;//store month selected
    static int yearSelected;//store year selected
    static LocalDate myDateObj = LocalDate.now();//date object

    //array of month names
    static String monthStr [] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};




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
                monthSelected--;
                if (monthSelected <= 0) {
                    monthSelected = 12;
                    yearSelected--;
                }
                monthLabel.setText(monthStr[monthSelected -1] + " " + yearSelected);
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
                monthSelected++;
                if (monthSelected > 12) {
                    monthSelected = 1;
                    yearSelected++;
                }
                monthLabel.setText(monthStr[monthSelected -1] + " " + yearSelected);
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

    }
}
