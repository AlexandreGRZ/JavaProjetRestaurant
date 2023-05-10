package MODEL;


import java.util.*;
import java.io.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.apache.commons.lang3.*;


public class Restaurant {


    ArrayList<Resevation> ListReservation = new ArrayList<Resevation>();

    ArrayList<Resevation> ListReservationAfficher = new ArrayList<Resevation>();
    Menu Menu = new Menu(1, new ArrayList<Plat>(), new ArrayList<Boisson>());
    ArrayList<Plat> ListDePlat = new ArrayList<Plat>();
    ArrayList<Aliment> ListAliment = new ArrayList<Aliment>(); // a charger depuis un fichier
    ArrayList<Aliment> ListAlimentAfficher = new ArrayList<Aliment>();
    ArrayList<Boisson> ListBoisson = new ArrayList<Boisson>(); // a charger depuis un fichier
    ArrayList<Personne> ListPersonne = new ArrayList<Personne>();
    ArrayList<Salle> ListSalle = new ArrayList<Salle>(); // a charger depuis un fichier



    Map<String, ArrayList<Table>> MapReservation = new HashMap<>();

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

    public ArrayList<Personne> getListPersonne() {
        return ListPersonne;
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

    public Map<String, ArrayList<Table>> getMapReservation() {
        return MapReservation;
    }

    public ArrayList<Resevation> getListReservationAfficher() {
        return ListReservationAfficher;
    }

    public void setListDePlat(ArrayList<Plat> listDePlat) {
            ListDePlat = listDePlat;
    }

    public void setListAliment(ArrayList<Aliment> listAliment) {
        ListAliment = listAliment;
    }

    public void setListAlimentAfficher(ArrayList<Aliment> listAlimentAfficher) {
        ListAlimentAfficher = listAlimentAfficher;
    }

    public void setListBoisson(ArrayList<Boisson> listBoisson) {
        ListBoisson = listBoisson;
    }


    public void setListReservation(ArrayList<Resevation> listReservation) {
        ListReservation = listReservation;
    }

    public void setListSalle(ArrayList<Salle> listSalle) {
        ListSalle = listSalle;
    }

    public void setListPersonne(ArrayList<Personne> listPersonne) {
        ListPersonne = listPersonne;
    }

    public void setMenu(MODEL.Menu menu) {
        Menu = menu;
    }

    public void setPersonneConnecte(Personne personneConnecte) {
        PersonneConnecte = personneConnecte;
    }

    public void setMapReservation(Map<String, ArrayList<Table>> mapReservation) {
        MapReservation = mapReservation;
    }

    public void setListReservationAfficher(ArrayList<Resevation> listReservationAfficher) {
        ListReservationAfficher = listReservationAfficher;
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
            if(Value.getNom().equals(NomAliment))
            {
                ListAlimentAfficher.add(Value);
                break;
            }

        }
    }

    public void SavePlat(ArrayList<Plat> data)
    {
        try(FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Plat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer))
        {
            for (Plat p: data) {
                objectOutputStream.writeObject(p);
            }
        }catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
        }

    }

    public void SaveMenu(Menu menu)
    {
        try(FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Menu");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer))
        {
            objectOutputStream.writeObject(menu);
        }catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
        }

    }

    public void SaveClient(ArrayList<Personne> data)
    {
        try(FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Client");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer))
        {
            for (Personne value: data) {
                System.out.println(value.toString());
                objectOutputStream.writeObject(value);
            }
        }catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
        }

    }

    public void SaveMapReservation()
    {
        try(FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\MapReservation");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer))
        {
            objectOutputStream.writeObject(MapReservation);
        }catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
        }

    }

    public void SaveReservation(ArrayList<Resevation> data)
    {
        try(FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Reservation");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(writer))
        {
            for (Resevation value: data) {
                System.out.println(value.toString());
                objectOutputStream.writeObject(value);
            }
        }catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
        }

    }
    public void LoadPlat()
    {
        try(FileInputStream reader = new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Plat");
            ObjectInputStream objectInputStream = new ObjectInputStream(reader))
        {
            Plat p = (Plat) objectInputStream.readObject();
            while (p != null)
            {
                getListDePlat().add(p);
                p = (Plat) objectInputStream.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Une erreur s'est produite lors de la lecture dans le fichier : " + e.getMessage());
        }
    }

    public void LoadMapReservation()
    {
        try(FileInputStream reader = new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\MapReservation");
            ObjectInputStream objectInputStream = new ObjectInputStream(reader))
        {
            Map<String, ArrayList<Table>> t = (Map<String, ArrayList<Table>>) objectInputStream.readObject();

            System.out.println(t.toString());

            setMapReservation( t );
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Une erreur s'est produite lors de la lecture dans le fichier : " + e.getMessage());
        }
    }
    public void LoadClient()
    {
        try(FileInputStream reader = new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Client");
            ObjectInputStream objectInputStream = new ObjectInputStream(reader))
        {
            Personne c = (Personne) objectInputStream.readObject();
            while (c != null)
            {
                System.out.println(c.toString());
                getListPersonne().add(c);
                c = (Personne) objectInputStream.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Une erreur s'est produite lors de la lecture dans le fichier : " + e.getMessage());
        }
    }

    public void LoadReservation()
    {
        try(FileInputStream reader = new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Reservation");
            ObjectInputStream objectInputStream = new ObjectInputStream(reader))
        {
            Resevation c = (Resevation) objectInputStream.readObject();
            while (c != null)
            {
                System.out.println(c.toString());
                getListReservation().add(c);
                c = (Resevation) objectInputStream.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Une erreur s'est produite lors de la lecture dans le fichier : " + e.getMessage());
        }
    }

    public void LoadMenu()
    {
        try(FileInputStream reader = new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\Menu");
            ObjectInputStream objectInputStream = new ObjectInputStream(reader))
        {
            Menu m = (Menu) objectInputStream.readObject();
            setMenu(m);
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Une erreur s'est produite lors de la lecture dans le fichier : " + e.getMessage());
        }
    }

    public Plat SearchPlat(int indice)
    {
        return getListDePlat().get(indice);
    }

    public Personne SearchClient(String nom)
    {
        for(int i = 0; i < getListPersonne().size(); i++)
        {
            if(getListPersonne().get(i).getNom().equals(nom))
                return getListPersonne().get(i);
        }
        return null;
    }


    public int Inscription(Client c, String mdp)
    {
        boolean checkifLoginIsUse = false;

        for (Personne value: getListPersonne()) {
            if(value.getLogin().equals(c.getLogin()))
            {
                checkifLoginIsUse = true;
                break;
            }
        }

        if(!checkifLoginIsUse)
        {
            getListPersonne().add(c);
            setmdp(c.getLogin(), mdp);
            setPersonneConnecte(c);
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public int Connexion(String login, String mdp)
    {
        System.out.println(login + mdp);
        boolean CheckIfLoginExist = false;
        Personne client = null;
        for (Personne value : getListPersonne()) {
            System.out.println(value.getLogin() + getmdp(value.getLogin()));
            if(value.getLogin().equals(login))
            {
                CheckIfLoginExist = true;
                client = value;
                break;
            }
        }

        if(CheckIfLoginExist)
        {
            System.out.println(mdp);
            if(this.getmdp(login).equals(mdp))
            {
                setPersonneConnecte(client);
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }

    public String getmdp(String login)
    {
        try{

            Properties p = new Properties();

            p.load(new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\mdp.properties"));

            String mdp = p.getProperty(login);
            return mdp;

        }catch (FileNotFoundException e)
        {
            System.out.println("File not find");
        } catch (IOException e) {
            System.out.println("PROBLEME IOException");
        }
        return null;
    }
    public void setmdp(String Login, String mdp)
    {

        File F = new File("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\mdp.properties");

        if(F.exists())
        {
            try(FileInputStream reader = new FileInputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\mdp.properties"))
            {
                Properties p = new Properties();
                p.load(reader);
                p.setProperty(Login, mdp);

                try( FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\mdp.properties"))
                {
                    p.store(writer, null);
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("file don't find ");
            } catch (IOException e) {
                System.out.println("Probleme de fichier");
            }

        }
        else
        {
            Properties p = new Properties();
            p.setProperty(Login, mdp);

            try( FileOutputStream writer = new FileOutputStream("E:\\Cours\\Java\\JavaProjetRestaurant\\data\\mdp.properties"))
            {
                p.store(writer, null);
            }
            catch (FileNotFoundException e)
            {
                System.out.println("file don't find ");
            } catch (IOException e) {
                System.out.println("Probleme de fichier");
            }
        }
    }

    public Table setReservation(Date dateReservation, int nbPersonne)
    {
        Map<String, ArrayList<Table>> reservations = getMapReservation();

        if(!reservations.containsKey(dateReservation.toString()))
        {
            reservations.put(dateReservation.toString(), new ArrayList<Table>());
            System.out.println("NEVER USE DATE");
        }

        System.out.println(reservations.get(dateReservation.toString()));
        Table t = SearchTable(nbPersonne, reservations.get(dateReservation.toString()));

        if(t != null)
        {
            reservations.get(dateReservation.toString()).add(t);
            System.out.println(reservations.get(dateReservation.toString()));
            System.out.println("TABLE FIND");
            return t;
        }
        else
            return null;

    }


    public Table SearchTable(int nbPersonne, ArrayList<Table> tables)
    {
        for (Salle value: ListSalle) {
            for (Zone zone: value.getDifferenteZone()) {
                for (Table table: zone.getVecTable()) {
                    boolean checkTable = false;
                    for (Table tableUse : tables) {
                        if(tableUse.equals(table))
                        {
                            checkTable = true;
                            break;
                        }
                    }

                    if(!checkTable)
                    {
                        System.out.println("Coucou");
                        if(nbPersonne <= table.getNbPersonne())
                        {
                            return table;
                        }
                        else
                            break;

                    }

                }
            }
        }
        return null;
    }

    public ArrayList<Resevation> ReservationAAfficher(int jour, int Mois, int Annee)
    {
        Date d = new Date(jour, Mois, Annee, 12, 30);
        ListReservationAfficher = new ArrayList<Resevation>();
        for (Resevation value: ListReservation) {

            System.out.println(value.toString() + d.toString());

            if(value.getDatereservation().toString().equals(d.toString()))
            {
                ListReservationAfficher.add(value);
            }

        }
        System.out.println(ListReservationAfficher);
        setListReservationAfficher(ListReservationAfficher);
        return ListReservationAfficher;

    }




}
