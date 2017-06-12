import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Prestamo {
    int idPrestamo;
    Calendar fechaInicial;
    Calendar fechaFinal;
    Libro libro;
    Socio socio;
    Bibliotecario bibliotecario;

    public Prestamo(int idPrestamo,Calendar fechaInicial, Calendar fechaFinal, Libro libro, Socio socio,Bibliotecario bibliotecario){
        this.idPrestamo = idPrestamo;
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

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
}
