package MODEL;
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

        setType("S");

    }

    public Serveur(int numServeur, String Grade, String nom, String prenom, String Login, int day, int month, int year)
    {

        super(nom, prenom, Login, day, month, year);

        setNumServeur(numServeur);

        setGrade(Grade);

        setChef(chef);

        setZoneDeService(ZoneDeService);

        setType("S");
    }

    public Serveur(Serveur c){
        super(c);

        setNumServeur(c.getNumServeur());

        setGrade(c.getGrade());

        setChef(c.getChef());

        setZoneDeService(c.getZoneDeService());

        setType(c.getType());
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

    public boolean equals(Serveur obj) {
        if(getNom().equals(obj.getNom()) && getPrenom().equals(obj.getPrenom())
                && getLogin().equals(obj.getLogin()) && getBirthDay().equals(obj.getBirthDay())
                && getChef().equals(obj.getChef())
                && getZoneDeService().equals(obj.getZoneDeService()) && getGrade().equals(obj.getGrade()))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Serveur{" +
                "NumServeur=" + NumServeur +
                ", Grade='" + Grade + '\'' +
                ", chef=" + chef +
                ", ZoneDeService=" + ZoneDeService +
                '}';
    }

    public static void main(String[] args) {

        //Test Constructor

        Serveur s1 = new Serveur();

        Serveur s2 = new Serveur(1, "COMI", "GRZEGORCZYK" ,"ALEXANDRE", "Papyrusse", 30, 03, 2003 );

        Serveur s3 = new Serveur(s2);

        System.out.println(s1.toString());

        System.out.println(s2.toString());

        System.out.println(s3.toString());

    }
}
