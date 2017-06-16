import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;

/**
 * Created by Dgarcia on 01/06/2017.
 */
public class AltaSancion {
    //elementos del panel
    private JPanel AltaSancionPanel;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTextPane descripcion;
    private JTable table;
    private JComboBox tipo;
    private Prestamo[] prestamos;
    private DataBase db = Getxml.cogexml();

    public AltaSancion() throws SQLException, ParseException {

        //crea la tabla
        createTable();
        //al cancelar vuelve atras
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
        //se inserta en la base de datos y muestra mensaje de confirmacion
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    db.insertSancion(new Sancion(0,descripcion.getText(),null,(String) tipo.getSelectedItem(),prestamos[table.getSelectedRow()]));
                    JOptionPane.showMessageDialog(Main.frame,"Guardada correctamente","Creado",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(Main.frame,"Error","Error",JOptionPane.WARNING_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });
    }
    //devuelve el panel
    public JPanel getAltaSancionPanel() {
        return AltaSancionPanel;
    }

    public void createTable() throws SQLException, ParseException {
        prestamos = db.getPrestamos();
        TableModel tm = new AbstractTableModel() {
            //numero de filas segun propiedades de prestamos
            public int getRowCount() {
                return prestamos.length ;
            }
            //muestra cabeceras de la tabla
            public String getColumnName(int col){
                switch (col){
                    case 0:
                        return "Usuario";
                    case 1:
                        return "Libro";
                    case 2:
                        return "Fecha Inicial";
                    case 3:
                        return "Fecha Final";
                }
                throw new RuntimeException("imposible man");
            }

            //numero de columnas de la tabla
            public int getColumnCount() {
                return 4;
            }

            //muestra los valores de los prestamos
            public Object getValueAt(int rowIndex, int columnIndex) {
                Prestamo p = prestamos[rowIndex];
                switch(columnIndex) {
                    case 0:
                        return p.getSocio().getNombre();
                    case 1:
                        return p.getLibro().getTitulo();
                    case 2:
                        return Util.calendarToString(p.getFechaInicial());
                    case 3:
                        return Util.calendarToString(p.getFechaFinal());
                }
                throw new RuntimeException("Impossible");
            }

        };

        table.setModel(tm);
    }
}
