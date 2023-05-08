package MODEL;

import java.util.ArrayList;

public class MaitreHotel extends Personne implements Affectation {

    private int NumServeur ;

    private Zone ZoneDeService;

    private int nbCommi;

    public MaitreHotel(){
        super();

        setNumServeur(0);

        setNbCommi(0);

        setZoneDeService(null);

        setType("MH");
    }

    public MaitreHotel(int numServeur, Zone ZoneDeService, int nbCommi ,String nom, String prenom, String Login, int day, int month, int year )
    {
        super(nom, prenom, Login, day, month, year);

        setNumServeur(numServeur);

        setZoneDeService(ZoneDeService);

        setNbCommi(nbCommi);

        setType("MH");
    }

    public MaitreHotel(MaitreHotel M){
        super(M);

        setNumServeur(M.getNumServeur());

        setNbCommi(M.getNbCommi());

        setZoneDeService(M.getZoneDeService());

        setType("MH");
    }

    public void setNumServeur(int numServeur) {
        NumServeur = numServeur;
    }

    public void setNbCommi(int nbCommi) {
        this.nbCommi = nbCommi;
    }

    public void setZoneDeService(Zone zoneDeService) {
        ZoneDeService = zoneDeService;
    }

    public int getNumServeur() {
        return NumServeur;
    }

    public int getNbCommi() {
        return nbCommi;
    }

    public Zone getZoneDeService() {
        return ZoneDeService;
    }

    @Override
    public void AffectationNouvelleZone(Zone Zone) {
        setZoneDeService(Zone);
    }

    @Override
    public void RetirerDeLaZone() {
        setZoneDeService(null);
    }


    public boolean equals(MaitreHotel obj) {
        if(getNom().equals(obj.getNom()) && getPrenom().equals(obj.getPrenom())
                && getLogin().equals(obj.getLogin()) && getBirthDay().equals(obj.getBirthDay())
                && getZoneDeService().equals(obj.getZoneDeService())
                && getZoneDeService().equals(obj.getZoneDeService()) && getNbCommi() == obj.getNbCommi()
        )
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "MaitreHotel{" +
                "NumServeur=" + NumServeur +
                ", ZoneDeService=" + ZoneDeService +
                ", nbCommi=" + nbCommi +
                ", Nom='" + getNom() + '\'' +
                ", Prenom='" + getPrenom() + '\'' +
                ", BirthDay=" + getBirthDay() +
                ", Login='" + getLogin() + '\'' +
                '}';
    }


    public static void main(String[] args) {

        //Test Constructor

        MaitreHotel c1 = new MaitreHotel();

        MaitreHotel c2 = new MaitreHotel(1, new Zone(1, 50, 5, new ArrayList<Table>()), 0,
                "GRZEGORCZYK" ,"ALEXANDRE", "Papyrusse", 30, 03, 2003 );

        MaitreHotel c3 = new MaitreHotel(c2);

        System.out.println(c1.toString());

        System.out.println(c2.toString());

        System.out.println(c3.toString());

        //TestChangement de Zone

        c3.AffectationNouvelleZone(new Zone(2, 500, 100, new ArrayList<Table>()));

        System.out.println(c3.toString());
        System.out.println(c2.toString());

        c3.RetirerDeLaZone();

        System.out.println(c3.toString());
        System.out.println(c2.toString());



    }
}
