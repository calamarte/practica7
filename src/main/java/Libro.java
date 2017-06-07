/**
 * Created by calamarte on 07/06/2017.
 */
public class Libro {
    int id;
    String isbn;
    String titulo;
    String portada;
    String editorial;
    String paginas;
    String tematica;
    String autor;
    String sinopsis;

    public Libro(int id, String isbn, String titulo, String portada, String editorial, String paginas, String tematica, String autor, String sinopsis){
        this.id = id;
        this.isbn= isbn;
        this.titulo = titulo;
        this.portada = portada;
        this.editorial = editorial;
        this.paginas = paginas;
        this.tematica = tematica;
        this.autor = autor;
        this.sinopsis = sinopsis;
    }
}
