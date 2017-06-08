import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dgarcia on 23/05/2017.
 */
public class DataBase {
    String servidor;
    String usuario;
    String passwd;
    Connection conn;

    public DataBase(String server, String username, String password) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/practica",username,password);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void InsertPerson(String name, String dni, String fecha) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into socio values (default, '"+name+"', '"+dni+"', '"+fecha+"');");
        stmt.close();
    }
    public void InsertAutor(String fecha, String nacionalidad, String alias, String nombre) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into autor values (default, '"+fecha+"', '"+nacionalidad+"', '"+alias+"', '"+nombre+"');");
        stmt.close();
    }

    public void InsertLibro(String isbn, String titulo, String portada, String editorial, String paginas, String tematica, String autor,String sinopsis) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into libro values (default, '"+isbn+"', '"+titulo+"','"+sinopsis+"' ,'"+portada+"', '"+editorial+"', '"+paginas+"', '"+tematica+"', '"+autor+"');");
        stmt.close();
    }

    public void InsertSancion(String descripcion, String fecha, String tipo, String prestamo) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into sancion values (default, '"+descripcion+"', '"+fecha+"', '"+tipo+"', '"+prestamo+"');");
        stmt.close();
    }

    public void InsertPrestamo(String socio, String libro, String bibliotecario, String fechainicial, String fechafinal) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("insert into prestamo values ('"+libro+"', '"+socio+"', '"+bibliotecario+"', '"+fechainicial+"', '"+fechafinal+"');");
        stmt.close();
    }

    public void DeleteAutor(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("delete from autor where id = '"+id+"';");
        stmt.close();
    }
    public void DeleteLibro(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("delete from libro where id = '"+id+"';");
        stmt.close();
    }

    public void DeletePrestamo(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("delete from prestamo where id = '"+id+"';");
        stmt.close();
    }

    public void DeleteSancion(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("delete from sancion where id = '"+id+"';");
        stmt.close();
    }

    public void DeleteSocio(int id) throws Exception {
        Statement stmt;
        stmt = conn.createStatement();
        stmt.execute("delete from socio where id = '"+id+"';");
        stmt.close();
    }

    public boolean login(String bibliotecario, String password){
        try {
        Statement stmt;
        ResultSet rs;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM bibliotecario where usuario = '"+bibliotecario+"' and password = md5('"+password+"');");
            if (rs.next())return true;
            else throw new Exception();
        }catch (Exception e){
            return false;
        }

    }

    public  Socio[] getSocios() throws SQLException {
        List<Socio> socioList = new ArrayList<Socio>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM socio;");

        while (rs.next()){
            Socio s = new Socio(rs.getInt("id"),rs.getString("nombre"),rs.getString("dni"),rs.getString("fecha_nacimiento"));
            socioList.add(s);
        }
        rs.close();
        stmt.close();
        Socio resultado[] = new Socio[socioList.size()];
        socioList.toArray(resultado);
        return resultado;
    }
}
