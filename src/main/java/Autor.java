import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Autor {
    private int id;
    private String nombre;
    private String nacionalidad;
    private String alias;
    private Calendar fecha;

    public Autor(int id, String nombre, String nacionalidad, String alias, Calendar fecha){
        this.id = id;
        this.nombre= nombre;
        this.nacionalidad = nacionalidad;
        this.alias = alias;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public Calendar getFecha() {
        return fecha;
    }
}
