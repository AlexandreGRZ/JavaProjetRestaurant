package InterfaceGraphique;

import Controlleur.Controlleur;
import InterfaceGraphique.JTableModel.PlatJtableModel;
import InterfaceGraphique.JTableModel.ReservationJTableModel;
import MODEL.Menu;
import MODEL.Resevation;

import javax.swing.*;
import java.util.ArrayList;

public class MainPageForClient extends JFrame {
    private JPanel PanelHeader;
    private JTable JTMenu;
    private JButton RESERVERUNETABLEButton;
    private JTable JTReservation;
    private JComboBox CBJOUR;
    private JComboBox CBMois;
    private JComboBox CBANNEE;
    private JPanel panel1;
    private JButton DECONNEXIONButton;
    private JScrollPane scrollpane;

    private ArrayList<Resevation> dataReservation;

    private Menu menu;

    public MainPageForClient(String Nom, Menu dataMenu, ArrayList<Resevation> datareservation) {

        super(Nom);
        menu = dataMenu;
        dataReservation = datareservation;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }


    public void setControlleur(Controlleur C)
    {
        DECONNEXIONButton.addActionListener(C);
        RESERVERUNETABLEButton.addActionListener(C);

        this.addWindowListener(C);
    }

    public void setNewModelMenu()
    {
        PlatJtableModel model = new PlatJtableModel(menu.getListPlats());
        JTMenu.setModel(model);
    }

    public void setNewModelReservation()
    {
        ReservationJTableModel model = new ReservationJTableModel(dataReservation);
        JTReservation.setModel(model);
    }


}
