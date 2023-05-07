package InterfaceGraphique;

import Controlleur.Controlleur;
import InterfaceGraphique.JTableModel.PlatJtableModel;
import MODEL.Menu;
import MODEL.Plat;
import MODEL.Resevation;

import javax.swing.*;
import java.util.ArrayList;

public class MainPage extends JFrame  {
    private JPanel panel1;
    private JPanel PanelHeader;
    private JPanel PanelMenuPlat;
    private JTable JTPlat;
    private JTable JTMenu;
    private JButton DECONNEXIONButton;
    private JButton AJOUTERPLATButton;
    private JButton SUPPRIMERDUMENUButton;
    private JButton CREEPLATButton;
    private JButton SUPPRIMERUNPLATButton;
    private JButton ajouterUneReservationButton;
    private JButton SUPPRIMERButton;
    private JTable JTReservation;

    private ArrayList<Plat> dataPlat;

    private ArrayList<Resevation> dataReservation;

    private Menu menu;


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


    public MainPage(String Nom, ArrayList<Plat> dataplat, Menu dataMenu, ArrayList<Resevation> datareservation) {

        super(Nom);

        dataPlat = dataplat;
        menu = dataMenu;
        dataReservation = datareservation;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }


    public void setControlleur(Controlleur C)
    {
        DECONNEXIONButton.addActionListener(C);
        AJOUTERPLATButton.addActionListener(C);
        CREEPLATButton.addActionListener(C);
        SUPPRIMERDUMENUButton.addActionListener(C);
        SUPPRIMERUNPLATButton.addActionListener(C);
        SUPPRIMERButton.addActionListener(C);
        ajouterUneReservationButton.addActionListener(C);

        this.addWindowListener(C);
    }

    public void setNewModelPlat()
    {
        PlatJtableModel model = new PlatJtableModel(dataPlat);
        JTPlat.setModel(model);
    }

    public void setNewModelMenu()
    {
        PlatJtableModel model = new PlatJtableModel(menu.getListPlats());
        JTMenu.setModel(model);
    }



}
