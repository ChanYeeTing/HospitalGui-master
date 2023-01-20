package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    final class Doctor {
        static JFrame f;
        static JPanel p2;
        static JPanel pDiv2[];

        static JLabel docName[];
        static JButton backButton;
        static JTextArea docDescrip[];

        static String docInfo[];

        public Doctor() throws FileNotFoundException {
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

            p2 = new JPanel();
            p2.setLayout(new GridLayout(4, 1));
            pDiv2 = new JPanel[4];

            docName = new JLabel[4];
            docDescrip = new JTextArea[4];

            File myObj2 = new File("Doctor's details.txt");
            Scanner myReader_ = new Scanner(myObj2);
            myReader_.useDelimiter("\t");
            int i = 0;
            while(myReader_.hasNextLine())
            {
                docInfo = (myReader_.nextLine()).split("\t");
                //System.out.println(i);
                docName[i] = new JLabel();
                docDescrip[i] = new JTextArea();
                docDescrip[i].setEditable(false);
                docName[i].setText(docInfo[0]);
                docDescrip[i].setText(docInfo[1]);
                pDiv2[i] = new JPanel();
                pDiv2[i].setLayout(new GridLayout(2, 1));
                pDiv2[i].add(docName[i]);
                pDiv2[i].add(docDescrip[i]);
                p2.add(pDiv2[i]);
                i++;
            }

            p2.setBounds(2, 60, 4500, 350);
            f.add(p2);


            f.getContentPane().setBackground(new Color(222, 142, 190));
            f.setSize(1800,480);
            f.setLayout(null);
            f.setVisible(true);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
        }
    }

