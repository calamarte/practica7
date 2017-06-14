import java.util.Calendar;

/**
 * Created by Dgarcia on 07/06/2017.
 */
public class Sancion {
   private int id;
   private String descripcion;
   private Calendar fecha;
   private String tipo;
   private Prestamo prestamo;

    public Sancion(int id,String descripcion,Calendar fecha,String tipo, Prestamo prestamo){
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.prestamo = prestamo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
}
