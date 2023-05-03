package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame  {
    private JPanel panel1;
    private JPanel PanelHeader;
    private JPanel PanelMenuPlat;
    private JTable table3;
    private JButton ajouterUnReservationButton;
    private JTable table1;
    private JTable table2;
    private JButton DECONNEXIONButton;
    private JButton AJOUTERButton;
    private JButton SUPPRIMERButton;
    private JButton AJOUTERButton1;
    private JButton SUPPRIMERButton1;
    private JButton SUPPRIMERButton2;


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
