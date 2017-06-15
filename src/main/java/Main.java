import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by calamarte on 23/05/2017.
 */
public class Main {
    static JFrame frame = new JFrame("La Biblioteca");
    static JPanel j = new JPanel();
    static JMenuBar jmb = new JMenuBar();
    static Bibliotecario bi;
    static Login l;
    static Inicio i;
    static AltaLibros ali;
    static AltaAutores aau;
    static AltaLectores ale;
    static AltaSancion asa;
    static BajaSocio bsoc;
    static HacerPrestamo hp;
    static ConsultarSanciones cs;

    public static void main(String[] args)throws Exception {
        l = new Login();
        i = new Inicio();
        ali = new AltaLibros();
        aau = new AltaAutores();
        ale = new AltaLectores();
        asa = new AltaSancion();
        bsoc = new BajaSocio();
        hp = new HacerPrestamo();
        cs = new ConsultarSanciones();
        setMenu();
        jmb.setVisible(false);
        ImageIcon img = new ImageIcon("C:\\Users\\calamarte\\Desktop\\Java\\practica7\\img\\estanteria.jpg");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(img.getImage());
        frame.setSize(400, 200);
        frame.setVisible(true);
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
    private static void setMenu(){
        frame.setJMenuBar(jmb);
        JMenu libros = new JMenu("Libros");
        jmb.add(libros);
        JMenuItem altaLibro = new JMenuItem("Nuevo libro");
        libros.add(altaLibro);
        altaLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaLibros");
            }
        });

        JMenu lectores = new JMenu("Lectores");
        jmb.add(lectores);
        JMenuItem altaLector = new JMenuItem("Nuevo Lector");
        JMenuItem bajaLector = new JMenuItem("Eliminar Lector");
        lectores.add(altaLector);
        lectores.add(bajaLector);
        altaLector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaLectores");
            }
        });
        bajaLector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"BajaSocio");
            }
        });

        JMenu autores = new JMenu("Autores");
        jmb.add(autores);
        JMenuItem altaAutor = new JMenuItem("Nuevo Autor");
        autores.add(altaAutor);
        altaAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaAutores");
            }
        });

        JMenu sanciones = new JMenu("Sanciones");
        jmb.add(sanciones);
        JMenuItem altaSancion = new JMenuItem("Nueva Sanción");
        JMenuItem consultarSancion = new JMenuItem("Consultar Sanciones");
        sanciones.add(altaSancion);
        sanciones.add(consultarSancion);
        altaSancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"AltaSancion");
            }
        });
        consultarSancion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"ConsultarSanciones");
            }
        });

        JMenu prestamos = new JMenu("Prestamos");
        jmb.add(prestamos);
        JMenuItem altaPrestamo = new JMenuItem("Nuevo Prestamo");
        prestamos.add(altaPrestamo);
        altaPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateTables();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                CardLayout cl = (CardLayout) Main.j.getLayout();
                cl.show(Main.j,"HacerPrestamo");
            }
        });
    }

    public static void updateTables() throws SQLException, ParseException {
        ali.createTable();
        asa.createTable();
        hp.createTable();
    }
}