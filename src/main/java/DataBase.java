import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by calamarte on 23/05/2017.
 */
public class DataBase {
    String servidor;
    String usuario;
    String passwd;




    public DataBase(String server, String username, String password) throws Exception {

        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://"+server+"/?" +
                            "user="+username+"&password="+password);
            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void InsertPerson(String name) throws Exception {

    }

}
