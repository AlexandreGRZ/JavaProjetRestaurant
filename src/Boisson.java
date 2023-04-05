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
}

