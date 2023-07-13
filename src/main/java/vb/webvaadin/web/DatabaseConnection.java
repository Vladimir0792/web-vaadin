package vb.webvaadin.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// данные БД
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
