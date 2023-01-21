package hospitalgui;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import javax.swing.*;

public class HospitalGUI extends JFrame implements ActionListener{

JPanel p,p1,p2,p3,p4;

JLabel l1;

JButton b1,b2,b3,b4, b7, b8;


    public  HospitalGUI(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,350);
        this.setTitle("HospitalGUI");
        this.setVisible(true);
        this.setLocation(40,100);
        this.setBackground(Color.DARK_GRAY);


        p =new JPanel();
        p.setLayout(new GridLayout(4,1));


        p3 =new JPanel();
        p4 =new JPanel();



        p1 =new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        l1=new JLabel("Always Here For You");
        l1.setFont(new Font("Lucida Handwriting", Font.BOLD, 50));

        p1.add(l1);

        p2 =new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
        b1=new JButton("Account Information");
        b1.addActionListener(this);
        b2=new JButton("Hospital Departments");
        b2.addActionListener(this);
        b3=new JButton("View Drugs Details");
        b3.addActionListener(this);
        b4=new JButton("View Doctor Details");
        b4.addActionListener(this);
        b7= new JButton("Make Appointment");
        b7.addActionListener(this);
        b8 = new JButton("Give Feedback");
        b8.addActionListener(this);
        b1.setBackground(Color.getHSBColor(255,240,22));
        b2.setBackground(Color.getHSBColor((float) 270.67, (float) 0.3, (float) 0.89));
        b3.setBackground(Color.getHSBColor(255,240,22));
        b4.setBackground(Color.getHSBColor((float) 270.67, (float) 0.3, (float) 0.89));
        b7.setBackground(Color.getHSBColor(255,240,22));
        b8.setBackground(Color.getHSBColor((float) 270.67, (float) 0.3, (float) 0.89));

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b7);
        p2.add(b8);

        p.add(p3);
        p.add(p1);
        p.add(p2);
        p.add(p4);

        this.add(p);

        p1.setBackground(Color.getHSBColor(5,90,80));
        p2.setBackground(Color.getHSBColor(5,90,80));
        p3.setBackground(Color.getHSBColor(5,90,80));
        p4.setBackground(Color.getHSBColor(5,90,80));

    }

    public static void main(String[] args) {

        new  Login();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        
         if(e.getSource()==b1){
           this.dispose();
           new PatientInfo();

         }else if(e.getSource()==b4){
             try {
                 this.dispose();
                 new Doctor();
             } catch (FileNotFoundException ex) {
                 throw new RuntimeException(ex);
             }
         }

         else if(e.getSource()==b2){
             try {
                 this.dispose();
                 new Department();
             } catch (FileNotFoundException ex) {
                 throw new RuntimeException(ex);
             }
         }else if(e.getSource()==b3){
             try {
                 this.dispose();
                 new Drug();
             } catch (FileNotFoundException ex) {
                 throw new RuntimeException(ex);
             }
         }else if(e.getSource() == b7)
         {
             this.dispose();
             try {
                 new MakeAppointment();
             } catch (ParseException ex) {
                 throw new RuntimeException(ex);
             } catch (FileNotFoundException ex) {
                 throw new RuntimeException(ex);
             }
         }else if (e.getSource() == b8)
         {
             this.dispose();
             new GiveFeedbackUI();
         }
    }

}