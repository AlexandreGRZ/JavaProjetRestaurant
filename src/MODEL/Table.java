package MODEL;
public class Table {

    private int numTable;

    private int nbPersonne;

    public Table()
    {
        setNumTable(0);

        setNbPersonne(0);
    }

    public Table(int numTable, int NbPersonne)
    {
        setNbPersonne(NbPersonne);

        setNumTable(numTable);
    }

    public Table(Table T)
    {
        setNumTable(T.getNumTable());

        setNbPersonne(T.getNbPersonne());
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public int getNumTable() {
        return numTable;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public void setNumTable(int numTable) {
        this.numTable = numTable;
    }
}
