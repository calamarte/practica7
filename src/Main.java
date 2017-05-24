import javax.swing.*;
import java.awt.*;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    static JFrame frame = new JFrame("La Blioteca");
    static JPanel j = new JPanel();

    public static void main(String[] args) {
        Login l = new Login();
        Inicio i = new Inicio();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
        j.setLayout(new CardLayout());
        j.add(l.getLoginPanel(),"Login");
        j.add(i.getInicio(),"Inicio");

        frame.setContentPane(j);

        //JOptionPane.showMessageDialog(frame,"Incorrecto","Tal",JOptionPane.WARNING_MESSAGE);
    }
}
