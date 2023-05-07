package MODEL;


import java.util.ArrayList;
import java.io.*;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.apache.commons.lang3.*;


public class Restaurant {


    ArrayList<Resevation> ListReservation;
    Menu Menu = new Menu(1, new ArrayList<Plat>(), new ArrayList<Boisson>());
    ArrayList<Plat> ListDePlat = new ArrayList<Plat>();
    ArrayList<Aliment> ListAliment = new ArrayList<Aliment>(); // a charger depuis un fichier
    ArrayList<Aliment> ListAlimentAfficher = new ArrayList<Aliment>();
    ArrayList<Boisson> ListBoisson = new ArrayList<Boisson>(); // a charger depuis un fichier
    ArrayList<Client> ListClient = new ArrayList<Client>();
    ArrayList<Serveur> ListServeur = new ArrayList<Serveur>();
    ArrayList<MaitreHotel>ListMaitreHotel = new ArrayList<MaitreHotel>();
    ArrayList<Salle> ListSalle = new ArrayList<Salle>(); // a charger depuis un fichier

    private static Restaurant r1;

    private Restaurant()
    {

    }
    private Personne PersonneConnecte = null;
    public static Restaurant getInstance()
    {
        if(r1 == null)
        {
            r1 = new Restaurant();
        }

        return r1;
    }
    public void AjouterClient(Client c1)
    {
        getListClient().add(c1);
    }

    public void AjouterUnServeur(Serveur s1)
    {
        getListServeur().add(s1);
    }

    public void AjouterUnMaitreHotel(MaitreHotel m1)
    {
        getListMaitreHotel().add(m1);
    }

    public void AjouterPlat(Plat p1)
    {
        getListDePlat().add(p1);
    }

    public void AjouterUneReservation(Resevation r1)
    {
        getListReservation().add(r1);
    }

    public void SupprimerPlat(Plat p1)
    {
        getListDePlat().remove(p1);
    }

    public void SupprimerUnPlatDuMenu(Plat p1)
    {
        p1.supprimerDuMenu(getMenu());
    }

    public void SuprimerUneReservation(Resevation r1)
    {
        getListReservation().remove(r1);
    }

    public ArrayList<Aliment> getListAliment() {
        return ListAliment;
    }

    public ArrayList<Boisson> getListBoisson() {
        return ListBoisson;
    }

    public ArrayList<Plat> getListDePlat() {
        return ListDePlat;
    }

    public ArrayList<Client> getListClient() {
        return ListClient;
    }

    public ArrayList<MaitreHotel> getListMaitreHotel() {
        return ListMaitreHotel;
    }

    public ArrayList<Serveur> getListServeur() {
        return ListServeur;
    }

    public ArrayList<Resevation> getListReservation() {
        return ListReservation;
    }

    public ArrayList<Aliment> getListAlimentAfficher() {
        return ListAlimentAfficher;
    }

    public ArrayList<Salle> getListSalle() {
        return ListSalle;
    }

    public MODEL.Menu getMenu() {
        return Menu;
    }

    public Personne getPersonneConnecte() {
        return PersonneConnecte;
    }


    //METHOD------------------------------------------------------------------------------------------------------------------

    public void LoadAliment()
    {
        try(CSVReader reader = new CSVReader(new FileReader("E:\\Cours\\Java\\JavaProjetRestaurant\\CSV\\Aliment.csv")))
        {
            reader.readNext();

            List<String[]> lignes = reader.readAll();
            for(String[] ligne : lignes)
            {
                int num = Integer.parseInt(ligne[0]);
                String NomAliment = ligne[1];
                ListAliment.add(new Aliment(num, NomAliment));
            }
        }
        catch (IOException | CsvException e)
        {
            System.out.println("Probleme avec le fichier csv");
        }
    }

    public void AddAlimentToPlat(String NomAliment)
    {
        for (Aliment Value: ListAliment) {
            if(Value.getNom() == NomAliment)
            {
                ListAlimentAfficher.add(Value);
                break;
            }

        }
    }

    public void Save(Object data)
    {
        try(FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer))
        {
            objectOutputStream.writeObject(data);
        }catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
        }

    }

    public Plat SearchPlat(int indice)
    {
        return getListDePlat().get(indice);
    }





}
