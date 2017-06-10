/**
 * Created by calamarte on 07/06/2017.
 */
public class Libro {
    int id;
    String isbn;
    String titulo;
    String portada;
    String editorial;
    int paginas;
    String tematica;

    public Libro(int id, String isbn, String titulo, String portada, String editorial, int paginas, String tematica){
        this.id = id;
        this.isbn= isbn;
        this.titulo = titulo;
        this.portada = portada;
        this.editorial = editorial;
        this.paginas = paginas;
        this.tematica = tematica;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getPortada() {
        return portada;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getTematica() {
        return tematica;
    }
}
