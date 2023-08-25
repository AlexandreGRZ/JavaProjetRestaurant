package MODEL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class LogOnTheSite {

    private String Login;

    private  String MotDepasse;

    private Restaurant Singleton;

    public String getLogin() {
        return Login;
    }

    public String getMotDepasse() {
        return MotDepasse;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setMotDepasse(String motDepasse) {
        MotDepasse = motDepasse;
    }

    public void setSingleton(Restaurant singleton) {
        Singleton = singleton;
    }

    public int Connexion(String login, String mdp)
    {

        boolean CheckIfLoginExist = false;
        Personne client = null;
        for (Personne value : Singleton.getListPersonne()) {
            System.out.println(value.getLogin() + getmdp(value.getLogin()));
            if(value.getLogin().equals(login))
            {
                CheckIfLoginExist = true;
                client = value;
                break;
            }
        }

        if(CheckIfLoginExist)
        {
            System.out.println(mdp);
            if(this.getmdp(login).equals(mdp))
            {
                Singleton.setPersonneConnecte(client);
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }

    public String getmdp(String login)
    {
        try{

            Properties p = new Properties();

            p.load(new FileInputStream("/Users/alexandregrzegorczyk/COURS/BAC2/Q2/JAVA/JavaProjetRestaurant/src/data/mdp.properties"));

            String mdp = p.getProperty(login);
            return mdp;

        }catch (FileNotFoundException e)
        {
            System.out.println("File not find");
        } catch (IOException e) {
            System.out.println("PROBLEME IOException");
        }
        return null;
    }
}
