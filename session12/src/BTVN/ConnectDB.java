package BTVN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:mysql://localhost:3306/demo1?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASS = "123";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return null;
    }
}
