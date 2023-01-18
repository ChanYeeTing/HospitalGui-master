package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class PatientInfo extends JFrame implements ActionListener {
    String info[] = new String[11];

    JPanel p,p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
    JLabel l0,l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
    JButton b1;

    public static String account;


    public PatientInfo() {
        super();

        //Read the patient information from text file
        int i = 0;
        try {
            FileReader fr = new FileReader(account+".txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                info[i] = line;
                i++;
            }
            fr.close();
        }
        catch (Exception ex) { }

        this.setTitle("Account Information");
        this.setLocation(220, 40);
        this.setSize(600,500);
        this.setBackground(Color.getHSBColor(5, 90, 80));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);



        l0 = l= new JLabel(" ");
        l= new JLabel("Account ");
        l.setFont(new Font("Times New Roman", Font.BOLD, 28));
        l1= new JLabel("Information");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 28));
        b1 = new JButton("Back");
        b1.setBackground(Color.getHSBColor(255,240,22));



        l2 = new JLabel("Name    :");
        l3 = new JLabel(info[0]+" "+info[1]);
        l4 = new JLabel("Gender   :");
        l5 = new JLabel(info[2]);
        l6 = new JLabel("Email    :");
        l7 = new JLabel(info[3]);
        l8 = new JLabel("Phone Number:");
        l9 = new JLabel(info[4]);
        l10 = new JLabel("Address :");
        l11 = new JLabel(info[5]);
        l12 = new JLabel("Height :");
        l13 = new JLabel(info[6]);
        l14 = new JLabel("Weight :");
        l15 = new JLabel(info[7]);
        l16 = new JLabel("Allergic :");
        l17 = new JLabel(info[8]);
        l18 = new JLabel("Allergen :");
        l19 = new JLabel(info[9]);
        l20 = new JLabel("Blood Type:");
        l21 = new JLabel(info[10]);

        p0 = new JPanel();
        p0.setLayout(new FlowLayout());
        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p5 = new JPanel();
        p5.setLayout(new FlowLayout());
        p6 = new JPanel();
        p6.setLayout(new FlowLayout());
        p7 = new JPanel();
        p7.setLayout(new FlowLayout());
        p8 = new JPanel();
        p8.setLayout(new FlowLayout());
        p9 = new JPanel();
        p9.setLayout(new FlowLayout());
        p10 = new JPanel();
        p10.setLayout(new FlowLayout());
        p11 = new JPanel();
        p11.setLayout(new FlowLayout());
        p12 = new JPanel();
        p12.setLayout(new FlowLayout());
        p13 = new JPanel();
        p13.setLayout(new FlowLayout(FlowLayout.RIGHT));


        p1.add(b1);
        p0.add(l0);

        p13.add(l);
        p2.add(l1);

        p3.add(l2);
        p3.add(l3);

        p4.add(l12);
        p4.add(l13);

        p5.add(l4);
        p5.add(l5);

        p6.add(l14);
        p6.add(l15);

        p7.add(l6);
        p7.add(l7);

        p8.add(l16);
        p8.add(l17);

        p9.add(l8);
        p9.add(l9);
        p10.add(l18);
        p10.add(l19);

        p11.add(l10);
        p11.add(l11);
        p12.add(l20);
        p12.add(l21);

        p = new JPanel();
        p.setLayout(new GridLayout(7, 2));

        p.add(p1);
        p.add(p0);
        p.add(p13);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);


        this.add(p);

        p0.setBackground(Color.getHSBColor(5,90,80));
        p1.setBackground(Color.getHSBColor(5,90,80));
        p2.setBackground(Color.getHSBColor(5,90,80));
        p3.setBackground(Color.getHSBColor(5,90,80));
        p4.setBackground(Color.getHSBColor(5,90,80));
        p5.setBackground(Color.getHSBColor(5,90,80));
        p6.setBackground(Color.getHSBColor(5,90,80));
        p7.setBackground(Color.getHSBColor(5,90,80));
        p8.setBackground(Color.getHSBColor(5,90,80));
        p9.setBackground(Color.getHSBColor(5,90,80));
        p10.setBackground(Color.getHSBColor(5,90,80));
        p11.setBackground(Color.getHSBColor(5,90,80));
        p12.setBackground(Color.getHSBColor(5,90,80));
        p13.setBackground(Color.getHSBColor(5,90,80));

        b1.addActionListener(this);

        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            this.dispose();
            new HospitalGUI();
        }
    }
}
