public class MaitreHotel extends Personne implements Affectation {

    private int NumServeur ;

    private Zone ZoneDeService;

    private int nbCommi;

    public MaitreHotel(){
        super();

        setNumServeur(0);

        setNbCommi(0);

        setZoneDeService(null);
    }

    public MaitreHotel(int numServeur, Zone ZoneDeService, int nbCommi ,String nom, String prenom, String Login, String Mdp, int day, int month, int year )
    {
        super(nom, prenom, Login, Mdp, day, month, year);

        setNumServeur(numServeur);

        setZoneDeService(ZoneDeService);

        setNbCommi(nbCommi);
    }

    public MaitreHotel(MaitreHotel M){
        super(M);

        setNumServeur(M.getNumServeur());

        setNbCommi(M.getNbCommi());

        setZoneDeService(M.getZoneDeService());
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
}
