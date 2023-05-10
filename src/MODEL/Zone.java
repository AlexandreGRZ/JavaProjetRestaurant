package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Zone implements Serializable {

    private int NumZone;

    private int Taille;

    private int nbTable;

    private ArrayList<Table> VecTable;



    public Zone()
    {
        setNumZone(0);

        setTaille(0);

        setNbTable(0);

        setVecTable(null);
    }

    public Zone(int NumZone, int Taille, int nbTable, ArrayList<Table> ListTable){

        setNumZone(NumZone);

        setNbTable(nbTable);

        setTaille(Taille);

        setVecTable(ListTable);
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

    public ArrayList<Table> getVecTable() {
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

    public void setVecTable(ArrayList<Table> vecTable) {
        VecTable = vecTable;
    }

    public void AjouterUneTableAUneZone(Table t1)
    {
        getVecTable().add(t1);
    }

    public void SupprimerUneTableAUneZone(Table t1)
    {
        getVecTable().remove(t1);
    }


    @Override
    public String toString() {
        return "Zone{" +
                "NumZone=" + NumZone +
                ", Taille=" + Taille +
                ", nbTable=" + nbTable +
                ", VecTable=" + VecTable +
                '}';
    }

    public boolean equals(Zone obj) {
        if(getNumZone() == obj.getNumZone() && getTaille() == obj.getTaille() && getNbTable() == obj.getNbTable())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        //Test Constructor

        Zone z1 = new Zone();

        Zone z2 = new Zone(1, 50, 5, new ArrayList<Table>());

        Zone z3 = new Zone(z2);

        System.out.println(z1.toString());

        System.out.println(z2.toString());

        System.out.println(z3.toString());


        //test des Ajout et suppression

        Table t2 = new Table(1, 5 );
        Table t3 = new Table(2, 5);
        Table t4 = new Table(3, 5);

        z3.AjouterUneTableAUneZone(t2);
        z3.AjouterUneTableAUneZone(t3);
        z3.AjouterUneTableAUneZone(t4);

        System.out.println(z3.toString());

        z3.SupprimerUneTableAUneZone(t2);

        System.out.println(z3.toString());

    }
}
