import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by calamarte on 24/05/2017.
 */
public class BajaLibros {
    private JPanel BajaLibrosPanel;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private JTextField textField1;
    private JButton consultarButton;

    public BajaLibros() {
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
    }

    public JPanel getBajaLibrosPanel() {
        return BajaLibrosPanel;
    }
}
