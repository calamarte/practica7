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
            conn =
                    DriverManager.getConnection("jdbc:mysql://"+server+"/?" +
                            "user="+username+"&password="+password);



        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void InsertPerson(String name) throws Exception {

    }

    public boolean login(String bibliotecario, String password)throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT count(*) FROM Bibliotecario where Nombre = "+usuario+"and Password = "+password);
        System.out.println(rs);

        if(rs.equals("1")){
            return true;
        }
        else return false;
    }
}
