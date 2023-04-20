
package MODEL;

public class Client extends Personne
{
    private int NumClient;
    private String NumTel;


    public Client(){
        super();

        setNumClient(0);

        setNumTel("0000000000");

    }

    public Client(int numClient, String numTel, String nom, String prenom, String Login, String Mdp, int day, int month, int year)
    {
        super(nom, prenom, Login, Mdp, day, month, year);

        setNumTel(numTel);

        setNumClient(numClient);
    }

    public Client(Client c){

        super(c);

        setNumClient(c.getNumClient());

        setNumTel(c.getNumTel());

    }

    public int getNumClient() {
        return NumClient;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumClient(int numClient) {
        NumClient = numClient;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

}
