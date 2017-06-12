import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by calamarte on 25/05/2017.
 */
public class AltaLectores {
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel AltaLectoresPanel;
    private JTextField nombre;
    private JTextField dni;
    private JComboBox dia;
    private JComboBox mes;
    private JComboBox year;
    private JTextField fecha;
    private DataBase db = new DataBase("localhost","root","");

    public AltaLectores() throws Exception {
        int y = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = y-120; i < y ; i++) {
            year.addItem(i+"");
        }
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar c = new GregorianCalendar(Integer.parseInt((String) year.getSelectedItem()),
                        Integer.parseInt((String) mes.getSelectedItem())-1,Integer.parseInt((String) dia.getSelectedItem()));

                Socio s = new Socio(0,nombre.getText(),dni.getText(),c);
                try {
                    db.insertSocio(s);
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
