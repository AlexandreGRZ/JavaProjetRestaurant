import Controlleur.Controlleur;
import InterfaceGraphique.InterfaceUtilisateur;
import InterfaceGraphique.MainPage;
import MODEL.*;

import java.util.ArrayList;
import java.util.Objects;

public class Main {


    public static void main(String[] args) {
        Restaurant Restaurant = MODEL.Restaurant.getInstance();
        //PREREQUIS POUR L'APPLICATION ---------------------------------------------------------------------------------

        Restaurant.LoadAliment();
        Restaurant.LoadPlat();
        Restaurant.LoadMenu();
        Restaurant.LoadClient();
        Restaurant.LoadMapReservation();

        Table t1 = new Table(1, 6);
        Table t2 = new Table(2, 6);
        Table t3 = new Table(3, 4);

        ArrayList<Table> t = new ArrayList<Table>();

        t.add(t1);
        t.add(t2);
        t.add(t3);

        Zone z1 = new Zone(1, 50, 3, t );

        ArrayList<Zone> z = new ArrayList<Zone>();

        z.add(z1);

        Salle s1 = new Salle(1, "Blue", z );

        Restaurant.getListSalle().add(s1);

        System.out.println("LOAD");
        for(int i = 0 ; i < Restaurant.getListClient().size(); i++)
        {
            System.out.println(Restaurant.getListClient().get(i).toString() + " ");

        }

       //CREATION DES FENETRE GRAPHIQUE----------------------------------------------------------------------------------
        InterfaceUtilisateur w = new InterfaceUtilisateur("test");

        Controlleur controleur = new Controlleur(Restaurant,w);
        w.setControlleur(controleur);
        w.setVisible(true);
    }

}
