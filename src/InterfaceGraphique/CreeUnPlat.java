package InterfaceGraphique;

import Controlleur.Controlleur;
import InterfaceGraphique.JTableModel.AlimentJtableModel;
import MODEL.Aliment;

import javax.swing.*;
import java.util.ArrayList;

public class CreeUnPlat extends JFrame{
    private JPanel panel1;
    private JTextField TFNomPlat;
    private JTextField TFPrix;
    private JComboBox CBAliment;
    private JButton AJOUTERALIMENTButton;
    private JButton CREERLEPLATButton;
    private JPanel AlimentPanel;
    private JTable AlimentTable;
    private ArrayList<Aliment> data;

    private ArrayList<Aliment> ListAlimentSelected = new ArrayList<Aliment>();

    public CreeUnPlat(String Nom, ArrayList<Aliment> data) {

        super(Nom);

        this.data = data;

        //Ajout du model dans la jTable

        setNewModel();

        //Ajout des élément dans le Combobox
        AddelementToCombox();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public void setControlleur(Controlleur C)
    {
       AJOUTERALIMENTButton.addActionListener(C);
       CREERLEPLATButton.addActionListener(C);
       this.addWindowListener(C);
    }

    public JComboBox getCBAliment() {
        return CBAliment;
    }

    public JTextField getTFNomPlat() {
        return TFNomPlat;
    }

    public JTextField getTFPrix() {
        return TFPrix;
    }

    public void AddelementToCombox()
    {
        for (Aliment value: data) {
            CBAliment.addItem(value.getNom());
        }
    }

    public void setListAlimentSelected(ArrayList<Aliment> listAlimentSelected) {
        ListAlimentSelected = listAlimentSelected;
    }

    public void setNewModel()
    {
        AlimentJtableModel model = new AlimentJtableModel(ListAlimentSelected);
        AlimentTable.setModel(model);
    }
}
