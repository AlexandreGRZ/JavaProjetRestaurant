package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame{


    private JPanel MainPanel;
    private JTable table1;
    private JPanel AJOUTERAUMENU;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton ajouterButton;
    private JButton ajouterButton1;
    private JPanel CréationDePlat;
    private JPanel VueReservation;
    private JTable table2;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox3;
    private JButton ajouterButton2;
    private JTable table3;
    private JTextField textField3;
    private JButton voirButton;

    public MainPage(String Nom)
    {

        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(MainPanel);

        this.pack();
    }

    public static void main(String[] args) {
        JFrame Init = new MainPage("MainPage");

        Init.setSize(new Dimension(720, 500));

        Init.setVisible(true);
    }


}
