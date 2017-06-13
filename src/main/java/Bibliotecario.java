import java.util.Calendar;

/**
 * Created by calamarte on 12/06/2017.
 */
public class Bibliotecario {
   private String usuario;
   private String nombre;
   private String dni;
   private String password;
   private Calendar fechaNacimiento;

   public Bibliotecario(String usuario,String nombre,String dni,String password,Calendar fechaNacimiento){
       this.usuario = usuario;
       this.nombre = nombre;
       this.dni = dni;
       this.password = password;
       this.fechaNacimiento = fechaNacimiento;
   }

//   public Bibliotecario(String usuario,String password){
//       this.usuario = usuario;
//       this.password = password;
//   }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public void setDni(String dni) {
//        this.dni = dni;
//    }
//
//    public void setFechaNacimiento(Calendar fechaNacimiento) {
//        this.fechaNacimiento = fechaNacimiento;
//    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }
}
