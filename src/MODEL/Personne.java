package MODEL;
import java.util.Date;

public abstract class Personne {

    private String Nom;
    private String Prenom;
    private Date BirthDay;

    private String Login;

    private String MotsDePasse;


    public Personne(){

        setNom("Inconnu");

        setPrenom("Inconnu");

        Date d = new Date(1,1,0);
        setBirthDay(d);

        setLogin("Inconnu");

        setMotsDePasse("   ");

    }

    public Personne(String nom, String prenom, String Login, String Mdp, int day, int month, int year){

        setNom(nom);

        setPrenom(prenom);

        Date d = new Date(year - 1900, month - 1, day);

        setBirthDay(d);

        setLogin(Login);

        setMotsDePasse(Mdp);

    }

    public Personne(Personne p){

        setNom(p.getNom());

        setPrenom(p.getPrenom());

        setBirthDay(p.getBirthDay());

        setLogin(p.getLogin());

        setMotsDePasse((p.getMotsDePasse()));

    }
    public Date getBirthDay() {
        return BirthDay;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getLogin() {
        return Login;
    }

    public String getMotsDePasse() {
        return MotsDePasse;
    }

    public void setBirthDay(Date birthDay) {BirthDay = new Date(birthDay.getTime());
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setMotsDePasse(String motsDePasse) {
        MotsDePasse = motsDePasse;
    }

    public boolean equals(Personne obj) {
        if(getNom().equals(obj.getNom()) && getPrenom().equals(obj.getPrenom())
                && getBirthDay().equals(obj.getBirthDay())
                && getMotsDePasse().equals(obj.getMotsDePasse()))
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", BirthDay=" + BirthDay +
                ", Login='" + Login + '\'' +
                ", MotsDePasse='" + MotsDePasse + '\'' +
                '}';
    }

    //comme la classe est abstraire elle ne sera jamais instancier et ses constructeurs sont utiliser dans
    // les autres personnes et fonctionne bien
}
