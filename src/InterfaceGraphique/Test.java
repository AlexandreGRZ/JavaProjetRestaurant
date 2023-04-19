package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    private JPanel Test1;


    public Test(String Nom) {
        super(Nom);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(Test1);
        this.pack();


    }


    public static void main(String[] args) {
        JFrame Init = new Test("MainPage");

        Init.setVisible(true);
    }

}
