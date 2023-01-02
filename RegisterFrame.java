package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterFrame extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
    JPasswordField pf1,pf2;
    JRadioButton rb1,rb2,rb3,rb4;
    JComboBox cb1;
    JButton b1,b2;
    JPanel p,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16;

    ButtonGroup Gender, Allergic;

    public RegisterFrame()
    {
        super("Registration");
        this.setLayout(new FlowLayout());
        this.setTitle("Registration");
        this.setLocation(500,0);
        this.setSize(350,670);
        this.getContentPane().setBackground(Color.getHSBColor(5,90,80));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        p =new JPanel();
        p.setLayout(new GridLayout(16,2));

        p1 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        l1= new JLabel("Registration");
        l1.setFont(new Font("Calibri", Font.BOLD, 22));

        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        l2= new JLabel("Account            ");
        tf1 = new JTextField(15);

        l3 = new JLabel("Password         ");
        pf1 = new JPasswordField(15);

        l4 = new JLabel("Confirm Password");
        pf2 = new JPasswordField(15);

        l5= new JLabel("First Name     ");
        tf2 = new JTextField(15);

        l6= new JLabel("Last Name     ");
        tf3 = new JTextField(15);

        Gender = new ButtonGroup();
        l7 = new JLabel("Gender        ");
        rb1 = new JRadioButton("Male",true);
        rb2 = new JRadioButton("Female", false);
        rb1.setBackground(Color.getHSBColor(5,90,80));
        rb2.setBackground(Color.getHSBColor(5,90,80));

        l8 = new JLabel("Email Address");
        tf4 = new JTextField(15);

        l9 = new JLabel("Phone Number  ");
        tf5 = new JTextField(15);

        l10 = new JLabel("Address        ");
        tf6 = new JTextField(15);

        l11 = new JLabel("Height        ");
        tf7 = new JTextField(15);

        l12 = new JLabel("Weight        ");
        tf8 = new JTextField(15);

        Allergic = new ButtonGroup();
        l13 = new JLabel("Allergic       ");
        rb3 = new JRadioButton("Yes",true);
        rb4 = new JRadioButton("No", false);
        rb3.setBackground(Color.getHSBColor(5,90,80));
        rb4.setBackground(Color.getHSBColor(5,90,80));

        l14 = new JLabel("Allergen       ");
        tf9 = new JTextField(15);

        l15 = new JLabel("Blood Type     ");
        cb1 = new JComboBox<>();
        cb1.setBackground(Color.WHITE);

        b1 = new JButton("Register");
        b2 = new JButton("Cancel");
        b1.setBackground(Color.getHSBColor(255,240,22));
        b2.setBackground(Color.getHSBColor(255,240,22));

        p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p4 = new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.CENTER));
        p6 = new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.CENTER));
        p7 = new JPanel();
        p7.setLayout(new FlowLayout(FlowLayout.CENTER));
        p8 = new JPanel();
        p8.setLayout(new FlowLayout(FlowLayout.CENTER));
        p9 = new JPanel();
        p9.setLayout(new FlowLayout(FlowLayout.CENTER));
        p10 = new JPanel();
        p10.setLayout(new FlowLayout(FlowLayout.CENTER));
        p11 = new JPanel();
        p11.setLayout(new FlowLayout(FlowLayout.CENTER));
        p12 = new JPanel();
        p12.setLayout(new FlowLayout(FlowLayout.CENTER));
        p13 = new JPanel();
        p13.setLayout(new FlowLayout(FlowLayout.CENTER));
        p14 = new JPanel();
        p14.setLayout(new FlowLayout(FlowLayout.CENTER));
        p15 = new JPanel();
        p15.setLayout(new FlowLayout(FlowLayout.CENTER));
        p16 = new JPanel();
        p16.setLayout(new FlowLayout(FlowLayout.CENTER));

        p1.add(l1);

        p2.add(l2);
        p2.add(tf1);

        p3.add(l3);
        p3.add(pf1);

        p4.add(l4);
        p4.add(pf2);

        p5.add(l5);
        p5.add(tf2);

        p6.add(l6);
        p6.add(tf3);

        Gender.add(rb1);
        Gender.add(rb2);
        p7.add(l7);
        p7.add(rb1);
        p7.add(rb2);

        p8.add(l8);
        p8.add(tf4);

        p9.add(l9);
        p9.add(tf5);

        p10.add(l10);
        p10.add(tf6);

        p11.add(l11);
        p11.add(tf7);

        p12.add(l12);
        p12.add(tf8);

        Allergic.add(rb3);
        Allergic.add(rb4);
        p13.add(l13);
        p13.add(rb3);
        p13.add(rb4);

        p14.add(l14);
        p14.add(tf9);

        p15.add(l15);
        p15.add(cb1);
        cb1.addItem("A");
        cb1.addItem("B");
        cb1.addItem("O");
        cb1.addItem("AB");

        p16.add(b1);
        p16.add(b2);

        p.add(p1);
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
        p.add(p13);
        p.add(p14);
        p.add(p15);
        p.add(p16);

        this.add(p);

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
        p14.setBackground(Color.getHSBColor(5,90,80));
        p15.setBackground(Color.getHSBColor(5,90,80));
        p16.setBackground(Color.getHSBColor(5,90,80));


        b1.addActionListener(this);
        b2.addActionListener(this);

        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String password1 = new String(pf1.getPassword());
            String password2 = new String(pf2.getPassword());

            if (!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this, "Two passwords are DIFFERENT");
                return;
            }

            String Account = tf1.getText();
            String FName = tf2.getText();
            String LName = tf3.getText();
            String Gender;
            if (rb1.isSelected())
                Gender = (String) rb1.getText();
            else
                Gender = (String) rb2.getText();

            String Email = tf4.getText();
            String PNumber = tf5.getText().trim();
            if (!PNumber.matches("([0-9]?)*")) {
                JOptionPane.showMessageDialog(this, "Phone Number Only Accept Number");
            }
            String Address = tf6.getText();
            String Height = tf7.getText().trim();
            if (!Height.matches("([0-9]?)*")) {
                JOptionPane.showMessageDialog(this, "Height Only Accept Number");
            }
            String Weight = tf8.getText().trim();
            if (!Weight.matches("([0-9]?)*")) {
                JOptionPane.showMessageDialog(this, "Weight Only Accept Number");
            }

            String Allergic;
            if (rb1.isSelected())
                Allergic = (String) rb3.getText();
            else
                Allergic = (String) rb4.getText();

            String Allergen = tf9.getText();
            String Blood = (String) cb1.getSelectedItem();

//            Conf.account = Account;
//            Conf.Fname = FName;
//            Conf.Lname = LName;
//            Conf.password = password1;
//            Conf.gender = Gender;
//            Conf.email = Email;
//            Conf.pNumber = PNumber;
//            Conf.address = Address;
//            Conf.height = Double.parseDouble(Height);
//            Conf.weight = Double.parseDouble(Weight);
//            Conf.allergic = Boolean.valueOf(Allergic);
//            Conf.NameAllergic = Allergen;
//            Conf.bloodType = Blood;


            try {
                FileWriter fw = new FileWriter("login.txt",true);
                fw.write(Account+"\t"+password1);
                fw.close();

                FileWriter fw2 = new FileWriter(Account+".txt",true);
                fw2.write(FName+"\t"+LName+"\t"+Gender+"\t"
                        +Email+"\t"+PNumber+"\t"+Address+"\t"+Height+"\t"+Weight+"\t"+Allergic+"\t"+
                        Allergen+"\t"+Blood);
                fw2.close();

                JOptionPane.showMessageDialog(this, Account + " Successfully Registered");
                this.dispose();
                new Login();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }



        }
        else if (e.getSource() == b2) {
            this.dispose();
            new Login();
        }
    }
}
