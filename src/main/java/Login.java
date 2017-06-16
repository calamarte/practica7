import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Login {
    //elementos del panel
    private JButton loginButton;
    private JTextField user;
    private JLabel Usuario;
    private JLabel Contraseña;
    private JPasswordField passwd;
    private JPanel loginPanel;
    //conexion a db
    private DataBase d = Getxml.cogexml();

    public Login() throws Exception {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //coge valores de los textfields
                String pas = new String(passwd.getPassword());
                //comprueba si el bibliotecario existe en la db
                if (d.login(user.getText(),pas)){
                    try {
                        //asigna como bibliotecario actual al introducido
                      Main.bi = d.getBibliotecario(user.getText(),pas);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    //si es correcto muestra el menu inicial
                    CardLayout cl = (CardLayout) Main.j.getLayout();
                    Main.jmb.setVisible(true);
                    cl.show(Main.j,"Inicio");
                    Main.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                }else{
                    //si no es correcto devuelve mensaje de error
                    JOptionPane.showMessageDialog(Main.frame,"Incorrecto","Error",JOptionPane.WARNING_MESSAGE);
                    user.setText("");
                    passwd.setText("");
                }
            }
        });
    }

    //devuelve panel
    public JPanel getLoginPanel() {
        return loginPanel;
    }

}
