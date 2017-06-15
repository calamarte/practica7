import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Prestamo {
    //propiedades de prestamo
    private int idPrestamo;
    private Calendar fechaInicial;
    private Calendar fechaFinal;
    private int nCopia;
    private Libro libro;
    private Socio socio;
    private Bibliotecario bibliotecario;

    //constructor
    public Prestamo(int idPrestamo,Calendar fechaInicial, Calendar fechaFinal, Libro libro, Socio socio,Bibliotecario bibliotecario,int nCopia){
        this.idPrestamo = idPrestamo;
        this.nCopia = nCopia;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.libro = libro;
        this.socio = socio;
        this.bibliotecario = bibliotecario;
    }

    //devuelve la fecha final
    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    //devuelve la fecha inicial
    public Calendar getFechaInicial() {
        return fechaInicial;
    }

    //devuelve la id del prestamo
    public int getIdPrestamo() {
        return idPrestamo;
    }

    //devuelve el libro
    public Libro getLibro() {
        return libro;
    }

    //devuelve el socio
    public Socio getSocio() {
        return socio;
    }

    //devuelve el numero de copia
    public int getnCopia() {
        return nCopia;
    }

    //devuelve bibliotecario
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
}
