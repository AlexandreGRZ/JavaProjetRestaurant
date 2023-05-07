package InterfaceGraphique.JTableModel;

import MODEL.Date;
import MODEL.Plat;
import MODEL.Resevation;
import MODEL.Restaurant;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ReservationJTableModel extends AbstractTableModel {

    ArrayList<Resevation> data;

    private String[] columnNames  = {"id", "nbPersonne", "Client", "Date"};

    ReservationJTableModel(ArrayList<Resevation> data)
    {
        this.data = data;

        AfficherElement();
    }



    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Resevation R = data.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return R.getNumReservation();
            case 1:
                return R.getNbPersonne();
            case 2:
                return R.getClients();
            case 3:
                return R.getDatereservation();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void AfficherElement()
    {
        for (int i = 0; i < data.size(); i++) {
            Resevation value = data.get(i);
            for(int j = 0; j < 3; j++)
            {
                switch (j)
                {
                    case 0:
                        this.setValueAt(value.getNumReservation(),i, j);
                    case 1:
                        this.setValueAt(value.getNbPersonne(),i, j);
                    case 2:
                        this.setValueAt(value.getClients().getNom(), i, j);
                    case 3:
                        this.setValueAt(value.getDatereservation().toString(), i, j);
                }
            }
        }
    }
}
