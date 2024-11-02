package view;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {
    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=webNote";
            String user = "sa";
            String password = "1234567";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
