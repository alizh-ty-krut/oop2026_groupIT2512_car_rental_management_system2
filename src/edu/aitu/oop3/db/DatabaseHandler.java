package edu.aitu.oop3.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseHandler implements IDB {
    private static DatabaseHandler instance;
    private Connection connection;
    private Properties properties;

    private DatabaseHandler() {
        loadProperties();
        connect();
    }

    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find application.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration properties", ex);
        }
    }

    private void connect() {
        try {
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection with Session Pooler!");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static synchronized DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed() || !connection.isValid(2)) {
                connect();
            }
        } catch (SQLException e) {
            connect();
        }
        return connection;
    }
}