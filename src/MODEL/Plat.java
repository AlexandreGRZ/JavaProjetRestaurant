package MODEL;

import java.util.Vector;

public class Plat implements IMenu {

    private int numPlat;

    private  String Nom;

    private float Prix;

    private Vector<Aliment> ListAliment;

    //private String Provenance;

    public Plat()
    {
        setNom(" ");

        setNumPlat(0);

        setPrix(0.0F);

        setListAliment(null);
    }


    public Plat(int NumPlat, String Nom, float Prix, Aliment[] ListAliment)
    {
        setNumPlat(NumPlat);

        setPrix(Prix);

        setNom(Nom);

        setListAliment(null);


    }


    public Plat(Plat P)
    {
        setPrix(P.getPrix());

        setNom(P.getNom());

        setNumPlat(P.getNumPlat());

        setListAliment(P.ListAliment);
    }


    public String getNom() {
        return Nom;
    }

    public float getPrix() {
        return Prix;
    }

    public int getNumPlat() {
        return numPlat;
    }

    public Vector<Aliment> getListAliment() {
        return ListAliment;
    }

    public void setPrix(float prix) {
        Prix = prix;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setNumPlat(int numPlat) {
        this.numPlat = numPlat;
    }

    public void setListAliment(Vector<Aliment> listAliment) {
        ListAliment = listAliment;
    }

    public void AjouteListAliment(Aliment Ali)
    {
        if(getListAliment() == null)
        {
            Vector<Aliment> List = new Vector<Aliment>();

            List.add(Ali);

            setListAliment(List);
        }
        else
            getListAliment().add(Ali);
    }


    @Override
    public void ajouterAuMenu(Menu M) {
        M.getListPlats().add(this);
    }

    @Override
    public void supprimerDuMenu(Menu M) {
        M.getListPlats().remove(this);
    }
}
