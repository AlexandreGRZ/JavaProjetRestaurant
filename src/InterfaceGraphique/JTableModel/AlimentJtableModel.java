package InterfaceGraphique.JTableModel;

import MODEL.Aliment;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import ca.odell.glazedlists.*;

public class AlimentJtableModel extends AbstractTableModel {

    private String[] columnNames  = {"id", "Nom"};

    private ArrayList<Aliment> data;

    public AlimentJtableModel(ArrayList<Aliment> data)
    {
        this.data = data;
        AfficherElement();

    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aliment aliment = data.get(rowIndex);

        switch (columnIndex){

            case 0:
                return aliment.getNumAliment();
            case 1:
                return aliment.getNom();
            default:
                return null;
        }
    }

    // méthode pour définir le nom d'une colonne
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void AfficherElement()
    {
        for (int i = 0; i < data.size(); i++) {
            Aliment value = data.get(i);
            for(int j = 0; j < 2; j++)
            {
                switch (j)
                {
                    case 0:
                        this.setValueAt(value.getNumAliment(),i, j);
                    case 1:
                        this.setValueAt(value.getNom(),i, j);
                }
            }
        }
    }

}
