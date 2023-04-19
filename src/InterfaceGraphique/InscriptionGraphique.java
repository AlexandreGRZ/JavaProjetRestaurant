package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class InscriptionGraphique extends JFrame {

    private JPanel MainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton INSCRIPTIONButton;
    private JButton déjaInscritButton;

    public InscriptionGraphique(String Nom)
    {

        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(MainPanel);

        this.pack();
    }

    public static void main(String[] args) {
        JFrame Init = new InscriptionGraphique("MainPage");

        Init.setSize(new Dimension(450, 250));

        Init.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
