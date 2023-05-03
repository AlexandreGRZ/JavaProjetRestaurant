package MODEL;
public class Resevation {

    private int numReservation;

    private int nbPersonne;

    private Client Clients;

    private int Jour;

    private int Mois;

    private int Annee;

    private int Heure;

    private int Min;

    public Resevation()
    {
        setNumReservation(-1);

        setNbPersonne(-1);

        setClients(new Client());

        setJour(1);

        setMois(1);

        setAnnee(1900);

        setHeure(12);

        setMin(0);

    }

    public Resevation(int numreservation, int nbPersonne, Client client, int jour, int mois, int annee, int heure, int min)
    {
        setNumReservation(numreservation);

        setNbPersonne(nbPersonne);

        setClients(client);

        setJour(jour);

        setMois(mois);

        setAnnee(annee);

        setHeure(heure);

        setMin(min);
    }

    public Resevation( Resevation R)
    {
        setNumReservation(R.getNumReservation());

        setNbPersonne(R.getNbPersonne());

        setClients(R.getClients());

        setJour(R.getJour());

        setMois(R.getMois());

       setAnnee(R.getAnnee());

        setHeure(R.getHeure());

        setMin(R.getMin());
    }

    public int getNumReservation() {
        return numReservation;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public Client getClients() {
        return Clients;
    }

    public int getJour() {
        return Jour;
    }

    public int getMois() {
        return Mois;
    }

    public int getAnnee() {
        return Annee;
    }

    public int getHeure() {
        return Heure;
    }

    public int getMin() {
        return Min;
    }


    public void setNumReservation(int numReservation) {
        this.numReservation = numReservation;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public void setClients(Client clients) {
        Clients = clients;
    }

    public void setJour(int jour) {
        Jour = jour;
    }

    public void setMois(int mois) {
        Mois = mois;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    public void setHeure(int heure) {
        Heure = heure;
    }

    public void setMin(int min) {
        Min = min;
    }


    public boolean equals(Resevation obj) {
       if(getNumReservation() == obj.getNumReservation() && getNbPersonne() == obj.getNumReservation()
               && getClients().equals(obj.getClients()) && getJour() == obj.getJour() && getMois() == obj.getMois()
               && getAnnee() == obj.getAnnee() && getHeure() == obj.getHeure() && getMin() == obj.getMin())
           return true;
       else return false;
    }

    @Override
    public String toString() {
        return "Resevation{" +
                "numReservation=" + numReservation +
                ", nbPersonne=" + nbPersonne +
                ", Clients=" + Clients +
                ", Jour=" + Jour +
                ", Mois=" + Mois +
                ", Annee=" + Annee +
                ", Heure=" + Heure +
                ", Min=" + Min +
                '}';
    }

    public static void main(String[] args) {

       Resevation r1 = new Resevation();

       Resevation r2 = new Resevation(1, 5, new Client(), 3, 3 , 2003, 12, 40);

       Resevation r3 = new Resevation(r2);


        System.out.println( r1.toString());

        System.out.println(  r2.toString());

        System.out.println( r3.toString());

    }
}
