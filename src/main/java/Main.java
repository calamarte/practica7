import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    //inicializar jframe y componentes
    static JFrame frame = new JFrame("La Biblioteca");
    static JPanel j = new JPanel();
    static JMenuBar jmb = new JMenuBar();
    static Bibliotecario bi;

    public static void main(String[] args)throws Exception {
        //crear el menu
        setMenu();
        //el menu en el login no es visible
        jmb.setVisible(false);
        Login l = new Login();
        Inicio i = new Inicio();
        AltaLibros ali = new AltaLibros();
        AltaAutores aau = new AltaAutores();
        AltaLectores ale = new AltaLectores();
        AltaSancion asa = new AltaSancion();
        BajaSocio bsoc = new BajaSocio();
        HacerPrestamo hp = new HacerPrestamo();
        ConsultarSanciones cs = new ConsultarSanciones();
        //insertar imagen para icono de aplicacion
        ImageIcon img = new ImageIcon("C:\\Users\\calamarte\\Desktop\\Java\\practica7\\img\\estanteria.jpg");
        //al cerrar ventana, cerrar programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(img.getImage());
        //definir tamaño del frame
        frame.setSize(400, 200);
        frame.setVisible(true);
        //añadir al jpanel las diferentes pantallas
        j.setLayout(new CardLayout());
        j.add(l.getLoginPanel(),"Login");
        j.add(i.getInicio(),"Inicio");
        j.add(ali.getAltaLibrosPanel(),"AltaLibros");
        j.add(asa.getAltaSancionPanel(),"AltaSancion");
        j.add(aau.getAltaAutoresPanel(),"AltaAutores");
        j.add(ale.getAltaLectoresPanel(),"AltaLectores");
        j.add(bsoc.getBajaSocioPanel(), "BajaSocio");
        j.add(hp.getHacerPrestamoPanel(),"HacerPrestamo");
        j.add(cs.getConsultarSancionPanel(),"ConsultarSanciones");

        frame.setContentPane(j);
    }
    //crear el menu superior
    private static void setMenu(){
        frame.setJMenuBar(jmb);
        //desplegable libros
        JMenu libros = new JMenu("Libros");
        jmb.add(libros);
        JMenuItem altaLibro = new JMenuItem("Nuevo libro");
        libros.add(altaLibro);
        //al seleccionar cambia de cardlayout
        altaLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaLibros");
            }
        });

        //deplegable lectores
        JMenu lectores = new JMenu("Lectores");
        jmb.add(lectores);
        JMenuItem altaLector = new JMenuItem("Nuevo Lector");
        JMenuItem bajaLector = new JMenuItem("Eliminar Lector");
        lectores.add(altaLector);
        lectores.add(bajaLector);
        //al seleccionar cambia de cardlayout
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
        //desplegable autores
        JMenu autores = new JMenu("Autores");
        jmb.add(autores);
        JMenuItem altaAutor = new JMenuItem("Nuevo Autor");
        autores.add(altaAutor);
        //al seleccionar cambia de cardlayout
        altaAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaAutores");
            }
        });

        //desplegable sanciones
        JMenu sanciones = new JMenu("Sanciones");
        jmb.add(sanciones);
        JMenuItem altaSancion = new JMenuItem("Nueva Sanción");
        JMenuItem consultarSancion = new JMenuItem("Consultar Sanciones");
        sanciones.add(altaSancion);
        sanciones.add(consultarSancion);
        //al seleccionar cambia de cardlayout
        altaSancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaSancion");
            }
        });
        consultarSancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"ConsultarSanciones");
            }
        });

        //desplegable prestamos
        JMenu prestamos = new JMenu("Prestamos");
        jmb.add(prestamos);
        JMenuItem altaPrestamo = new JMenuItem("Nuevo Prestamo");
        prestamos.add(altaPrestamo);
        //al seleccionar cambia de cardlayout
        altaPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"HacerPrestamo");
            }
        });
    }
}