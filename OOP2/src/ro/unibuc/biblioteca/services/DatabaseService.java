package ro.unibuc.biblioteca.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static DatabaseService instance;
    private Connection connection;

    private static final String URL = "jdbc:mariadb://100.88.113.106:3306/biblioteca";
    private static final String USER = "bogdan";
    private static final String PASSWORD = "2564";

    private DatabaseService() {}

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("Nu s-a putut conecta la baza de date. Verificati conexiunea MySQL / credentialele.");
        }
        return connection;
    }
}