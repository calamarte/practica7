import javax.swing.*;
import java.awt.*;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    static JFrame frame = new JFrame("La Blioteca");
    static JPanel j = new JPanel();
    static JMenuBar jmb = new JMenuBar();

    public static void main(String[] args) {
        setMenu();
        jmb.setVisible(false);
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
    private static void setMenu(){
        frame.setJMenuBar(jmb);

        JMenu libros = new JMenu("Libros");
        jmb.add(libros);
        JMenuItem altaLibro = new JMenuItem("Nuevo libro");
        JMenuItem bajaLibro = new JMenuItem("Eliminar libro");
        JMenuItem modificarLibro = new JMenuItem("Modificar ficha del libro");
        JMenuItem consultarLibro = new JMenuItem("Consultar libros");
        libros.add(altaLibro);
        libros.add(bajaLibro);
        libros.add(modificarLibro);
        libros.add(consultarLibro);

    }
}
