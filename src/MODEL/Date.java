package MODEL;

import java.io.Serializable;

public class Date implements Serializable {

    private int Jour;

    private int Mois;

    private int Annee;

    private int Heure;

    private int Min;


    public Date()
    {
        Jour = 1;

        Mois = 1;

        Annee = 1900;

        Heure = 0;

        Min = 0;
    }

    public Date(int jour, int mois, int annee, int heure, int min)
    {
        setAnnee(annee);

        setHeure(heure);

        setJour(jour);

        setMois(mois);

        setMin(min);
    }

    public Date(Date d)
    {
        setMin(d.getMin());

        setMois(d.getMois());

        setJour(d.getJour());

        setMois(d.getMois());

        setAnnee(d.getAnnee());
    }


    public int getMin() {
        return Min;
    }

    public int getHeure() {
        return Heure;
    }

    public int getAnnee() {
        return Annee;
    }

    public int getMois() {
        return Mois;
    }

    public int getJour() {
        return Jour;
    }

    public void setMin(int min) {
        Min = min;
    }

    public void setHeure(int heure) {
        Heure = heure;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    public void setMois(int mois) {
        Mois = mois;
    }

    public void setJour(int jour) {
        Jour = jour;
    }

    @Override
    public String toString() {
        return getJour() + "/" + getMois() + "/" + getAnnee() + "   " + getHeure() + " : " + getHeure();
    }

    public boolean equals(Date obj) {
        if(obj.getJour() == getJour() && obj.getMois() == getMois() && obj.getAnnee() == getAnnee())
            return true;
        else
            return false;
    }
}
