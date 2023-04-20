package MODEL;

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
}
