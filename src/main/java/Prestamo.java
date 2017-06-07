/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Prestamo {
    int idlibro;
    String fechainicial;
    String fechafinal;
    int idsocio;
    int idbibliotecario;

    public Prestamo(String fechafinal,String fechainicial, int idlibro, int idsocio, int idbibliotecario){
        this.fechafinal = fechafinal;
        this.fechainicial = fechainicial;
        this.idlibro = idlibro;
        this.idsocio = idsocio;
        this.idbibliotecario = idbibliotecario;
    }
}
