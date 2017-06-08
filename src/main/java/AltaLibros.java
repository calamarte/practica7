import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

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
    private DataBase db = new DataBase("localhost","root","");
    private Autor[] autores;


    public AltaLibros() throws Exception {
        Tematica[] t = db.getTematicas();
        for (int i = 0; i < t.length; i++) {
            temas.addItem(t[i].getTipo());
        }

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
                        return a.nombre;
                    case 1:
                        return a.alias;
                    case 2:
                        return a.fecha;
                    case 3:
                        return a.nacionalidad;
                }
                throw new RuntimeException("Impossible");
            }
        };
        table1.setModel(tm);

            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CardLayout cl = (CardLayout) Main.j.getLayout();
                    cl.show(Main.j,"Inicio");
                }
            });
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        db.InsertLibro(isbn.getText(), titulo.getText(), portada.getText(), editorial.getText(), paginas.getText(), (String) temas.getSelectedItem(), autor.getText());
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
            });

    }


    public JPanel getAltaLibrosPanel() {
        return AltaLibrosPanel;
    }
}
