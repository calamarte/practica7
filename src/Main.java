import javax.swing.*;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        Login l = new Login();
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);


        frame.setContentPane(l.getLoginPanel());
    }
}
