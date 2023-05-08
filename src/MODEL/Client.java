
package MODEL;

import java.io.Serializable;

public class Client extends Personne implements Serializable {
    private int NumClient;
    private String NumTel;


    public Client(){
        super();

        setNumClient(0);

        setNumTel("0000000000");

        setType("C");

    }

    public Client(int numClient, String numTel, String nom, String prenom, String Login, int day, int month, int year)
    {
        super(nom, prenom, Login, day, month, year);

        setNumTel(numTel);

        setNumClient(numClient);

        setType("C");
    }

    public Client(Client c){

        super(c);

        setNumClient(c.getNumClient());

        setNumTel(c.getNumTel());

        setType(c.getType());

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


    public boolean equals(Client obj) {
        if(getNom().equals(obj.getNom()) && getPrenom().equals(obj.getPrenom()) && getNumTel().equals(obj.getNumTel())
                && getLogin().equals(obj.getLogin()) && getBirthDay().equals(obj.getBirthDay())
                && getNumClient() == obj.getNumClient())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return getNom();
    }


    public static void main(String[] args) {

       //Test Constructor

        Client c1 = new Client();

        Client c2 = new Client(1, "0478026455", "GRZEGORCZYK" ,"ALEXANDRE", "Papyrusse", 30, 03, 2003 );

        Client c3 = new Client(c2);

        System.out.println(c1.toString());

        System.out.println(c2.toString());

        System.out.println(c3.toString());

    }
}
