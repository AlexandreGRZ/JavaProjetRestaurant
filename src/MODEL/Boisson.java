
package MODEL;

import java.util.ArrayList;

public class Boisson implements IMenu{

    private int numBoisson;

    private String Nom;

    private Float Prix;

    //private boolean Alcoolise;



    public Boisson(){
        setNom(" ");

        setNumBoisson( 0 );

        setPrix(0.0F);
    }


    public Boisson(int numBoisson, String Nom, float Prix){
        setPrix(Prix);

        setNom(Nom);

        setNumBoisson(numBoisson);
    }


    public Boisson(Boisson B){
        setNumBoisson(B.getNumBoisson());

        setPrix(B.getPrix());

        setNom(B.getNom());
    }

    public String getNom() {
        return Nom;
    }

    public Float getPrix() {
        return Prix;
    }

    public int getNumBoisson() {
        return numBoisson;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setNumBoisson(int numBoisson) {
        this.numBoisson = numBoisson;
    }

    public void setPrix(Float prix) {
        Prix = prix;
    }

    @Override
    public void ajouterAuMenu(Menu M) {
        M.getListBoisson().add(this);
    }

    @Override
    public void supprimerDuMenu(Menu M) {
        M.getListBoisson().remove(this);
    }

    public boolean equals(Boisson obj) {
        if( getNom().equals(obj.getNom()) && getPrix() == obj.getPrix() && getNumBoisson() == obj.getNumBoisson())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Boisson{" +
                "numBoisson=" + numBoisson +
                ", Nom='" + Nom + '\'' +
                ", Prix=" + Prix +
                '}';
    }


    public static void main(String[] args) {


        //Test Constructeur
        Boisson b1 = new Boisson();

        Boisson b2 = new Boisson(1, "COCA Normal", 2.5F);

        Boisson b3 = new Boisson(b2);

        System.out.println( b1.toString());

        System.out.println(  b2.toString());

        System.out.println( b3.toString());


        //Test AjoutAuMenu

        Menu m1 = new Menu(1, new ArrayList<Plat>(), new ArrayList<Boisson>());

        Boisson b4 = new Boisson(2, "COCA Light", 2.5F);

        Boisson b5 = new Boisson(3, "COCA Zero", 2F);

        b3.ajouterAuMenu(m1);

        b4.ajouterAuMenu(m1);

        b5.ajouterAuMenu(m1);

        System.out.println(m1.toString());

    }
}

