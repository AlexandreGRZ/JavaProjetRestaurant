package InterfaceGraphique;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import org.jdatepicker.impl.*;


import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class MainPage extends JFrame  {
    private JPanel panel1;
    private JPanel PanelHeader;
    private JPanel PanelMenuPlat;
    private JButton AJOUTERAUMENUButton1;
    private JButton AJOUTERAUPLATButton;
    private JTable table3;
    private JTable table1;
    private JTable table2;
    private JPanel datepannelMainPage;


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
