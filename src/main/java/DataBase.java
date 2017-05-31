import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 * Created by calamarte on 23/05/2017.
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
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void InsertPerson(String name) throws Exception {

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
}
