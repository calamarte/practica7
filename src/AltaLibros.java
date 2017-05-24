import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by calamarte on 24/05/2017.
 */
public class AltaLibros {
    private JPanel AltaLibrosPanel;
    private JButton cancel;
    private JButton ok;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public AltaLibros() {
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"Inicio");
            }
        });
    }

    public JPanel getAltaLibrosPanel() {
        return AltaLibrosPanel;
    }
}
