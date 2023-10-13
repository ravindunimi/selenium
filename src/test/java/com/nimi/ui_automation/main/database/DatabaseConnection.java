package com.nimi.ui_automation.main.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection(String host, String port, String databaseName, String username, String password) throws SQLException {

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;

        return DriverManager.getConnection(url, username, password);
    }
}
