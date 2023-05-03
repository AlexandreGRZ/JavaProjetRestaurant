package MODEL;

import java.util.ArrayList;
import java.util.Vector;

public class Plat implements IMenu {

    private int numPlat;

    private  String Nom;

    private float Prix;

    private ArrayList<Aliment> ListAliment;

    //private String Provenance;

    public Plat()
    {
        setNom(" ");

        setNumPlat(0);

        setPrix(0.0F);

        setListAliment(null);
    }


    public Plat(int NumPlat, String Nom, float Prix, ArrayList<Aliment> List)
    {
        setNumPlat(NumPlat);

        setPrix(Prix);

        setNom(Nom);

        setListAliment(List);


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

    public ArrayList<Aliment> getListAliment() {
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

    public void setListAliment(ArrayList<Aliment> listAliment) {
        ListAliment = listAliment;
    }

    public void AjouteListAliment(Aliment Ali)
    {
        if(getListAliment() == null)
        {
            ArrayList<Aliment> List = new ArrayList<Aliment>();

            List.add(Ali);

            setListAliment(List);
        }
        else
            getListAliment().add(Ali);
    }

    public void AjouterUnAlimentAuPlat(Aliment A)
    {
        getListAliment().add(A);
    }

    public void SupprimerUnAliment(Aliment A)
    {
        getListAliment().remove(A);
    }



    @Override
    public void ajouterAuMenu(Menu M) {
        M.getListPlats().add(this);
    }

    @Override
    public void supprimerDuMenu(Menu M) {
        M.getListPlats().remove(this);
    }


    public boolean equals(Plat obj) {
        if(getNom().equals(obj.getNom()) && getNumPlat() == obj.getNumPlat() && getPrix() == obj.getPrix())
        {
            boolean bool = false;
            for(int i = 0; i < getListAliment().size() && !bool ; i++ )
            {
                if(! (getListAliment().get(i).equals(obj.getListAliment().get(i))) )
                    bool = true;
            }

            if(!bool)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Plat{" +
                "numPlat=" + numPlat +
                ", Nom='" + Nom + '\'' +
                ", Prix=" + Prix +
                ", ListAliment=" + ListAliment +
                '}';
    }

    public static void main(String[] args) {

        //Test Constructor

        Plat p1 = new Plat();

        Plat p2 = new Plat(1, "Pates Bolo", 15.5F, new ArrayList<Aliment>());

        Plat p3 = new Plat(p2);

        System.out.println(p1.toString());

        System.out.println(p2.toString());

        System.out.println(p3.toString());


        //Test ajout des Aliment

        Aliment a1 = new Aliment(1, "Carrote");

        Aliment a2 = new Aliment(2, "Pate");

        Aliment a3 = new Aliment(3, "Ognons");

        Aliment a4 = new Aliment(4, "Tomate");

        p3.AjouterUnAlimentAuPlat(a1);
        p3.AjouterUnAlimentAuPlat(a2);
        p3.AjouterUnAlimentAuPlat(a3);
        p3.AjouterUnAlimentAuPlat(a4);

        System.out.println(p3.toString());

        p3.SupprimerUnAliment(a3);

        System.out.println(p3.toString());


    }
}
