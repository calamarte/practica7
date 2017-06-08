import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Dgarcia on 01/06/2017.
 */
public class AltaAutores {
    private JPanel AltaAutoresPanel;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField nombre;
    private JTextField nacionalidad;
    private JTextField alias;
    private JTextField fecha;
    private JPanel AltaAutorPanel;
    private JLabel Nombre_label;
    private JLabel Nacionalidad_label;
    private JLabel Alias_label;
    private JLabel Fecha_label;
    private DataBase db = new DataBase("localhost","root","");

    public AltaAutores() throws Exception {
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = null;
                try {
                    date = sdf.parse(fecha.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                try {
                    db.InsertAutor(date, nacionalidad.getText(), alias.getText(), nombre.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

    public JPanel getAltaAutoresPanel() {
        return AltaAutoresPanel;
    }
}
