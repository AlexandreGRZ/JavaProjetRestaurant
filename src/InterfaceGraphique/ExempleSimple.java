package InterfaceGraphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
public class ExempleSimple extends javax.swing.JFrame implements
        ActionListener
{
    public ExempleSimple()
    {
        initComponents();
        jButton1.addActionListener(this);
        jButton1.setVerticalTextPosition(AbstractButton.BOTTOM);
        jButton1.setHorizontalTextPosition(AbstractButton.CENTER);
        jButton1.setMnemonic(KeyEvent.VK_D); // Alt-d actionne le bouton
        jButton1.setToolTipText("Double la valeur entrée ci-contre");
    }
    private void initComponents()
    {
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Exemple simple de GUI en Swing");
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        jButton1.setText("Double !");
        getContentPane().add(jButton1);
        getContentPane().add(jTextField1);

        jLabel1.setText("???");
        getContentPane().add(jLabel1);
        setSize(new java.awt.Dimension(768, 286));
        setLocationRelativeTo(null);
    }
    public static void main(String args[])
    {
        new ExempleSimple().setVisible(true);
    }
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    public void actionPerformed(ActionEvent ae)
    {
        Double valeur = Double.parseDouble(jTextField1.getText());
        valeur = valeur * 2.0;
        jLabel1.setText(String.valueOf(valeur));
    }
}