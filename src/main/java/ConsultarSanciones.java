import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by calamarte on 14/06/2017.
 */
public class ConsultarSanciones {
    //elementos del panel
    private JPanel ConsultarSancionPanel;
    private JTable tabla;
    private JTextField nombre;
    private JButton buscar;
    private JScrollPane table;
    private DataBase db = Getxml.cogexml();
    private Sancion[] sancions;

    public ConsultarSanciones() {
        //muestra sancion segun el nombre buscado
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    sancions = db.getSanciones(nombre.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                TableModel tm = new AbstractTableModel() {
                    //tantas filas como sanciones
                    public int getRowCount() {
                        return sancions.length;
                    }

                    //cabeceras
                    public String getColumnName(int col) {
                        switch (col) {
                            case 0:
                                return "Nombre";
                            case 1:
                                return "Tipo";
                            case 2:
                                return "Descripción";
                            case 3:
                                return "Fecha";
                        }
                        throw new RuntimeException("imposible man");
                    }

                    //definir numero de columnas
                    public int getColumnCount() {
                        return 4;
                    }

                    //mostrar valores
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Sancion s = sancions[rowIndex];
                        switch (columnIndex) {
                            case 0:
                                return s.getPrestamo().getSocio().getNombre();
                            case 1:
                                return s.getTipo();
                            case 2:
                                return s.getDescripcion();
                            case 3:
                                return Util.calendarToString(s.getFecha());
                        }
                        throw new RuntimeException("Impossible");
                    }
                };
                tabla.setModel(tm);
            }
        });
    }

    //devuelve el panel
    public JPanel getConsultarSancionPanel() {
        return ConsultarSancionPanel;
    }

}
