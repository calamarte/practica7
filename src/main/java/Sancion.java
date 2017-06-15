import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Sancion {
    //propiedades sancion
   private int id;
   private String descripcion;
   private Calendar fecha;
   private String tipo;
   private Prestamo prestamo;

    //constructor
    public Sancion(int id,String descripcion,Calendar fecha,String tipo, Prestamo prestamo){
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.prestamo = prestamo;
    }

    //devuelve la id
    public int getId() {
        return id;
    }

    //devuelve el tipo
    public String getTipo() {
        return tipo;
    }

    //devuelve la descripcion
    public String getDescripcion() {
        return descripcion;
    }

    //devuelve la fecha
    public Calendar getFecha() {
        return fecha;
    }

    //devuelve prestamo
    public Prestamo getPrestamo() {
        return prestamo;
    }
}
