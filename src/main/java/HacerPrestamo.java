import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by calamarte on 12/06/2017.
 */
public class HacerPrestamo {
    private JTable tableSocio;
    private JTextField textField1;
    private JComboBox fFDia;
    private JComboBox fFMes;
    private JComboBox fFAno;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel HacerPrestamoPanel;
    private JTable tableLibro;
    private DataBase db = new DataBase("localhost","root","");
    private Socio[] socios;
    private Libro[] libros;

    HacerPrestamo() throws Exception {
        int y = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = y; i < y+120 ; i++) {
            fFAno.addItem(i);
        }

        libros = db.getLibros();
        socios = db.getSocios("Todos",null);
        TableModel tmSocio = new AbstractTableModel() {
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
                        return Util.calendarToString(s.getFechaNa());
                }
                throw new RuntimeException("Impossible");
            }

        };

        tableSocio.setModel(tmSocio);

        TableModel tmLibro = new AbstractTableModel() {
            public int getRowCount() {
                return libros.length ;
            }
            public String getColumnName(int col){
                switch (col){
                    case 0:
                        return "Titulo";
                    case 1:
                        return "Tematica";
                    case 2:
                        return "Editorial";
                    case 3:
                        return "ISBN";
                    case 4:
                        return "Páginas";

                }
                throw new RuntimeException("imposible man");
            }

            public int getColumnCount() {
                return 5;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                Libro l = libros[rowIndex];
                switch(columnIndex) {
                    case 0:
                        return l.getTitulo();
                    case 1:
                        return l.getTematica();
                    case 2:
                        return l.getEditorial();
                    case 3:
                        return l.getIsbn();
                    case 4:
                        return l.getPaginas();
                }
                throw new RuntimeException("Impossible");
            }
        };
        tableLibro.setModel(tmLibro);
    }

    public JPanel getHacerPrestamoPanel() {
        return HacerPrestamoPanel;
    }

}
