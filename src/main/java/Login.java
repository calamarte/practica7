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
    private JButton loginButton;
    private JTextField user;
    private JLabel Usuario;
    private JLabel Contraseña;
    private JPasswordField passwd;
    private JPanel loginPanel;
    private DataBase d = Getxml.cogexml();

    public Login() throws Exception {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String pas = new String(passwd.getPassword());
                if (d.login(user.getText(),pas)){
                    try {
                      Main.bi = d.getBibliotecario(user.getText(),pas);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    CardLayout cl = (CardLayout) Main.j.getLayout();
                    Main.jmb.setVisible(true);
                    cl.show(Main.j,"Inicio");
                    Main.frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                }else{
                    JOptionPane.showMessageDialog(Main.frame,"Incorrecto","Error",JOptionPane.WARNING_MESSAGE);
                    user.setText("");
                    passwd.setText("");
                }
            }
        });
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

}
