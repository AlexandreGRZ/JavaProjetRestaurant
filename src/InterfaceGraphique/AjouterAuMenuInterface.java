package InterfaceGraphique;




import Controlleur.Controlleur;
import InterfaceGraphique.JTableModel.AlimentJtableModel;
import InterfaceGraphique.JTableModel.PlatJtableModel;
import MODEL.Plat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AjouterAuMenuInterface extends JFrame{
    private JButton AJOUTERAUMENUButton;
    private JButton CREERUNPLATButton;
    private JPanel panel1;
    private JTable JTPlat;

    ArrayList<Plat> data;


    public AjouterAuMenuInterface(String Nom, ArrayList<Plat> data) {
        super(Nom);

        this.data = data;

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setContentPane(panel1);

        this.pack();
    }

    public void setControlleur(Controlleur C)
    {
        AJOUTERAUMENUButton.addActionListener(C);
        CREERUNPLATButton.addActionListener(C);

        this.addWindowListener(C);
    }

    public void setNewModel()
    {
        PlatJtableModel model = new PlatJtableModel(data);
        JTPlat.setModel(model);
    }

    public JTable getJTPlat() {
        return JTPlat;
    }
}
