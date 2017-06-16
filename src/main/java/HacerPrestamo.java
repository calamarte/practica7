import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by calamarte on 12/06/2017.
 */
public class HacerPrestamo {
    //elementos del panel
    private JTable tableSocio;
    private JTextField nCopia;
    private JComboBox fFDia;
    private JComboBox fFMes;
    private JComboBox fFAno;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel HacerPrestamoPanel;
    private JTable tableLibro;
    private DataBase db = Getxml.cogexml();
    private Socio[] socios;
    private Libro[] libros;

    HacerPrestamo() throws SQLException, ParseException {
        //muestra desplegable de años
        int y = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = y; i < y+120 ; i++) {
            fFAno.addItem(i+"");
        }
        //crea tabla
        createTable();
        //se crea el prestamo y muestra mensaje de confirmacion
        aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //compone la fecha entera
                Calendar c = new GregorianCalendar(Integer.parseInt((String) fFAno.getSelectedItem()),
                        Integer.parseInt((String) fFMes.getSelectedItem()),Integer.parseInt((String) fFDia.getSelectedItem()));

                Prestamo p = new Prestamo(0,null,c,libros[tableLibro.getSelectedRow()],socios[tableSocio.getSelectedRow()],Main.bi,Integer.parseInt(nCopia.getText()));

                try {
                    db.insertPrestamo(p);
                    JOptionPane.showMessageDialog(Main.frame,"Guardado correctamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(Main.frame,"Error","Error",JOptionPane.WARNING_MESSAGE);
                    e1.printStackTrace();
                }
            }
        });

        //al cancelar vuelve atras
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
    }

    public void createTable() throws SQLException, ParseException {
        libros = db.getLibros();
        socios = db.getSocios("Todos",null);
        TableModel tmSocio = new AbstractTableModel() {
            //filas segun numero de socios
            public int getRowCount() {
                return socios.length ;
            }
            //cabeceras
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

            //numero de columnas
            public int getColumnCount() {
                return 3;
            }

            //mostrar valores
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
            //filas segun libros
            public int getRowCount() {
                return libros.length ;
            }
            //cabeceras
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

            //numero de columnas
            public int getColumnCount() {
                return 5;
            }

            //mostrar valores
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

    //devuelve panel
    public JPanel getHacerPrestamoPanel() {
        return HacerPrestamoPanel;
    }

}
