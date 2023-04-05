import java.util.Vector;

public class Menu {

    private int numMenu;

    private Vector<Plat> ListPlats;

    private  Vector<Boisson> ListBoisson;


    public Menu()
    {
        setNumMenu(0);

        setListBoisson(null);

        setListPlats(null);
    }


    public Menu(int numMenu, Vector<Plat> ListPlats, Vector<Boisson> ListBoisson)
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


    public void setListBoisson(Vector<Boisson> listBoisson) {
        ListBoisson = listBoisson;
    }

    public void setListPlats(Vector<Plat> listPlats) {
        ListPlats = listPlats;
    }

    public void setNumMenu(int numMenu) {
        this.numMenu = numMenu;
    }

    public int getNumMenu() {
        return numMenu;
    }

    public Vector<Boisson> getListBoisson() {
        return ListBoisson;
    }

    public Vector<Plat> getListPlats() {
        return ListPlats;
    }



}
