import Controlleur.Controlleur;
import InterfaceGraphique.MainPage;
import MODEL.Restaurant;

public class Main {


    public static void main(String[] args) {
        Restaurant Restaurant = MODEL.Restaurant.getInstance();
        MainPage fenetre = new MainPage("Test");
        //JFrameSecondDegre fenetre = new JFrameSecondDegre();

        Controlleur controleur = new Controlleur(Restaurant,fenetre);
        fenetre.setControlleur(controleur);

        fenetre.setVisible(true);
    }
}
