/**
 * Created by calamarte on 07/06/2017.
 */
public class Libro {
    //propiedades de libro
    private int id;
    private String isbn;
    private String titulo;
    private String portada;
    private String editorial;
    private int paginas;
    private String tematica;

    //constructor
    public Libro(int id, String isbn, String titulo, String portada, String editorial, int paginas, String tematica){
        this.id = id;
        this.isbn= isbn;
        this.titulo = titulo;
        this.portada = portada;
        this.editorial = editorial;
        this.paginas = paginas;
        this.tematica = tematica;
    }

    //devuelve la id
    public int getId() {
        return id;
    }

    //devuelve el isbn
    public String getIsbn() {
        return isbn;
    }

    //devuelve el titulo
    public String getTitulo() {
        return titulo;
    }

    //devuelve el numero de paginas
    public int getPaginas() {
        return paginas;
    }

    //devueelve el tipo de portada
    public String getPortada() {
        return portada;
    }

    //devuelve la editorial
    public String getEditorial() {
        return editorial;
    }

    //devuelve la tematica
    public String getTematica() {
        return tematica;
    }
}
