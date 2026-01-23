package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler implements IDB {
    private static DatabaseHandler instance;
    private Connection connection;

    private String url = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres";
    private String user = "postgres.qzdvvbshjisziiligrax";
    private String password = "OPANA333456$";

    private DatabaseHandler() {
        connect();
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successful connection with Session Pooler!");
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static synchronized DatabaseHandler getInstance() { // synchronized - это чтобы программа не ломалась при множества потоках
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