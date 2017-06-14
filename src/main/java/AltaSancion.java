import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dgarcia on 01/06/2017.
 */
public class AltaSancion {
    private JPanel AltaSancionPanel;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField tipo;
    private JTextField fecha;
    private JTextArea descripcion;
    private JComboBox prestamo;
    private DataBase db = new DataBase("localhost","root","");

    public AltaSancion() throws Exception {
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //coger texto del prestamo
                    db.InsertSancion(descripcion.getText(), fecha.getText(), tipo.getText(), prestamo.getToolTipText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
    }
    public JPanel getAltaSancionPanel() {
        return AltaSancionPanel;
    }
}
