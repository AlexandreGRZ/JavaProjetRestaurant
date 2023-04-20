package MODEL;
public class Zone {

    private int NumZone;

    private int Taille;

    private int nbTable;

    private Table[] VecTable;



    public Zone()
    {
        setNumZone(0);

        setTaille(0);

        setNbTable(0);

        setVecTable(null);
    }

    public Zone(int NumZone, int Taille, int nbTable){

        setNumZone(NumZone);

        setNbTable(nbTable);

        setTaille(Taille);

        setVecTable(null);
    }

    public Zone(Zone Z){

        setNumZone(Z.getNumZone());

        setNbTable(Z.getNbTable());

        setTaille(Z.getTaille());

        setVecTable(Z.getVecTable());
    }

    public int getNbTable() {
        return nbTable;
    }

    public int getTaille() {
        return Taille;
    }

    public int getNumZone() {
        return NumZone;
    }

    public Table[] getVecTable() {
        return VecTable;
    }

    public void setNbTable(int nbTable) {
        this.nbTable = nbTable;
    }

    public void setTaille(int taille) {
        Taille = taille;
    }

    public void setNumZone(int numZone) {
        NumZone = numZone;
    }

    public void setVecTable(Table[] vecTable) {
        VecTable = vecTable;
    }
}
