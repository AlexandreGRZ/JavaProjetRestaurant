package Controlleur;

import InterfaceGraphique.*;
import MODEL.Aliment;
import MODEL.Plat;
import MODEL.Restaurant;

import javax.print.DocFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Controlleur implements ActionListener, WindowListener {


    private Restaurant restaurant;

    private MainPage mainvue;

    private ReservationMainView ReservationMainVue;

    private InterfaceUtilisateur ConnexionWindow;

    private InscriptionGraphique InscriptionWindow;

    private CreeUnPlat CreePlatWindow;

    private AjouterAuMenuInterface AddMenuWindow;

    public Controlleur (Restaurant r, InterfaceUtilisateur m)
    {
        restaurant = r;

        ConnexionWindow = m;
    }

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
                AddMenuWindow = new AjouterAuMenuInterface("Test",restaurant.getListDePlat());
                AddMenuWindow.setControlleur(this);
                AddMenuWindow.setNewModel();
                AddMenuWindow.setVisible(true);
            }

            if(e.getActionCommand().equals("CREE PLAT"))
            {
                CreePlatWindow = new CreeUnPlat("test", restaurant.getListAliment());
                CreePlatWindow.setControlleur(this);
                CreePlatWindow.setVisible(true);
            }

            if(e.getActionCommand().equals("Ajouter Un Reservation"))
            {
                ReservationMainVue = new ReservationMainView("test");
                ReservationMainVue.setControlleur(this);
                ReservationMainVue.setVisible(true);

            }
            if(e.getActionCommand().equals("RESERVER"))
            {
                ReservationMainVue.dispose();
            }

            if(e.getActionCommand().equals("Deja Connecté"))
            {
                ConnexionWindow.dispose();
                InscriptionWindow = new InscriptionGraphique("test");
                InscriptionWindow.setVisible(true);
                InscriptionWindow.setControlleur(this);
            }

            if(e.getActionCommand().equals("CONNEXION"))
            {
                ConnexionWindow.dispose();
            }

            if(e.getActionCommand().equals("INSCRIPTION"))
            {
                InscriptionWindow.dispose();
            }

            if(e.getActionCommand().equals("Déja Inscrit"))
            {
                InscriptionWindow.dispose();
                ConnexionWindow = new InterfaceUtilisateur("test");
                ConnexionWindow.setControlleur(this);
                ConnexionWindow.setVisible(true);
            }

            if(e.getActionCommand().equals("AJOUTER ALIMENT"))
            {
                String AlimentSelected = (String) CreePlatWindow.getCBAliment().getSelectedItem();

                restaurant.AddAlimentToPlat(AlimentSelected);

                CreePlatWindow.setListAlimentSelected(restaurant.getListAlimentAfficher());
                CreePlatWindow.setNewModel();
            }
            if(e.getActionCommand().equals("CREER LE PLAT"))
            {
                CreePlatWindow.dispose();
                Plat p = new Plat(restaurant.getListDePlat().size(),CreePlatWindow.getTFNomPlat().getText(),
                        Float.parseFloat(CreePlatWindow.getTFPrix().getText()), Restaurant.getInstance().getListAlimentAfficher());

                restaurant.getListDePlat().add(p);
                restaurant.getListAlimentAfficher().clear();
                mainvue.setNewModelPlat();
            }

            if(e.getActionCommand().equals("AJOUTER AU MENU"))
            {
                restaurant.getMenu().getListPlats().add(restaurant.SearchPlat(AddMenuWindow.getJTPlat().getSelectedRow()));
                AddMenuWindow.dispose();
                mainvue.setNewModelMenu();
            }

            if(e.getActionCommand().equals("CREER UN PLAT"))
            {
                AddMenuWindow.dispose();
                CreePlatWindow = new CreeUnPlat("test", restaurant.getListAliment());
                CreePlatWindow.setControlleur(this);
                CreePlatWindow.setVisible(true);
            }

            if(e.getActionCommand().equals("SUPPRIMER DU MENU"))
            {

            }

            if(e.getActionCommand().equals("SUPPRIMER UN PLAT"))
            {

            }

            if(e.getActionCommand().equals("SUPPRIMER"))
            {

            }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        //  restaurant.Save(restaurant.getListDePlat());

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
