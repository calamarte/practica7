import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by calamarte on 25/05/2017.
 */
public class AltaLectores {
    private JButton cancelarButton;
    private JButton guardarButton;
    private JPanel AltaLectoresPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    public AltaLectores() {
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
    }

    public JPanel getAltaLectoresPanel() {
        return AltaLectoresPanel;
    }
}
