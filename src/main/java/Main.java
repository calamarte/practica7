import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    static JFrame frame = new JFrame("La Biblioteca");
    static JPanel j = new JPanel();
    static JMenuBar jmb = new JMenuBar();
    static Bibliotecario bi;

    public static void main(String[] args)throws Exception {
        setMenu();
        jmb.setVisible(false);
        Login l = new Login();
        Inicio i = new Inicio();
        AltaLibros ali = new AltaLibros();
        AltaAutores aau = new AltaAutores();
        AltaLectores ale = new AltaLectores();
        AltaSancion asa = new AltaSancion();
        AltaPrestamo apre = new AltaPrestamo();
        BajaLibro bali = new BajaLibro();
        BajaSocio bsoc = new BajaSocio();
        BajaSancion bsan = new BajaSancion();
        HacerPrestamo hp = new HacerPrestamo();
        ImageIcon img = new ImageIcon("C:\\Users\\calamarte\\Desktop\\Java\\practica7\\img\\estanteria.jpg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(img.getImage());
        frame.setSize(400, 200);
        frame.setVisible(true);
        j.setLayout(new CardLayout());
        j.add(l.getLoginPanel(),"Login");
        j.add(i.getInicio(),"Inicio");
        j.add(ali.getAltaLibrosPanel(),"AltaLibros");
        j.add(bali.getBajaLibroPanel(),"BajaLibro");
        j.add(asa.getAltaSancionPanel(),"AltaSancion");
        j.add(bsan.getBajaSancionPanel(), "BajaSancion");
        j.add(aau.getAltaAutoresPanel(),"AltaAutores");
        j.add(ale.getAltaLectoresPanel(),"AltaLectores");
        j.add(bsoc.getBajaSocioPanel(), "BajaSocio");
        j.add(apre.getAltaPrestamoPanel(),"AltaPrestamo");
        j.add(hp.getHacerPrestamoPanel(),"HacerPrestamo");

        frame.setContentPane(j);
    }
    private static void setMenu(){
        frame.setJMenuBar(jmb);
        JMenu libros = new JMenu("Libros");
        jmb.add(libros);
        JMenuItem altaLibro = new JMenuItem("Nuevo libro");
        JMenuItem bajaLibro = new JMenuItem("Eliminar libro");
        JMenuItem consultarLibro = new JMenuItem("Consultar libros");
        libros.add(altaLibro);
        libros.add(bajaLibro);
        libros.add(consultarLibro);
        altaLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaLibros");
            }
        });
        bajaLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"BajaLibro");
            }
        });

        JMenu lectores = new JMenu("Lectores");
        jmb.add(lectores);
        JMenuItem altaLector = new JMenuItem("Nuevo Lector");
        JMenuItem bajaLector = new JMenuItem("Eliminar Lector");
        JMenuItem consultarLector = new JMenuItem("Consultar lectores");
        lectores.add(altaLector);
        lectores.add(bajaLector);
        lectores.add(consultarLector);
        altaLector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaLectores");
            }
        });
        bajaLector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"BajaSocio");
            }
        });

        JMenu autores = new JMenu("Autores");
        jmb.add(autores);
        JMenuItem altaAutor = new JMenuItem("Nuevo Autor");
        JMenuItem bajaAutor = new JMenuItem("Eliminar Autor");
        JMenuItem consultarAutor = new JMenuItem("Consultar autores");
        autores.add(altaAutor);
        autores.add(bajaAutor);
        autores.add(consultarAutor);
        altaAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaAutores");
            }
        });

        JMenu sanciones = new JMenu("Sanciones");
        jmb.add(sanciones);
        JMenuItem altaSancion = new JMenuItem("Nueva Sanción");
        JMenuItem bajaSancion = new JMenuItem("Eliminar Sanción");
        JMenuItem consultarSancion = new JMenuItem("Consultar Sanciones");
        sanciones.add(altaSancion);
        sanciones.add(bajaSancion);
        sanciones.add(consultarSancion);
        altaSancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaSancion");
            }
        });
        bajaSancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"BajaSancion");
            }
        });

        JMenu prestamos = new JMenu("Prestamos");
        jmb.add(prestamos);
        JMenuItem altaPrestamo = new JMenuItem("Nuevo Prestamo");
        JMenuItem bajaPrestamo = new JMenuItem("Eliminar Prestamo");
        JMenuItem consultarPrestamo = new JMenuItem("Consultar Prestamo");
        prestamos.add(altaPrestamo);
        prestamos.add(bajaPrestamo);
        prestamos.add(consultarPrestamo);
        altaPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"HacerPrestamo");
            }
        });
    }

}
