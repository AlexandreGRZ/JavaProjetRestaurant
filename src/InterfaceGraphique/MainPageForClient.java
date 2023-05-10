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
    private JButton RECHERCHERButton;

    private ArrayList<Resevation> dataReservation;

    private Menu menu;

    public MainPageForClient(String Nom, Menu dataMenu, ArrayList<Resevation> datareservation) {

        super(Nom);
        menu = dataMenu;
        dataReservation = datareservation;

        AfficherLesElementCBox();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }


    public void setControlleur(Controlleur C)
    {
        DECONNEXIONButton.addActionListener(C);
        RESERVERUNETABLEButton.addActionListener(C);
        CBJOUR.addActionListener(C);
        CBMois.addActionListener(C);
        CBANNEE.addActionListener(C);
        RECHERCHERButton.addActionListener(C);

        this.addWindowListener(C);
    }

    public void setNewModelMenu()
    {
        PlatJtableModel model = new PlatJtableModel(menu.getListPlats());
        JTMenu.setModel(model);
    }

    public void setDataReservation(ArrayList<Resevation> dataReservation) {
        this.dataReservation = dataReservation;
    }

    public void setNewModelReservation()
    {
        ReservationJTableModel model = new ReservationJTableModel(dataReservation);
        JTReservation.setModel(model);
    }

    public JComboBox getCBJOUR() {
        return CBJOUR;
    }

    public JComboBox getCBMois() {
        return CBMois;
    }

    public JComboBox getCBANNEE() {
        return CBANNEE;
    }

    public void AfficherLesElementCBox() {

        for (int i = 1; i < 31; i++)
        {
            CBJOUR.addItem(i);
        }

        for (int i = 1; i < 12; i++) {
            CBMois.addItem(i);
        }

        for (int i = 2023; i < 2030; i++) {
            CBANNEE.addItem(i);

        }

    }
    public void ChangeNbJour()
    {
        int Mois = (int) CBMois.getSelectedItem();
        int Annee = (int) CBANNEE.getSelectedItem();
        CBJOUR.removeAllItems();
        System.out.println("coucou");
        if(Mois == 1 || Mois == 3 || Mois == 5 || Mois == 7 || Mois == 8 || Mois == 10 || Mois == 12)
        {

            for (int i = 1; i < 32; i++)
            {
                CBJOUR.addItem(i);
                CBJOUR.setSelectedItem(1);
            }
        }
        else
        {
            if(Mois != 2)
            {
                for (int i = 1; i < 31; i++)
                {
                    CBJOUR.addItem(i);
                    CBJOUR.setSelectedItem(1);
                }
            }
            else
            {
                if(Annee % 4 == 0 )
                {
                    if(Annee % 100 == 0)
                    {
                        if(Annee % 400 == 0)
                        {
                            for (int i = 1; i < 30; i++)
                            {
                                CBJOUR.addItem(i);
                                CBJOUR.setSelectedItem(1);
                            }
                        }
                        else
                        {
                            for (int i = 1; i < 29; i++)
                            {
                                CBJOUR.addItem(i);
                                CBJOUR.setSelectedItem(1);
                            }
                        }
                    }
                    else
                    {
                        for (int i = 1; i < 30; i++)
                        {
                            CBJOUR.addItem(i);
                            CBJOUR.setSelectedItem(1);
                        }
                    }
                }
                else
                {
                    for (int i = 1; i < 29; i++)
                    {
                        CBJOUR.addItem(i);
                        CBJOUR.setSelectedItem(1);
                    }
                }
            }
        }
    }

}
