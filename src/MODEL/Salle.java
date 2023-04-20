
package MODEL;

public class Salle {

    private int NumSalle;

    private String NomSalle;

    private Zone[] DifferenteZone;

    public Salle()
    {
        setNomSalle("  ");

        setNumSalle(0);

        setDifferenteZone(null);
    }

    public Salle(int NumSalle, String NomSalle)
    {
        setNumSalle(NumSalle);

        setNomSalle(NomSalle);

        setDifferenteZone(null);

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

    public Zone[] getDifferenteZone() {
        return DifferenteZone;
    }

    public void setDifferenteZone(Zone[] differenteZone) {
        DifferenteZone = differenteZone;
    }

    public void setNomSalle(String nomSalle) {
        NomSalle = nomSalle;
    }

    public void setNumSalle(int numSalle) {
        this.NumSalle = numSalle;
    }
}
