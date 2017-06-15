import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;


/**
 * Created by calamarte on 24/05/2017.
 */
public class AltaLibros {
    private JPanel AltaLibrosPanel;
    private JButton cancel;
    private JButton ok;
    private JTextField titulo;
    private JTextField portada;
    private JTextField autor;
    private JTextField paginas;
    private JTextField editorial;
    private JTextField isbn;
    private JTable table1;
    private JComboBox temas;
    private DataBase db = Getxml.cogexml();
    private Autor[] autores;


    public AltaLibros() throws SQLException, ParseException {
        Tematica[] t = db.getTematicas();
        for (int i = 0; i < t.length; i++) {
            temas.addItem(t[i].getTipo());
        }

            createTable();

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout) Main.j.getLayout();
                    cl.show(Main.j,"Inicio");
                }
            });
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int row = table1.getSelectedRow();
                    Libro l = new Libro(0,isbn.getText(),titulo.getText(),portada.getText(),editorial.getText(),Integer.parseInt(paginas.getText()),(String) temas.getSelectedItem());
                    try {
                        db.insertLibro(l,autores[row]);
                        JOptionPane.showMessageDialog(Main.frame,"Guardado correctamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(Main.frame,"Error","Error",JOptionPane.WARNING_MESSAGE);

                        e1.printStackTrace();
                    }
                }
            });


    }


    public JPanel getAltaLibrosPanel() {
        return AltaLibrosPanel;
    }

    public void createTable() throws SQLException, ParseException {
        autores = db.getAutores();
        TableModel tm = new AbstractTableModel() {
            public int getRowCount() {
                return autores.length ;
            }
            public String getColumnName(int col){
                switch (col){
                    case 0:
                        return "Nombre";
                    case 1:
                        return "Alias";
                    case 2:
                        return "Fecha de nacimiento";
                    case 3:
                        return "Nacionalidad";
                }
                throw new RuntimeException("imposible man");
            }

            public int getColumnCount() {
                return 4;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                Autor a = autores[rowIndex];
                switch(columnIndex) {
                    case 0:
                        return a.getNombre();
                    case 1:
                        return a.getAlias();
                    case 2:
                        return Util.calendarToString(a.getFecha());
                    case 3:
                        return a.getNacionalidad();
                }
                throw new RuntimeException("Impossible");
            }

        };
        table1.setModel(tm);
    }
}
