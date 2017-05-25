import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Created by calamarte on 23/05/2017.
 */
public class DataBase {
    String servidor;
    String usuario;
    String passwd;




    public DataBase(String server, String username, String password) throws Exception {



        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection conexion = DriverManager.getConnection(servidor,usuario,password);

//        try (PreparedStatement stmt = con.prepareStatement("SELECT country FROM country")) {
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next())
//                System.out.println (rs.getString("country"));
//
//        } catch (SQLException sqle) {
//            System.out.println("Error en la ejecución:"
//                    + sqle.getErrorCode() + " " + sqle.getMessage());
//        }
    }

    public void InsertPerson(String name) throws Exception {

    }

}
