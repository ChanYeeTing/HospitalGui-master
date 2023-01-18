package hospitalgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JPanel p,p1,p2,p3,p4;
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1, b2;


    public Login(){
        super("Login");
        this.setTitle("Login");
        this.setLocation(500,100);
        this.setSize(350,350);
        this.setBackground(Color.getHSBColor(5,90,80));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        p =new JPanel();
        p.setLayout(new GridLayout(4,2));


        p1 = new JPanel();
        l1= new JLabel("Login");
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        l1.setFont(new Font("Times New Roman", Font.BOLD, 40));

        p2 = new JPanel();
        l2= new JLabel("Account    ");
        tf1 = new JTextField(15);
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        l2.setFont(new Font("Calibri", Font.BOLD, 14));

        p3 = new JPanel();
        l3 = new JLabel("Password ");
        pf1 = new JPasswordField(15);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        l3.setFont(new Font("Calibri", Font.BOLD, 14));

        p4 = new JPanel();
        b1 = new JButton("Log in");
        b2 = new JButton("Register");
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBackground(Color.getHSBColor(255,240,22));
        b2.setBackground(Color.getHSBColor((float) 270.67, (float) 0.3, (float) 0.89));

        p1.add(l1);
        p2.add(l2);
        p2.add(tf1);
        p3.add(l3);
        p3.add(pf1);
        p4.add(b1);
        p4.add(b2);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);

        this.add(p);

        p1.setBackground(Color.getHSBColor(5,90,80));
        p2.setBackground(Color.getHSBColor(5,90,80));
        p3.setBackground(Color.getHSBColor(5,90,80));
        p4.setBackground(Color.getHSBColor(5,90,80));

        this.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1)
        {
            boolean matched = false;
            String account = tf1.getText().trim();
            String password = new String(pf1.getPassword());

            try {
                FileReader fr = new FileReader("login.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(account + "\t" + password)) {
                        matched = true;
                        break;
                    }
                }
                fr.close();
            }
            catch (Exception ex) { }
            if(matched)
            {
                JOptionPane.showMessageDialog(this, "Login Successful");
                PatientInfo.account = account;
                this.dispose();
                new HospitalGUI();
            }

            else{
                JOptionPane.showMessageDialog(this, "Login Unsuccessful");
            }

        }
        else if(e.getSource() == b2)
        {
            this.dispose();
            new RegisterFrame();
        }
    }
}


