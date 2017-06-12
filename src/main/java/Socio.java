import java.util.Calendar;


/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Socio {
    private int id;
    private String nombre;
    private String dni;
    private Calendar fechaNa;


    public Socio(int id,String nombre,String dni,Calendar fechaNa){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNa = fechaNa;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Calendar getFechaNa() {
        return fechaNa;
    }
}
