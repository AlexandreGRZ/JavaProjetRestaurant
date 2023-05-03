package MODEL;


import java.util.ArrayList;

public class Restaurant {


    ArrayList<Resevation> ListReservation;
    Menu Menu = new Menu(1, new ArrayList<Plat>(), new ArrayList<Boisson>());
    ArrayList<Plat> ListDePlat;
    ArrayList<Aliment> ListAliment; // a charger depuis un fichier
    ArrayList<Boisson> ListBoisson; // a charger depuis un fichier
    ArrayList<Client> ListClient;
    ArrayList<Serveur> ListServeur;
    ArrayList<MaitreHotel>ListMaitreHotel;
    ArrayList<Salle> ListSalle; // a charger depuis un fichier

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

    public ArrayList<Salle> getListSalle() {
        return ListSalle;
    }

    public MODEL.Menu getMenu() {
        return Menu;
    }

    public Personne getPersonneConnecte() {
        return PersonneConnecte;
    }

}
