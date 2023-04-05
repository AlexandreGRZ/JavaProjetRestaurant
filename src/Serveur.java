public class Serveur extends Personne implements Affectation {

    private int NumServeur ;

    private String Grade;

    private MaitreHotel chef;

    private Zone ZoneDeService;

    public Serveur()
    {
        super();

        setNumServeur(0);

        setChef(null);

        setGrade("Commi");

        setZoneDeService(null);



    }

    public Serveur(int numServeur, String Grade, MaitreHotel chef, Zone ZoneDeService, String nom, String prenom, String Login, String Mdp, int day, int month, int year)
    {

        super(nom, prenom, Login, Mdp, day, month, year);

        setNumServeur(numServeur);

        setGrade(Grade);

        setChef(chef);

        setZoneDeService(ZoneDeService);
    }

    public Serveur(Serveur c){
        super(c);

        setNumServeur(c.getNumServeur());

        setGrade(c.getGrade());

        setChef(c.getChef());

        setZoneDeService(c.getZoneDeService());
    }

    public int getNumServeur() {
        return NumServeur;
    }

    public MaitreHotel getChef() {
        return chef;
    }

    public String getGrade() {
        return Grade;
    }

    public Zone getZoneDeService() {
        return ZoneDeService;
    }

    public void setChef(MaitreHotel chef) {
        this.chef = chef;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public void setNumServeur(int numServeur) {
        NumServeur = numServeur;
    }

    public void setZoneDeService(Zone zoneDeService) {
        ZoneDeService = zoneDeService;
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
