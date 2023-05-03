package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class ReservationMainView extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton RESERVATIONButton;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JPanel panel1;


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


    public ReservationMainView(String Nom) {

        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public static void main(String[] args) {

        JFrame Init = new ReservationMainView("MainPage");

        Init.setSize(new Dimension(450, 250));

        Init.setVisible(true);
    }
}
