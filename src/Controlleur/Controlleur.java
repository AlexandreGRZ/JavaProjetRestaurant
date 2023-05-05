package Controlleur;

import InterfaceGraphique.AjouterAuMenuInterface;
import InterfaceGraphique.CreeUnPlat;
import InterfaceGraphique.MainPage;
import InterfaceGraphique.ReservationMainView;
import MODEL.Restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlleur implements ActionListener, WindowListener {


    private Restaurant restaurant;

    private MainPage mainvue;

    public Controlleur (Restaurant r, MainPage m)
    {
        restaurant = r;

        mainvue = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("DECONNEXION"))
            {
                System.exit(0);
            }

            if(e.getActionCommand().equals("AJOUTER PLAT"))
            {
                AjouterAuMenuInterface w = new AjouterAuMenuInterface("Test");
                w.setControlleur(this);
                w.setVisible(true);
            }

            if(e.getActionCommand().equals("CREE PLAT"))
            {
                CreeUnPlat w = new CreeUnPlat("test");
                w.setVisible(true);
            }

            if(e.getActionCommand().equals("Ajouter Un Reservation"))
            {
                ReservationMainView w = new ReservationMainView("test");
                w.setVisible(true);
            }


    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        e.getWindow().setVisible(false);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
