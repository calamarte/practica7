import javax.swing.*;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    static JFrame frame = new JFrame("Login");

    public static void main(String[] args) {
        Login l = new Login();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);


        frame.setContentPane(l.getLoginPanel());
        //JOptionPane.showMessageDialog(frame,"Incorrecto","Tal",JOptionPane.WARNING_MESSAGE);
    }
}
