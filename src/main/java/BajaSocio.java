import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Dgarcia on 01/06/2017.
 */
public class BajaSocio {
    //elementos del panel
    private JButton cancelarButton;
    private JButton eliminarButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton buscarButton;
    private JPanel BajaSocioPanel;
    private JTable table;
    //conexion a db
    private DataBase db = Getxml.cogexml();
    Socio socios [];


    public BajaSocio() throws Exception {
        //al buscar coge el valor introducido en el textfield y lo busca en la db
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s =  (String) comboBox1.getSelectedItem();
                try {
                    socios = db.getSocios(s,textField1.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                TableModel tm = new AbstractTableModel() {
                    //tantas filas como socios
                    public int getRowCount() {
                        return socios.length ;
                    }

                    //cabeceras de la tabla
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

                    //numero de columnas segun campos
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
                table.setModel(tm);
            }
        });

        //se da de baja el usuario en la db
        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    db.deleteSocio(socios[table.getSelectedRow()]);
                } catch (Exception e1) {
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

    //devuelve el panel
    public JPanel getBajaSocioPanel() {
        return BajaSocioPanel;
    }
}
