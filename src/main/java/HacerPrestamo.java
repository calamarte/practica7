import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by calamarte on 12/06/2017.
 */
public class HacerPrestamo {
    private JTable tableSocio;
    private JTable table1;
    private JTextField textField1;
    private JComboBox fFDia;
    private JComboBox fFMes;
    private JComboBox fFAno;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel HacerPrestamoPanel;
    private DataBase db = new DataBase("localhost","root","");
    private Socio[] socios;

    HacerPrestamo() throws Exception {
        int y = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = y; i < y+120 ; i++) {
            fFAno.addItem(i);
        }

        socios = db.getSocios("Todos",null);
        TableModel tm = new AbstractTableModel() {
            public int getRowCount() {
                return socios.length ;
            }
            public String getColumnName(int col){
                switch (col){
                    case 0:
                        return "Nombre";
                    case 1:
                        return "DNI";
                    case 2:
                        return "Fecha de nacimiento";
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
                        return s.getNombre();
                    case 1:
                        return s.getDni();
                    case 2:
                        return calendarToString(s.getFechaNa());
                }
                throw new RuntimeException("Impossible");
            }

        };

        tableSocio.setModel(tm);

    }

    public JPanel getHacerPrestamoPanel() {
        return HacerPrestamoPanel;
    }

    private String calendarToString(Calendar c){
        Calendar cal = c;
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        return sdf.format(c.getTime());
    }
}
