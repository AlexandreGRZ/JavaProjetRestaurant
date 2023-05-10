package MODEL;

import java.io.Serializable;

public class Table implements Serializable {

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

    public boolean equals(Table obj) {
       if (getNbPersonne() == obj.getNbPersonne() && getNumTable() == obj.getNumTable())
           return true;
       else
           return false;
    }

    @Override
    public String toString() {
        return "Table{" +
                "numTable=" + numTable +
                ", nbPersonne=" + nbPersonne +
                '}';
    }

    public static void main(String[] args) {

        //Test Constructor
        Table t1 = new Table();

        Table t2 = new Table(1, 5);

        Table t3 = new Table(t2);

        System.out.println(t1.toString());

        System.out.println(t2.toString());

        System.out.println(t3.toString());

    }
}
