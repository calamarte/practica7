import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by Dgarcia on 01/06/2017.
 */
public class AltaAutores {
    //elementos del panel
    private JPanel AltaAutoresPanel;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextField nombre;
    private JTextField nacionalidad;
    private JTextField alias;
    private JPanel AltaAutorPanel;
    private JLabel Nombre_label;
    private JLabel Nacionalidad_label;
    private JLabel Alias_label;
    private JLabel Fecha_label;
    private JComboBox dia;
    private JComboBox mes;
    private JComboBox year;
    //conexion a la base de datos
    private DataBase db = Getxml.cogexml();

    public AltaAutores() throws Exception {
        //añadir años al desplegable
        int y = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = y-1000; i < y ; i++) {
            year.addItem(i+"");
        }

        //al darle al boton cancelar vuelve al menu principal
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        //al guardar se inserta el autor en la base de datos y da un mensaje de confirmacion
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar c = new GregorianCalendar(Integer.parseInt((String) year.getSelectedItem()),
                        Integer.parseInt((String) mes.getSelectedItem())-1,Integer.parseInt((String) dia.getSelectedItem()));

                try {
                    db.insertAutor(new Autor(0,nombre.getText(),nacionalidad.getText(),alias.getText(),c));
                    JOptionPane.showMessageDialog(Main.frame,"Guardado Correctamente","Guardar",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(Main.frame,"Error","Error",JOptionPane.WARNING_MESSAGE);
                    e1.printStackTrace();
                }

            }
        });
    }

    //devuelve el panel
    public JPanel getAltaAutoresPanel() {
        return AltaAutoresPanel;
    }
}
