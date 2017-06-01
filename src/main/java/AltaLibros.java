import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by calamarte on 24/05/2017.
 */
public class AltaLibros {
    private JPanel AltaLibrosPanel;
    private JButton cancel;
    private JButton ok;
    private JTextField titulo;
    private JTextField portada;
    private JTextField autor;
    private JTextField paginas;
    private JTextField editorial;
    private JTextField isbn;

    public AltaLibros() {
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Base de Datos
            }
        });
    }

    public JPanel getAltaLibrosPanel() {
        return AltaLibrosPanel;
    }
}
