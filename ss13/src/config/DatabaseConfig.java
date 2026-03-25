package config;

public class DatabaseConfig {
    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Rikkei_Reception";

    public static final String USER = "sa";
    public static final String PASS = "123456";

    public static String getURL(String dbName) {
        return "jdbc:sqlserver://localhost:1433;databaseName=" + dbName;
    }
}