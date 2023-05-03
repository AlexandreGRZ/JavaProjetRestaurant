package MODEL;

import java.util.ArrayList;
import java.util.Vector;

public class Menu {

    private int numMenu;

    private ArrayList<Plat> ListPlats;

    private  ArrayList<Boisson> ListBoisson;


    public Menu()
    {
        setNumMenu(0);

        setListBoisson(null);

        setListPlats(null);
    }


    public Menu(int numMenu, ArrayList<Plat> ListPlats, ArrayList<Boisson> ListBoisson)
    {

        setNumMenu(numMenu);

        setListPlats(ListPlats);

        setListBoisson(ListBoisson);


    }


    public Menu(Menu M)
    {
        setNumMenu(M.getNumMenu());

        setListBoisson(M.getListBoisson());

        setListPlats(M.getListPlats());
    }


    public void setListBoisson(ArrayList<Boisson> listBoisson) {
        ListBoisson = listBoisson;
    }

    public void setListPlats(ArrayList<Plat> listPlats) {
        ListPlats = listPlats;
    }

    public void setNumMenu(int numMenu) {
        this.numMenu = numMenu;
    }

    public int getNumMenu() {
        return numMenu;
    }

    public ArrayList<Boisson> getListBoisson() {
        return ListBoisson;
    }

    public ArrayList<Plat> getListPlats() {
        return ListPlats;
    }

    public boolean equals(Menu obj) {
        if(getNumMenu() == obj.getNumMenu())
        {
            boolean bool = false;


            for(int i = 0; i < getListPlats().size() && !bool; i++ )
            {
                if( !(getListPlats().get(i).equals(obj.getListPlats().get(i)) ))
                    bool = true;
            }

            if(!bool)
            {
                for(int i = 0; i < getListBoisson().size() && !bool; i++ )
                {
                    if( !(getListBoisson().get(i).equals(obj.getListBoisson().get(i)) ))
                        bool = true;
                }

                if(!bool) return true;
                else return false;
            }
            else return false;

        }
        else return false;

    }

    @Override
    public String toString() {
        return "Menu{" +
                "numMenu=" + numMenu +
                ", ListPlats=" + ListPlats +
                ", ListBoisson=" + ListBoisson +
                '}';
    }

    public static void main(String[] args) {

        //Test Constructor

        Menu c1 = new Menu();

        Menu c2 = new Menu(1, new ArrayList<Plat>(), new ArrayList<Boisson>());

        Menu c3 = new Menu(c2);

        System.out.println(c1.toString());

        System.out.println(c2.toString());

        System.out.println(c3.toString());

        //Test des ajout deja fait dans les boisson et Plat

    }
}
