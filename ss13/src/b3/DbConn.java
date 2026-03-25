package b3;

import java.sql.*;
import config.DatabaseConfig;

public class DbConn {
    public static Connection getC() throws Exception {
        Class.forName(DatabaseConfig.DRIVER);
        Connection c = DriverManager.getConnection(DatabaseConfig.getURL("RikkeiHospital_Exit"), DatabaseConfig.USER, DatabaseConfig.PASS);
        return c;
    }
}
