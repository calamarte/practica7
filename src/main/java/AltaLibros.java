import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private JTextField tematica;
    private JTextArea sinopsis;
    private DataBase db = new DataBase("localhost","root","");

    public AltaLibros() throws Exception {
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout) Main.j.getLayout();
                    cl.show(Main.j,"Inicio");
                }
            });
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        db.InsertLibro(isbn.getText(), titulo.getText(), portada.getText(), editorial.getText(), paginas.getText(), tematica.getText(), autor.getText(),sinopsis.getText());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
            });
    }


    public JPanel getAltaLibrosPanel() {
        return AltaLibrosPanel;
    }
}
