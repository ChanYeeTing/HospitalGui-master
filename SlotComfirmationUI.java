package hospitalgui;

import javax.swing.*;
import java.awt.*;


public class SlotComfirmationUI {
    //JFrame
    static JFrame f;


    //JPanels
    static JPanel instructionPanel;


    //JLabels
    static JLabel instructionLabel;


    public static void buildInstructionPanel()
    {
        instructionPanel = new JPanel();
        instructionPanel.setBounds(0, 0, 700, 50);
        instructionPanel.setLayout(new GridBagLayout());
        instructionPanel.setBackground(Color.pink);

        instructionLabel = new JLabel("Select appointment duration and ensure appointment details");
        instructionLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        instructionPanel.add(instructionLabel);
        f.add(instructionPanel);
    }

    
    SlotComfirmationUI(int i , int j)
    {
        //initialize and set properties of f
        f = new JFrame("Slot confirm");
        f.setSize(700,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        f.setLocationRelativeTo(null);

        buildInstructionPanel();
    }
}
