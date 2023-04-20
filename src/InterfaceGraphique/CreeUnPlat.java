package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class CreeUnPlat extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton AJOUTERButton;
    private JButton AJOUTERButton1;
    private JTable table1;

    public CreeUnPlat(String Nom) {
        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public static void main(String[] args) {
        JFrame Init = new CreeUnPlat("MainPage");

        Init.setSize(new Dimension(400, 300));

        Init.setVisible(true);
    }
}
