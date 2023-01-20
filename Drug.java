package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


    final class Drug {
        static JFrame f;

        static JPanel p1;
        static JPanel pDiv1[];

        static JLabel drugName[];
        static JButton backButton;
        static JTextArea drugDescrip[];

        static String drugInfo[];

        public Drug() throws FileNotFoundException {
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


            p1 = new JPanel();
            p1.setLayout(new GridLayout(9, 1));
            pDiv1 = new JPanel[9];

            drugName = new JLabel[9];
            drugDescrip = new JTextArea[9];

            File myObj2 = new File("Drug's details.txt");
            Scanner myReader_ = new Scanner(myObj2);
            myReader_.useDelimiter("\t");
            int i = 0;
            while(myReader_.hasNextLine())
            {
                drugInfo = (myReader_.nextLine()).split("\t");
                //System.out.println(i);
                drugName[i] = new JLabel();
                drugDescrip[i] = new JTextArea();
                drugDescrip[i].setEditable(false);
                drugName[i].setText(drugInfo[0]);
                drugDescrip[i].setText(drugInfo[1]);
                pDiv1[i] = new JPanel();
                pDiv1[i].setLayout(new GridLayout(2, 1));
                pDiv1[i].add(drugName[i]);
                pDiv1[i].add(drugDescrip[i]);
                p1.add(pDiv1[i]);
                i++;
            }

            p1.setBounds(2, 60, 4500, 350);
            f.add(p1);


            f.getContentPane().setBackground(new Color(222, 142, 190));
            f.setSize(1800,480);
            f.setLayout(null);
            f.setVisible(true);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLocationRelativeTo(null);
        }
    }



