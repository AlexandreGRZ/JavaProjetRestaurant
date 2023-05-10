package Controlleur;

import InterfaceGraphique.*;
import MODEL.*;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Controlleur implements ActionListener, WindowListener {


    private Restaurant restaurant;

    private MainPage mainvue;

    private MainPageForClient mainVueForClient;

    private ReservationMainView ReservationMainVue;

    private ReservationMainVueForClient ReservationMainVueForClient;

    private InterfaceUtilisateur ConnexionWindow;

    private InscriptionGraphique InscriptionWindow;

    private CreeUnPlat CreePlatWindow;

    private AjouterAuMenuInterface AddMenuWindow;

    public Controlleur (Restaurant r, InterfaceUtilisateur m)
    {
        restaurant = r;

        ConnexionWindow = m;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("DECONNEXION"))
            {
                restaurant.setPersonneConnecte(null);
                if(mainvue != null)
                    mainvue.dispose();
                else
                    mainVueForClient.dispose();

                InterfaceUtilisateur w = new InterfaceUtilisateur("test");
                w.setControlleur(this);
                w.setVisible(true);
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

            if(e.getActionCommand().equals("RESERVER UNE TABLE"))
            {

                if(restaurant.getPersonneConnecte().getType().equals("C"))
                {
                    ReservationMainVueForClient = new ReservationMainVueForClient("test");
                    ReservationMainVueForClient.setControlleur(this);
                    ReservationMainVueForClient.setVisible(true);
                }
                else {
                    ReservationMainVue = new ReservationMainView("test");
                    ReservationMainVue.setControlleur(this);
                    ReservationMainVue.setVisible(true);
                }
            }
            if(e.getActionCommand().equals("RESERVER"))
            {

                if(restaurant.getPersonneConnecte().getType().equals("C"))
                {
                    Date d = new Date(Integer.parseInt(ReservationMainVueForClient.getTFJour().getText()),
                            Integer.parseInt(ReservationMainVueForClient.getTFMois().getText()),
                            Integer.parseInt(ReservationMainVueForClient.getTFAnnee().getText()),
                            Integer.parseInt(ReservationMainVueForClient.getTFHeure().getText()),
                            Integer.parseInt(ReservationMainVueForClient.getTFMin().getText()));

                    Table t = restaurant.setReservation(d,Integer.parseInt(ReservationMainVueForClient.getTFNbPersonne().getText()));

                    if(t != null)
                    {
                        Resevation r = new Resevation(restaurant.getListReservation().size(),
                                Integer.parseInt(ReservationMainVueForClient.getTFNbPersonne().getText()),
                                (Client) restaurant.getPersonneConnecte(),
                                d,t); // A MODIFIER ______________________
                        restaurant.getListReservation().add(r);
                        System.out.println(restaurant.getListReservation().toString());
                        ReservationMainVueForClient.dispose();
                        mainVueForClient.setNewModelReservation();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Toutes les Table ce jour la sont déja prise");
                    }
                }
                else
                {
                    Date d = new Date(Integer.parseInt(ReservationMainVue.getTFJour().getText()),
                            Integer.parseInt(ReservationMainVue.getTFMois().getText()),
                            Integer.parseInt(ReservationMainVue.getTFAnnee().getText()),
                            Integer.parseInt(ReservationMainVue.getTFHeure().getText()),
                            Integer.parseInt(ReservationMainVue.getTFMin().getText()));

                    Table t = restaurant.setReservation(d,Integer.parseInt(ReservationMainVue.getTFNbPersonne().getText()));

                    if(t != null)
                    {
                        Resevation r = new Resevation(restaurant.getListReservation().size(),
                                Integer.parseInt(ReservationMainVue.getTFNbPersonne().getText()),
                                (Client) restaurant.SearchClient(ReservationMainVue.getTFNomPersonne().getText()),
                                d,t); // A MODIFIER ______________________
                        restaurant.getListReservation().add(r);
                        System.out.println(restaurant.getListReservation().toString());
                        ReservationMainVue.dispose();
                        mainvue.setNewModelReservation();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Toutes les Table ce jour la sont déja prise");
                    }
                }






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
                int resultat = restaurant.Connexion(ConnexionWindow.getTFLogin().getText(), ConnexionWindow.getTFMdp().getText());

                if(resultat == 1)
                {
                    ConnexionWindow.dispose();
                    if(restaurant.getPersonneConnecte().getType().equals("C"))
                    {
                        mainVueForClient = new MainPageForClient("test", restaurant.getMenu(), restaurant.getListReservationAfficher());
                        mainVueForClient.setControlleur(this);
                        mainVueForClient.setNewModelMenu();
                        mainVueForClient.setNewModelReservation();
                        mainVueForClient.setVisible(true);
                        mainvue = new MainPage("test", restaurant.getListDePlat(), restaurant.getMenu(),restaurant.getListReservation());

                    }
                    else
                    {
                        mainvue = new MainPage("test", restaurant.getListDePlat(), restaurant.getMenu(),
                                restaurant.getListReservationAfficher());
                        mainvue.setControlleur(this);
                        mainvue.setNewModelReservation();
                        mainvue.setNewModelMenu();
                        mainvue.setNewModelPlat();
                        mainvue.setVisible(true);
                        mainVueForClient = new MainPageForClient("test", restaurant.getMenu(), restaurant.getListReservation());
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Le mots de passe ou le login n'est pas correct");
                }
            }

            if(e.getActionCommand().equals("INSCRIPTION"))
            {

                Client c = new Client(restaurant.getListPersonne().size(),InscriptionWindow.getTFNumTel().getText(),
                        InscriptionWindow.getTFNom().getText(), InscriptionWindow.getTFPrenom().getText(),
                        InscriptionWindow.getTFLogin().getText(), Integer.parseInt(InscriptionWindow.getTFJour().getText())
                        , Integer.parseInt(InscriptionWindow.getTFMois().getText()) ,
                        Integer.parseInt(InscriptionWindow.getTFAnnee().getText()));
                int resultat = restaurant.Inscription(c, InscriptionWindow.getTFMdp().getText());

                if(resultat == 1)
                {
                    MainPage m = new MainPage("test", restaurant.getListDePlat(), restaurant.getMenu(), restaurant.getListReservation());
                    mainvue = m;
                    mainvue.setControlleur(this);
                    mainvue.setNewModelReservation();
                    mainvue.setNewModelMenu();
                    mainvue.setNewModelPlat();
                    mainvue.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Le Login est déja utilisé");
                }
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

            if(e.getSource() == mainVueForClient.getCBMois() || e.getSource() == mainVueForClient.getCBANNEE() || mainvue.getCBMois() == e.getSource() || e.getSource() == mainvue.getCBANNEE())
            {
                if (restaurant.getPersonneConnecte().getType().equals("C"))
                    mainVueForClient.ChangeNbJour();
                else
                    mainvue.ChangeNbJour();

            }

            if(e.getActionCommand().equals("RECHERCHER"))
            {
                if(restaurant.getPersonneConnecte().getType() == "C")
                {
                    ArrayList<Resevation> List = restaurant.ReservationAAfficher((int) mainVueForClient.getCBJOUR().getSelectedItem(),
                            (int) mainVueForClient.getCBMois().getSelectedItem(), (int) mainVueForClient.getCBANNEE().getSelectedItem());

                    mainVueForClient.setDataReservation(List);
                    mainVueForClient.setNewModelReservation();
                }
                else
                {
                    ArrayList<Resevation> List = restaurant.ReservationAAfficher((int) mainvue.getCBJOUR().getSelectedItem(),
                            (int) mainvue.getCBMois().getSelectedItem(), (int) mainvue.getCBANNEE().getSelectedItem());

                    mainvue.setDataReservation(List);
                    mainvue.setNewModelReservation();
                }


            }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        restaurant.SavePlat(restaurant.getListDePlat());
        restaurant.SaveMenu(restaurant.getMenu());
        restaurant.SaveClient(restaurant.getListPersonne());
        restaurant.SaveMapReservation();
        restaurant.SaveReservation(restaurant.getListReservation());

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
