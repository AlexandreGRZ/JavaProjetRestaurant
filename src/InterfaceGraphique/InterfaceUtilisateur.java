package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class InterfaceUtilisateur extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton CONNEXIONButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public InterfaceUtilisateur(String Nom) {
        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public static void main(String[] args) {
        JFrame Init = new InterfaceUtilisateur("MainPage");

        Init.setSize(new Dimension(450, 250));

        Init.setVisible(true);
    }

}