import java.util.Calendar;

/**
 * Created by calamarte on 12/06/2017.
 */
public class Bibliotecario {
    //propiedades de bibliotecario
   private String usuario;
   private String nombre;
   private String dni;
   private String password;
   private Calendar fechaNacimiento;

    //constructor
   public Bibliotecario(String usuario,String nombre,String dni,String password,Calendar fechaNacimiento){
       this.usuario = usuario;
       this.nombre = nombre;
       this.dni = dni;
       this.password = password;
       this.fechaNacimiento = fechaNacimiento;
   }

   //devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    //devuelve el usuario
    public String getUsuario() {
        return usuario;
    }
}
