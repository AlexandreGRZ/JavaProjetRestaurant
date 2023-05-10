
package MODEL;

import java.io.Serializable;
import java.util.ArrayList;

public class Salle implements Serializable {

    private int NumSalle;

    private String NomSalle;

    private ArrayList<Zone> DifferenteZone;

    public Salle()
    {
        setNomSalle("  ");

        setNumSalle(0);

        setDifferenteZone(null);
    }

    public Salle(int NumSalle, String NomSalle, ArrayList<Zone> ListZone )
    {
        setNumSalle(NumSalle);

        setNomSalle(NomSalle);

        setDifferenteZone(ListZone);

    }

    public Salle(Salle S)
    {
        setNomSalle(S.getNomSalle());

        setNumSalle(S.getNumSalle());

        setDifferenteZone(S.getDifferenteZone());
    }


    public int getNumSalle() {
        return NumSalle;
    }

    public String getNomSalle() {
        return NomSalle;
    }

    public ArrayList<Zone> getDifferenteZone() {
        return DifferenteZone;
    }

    public void setDifferenteZone(ArrayList<Zone> differenteZone) {
        DifferenteZone = differenteZone;
    }

    public void setNomSalle(String nomSalle) {
        NomSalle = nomSalle;
    }

    public void setNumSalle(int numSalle) {
        this.NumSalle = numSalle;
    }

    public void AjouterUneZone(Zone z1)
    {
        getDifferenteZone().add(z1);
    }

    public void SupprimerUneZone(Zone z1)
    {
        getDifferenteZone().remove(z1);
    }


    @Override
    public String toString() {
        return "Salle{" +
                "NumSalle=" + NumSalle +
                ", NomSalle='" + NomSalle + '\'' +
                ", DifferenteZone=" + DifferenteZone +
                '}';
    }

    public boolean equals(Salle obj) {
       if(getNumSalle() == obj.getNumSalle() && getNomSalle().equals(obj.getNomSalle()))
       {
           boolean bool = false;
            for(int i = 0 ; i < getDifferenteZone().size() && !bool ; i++)
            {
                if( ! (getDifferenteZone().get(i).equals(obj.getDifferenteZone().get(i))) )
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

    public static void main(String[] args) {

        //Test Constructor

        Salle s1 = new Salle();

        Salle s2 = new Salle(1 ,"purple", new ArrayList<Zone>());

        Salle s3 = new Salle(s2);

        System.out.println(s1.toString());

        System.out.println(s2.toString());

        System.out.println(s3.toString());


        //Test Ajout et supprime de Zone

        Zone z1 = new Zone(1 , 50, 5 ,new ArrayList<Table>());

        Zone z2 = new Zone(2, 200, 20, new ArrayList<Table>());

        Zone z3 = new Zone(3, 500, 50, new ArrayList<Table>());

        s3.AjouterUneZone(z1);
        s3.AjouterUneZone(z2);
        s3.AjouterUneZone(z3);

        System.out.println(s3.toString());

        s3.SupprimerUneZone(z2);

        System.out.println(s3.toString());


    }
}
