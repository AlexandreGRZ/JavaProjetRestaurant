package MODEL;
import java.io.Serializable;
import java.util.Date;

public abstract class Personne implements Serializable {

    private String Nom;
    private String Prenom;
    private Date BirthDay;
    private String Login;
    private String Type = "C";



    public Personne(){

        setNom("Inconnu");

        setPrenom("Inconnu");

        Date d = new Date(1,1,0);
        setBirthDay(d);

        setLogin("Inconnu");



    }

    public Personne(String nom, String prenom, String Login, int day, int month, int year){

        setNom(nom);

        setPrenom(prenom);

        Date d = new Date(year - 1900, month - 1, day);

        setBirthDay(d);

        setLogin(Login);


    }

    public Personne(Personne p){

        setNom(p.getNom());

        setPrenom(p.getPrenom());

        setBirthDay(p.getBirthDay());

        setLogin(p.getLogin());

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

    public String getType() {
        return Type;
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

    public void setType(String type) {
        Type = type;
    }

    public boolean equals(Personne obj) {
        if(getNom().equals(obj.getNom()) && getPrenom().equals(obj.getPrenom())
                && getBirthDay().equals(obj.getBirthDay()))
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
                '}';
    }

    //comme la classe est abstraire elle ne sera jamais instancier et ses constructeurs sont utiliser dans
    // les autres personnes et fonctionne bien
}
