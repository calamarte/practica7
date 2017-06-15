import java.util.Calendar;


/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Socio {
    //propiedades socio
    private int id;
    private String nombre;
    private String dni;
    private Calendar fechaNa;

    //constructor
    public Socio(int id,String nombre,String dni,Calendar fechaNa){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNa = fechaNa;
    }

    //devuelve id
    public int getId() {
        return id;
    }

    //devuelve nombre
    public String getNombre() {
        return nombre;
    }

    //devuelve dni
    public String getDni() {
        return dni;
    }

    //devuelve fecha de nacimiento
    public Calendar getFechaNa() {
        return fechaNa;
    }
}
