import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Prestamo {
    private int idPrestamo;
    private Calendar fechaInicial;
    private Calendar fechaFinal;
    private int nCopia;
    private Libro libro;
    private Socio socio;
    private Bibliotecario bibliotecario;

    public Prestamo(int idPrestamo,Calendar fechaInicial, Calendar fechaFinal, Libro libro, Socio socio,Bibliotecario bibliotecario,int nCopia){
        this.idPrestamo = idPrestamo;
        this.nCopia = nCopia;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.libro = libro;
        this.socio = socio;
        this.bibliotecario = bibliotecario;
    }

    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public Calendar getFechaInicial() {
        return fechaInicial;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public int getnCopia() {
        return nCopia;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
}
