package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    private static final String url = "jdbc:mysql://localhost:3306/kurswork";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("can't provide connection", e);
        }
    }
}
