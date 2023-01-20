package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
public class JavaFile {
    static JFrame f;
    static JLabel department_name[];
    static JTextArea dprt_des[];
    static JPanel p1;

    public JavaFile() throws FileNotFoundException {
        f = new JFrame("Department");
        f.getContentPane().setBackground(new Color(29, 143, 168));
        f.setSize(1280, 720);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));
        p1.setBounds(40, 80, 1220, 55);

        department_name = new JLabel[4];
        dprt_des = new JTextArea[4];

        int i = 0;
        String temp;
        String str1;
        String str = null;
        department_name[i] = new JLabel();
        dprt_des[i] = new JTextArea();
        Scanner myReader = new Scanner(new File("Department_details.txt"));

        while(myReader.hasNextLine()) {
            //department_name[i] = new JLabel();
            //dprt_des[i] = new JTextArea();
            department_name[i].setText(myReader.nextLine());

            //while (myReader.hasNextLine() && myReader.next().equals("\t\n")) {
            while (myReader.hasNextLine()) {
                str = str + myReader.nextLine();
            }

            dprt_des[i].setText(str);
            dprt_des[i].setLineWrap(true);
            if (myReader.hasNextLine() && myReader.nextLine() == "\n")
                temp = myReader.nextLine();
            p1.add(department_name[i]);
            p1.add(dprt_des[i]);
        }
    }
}

        String[] lines = new String[QUESTIONS*CHOICES*];//each choice has 3 lines = choice + 2 descriptions
        DiscOption[] discOptions = new DiscOption[CHOICES*3];
        for(int x = 0, y = lines.length; x < y; x++)
        {
            lines[x] = fileInput.readLine();
            if(x % 3 == 2)
            {
                discOptions[x/3] = new DiscOption(lines[x-2],lines[x-1],lines[x]);
            }
        }
        for(int x = 0, y = discQuestions.length; x < y; x++)
        {
            discQuestions[x] = new DiscQuestion(new DiscOption[]{
                    discOptions[x*4],discOptions[x*4 +1],discOptions[x*4+2],discOptions[x*4 +3]});
        }

*/

final class Department {
    static JFrame f;
    static JPanel p;
    static JPanel pDiv[];

    static JLabel departName[];
    static JButton backButton;
    static JTextArea departDescrip[];

    static String departmentInfo[];

    public Department() throws FileNotFoundException {
        f = new JFrame();

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

        p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        pDiv = new JPanel[4];

        departName = new JLabel[4];
        departDescrip = new JTextArea[4];

        File myObj = new File("Department_details.txt");
        Scanner myReader = new Scanner(myObj);
        myReader.useDelimiter("\t");
        int i = 0;
        while(myReader.hasNextLine())
        {
            departmentInfo = (myReader.nextLine()).split("\t");
            //System.out.println(i);
            departName[i] = new JLabel();
            departDescrip[i] = new JTextArea();
            departDescrip[i].setEditable(false);
            departName[i].setText(departmentInfo[0]);
            departDescrip[i].setText(departmentInfo[1]);
            pDiv[i] = new JPanel();
            pDiv[i].setLayout(new GridLayout(2, 1));
            pDiv[i].add(departName[i]);
            pDiv[i].add(departDescrip[i]);
            p.add(pDiv[i]);
            i++;
        }

        p.setBounds(2, 60, 4500, 300);
        f.add(p);


        f.getContentPane().setBackground(new Color(222, 142, 190));
        f.setSize(1800,480);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
}
