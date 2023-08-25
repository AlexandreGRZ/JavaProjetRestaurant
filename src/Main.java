import Controlleur.Controlleur;
import InterfaceGraphique.InterfaceUtilisateur;
import InterfaceGraphique.MainPage;
import MODEL.*;

import java.beans.Beans;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.beans.*;

public class Main {



    public static void main(String[] args) {
        LogOnTheSite connexion;
        Restaurant Restaurant = MODEL.Restaurant.getInstance();
        //PREREQUIS POUR L'APPLICATION ---------------------------------------------------------------------------------



        Restaurant.LoadAliment();
        Restaurant.LoadPlat();
        Restaurant.LoadMenu();
        Restaurant.LoadClient();
        Restaurant.LoadMapReservation();
        Restaurant.LoadReservation();


        System.out.println(Restaurant.getListPersonne());

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
        for(int i = 0 ; i < Restaurant.getListPersonne().size(); i++)
        {
            System.out.println(Restaurant.getListPersonne().get(i).toString() + " ");

        }

        try{
            connexion = (LogOnTheSite) Beans.instantiate(null, "MODEL.LogOnTheSite");
            connexion.setSingleton(Restaurant);
            Restaurant.setConnexion(connexion);
        }catch (ClassNotFoundException e)
        {
            System.out.println("Classe non trouvée : " + e.getMessage());
            System.exit(0);
        }
        catch(IOException e)
        {
            System.out.println("Erreur IO : " + e.getMessage());
            System.exit(0);
        }

       //CREATION DES FENETRE GRAPHIQUE----------------------------------------------------------------------------------
        InterfaceUtilisateur w = new InterfaceUtilisateur("test");

        Controlleur controleur = new Controlleur(Restaurant,w);

        w.setControlleur(controleur);
        w.setVisible(true);
    }

}
