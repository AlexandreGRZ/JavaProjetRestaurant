package MODEL;
public class Resevation {

    private int numReservation;

    private int nbPersonne;

    private Client Clients;

    private Date datereservation;

    public Resevation()
    {
        setNumReservation(-1);

        setNbPersonne(-1);

        setClients(new Client());

        setDatereservation(new Date());

    }

    public Resevation(int numreservation, int nbPersonne, Client client, Date datereservation)
    {
        setNumReservation(numreservation);

        setNbPersonne(nbPersonne);

        setClients(client);

        setDatereservation(datereservation);
    }

    public Resevation( Resevation R)
    {
        setNumReservation(R.getNumReservation());

        setNbPersonne(R.getNbPersonne());

        setClients(R.getClients());

        setDatereservation(R.getDatereservation());
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

    public Date getDatereservation() {
        return datereservation;
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

    public void setDatereservation(Date datereservation) {
        this.datereservation = datereservation;
    }

    public boolean equals(Resevation obj) {
       if(getNumReservation() == obj.getNumReservation() && getNbPersonne() == obj.getNumReservation()
               && getClients().equals(obj.getClients()))
           return true;
       else return false;
    }

    @Override
    public String toString() {
        return "Resevation{" +
                "numReservation=" + numReservation +
                ", nbPersonne=" + nbPersonne +
                ", Clients=" + Clients +
                '}';
    }

    public static void main(String[] args) {

       Resevation r1 = new Resevation();

       Resevation r2 = new Resevation(1, 5, new Client(),new Date(3, 3 , 2003, 12, 40));

       Resevation r3 = new Resevation(r2);


        System.out.println( r1.toString());

        System.out.println(  r2.toString());

        System.out.println( r3.toString());

    }
}
