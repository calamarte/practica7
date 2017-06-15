import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by calamarte on 25/05/2017.
 */
public class AltaLectores {
    //elementos del panel
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel AltaLectoresPanel;
    private JTextField nombre;
    private JTextField dni;
    private JComboBox dia;
    private JComboBox mes;
    private JComboBox year;
    //conexion a db
    private DataBase db = Getxml.cogexml();

    public AltaLectores() throws Exception {
        //desplegable de años
        int y = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = y-120; i < y ; i++) {
            year.addItem(i+"");
        }
        //al cancelar vuelve atras
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        //se inserta en la db y muestra mensaje de confirmacion
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar c = new GregorianCalendar(Integer.parseInt((String) year.getSelectedItem()),
                        Integer.parseInt((String) mes.getSelectedItem())-1,Integer.parseInt((String) dia.getSelectedItem()));

                Socio s = new Socio(0,nombre.getText(),dni.getText(),c);
                try {
                    db.insertSocio(s);
                    JOptionPane.showMessageDialog(Main.frame,"Guardado Correctamente","Guardar",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(Main.frame,"Error","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //devuelve panel
    public JPanel getAltaLectoresPanel() {
        return AltaLectoresPanel;
    }
}
