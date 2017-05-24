import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.getText().equals("root") && passwd.getText().equals("1234")){
                    Main.frame.setSize(1100,500);
                    CardLayout cl = (CardLayout) Main.j.getLayout();
                    Main.jmb.setVisible(true);
                    cl.show(Main.j,"Inicio");
                    //JOptionPane.showMessageDialog(Main.frame,"Todo bien","ole",JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(Main.frame,"Incorrecto","Error",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }
}
