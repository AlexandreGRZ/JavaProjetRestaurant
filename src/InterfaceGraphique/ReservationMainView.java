package InterfaceGraphique;

import Controlleur.Controlleur;

import javax.swing.*;

public class ReservationMainView extends JFrame {
    private JTextField TFNbPersonne;
    private JTextField TFJour;
    private JTextField TFMois;
    private JTextField TFAnnee;
    private JButton RESERVERBTN;
    private JTextField TFNomPersonne;
    private JTextField TFHeure;
    private JTextField TFMin;
    private JPanel panel1;
    private JButton RESERVERButton;


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


    public ReservationMainView(String Nom) {

        super(Nom);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public void setControlleur(Controlleur C)
    {
        RESERVERButton.addActionListener(C);
        this.addWindowListener(C);
    }

    public JTextField getTFAnnee() {
        return TFAnnee;
    }

    public JTextField getTFJour() {
        return TFJour;
    }

    public JTextField getTFMois() {
        return TFMois;
    }

    public JTextField getTFHeure() {
        return TFHeure;
    }

    public JTextField getTFMin() {
        return TFMin;
    }
}
