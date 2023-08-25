package InterfaceGraphique;

import Controlleur.Controlleur;

import javax.swing.*;
import java.awt.*;

public class InscriptionGraphique extends JFrame {

    private JPanel MainPanel;
    private JTextField TFNom;
    private JTextField TFPrenom;
    private JTextField TFLogin;
    private JTextField TFNumTel;
    private JTextField TFMdp;
    private JTextField TFJour;
    private JTextField TFMois;
    private JTextField TFAnnee;
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

    public void setControlleur(Controlleur C)
    {
        INSCRIPTIONButton.addActionListener(C);
        déjaInscritButton.addActionListener(C);
        this.addWindowListener(C);
    }

    public JTextField getTFAnnee() {
        return TFAnnee;
    }

    public JTextField getTFJour() {
        return TFJour;
    }

    public JTextField getTFLogin() {
        return TFLogin;
    }

    public JTextField getTFMdp() {
        return TFMdp;
    }

    public JTextField getTFMois() {
        return TFMois;
    }

    public JTextField getTFNom() {
        return TFNom;
    }

    public JTextField getTFNumTel() {
        return TFNumTel;
    }

    public JTextField getTFPrenom() {
        return TFPrenom;
    }
}
