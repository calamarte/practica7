import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Autor {
    //propiedades de autor
    private int id;
    private String nombre;
    private String nacionalidad;
    private String alias;
    private Calendar fecha;

    //constructor
    public Autor(int id, String nombre, String nacionalidad, String alias, Calendar fecha){
        this.id = id;
        this.nombre= nombre;
        this.nacionalidad = nacionalidad;
        this.alias = alias;
        this.fecha = fecha;
    }

    //devuelve la id
    public int getId() {
        return id;
    }

    //devuelve la nacionalidad
    public String getNacionalidad() {
        return nacionalidad;
    }

    //devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    //devuelve el alias
    public String getAlias() {
        return alias;
    }

    //devuelve la fecha
    public Calendar getFecha() {
        return fecha;
    }
}
