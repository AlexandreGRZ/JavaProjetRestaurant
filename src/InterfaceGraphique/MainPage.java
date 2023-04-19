package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame  {
    private JTable table1;
    private JButton AJOUTERAUMENUButton;
    private JPanel panel1;
    private JTable table2;
    private JButton AJOUTERPLATButton;


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public MainPage(String Nom) {
        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public static void main(String[] args) {
        JFrame Init = new MainPage("MainPage");

        Init.setSize(new Dimension(1080, 720));

        Init.setVisible(true);
    }


}
