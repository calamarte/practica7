/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Sancion {
    int id;
    String descripcion;
    String fecha;
    String tipo;
    int idlibro;
    int idsocio;
    int idbibliotecario;

    public Sancion(int id,String descripcion,String fecha,String tipo, int idlibro, int idsocio, int idbibliotecario){
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idlibro = idlibro;
        this.idsocio = idsocio;
        this.idbibliotecario = idbibliotecario;
    }
}
