package hospitalgui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HospitalGUI extends JFrame implements ActionListener{
    
JPanel p,p1,p2,p3,p4;
    
JLabel l1,l2,l3,l4,l5,l6,l7;

JList list2;
JList list1;

JTextField tf1,tf2,tf3,tf4,tf5,tf6;


 JButton b1,b2,b3,b4,b5,b6;
 
 JComboBox c1;
 
 String a[]={"Surgeon","Pediatrician","Psychiatrist","Cardiologist","Dermatologist"};

    public  HospitalGUI(){
        
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setSize(1100,300);
         this.setTitle("HospitalGUI");
         this.setVisible(true);
         this.setLocation(200,200);
         this.setBackground(Color.DARK_GRAY);
        
        
         p =new JPanel();
         p.setLayout(new GridLayout(4,1));
        
        
         p3 =new JPanel();
         p4 =new JPanel();
        
     
      
     
        p1 =new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        l1=new JLabel("Always Here For You");
        l1.setFont(new Font("Calibri", Font.BOLD, 50));
     
        p1.add(l1);
        
        p2 =new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER,40,40));
        b1=new JButton("View Your Account");
        b1.addActionListener(this);
        b2=new JButton("Hospital Departments");
        b2.addActionListener(this);
        b3=new JButton("View Products & Services");
        b3.addActionListener(this);
        b4=new JButton("Find A Doctor");
        b4.addActionListener(this);
        
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        
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
        new  HospitalGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource()==b1){
             
            p4.removeAll();
             view1();
         p4.setVisible(true);
         }else if(e.getSource()==b4){
              p4.removeAll();
              view2();
               p4.setVisible(true);
         }else if(e.getSource()==b5){
             if(" ".equals(tf1.getText())){
              JOptionPane.showMessageDialog(this,"account not submitted","confirmation", JOptionPane.PLAIN_MESSAGE);
             }else{
                 JOptionPane.showMessageDialog(this,"account submitted","confirmation", JOptionPane.PLAIN_MESSAGE);
             }
         }else if(e.getSource()==b6){
              JOptionPane.showMessageDialog(this,"doctor is not found","confirmation", JOptionPane.PLAIN_MESSAGE);
         }else if(e.getSource()==b2){
              p4.removeAll();
               view3();
               p4.setVisible(true);
         }else if(e.getSource()==b3){
              p4.removeAll();
              view4();
               p4.setVisible(true);
         }
         }
       
    
        public void view1(){
            
             p4.setLayout(new GridLayout(3,4));
         
         l2=new JLabel("   first name");
         tf1=new JTextField(5);
          tf1.setBackground(Color.LIGHT_GRAY);
          
         l3=new JLabel("   last name");
         tf2=new JTextField(5);
          tf2.setBackground(Color.LIGHT_GRAY);
          
         l4=new JLabel("   Email");
         tf3=new JTextField(5);
          tf3.setBackground(Color.LIGHT_GRAY);
          
         l5=new JLabel("   phone number");
         tf4=new JTextField(11);
          tf4.setBackground(Color.LIGHT_GRAY);
          
         l6=new JLabel("   address");
         tf5=new JTextField(11);
          tf5.setBackground(Color.LIGHT_GRAY);
          
          l7=new JLabel("");
         b5=new JButton("   submit");
          b5.addActionListener(this);
        
          p4.add(l2);
          p4.add(tf1);
          
          p4.add(l3);
          p4.add(tf2);
          
          p4.add(l4);
          p4.add(tf3);
          
          p4.add(l5);
          p4.add(tf4);
          
          p4.add(l6);
          p4.add(tf5);
          
          p4.add(l7);
          p4.add(b5);
          
        p4.setVisible(false);
        
        }
        
         public void view2(){
             
               p4.setLayout(new GridLayout(3,4));
          l2=new JLabel("   first name");
         tf1=new JTextField(5);
          tf1.setBackground(Color.LIGHT_GRAY);
          
         l3=new JLabel("   last name");
         tf2=new JTextField(5);
         tf2.setBackground(Color.LIGHT_GRAY);

         
          l4=new JLabel("   Specialty");
          c1=new JComboBox (a);
          
          
           l5=new JLabel("");
           b6=new JButton("   submit");
            b6.addActionListener(this);
            
           
           l6=new JLabel("");
           l7=new JLabel("");
          
            p4.add(l2);
          p4.add(tf1);
          
          p4.add(l3);
          p4.add(tf2);
          
          p4.add(l4);
           p4.add(c1);
           
            p4.add(l5);
           p4.add(b6);
           
           p4.add(l6);
           p4.add(l7);
          
            p4.setVisible(false);
         
         }
          public void view3(){
                 p4.setLayout(new GridLayout(2,3));
                  l2=new JLabel(" Recovery Room");
                   l2.setFont(new Font("Calibri", Font.BOLD, 20));
                   l3=new JLabel("   Endoscope Reprocessing");
                    l3.setFont(new Font("Calibri", Font.BOLD, 20));
                    l4=new JLabel("   Hybrid OR");
                     l4.setFont(new Font("Calibri", Font.BOLD, 20));
                     
                      l5=new JLabel(" The recovery room is a place for the patient to safely");
                       l6=new JLabel(" Modern infection control is based on the barrier principle");
                        l7=new JLabel("  It’s the most technically complex surgical suite");
           
                         p4.add(l2);
                          p4.add(l3);
                           p4.add(l4);
                           
                            p4.add(l5);
                             p4.add(l6);
                              p4.add(l7);
                              
                         p4.setVisible(false);
                        
          }
          
           public void view4(){
                p4.setLayout(new GridLayout(2,2));
                
                 l2=new JLabel(" If you need help now,and you're not sure what to do");
                   l2.setFont(new Font("Calibri", Font.BOLD, 20));
                    l4=new JLabel("  Go to 111.NHS.uk or call 111");
                   l3=new JLabel("       If you think it's an emergency");
                    l3.setFont(new Font("Calibri", Font.BOLD, 20));
                     l5=new JLabel("             Find your nearest A&E\n" +"Call 999");
                 p4.add(l2);
                  p4.add(l3);
                 p4.add(l4);
                   p4.add(l5);
                  
                 
                p4.setVisible(false);
           }
         
    
    }