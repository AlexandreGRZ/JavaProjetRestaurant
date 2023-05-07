import Controlleur.Controlleur;
import InterfaceGraphique.InterfaceUtilisateur;
import InterfaceGraphique.MainPage;
import MODEL.Restaurant;

public class Main {


    public static void main(String[] args) {
        Restaurant Restaurant = MODEL.Restaurant.getInstance();
        //PREREQUIS POUR L'APPLICATION ---------------------------------------------------------------------------------

        Restaurant.LoadAliment();

       //CREATION DES FENETRE GRAPHIQUE----------------------------------------------------------------------------------
        MainPage fenetre = new MainPage("Test", Restaurant.getListDePlat(), Restaurant.getMenu(), Restaurant.getListReservation());
        InterfaceUtilisateur w = new InterfaceUtilisateur("test");

        Controlleur controleur = new Controlleur(Restaurant,fenetre);
        w.setControlleur(controleur);
        fenetre.setControlleur(controleur);
        fenetre.setVisible(true);
        w.setVisible(true);
    }
}
