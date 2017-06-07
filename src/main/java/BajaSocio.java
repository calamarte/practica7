import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Dgarcia on 01/06/2017.
 */
public class BajaSocio {
    private JButton cancelarButton;
    private JButton eliminarButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton buscarButton;
    private JPanel BajaSocioPanel;
    JTable table = new JTable();
    private DataBase db = new DataBase("localhost","root","");
    Socio socios [];


    public BajaSocio() throws Exception {
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    socios = db.getSocios();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                TableModel tm = new AbstractTableModel() {
                    public int getRowCount() {
                        return socios.length ;
                    }

                    public String getColumnName(int col){
                        switch (col){
                            case 0:
                                return "nombre";
                            case 1:
                                return "dni";
                            case 2:
                                return "fecha de nacimiento";
                        }
                        throw new RuntimeException("imposible man");
                    }

                    public int getColumnCount() {
                        return 3;
                    }

                    public Object getValueAt(int rowIndex, int columnIndex) {
                        Socio s = socios[rowIndex];
                        switch(columnIndex) {
                            case 0:
                                return s.nombre;
                            case 1:
                                return s.dni;
                            case 2:
                                return s.fechaNa;
                        }
                        throw new RuntimeException("Impossible");
                    }
                };
            }
        });
    }

    public JPanel getBajaSocioPanel() {
        return BajaSocioPanel;
    }


}
