package InterfaceGraphique;




import Controlleur.Controlleur;

import javax.swing.*;
import java.awt.*;

public class AjouterAuMenuInterface extends JFrame{
    private JButton AJOUTERButton;
    private JButton AJOUTERUNPLATButton;
    private JPanel panel1;
    private JTable table1;


    public AjouterAuMenuInterface(String Nom) {
        super(Nom);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public static void main(String[] args) {

        JFrame Init = new AjouterAuMenuInterface("MainPage");

        Init.setSize(new Dimension(400, 300));

        Init.setVisible(true);
    }

    public void setControlleur(Controlleur C)
    {
        this.addWindowListener(C);
    }
}
