package MODEL;

import java.util.Objects;

public class Aliment {


    private int NumAliment;

    private String Nom;


    public Aliment()
    {
        setNumAliment(0);

        setNom(" ");
    }

    public Aliment(int NumTable, String Nom)
    {
        setNumAliment(NumTable);

        setNom(Nom);
    }


    public Aliment(Aliment Ali)
    {
        setNumAliment(Ali.getNumAliment());

        setNom(Ali.getNom());
    }


    public String getNom() {
        return Nom;
    }

    public int getNumAliment() {
        return NumAliment;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setNumAliment(int numAliment) {
        NumAliment = numAliment;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "NumAliment=" + NumAliment +
                ", Nom='" + Nom + '\'' +
                '}';
    }

    public boolean equals(Aliment obj) {

        if(getNom().equals(obj.getNom()) && getNumAliment() == obj.getNumAliment())
            return true;
        else
            return false;

    }


    public static void main(String[] args) {

            Aliment al1 = new Aliment();

            Aliment al2 = new Aliment(1, "Carotte");

            Aliment al3 = new Aliment(al2);

            System.out.println( al1.toString());

            System.out.println(  al2.toString());

            System.out.println( al3.toString());

    }
}
