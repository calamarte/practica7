import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by calamarte on 25/05/2017.
 */
public class AltaLectores {
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel AltaLectoresPanel;
    private JTextField nombre;
    private JTextField apellidos;
    private JTextField dni;
    private JTextField fecha;
    private DataBase db = new DataBase("localhost","root","");

    public AltaLectores() throws Exception {
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    db.InsertPerson(nombre.getText(),dni.getText(),fecha.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public JPanel getAltaLectoresPanel() {
        return AltaLectoresPanel;
    }
}
