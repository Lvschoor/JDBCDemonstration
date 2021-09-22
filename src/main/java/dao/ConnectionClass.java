package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// utility class to make a connection with the database


public class ConnectionClass {

    // private constructor to avoid instantiation
    private ConnectionClass() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33062/luc", "luc", "luc123");
    }
}