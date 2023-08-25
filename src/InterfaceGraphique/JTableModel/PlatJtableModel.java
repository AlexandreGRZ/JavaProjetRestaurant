package InterfaceGraphique.JTableModel;

import MODEL.Aliment;
import MODEL.Plat;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PlatJtableModel extends AbstractTableModel {

    ArrayList<Plat> data;

    private String[] columnNames  = {"id", "Nom", "Prix"};

    public PlatJtableModel(ArrayList<Plat> data)
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

        Plat p = data.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return p.getNumPlat();
            case 1:
                return p.getNom();
            case 2:
                return p.getPrix();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) { return columnNames[column]; }

    public void AfficherElement()
    {
        for (int i = 0; i < data.size(); i++) {
            Plat value = data.get(i);
            for(int j = 0; j < 3; j++)
            {
                switch (j)
                {
                    case 0:
                        this.setValueAt(value.getNumPlat(),i, j);
                    case 1:
                        this.setValueAt(value.getNom(),i, j);
                    case 2:
                        this.setValueAt(value.getPrix(), i, j);
                }
            }
        }
    }
}
