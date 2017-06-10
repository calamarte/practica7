
/**
 * Created by calamarte on 10/06/2017.
 */
public class LibroAutor {
    private int idLibro;
    private int idAutor;

    LibroAutor(int idLibro,int idAutor){
        this.idAutor = idAutor;
        this.idLibro = idLibro;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public int getIdLibro() {
        return idLibro;
    }
}
