package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class Header extends javax.swing.JFrame {

    private int Width20;

    public int getWidth20() {
        return Width20;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setWidth(java.awt.Component obj){
        obj.setPreferredSize(new Dimension(getWidth20(), 0));
        System.out.println(getWidth20());
    }

    public void setWidth20(int width20) {
        Width20 = (width20 * 20) / 100;
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;

    public Header()
    {


        initComponents();
    }

   private void initComponents()
   {
       jButton1 = new javax.swing.JButton();
       Dimension D =  new Dimension(500, 800);
       setSize(D);
       jLabel1 = new javax.swing.JLabel();
       ImageIcon img = new ImageIcon(getClass().getResource("pngaaa.com-1713277.png"));
       setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       setWidth20((int) D.getWidth());

       JPanel contentPane = (JPanel) getContentPane();

       contentPane.setLayout(new BorderLayout());

       jButton1.setPreferredSize(new Dimension(getWidth20() , 0));
       jLabel1.setPreferredSize(new Dimension((getWidth() * 80) / 100 , 0));

       jButton1.setIcon(img);

       jButton1.setText("Double !");

       jLabel1.setText("RESTgzbeugbzoîgbouizegubpzpoiugbvzeupgbuzbg");
       contentPane.add(jButton1, BorderLayout.WEST);

       contentPane.add(jLabel1, BorderLayout.EAST);

       setLocationRelativeTo(null);
   }

    public static void main(String args[])
    {
        Header H = new Header();

        H.setVisible(true);

        int width = H.getWidth();

        while(true){



            if(H.getWidth() != width)
            {
                width = H.getWidth();
                H.setWidth20(H.getWidth());

                H.setWidth(H.getjButton1());
                H.getContentPane().remove(H.getjButton1());
                H.getContentPane().add(H.getjButton1());



            }



        }



    }


}
